// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.Logger;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.Map;

public class LocationRequestOptions
    implements Parcelable, JsonSerializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final int DEFAULT_REQUEST_PRIORITY = 2;
    public static final float DEFAULT_UPDATE_INTERVAL_METERS = 800F;
    public static final long DEFAULT_UPDATE_INTERVAL_MILLISECONDS = 0x493e0L;
    public static final String MIN_DISTANCE_KEY = "minDistance";
    public static final String MIN_TIME_KEY = "minTime";
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 2;
    public static final int PRIORITY_HIGH_ACCURACY = 1;
    public static final String PRIORITY_KEY = "priority";
    public static final int PRIORITY_LOW_POWER = 3;
    public static final int PRIORITY_NO_POWER = 4;
    private final float minDistance;
    private final long minTime;
    private final int priority;

    private LocationRequestOptions(int i, long l, float f)
    {
        priority = i;
        minTime = l;
        minDistance = f;
    }

    private LocationRequestOptions(Parcel parcel)
    {
        this(parcel.readInt(), parcel.readLong(), parcel.readFloat());
    }

    LocationRequestOptions(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private LocationRequestOptions(Builder builder)
    {
        this(builder.priority, builder.minTime, builder.minDistance);
    }

    LocationRequestOptions(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public static LocationRequestOptions createDefaultOptions()
    {
        return new LocationRequestOptions(2, 0x493e0L, 800F);
    }

    public static LocationRequestOptions parseJson(String s)
    {
        s = JsonValue.parseString(s).getMap();
        if (s == null)
        {
            return null;
        }
        Number number = s.opt("minDistance").getNumber();
        float f;
        int i;
        long l;
        if (number == null)
        {
            f = 800F;
        } else
        {
            f = number.floatValue();
        }
        l = s.opt("minTime").getLong(0x493e0L);
        i = s.opt("priority").getInt(2);
        verifyPriority(i);
        verifyMinDistance(f);
        verifyMinTime(l);
        return new LocationRequestOptions(i, l, f);
    }

    private static void verifyMinDistance(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("minDistance must be greater or equal to 0");
        } else
        {
            return;
        }
    }

    private static void verifyMinTime(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("minTime must be greater or equal to 0");
        } else
        {
            return;
        }
    }

    private static void verifyPriority(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Priority can only be either PRIORITY_HIGH_ACCURACY, PRIORITY_BALANCED_POWER_ACCURACY, PRIORITY_LOW_POWER, or PRIORITY_NO_POWER");

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LocationRequestOptions)
        {
            if (((LocationRequestOptions) (obj = (LocationRequestOptions)obj)).priority == priority && ((LocationRequestOptions) (obj)).minTime == minTime && ((LocationRequestOptions) (obj)).minDistance == minDistance)
            {
                return true;
            }
        }
        return false;
    }

    public float getMinDistance()
    {
        return minDistance;
    }

    public long getMinTime()
    {
        return minTime;
    }

    public int getPriority()
    {
        return priority;
    }

    public JsonValue toJsonValue()
    {
        Object obj = new HashMap();
        ((Map) (obj)).put("priority", Integer.valueOf(getPriority()));
        ((Map) (obj)).put("minDistance", Float.valueOf(getMinDistance()));
        ((Map) (obj)).put("minTime", Long.valueOf(getMinTime()));
        try
        {
            obj = JsonValue.wrap(obj);
        }
        catch (JsonException jsonexception)
        {
            Logger.error("LocationRequestOptions - Unable to serialize to JSON.", jsonexception);
            return JsonValue.NULL;
        }
        return ((JsonValue) (obj));
    }

    public String toString()
    {
        return (new StringBuilder("LocationRequestOptions: Priority ")).append(priority).append(" minTime ").append(minTime).append(" minDistance ").append(minDistance).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(priority);
        parcel.writeLong(minTime);
        parcel.writeFloat(minDistance);
    }





    private class Builder
    {

        private float minDistance;
        private long minTime;
        private int priority;

        public LocationRequestOptions create()
        {
            return new LocationRequestOptions(this, null);
        }

        public Builder setMinDistance(float f)
        {
            LocationRequestOptions.verifyMinDistance(f);
            minDistance = f;
            return this;
        }

        public Builder setMinTime(long l, TimeUnit timeunit)
        {
            LocationRequestOptions.verifyMinTime(timeunit.toMillis(l));
            minTime = timeunit.toMillis(l);
            return this;
        }

        public Builder setPriority(int i)
        {
            LocationRequestOptions.verifyPriority(i);
            priority = i;
            return this;
        }




        public Builder()
        {
            minTime = 0x493e0L;
            minDistance = 800F;
            priority = 2;
        }
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final LocationRequestOptions createFromParcel(Parcel parcel)
        {
            return new LocationRequestOptions(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final LocationRequestOptions[] newArray(int i)
        {
            return new LocationRequestOptions[i];
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
