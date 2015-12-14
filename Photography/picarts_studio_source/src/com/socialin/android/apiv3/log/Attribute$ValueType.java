// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class value
{

    public static final String KEY_DATA_TYPE = "data_type";
    public static final String KEY_VALUE = "value";
    private Types dataType;
    private Object value;

    public Types getDataType()
    {
        return dataType;
    }

    public Object getValue()
    {
        return value;
    }

    public void setDataType(Types types)
    {
        dataType = types;
    }

    public void setValue(Objects objects)
    {
        value = objects;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("data_type", dataType.getName());
            jsonobject.put("value", value);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public Types(Types types, Object obj)
    {
        dataType = types;
        value = obj;
    }
}
