// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import org.json.JSONObject;

public class Attribute
{

    private String attributeName;
    private String attributeType;
    private JSONObject attributeValue;
    private int id;
    private String sessionId;

    public Attribute()
    {
        attributeValue = new JSONObject();
    }

    public Attribute(String s, String s1, ValueType valuetype)
    {
        attributeValue = new JSONObject();
        attributeName = s;
        attributeType = s1;
        attributeValue = valuetype.toJSON();
    }

    public Attribute(String s, String s1, String s2, ValueType valuetype)
    {
        attributeValue = new JSONObject();
        sessionId = s;
        attributeName = s1;
        attributeType = s2;
        attributeValue = valuetype.toJSON();
    }

    public Attribute(String s, String s1, String s2, JSONObject jsonobject)
    {
        attributeValue = new JSONObject();
        sessionId = s;
        attributeName = s1;
        attributeType = s2;
        attributeValue = jsonobject;
    }

    public String getAttributeName()
    {
        return attributeName;
    }

    public String getAttributeType()
    {
        return attributeType;
    }

    public JSONObject getAttributeValue()
    {
        return attributeValue;
    }

    public int getId()
    {
        return id;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public Attribute setAttributeDouble(double d)
    {
        attributeValue = (new ValueType(ValidValueTypes.DOUBLE, Double.valueOf(d))).toJSON();
        return this;
    }

    public Attribute setAttributeName(String s)
    {
        attributeName = s;
        return this;
    }

    public Attribute setAttributeType(String s)
    {
        attributeType = s;
        return this;
    }

    public Attribute setAttributeValue(int i)
    {
        attributeValue = (new ValueType(ValidValueTypes.INTEGER, Integer.valueOf(i))).toJSON();
        return this;
    }

    public Attribute setAttributeValue(long l)
    {
        attributeValue = (new ValueType(ValidValueTypes.LONG, Long.valueOf(l))).toJSON();
        return this;
    }

    public Attribute setAttributeValue(ValueType valuetype)
    {
        attributeValue = valuetype.toJSON();
        return this;
    }

    public Attribute setAttributeValue(String s)
    {
        attributeValue = (new ValueType(ValidValueTypes.STRING, s)).toJSON();
        return this;
    }

    public Attribute setAttributeValue(JSONObject jsonobject)
    {
        attributeValue = jsonobject;
        return this;
    }

    public Attribute setAttributeValue(boolean flag)
    {
        attributeValue = (new ValueType(ValidValueTypes.BOOLEAN, Boolean.valueOf(flag))).toJSON();
        return this;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setSessionId(String s)
    {
        sessionId = s;
    }

    private class ValueType
    {

        public static final String KEY_DATA_TYPE = "data_type";
        public static final String KEY_VALUE = "value";
        private ValidValueTypes dataType;
        private Object value;

        public ValidValueTypes getDataType()
        {
            return dataType;
        }

        public Object getValue()
        {
            return value;
        }

        public void setDataType(ValidValueTypes validvaluetypes)
        {
            dataType = validvaluetypes;
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

        public ValueType(ValidValueTypes validvaluetypes, Object obj)
        {
            dataType = validvaluetypes;
            value = obj;
        }
    }


    private class ValidValueTypes extends Enum
    {

        private static final ValidValueTypes $VALUES[];
        public static final ValidValueTypes BOOLEAN;
        public static final ValidValueTypes DOUBLE;
        public static final ValidValueTypes INTEGER;
        public static final ValidValueTypes LONG;
        public static final ValidValueTypes STRING;
        private String type;

        public static ValidValueTypes getValue(String s)
        {
            return valueOf(s);
        }

        public static ValidValueTypes valueOf(String s)
        {
            return (ValidValueTypes)Enum.valueOf(com/socialin/android/apiv3/log/Attribute$ValidValueTypes, s);
        }

        public static ValidValueTypes[] values()
        {
            return (ValidValueTypes[])$VALUES.clone();
        }

        public final String getName()
        {
            return type;
        }

        static 
        {
            INTEGER = new ValidValueTypes("INTEGER", 0, "integer");
            LONG = new ValidValueTypes("LONG", 1, "long");
            DOUBLE = new ValidValueTypes("DOUBLE", 2, "double");
            STRING = new ValidValueTypes("STRING", 3, "string");
            BOOLEAN = new ValidValueTypes("BOOLEAN", 4, "boolean");
            $VALUES = (new ValidValueTypes[] {
                INTEGER, LONG, DOUBLE, STRING, BOOLEAN
            });
        }

        private ValidValueTypes(String s, int i, String s1)
        {
            super(s, i);
            type = s1;
        }
    }

}
