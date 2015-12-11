// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.json;

import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.Logger;
import com.urbanairship.util.UAStringUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

// Referenced classes of package com.urbanairship.json:
//            JsonException, JsonMap, JsonList, JsonSerializable

public class JsonValue
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final JsonValue NULL = new JsonValue(null);
    private final Object value;

    private JsonValue(Object obj)
    {
        value = obj;
    }

    public static JsonValue parseString(String s)
    {
        if (UAStringUtil.isEmpty(s))
        {
            return NULL;
        }
        s = new JSONTokener(s);
        try
        {
            s = wrap(s.nextValue());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new JsonException("Unable to parse string", s);
        }
        return s;
    }

    public static JsonValue wrap(char c)
    {
        return wrap(Character.valueOf(c), NULL);
    }

    public static JsonValue wrap(int i)
    {
        return wrap(Integer.valueOf(i), NULL);
    }

    public static JsonValue wrap(long l)
    {
        return wrap(Long.valueOf(l), NULL);
    }

    public static JsonValue wrap(JsonSerializable jsonserializable)
    {
        return wrap(jsonserializable, NULL);
    }

    public static JsonValue wrap(Object obj)
    {
        if (obj != null && obj != JSONObject.NULL) goto _L2; else goto _L1
_L1:
        obj = NULL;
_L4:
        return ((JsonValue) (obj));
_L2:
        if (obj instanceof JsonValue)
        {
            return (JsonValue)obj;
        }
        if ((obj instanceof JsonMap) || (obj instanceof JsonList) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String))
        {
            return new JsonValue(obj);
        }
        if (!(obj instanceof JsonSerializable))
        {
            break; /* Loop/switch isn't completed */
        }
        JsonValue jsonvalue = ((JsonSerializable)obj).toJsonValue();
        obj = jsonvalue;
        if (jsonvalue == null)
        {
            return NULL;
        }
        if (true) goto _L4; else goto _L3
