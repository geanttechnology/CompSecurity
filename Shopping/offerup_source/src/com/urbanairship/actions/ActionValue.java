// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;

// Referenced classes of package com.urbanairship.actions:
//            ActionValueException

public class ActionValue
    implements Parcelable, JsonSerializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final JsonValue jsonValue;

    public ActionValue()
    {
        jsonValue = JsonValue.NULL;
    }

    public ActionValue(JsonValue jsonvalue)
    {
        JsonValue jsonvalue1 = jsonvalue;
        if (jsonvalue == null)
        {
            jsonvalue1 = JsonValue.NULL;
        }
        jsonValue = jsonvalue1;
    }

    public static ActionValue wrap(char c)
    {
        return new ActionValue(JsonValue.wrap(c));
    }

    public static ActionValue wrap(int i)
    {
        return new ActionValue(JsonValue.wrap(i));
    }

    public static ActionValue wrap(long l)
    {
        return new ActionValue(JsonValue.wrap(l));
    }

    public static ActionValue wrap(JsonSerializable jsonserializable)
    {
        return new ActionValue(JsonValue.wrap(jsonserializable));
    }

    public static ActionValue wrap(Object obj)
    {
        ActionValue actionvalue;
        try
        {
            actionvalue = new ActionValue(JsonValue.wrap(obj));
        }
        catch (JsonException jsonexception)
        {
            throw new ActionValueException((new StringBuilder("Invalid ActionValue object: ")).append(obj).toString(), jsonexception);
        }
        return actionvalue;
    }

    public static ActionValue wrap(String s)
    {
        return new ActionValue(JsonValue.wrap(s));
    }

    public static ActionValue wrap(boolean flag)
    {
        return new ActionValue(JsonValue.wrap(flag));
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ActionValue)
        {
            obj = (ActionValue)obj;
            return jsonValue.equals(((ActionValue) (obj)).jsonValue);
        } else
        {
            return false;
        }
    }

    public boolean getBoolean(boolean flag)
    {
        return jsonValue.getBoolean(flag);
    }

    public double getDouble(double d)
    {
        return jsonValue.getDouble(d);
    }

    public int getInt(int i)
    {
        return jsonValue.getInt(i);
    }

    public JsonList getList()
    {
        return jsonValue.getList();
    }

    public long getLong(long l)
    {
        return jsonValue.getLong(l);
    }

    public JsonMap getMap()
    {
        return jsonValue.getMap();
    }

    public String getString()
    {
        return getString(null);
    }

    public String getString(String s)
    {
        return jsonValue.getString(s);
    }

    public int hashCode()
    {
        return jsonValue.hashCode();
    }

    public boolean isNull()
    {
        return jsonValue.isNull();
    }

    public JsonValue toJsonValue()
    {
        return jsonValue;
    }

    public String toString()
    {
        return jsonValue.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(jsonValue, i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ActionValue createFromParcel(Parcel parcel)
        {
            return new ActionValue((JsonValue)parcel.readParcelable(com/urbanairship/json/JsonValue.getClassLoader()));
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ActionValue[] newArray(int i)
        {
            return new ActionValue[i];
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
