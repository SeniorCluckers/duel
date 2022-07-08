package com.seniorcluckers.duel.pdc;

import com.google.gson.Gson;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class DataType implements PersistentDataType<String, DataContainer> {

    private static final Gson GSON = new Gson();

    @NotNull
    @Override
    public Class<String> getPrimitiveType() {
        return String.class;
    }

    @NotNull
    @Override
    public Class<DataContainer> getComplexType() {
        return DataContainer.class;
    }

    @NotNull
    @Override
    public String toPrimitive(@NotNull DataContainer complex, @NotNull PersistentDataAdapterContext context) {
        return GSON.toJson(complex);
    }

    @NotNull
    @Override
    public DataContainer fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
        return GSON.fromJson(primitive, DataContainer.class);
    }

}
