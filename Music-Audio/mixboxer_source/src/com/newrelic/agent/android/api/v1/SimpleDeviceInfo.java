// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;

import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.newrelic.agent.android.api.v1:
//            DeviceInfo

public final class SimpleDeviceInfo
    implements DeviceInfo
{
    private static final class Field extends Enum
    {

        private static final Field $VALUES[];
        public static final Field AGENT_NAME;
        public static final Field AGENT_VERSION;
        public static final Field COUNTRY_CODE;
        public static final Field DEVICE_ID;
        public static final Field MANUFACTURER;
        public static final Field MANUFACTURER_MODEL;
        public static final Field MISC;
        public static final Field OS_NAME;
        public static final Field OS_VERSION;
        public static final Field REGION_CODE;

        public static Field valueOf(String s)
        {
            return (Field)Enum.valueOf(com/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field, s);
        }

        public static Field[] values()
        {
            return (Field[])$VALUES.clone();
        }

        static 
        {
            OS_NAME = new Field("OS_NAME", 0);
            OS_VERSION = new Field("OS_VERSION", 1);
            MANUFACTURER_MODEL = new Field("MANUFACTURER_MODEL", 2);
            AGENT_NAME = new Field("AGENT_NAME", 3);
            AGENT_VERSION = new Field("AGENT_VERSION", 4);
            DEVICE_ID = new Field("DEVICE_ID", 5);
            COUNTRY_CODE = new Field("COUNTRY_CODE", 6);
            REGION_CODE = new Field("REGION_CODE", 7);
            MANUFACTURER = new Field("MANUFACTURER", 8);
            MISC = new Field("MISC", 9);
            $VALUES = (new Field[] {
                OS_NAME, OS_VERSION, MANUFACTURER_MODEL, AGENT_NAME, AGENT_VERSION, DEVICE_ID, COUNTRY_CODE, REGION_CODE, MANUFACTURER, MISC
            });
        }

        private Field(String s, int i)
        {
            super(s, i);
        }
    }


    private final JSONArray jsonArray;

    public SimpleDeviceInfo()
    {
        this(null, null, null, null, null, null, null, null);
    }

    public SimpleDeviceInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Map map)
    {
        jsonArray = newJSONArray(new Object[] {
            s, s1, (new StringBuilder()).append(s2).append(" ").append(s3).toString(), s4, s5, s6, null, null, s2, map
        });
    }

    private SimpleDeviceInfo(JSONArray jsonarray)
        throws JSONException
    {
        jsonArray = new JSONArray();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            jsonArray.put(jsonarray.get(i));
        }

    }

    private static Object convertValue(Object obj)
    {
        Object obj1;
        if (obj instanceof Collection)
        {
            obj1 = new JSONArray((Collection)obj);
        } else
        {
            if (obj instanceof Map)
            {
                return new JSONObject((Map)obj);
            }
            obj1 = obj;
            if (obj == null)
            {
                return JSONObject.NULL;
            }
        }
        return obj1;
    }

    private static transient JSONArray newJSONArray(Object aobj[])
    {
        JSONArray jsonarray = new JSONArray();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            jsonarray.put(convertValue(aobj[i]));
        }

        return jsonarray;
    }

    private void put(Field field, Object obj)
        throws JSONException
    {
        jsonArray.put(field.ordinal(), convertValue(obj));
    }

    public void setAgentName(String s)
        throws JSONException
    {
        put(Field.AGENT_NAME, s);
    }

    public void setAgentVersion(String s)
        throws JSONException
    {
        put(Field.AGENT_VERSION, s);
    }

    public void setCountryCode(String s)
        throws JSONException
    {
        put(Field.COUNTRY_CODE, s);
    }

    public void setDeviceId(String s)
        throws JSONException
    {
        put(Field.DEVICE_ID, s);
    }

    public void setManufacturer(String s)
        throws JSONException
    {
        put(Field.MANUFACTURER, s);
    }

    public void setMisc(Map map)
        throws JSONException
    {
        put(Field.MISC, map);
    }

    public void setModel(String s)
        throws JSONException
    {
        put(Field.MANUFACTURER_MODEL, s);
    }

    public void setOsName(String s)
        throws JSONException
    {
        put(Field.OS_NAME, s);
    }

    public void setOsVersion(String s)
        throws JSONException
    {
        put(Field.OS_VERSION, s);
    }

    public void setRegionCode(String s)
        throws JSONException
    {
        put(Field.REGION_CODE, s);
    }

    public JSONArray toJSONArray()
    {
        return jsonArray;
    }

    public String toString()
    {
        return toJSONArray().toString();
    }

    public SimpleDeviceInfo withLocation(String s, String s1)
        throws JSONException
    {
        SimpleDeviceInfo simpledeviceinfo = new SimpleDeviceInfo(jsonArray);
        simpledeviceinfo.setCountryCode(s);
        simpledeviceinfo.setRegionCode(s1);
        return simpledeviceinfo;
    }
}