_L3:
label0:
        {
            if ((obj instanceof Byte) || (obj instanceof Short))
            {
                return new JsonValue(Integer.valueOf(((Number)obj).intValue()));
            }
            if (obj instanceof Character)
            {
                return new JsonValue(((Character)obj).toString());
            }
            if (obj instanceof Float)
            {
                return new JsonValue(Double.valueOf(((Number)obj).doubleValue()));
            }
            if (obj instanceof Double)
            {
                Double double1 = (Double)obj;
                if (double1.isInfinite() || double1.isNaN())
                {
                    throw new JsonException((new StringBuilder("Invalid Double value: ")).append(double1).toString());
                } else
                {
                    return new JsonValue(obj);
                }
            }
            try
            {
                if (obj instanceof JSONArray)
                {
                    return wrapJSONArray((JSONArray)obj);
                }
                if (obj instanceof JSONObject)
                {
                    return wrapJSONObject((JSONObject)obj);
                }
                if (obj instanceof Collection)
                {
                    return wrapCollection((Collection)obj);
                }
                if (obj.getClass().isArray())
                {
                    return wrapArray(obj);
                }
                if (!(obj instanceof Map))
                {
                    break label0;
                }
                obj = wrapMap((Map)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new JsonException("Failed to wrap value.", ((Throwable) (obj)));
            }
            return ((JsonValue) (obj));
        }
        throw new JsonException((new StringBuilder("Illegal object: ")).append(obj).toString());
    }

    public static JsonValue wrap(Object obj, JsonValue jsonvalue)
    {
        try
        {
            obj = wrap(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return jsonvalue;
        }
        return ((JsonValue) (obj));
    }

    public static JsonValue wrap(String s)
    {
        return wrap(s, NULL);
    }

    public static JsonValue wrap(boolean flag)
    {
        return wrap(Boolean.valueOf(flag), NULL);
    }

    private static JsonValue wrapArray(Object obj)
    {
        int j = Array.getLength(obj);
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                arraylist.add(wrap(obj1));
            }
        }

        return new JsonValue(new JsonList(arraylist));
    }

    private static JsonValue wrapCollection(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj = collection.next();
            if (obj != null)
            {
                arraylist.add(wrap(obj));
            }
        } while (true);
        return new JsonValue(new JsonList(arraylist));
    }

    private static JsonValue wrapJSONArray(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList(jsonarray.length());
        for (int i = 0; i < jsonarray.length(); i++)
        {
            if (!jsonarray.isNull(i))
            {
                arraylist.add(wrap(jsonarray.opt(i)));
            }
        }

        return new JsonValue(new JsonList(arraylist));
    }

    private static JsonValue wrapJSONObject(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!jsonobject.isNull(s))
            {
                hashmap.put(s, wrap(jsonobject.opt(s)));
            }
        } while (true);
        return new JsonValue(new JsonMap(hashmap));
    }

    private static JsonValue wrapMap(Map map)
    {
        HashMap hashmap = new HashMap();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!(entry.getKey() instanceof String))
            {
                throw new JsonException("Only string map keys are accepted.");
            }
            if (entry.getValue() != null)
            {
                hashmap.put((String)entry.getKey(), wrap(entry.getValue()));
            }
        } while (true);
        return new JsonValue(new JsonMap(hashmap));
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof JsonValue))
        {
            return false;
        }
        obj = (JsonValue)obj;
        if (isNull())
        {
            return ((JsonValue) (obj)).isNull();
        } else
        {
            return value.equals(((JsonValue) (obj)).value);
        }
    }

    public boolean getBoolean(boolean flag)
    {
        while (isNull() || !isBoolean()) 
        {
            return flag;
        }
        return ((Boolean)value).booleanValue();
    }

    public double getDouble(double d)
    {
        if (!isNull())
        {
            if (isDouble())
            {
                return ((Double)value).doubleValue();
            }
            if (isNumber())
            {
                return ((Number)value).doubleValue();
            }
        }
        return d;
    }

    public int getInt(int i)
    {
        if (!isNull())
        {
            if (isInteger())
            {
                return ((Integer)value).intValue();
            }
            if (isNumber())
            {
                return ((Number)value).intValue();
            }
        }
        return i;
    }

    public JsonList getList()
    {
        if (isNull() || !isJsonList())
        {
            return null;
        } else
        {
            return (JsonList)value;
        }
    }

    public long getLong(long l)
    {
        if (!isNull())
        {
            if (isLong())
            {
                return ((Long)value).longValue();
            }
            if (isNumber())
            {
                return ((Number)value).longValue();
            }
        }
        return l;
    }

    public JsonMap getMap()
    {
        if (isNull() || !isJsonMap())
        {
            return null;
        } else
        {
            return (JsonMap)value;
        }
    }

    public Number getNumber()
    {
        if (isNull() || !isNumber())
        {
            return null;
        } else
        {
            return (Number)value;
        }
    }

    public String getString()
    {
        return getString(null);
    }

    public String getString(String s)
    {
        if (isNull())
        {
            return null;
        }
        if (isString())
        {
            return (String)value;
        } else
        {
            return s;
        }
    }

    public Object getValue()
    {
        return value;
    }

    public int hashCode()
    {
        int i = 17;
        if (value != null)
        {
            i = value.hashCode() + 527;
        }
        return i;
    }

    public boolean isBoolean()
    {
        return value instanceof Boolean;
    }

    public boolean isDouble()
    {
        return value instanceof Double;
    }

    public boolean isInteger()
    {
        return value instanceof Integer;
    }

    public boolean isJsonList()
    {
        return value instanceof JsonList;
    }

    public boolean isJsonMap()
    {
        return value instanceof JsonMap;
    }

    public boolean isLong()
    {
        return value instanceof Long;
    }

    public boolean isNull()
    {
        return value == null;
    }

    public boolean isNumber()
    {
        return value instanceof Number;
    }

    public boolean isString()
    {
        return value instanceof String;
    }

    public String toString()
    {
        if (isNull())
        {
            return "null";
        }
        String s;
        try
        {
            if (value instanceof String)
            {
                return JSONObject.quote((String)value);
            }
            if (value instanceof Number)
            {
                return JSONObject.numberToString((Number)value);
            }
            if ((value instanceof JsonMap) || (value instanceof JsonList))
            {
                return value.toString();
            }
            s = String.valueOf(value);
        }
        catch (JSONException jsonexception)
        {
            Logger.error("JsonValue - Failed to create JSON String.", jsonexception);
            return "";
        }
        return s;
    }

    void write(JSONStringer jsonstringer)
    {
        if (isNull())
        {
            jsonstringer.value(null);
            return;
        }
        if (value instanceof JsonList)
        {
            ((JsonList)value).write(jsonstringer);
            return;
        }
        if (value instanceof JsonMap)
        {
            ((JsonMap)value).write(jsonstringer);
            return;
        } else
        {
            jsonstringer.value(value);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(toString());
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final JsonValue createFromParcel(Parcel parcel)
        {
            try
            {
                parcel = JsonValue.parseString(parcel.readString());
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                Logger.error("JsonValue - Unable to create JsonValue from parcel.", parcel);
                return null;
            }
            return parcel;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final JsonValue[] newArray(int i)
        {
            return new JsonValue[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
