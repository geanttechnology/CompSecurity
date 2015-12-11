// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public interface Harvestable
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type ARRAY;
        public static final Type OBJECT;
        public static final Type VALUE;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/newrelic/agent/android/harvest/type/Harvestable$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            OBJECT = new Type("OBJECT", 0);
            ARRAY = new Type("ARRAY", 1);
            VALUE = new Type("VALUE", 2);
            $VALUES = (new Type[] {
                OBJECT, ARRAY, VALUE
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract JsonElement asJson();

    public abstract JsonArray asJsonArray();

    public abstract JsonObject asJsonObject();

    public abstract JsonPrimitive asJsonPrimitive();

    public abstract Type getType();

    public abstract String toJsonString();
}
