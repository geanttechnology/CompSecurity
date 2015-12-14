// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MoaParameter
    implements Serializable, Cloneable
{

    public static final int COLOR_STRING_SIZE = 8;
    public static final int MATRIX_SIZE = 9;
    public static final int RECT_BOTTOM_INDEX = 3;
    public static final int RECT_LEFT_INDEX = 0;
    public static final int RECT_RIGHT_INDEX = 2;
    public static final int RECT_SIZE = 4;
    public static final int RECT_TOP_INDEX = 1;
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_MATRIX = "matrix";
    public static final String TYPE_POINT = "point";
    public static final String TYPE_RECT = "rect";
    private static final long serialVersionUID = 0xc8fe1ff06d8878a5L;
    Object defaultValue;
    String description;
    boolean hasLimits;
    Object maxValue;
    Object minValue;
    String name;
    String type;
    String uid;
    Object value;

    public MoaParameter()
    {
    }

    public abstract Object clone();

    public void decode(JSONObject jsonobject)
        throws JSONException
    {
        uid = jsonobject.optString("uid");
        name = jsonobject.getString("id");
        description = jsonobject.optString("description", "");
        if (jsonobject.has("min"))
        {
            minValue = parseValue(jsonobject, "min");
            maxValue = parseValue(jsonobject, "max");
            hasLimits = true;
        }
        defaultValue = parseValue(jsonobject, "defaultValue");
        value = defaultValue;
    }

    public abstract Object encode();

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getUID()
    {
        return uid;
    }

    public Object getValue()
    {
        return value;
    }

    public boolean hasLimits()
    {
        return hasLimits;
    }

    abstract Object parseValue(JSONObject jsonobject, String s);

    public void setValue(Object obj)
    {
        value = obj;
    }
}
