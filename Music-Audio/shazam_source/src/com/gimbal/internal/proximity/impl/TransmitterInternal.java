// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.gimbal.proguard.Keep;

public class TransmitterInternal
    implements Parcelable, Keep
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TransmitterInternal(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new TransmitterInternal[i];
        }

    };
    private int battery;
    private String iconUrl;
    private String identifier;
    private String name;
    private String ownerId;
    private int temperature;
    private String uuid;

    public TransmitterInternal()
    {
    }

    private TransmitterInternal(Parcel parcel)
    {
        identifier = parcel.readString();
        name = parcel.readString();
        ownerId = parcel.readString();
        iconUrl = parcel.readString();
        battery = parcel.readInt();
        temperature = parcel.readInt();
        uuid = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TransmitterInternal)obj;
            if (battery != ((TransmitterInternal) (obj)).battery)
            {
                return false;
            }
            if (iconUrl == null)
            {
                if (((TransmitterInternal) (obj)).iconUrl != null)
                {
                    return false;
                }
            } else
            if (!iconUrl.equals(((TransmitterInternal) (obj)).iconUrl))
            {
                return false;
            }
            if (identifier == null)
            {
                if (((TransmitterInternal) (obj)).identifier != null)
                {
                    return false;
                }
            } else
            if (!identifier.equals(((TransmitterInternal) (obj)).identifier))
            {
                return false;
            }
            if (uuid == null)
            {
                if (((TransmitterInternal) (obj)).uuid != null)
                {
                    return false;
                }
            } else
            if (!uuid.equals(((TransmitterInternal) (obj)).uuid))
            {
                return false;
            }
            if (name == null)
            {
                if (((TransmitterInternal) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((TransmitterInternal) (obj)).name))
            {
                return false;
            }
            if (ownerId == null)
            {
                if (((TransmitterInternal) (obj)).ownerId != null)
                {
                    return false;
                }
            } else
            if (!ownerId.equals(((TransmitterInternal) (obj)).ownerId))
            {
                return false;
            }
            if (temperature != ((TransmitterInternal) (obj)).temperature)
            {
                return false;
            }
        }
        return true;
    }

    public int getBattery()
    {
        return battery;
    }

    public String getIconUrl()
    {
        return iconUrl;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getName()
    {
        return name;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public String getUuid()
    {
        return uuid;
    }

    public int hashCode()
    {
        int i1 = 0;
        int j1 = battery;
        int i;
        int j;
        int k;
        int l;
        if (iconUrl == null)
        {
            i = 0;
        } else
        {
            i = iconUrl.hashCode();
        }
        if (identifier == null)
        {
            j = 0;
        } else
        {
            j = identifier.hashCode();
        }
        if (uuid == null)
        {
            k = 0;
        } else
        {
            k = uuid.hashCode();
        }
        if (name == null)
        {
            l = 0;
        } else
        {
            l = name.hashCode();
        }
        if (ownerId != null)
        {
            i1 = ownerId.hashCode();
        }
        return ((l + (k + (j + (i + (j1 + 31) * 31) * 31) * 31) * 31) * 31 + i1) * 31 + temperature;
    }

    public void setBattery(Integer integer)
    {
        battery = integer.intValue();
    }

    public void setIconUrl(String s)
    {
        iconUrl = s;
    }

    public void setIdentifier(String s)
    {
        identifier = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setOwnerId(String s)
    {
        ownerId = s;
    }

    public void setTemperature(Integer integer)
    {
        temperature = integer.intValue();
    }

    public void setUuid(String s)
    {
        uuid = s;
    }

    public String toString()
    {
        return (new StringBuilder("TransmitterInternal [identifier=")).append(identifier).append(", uuid=").append(uuid).append(", name=").append(name).append(", ownerId=").append(ownerId).append(", iconUrl=").append(iconUrl).append(", battery=").append(battery).append(", temperature=").append(temperature).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(identifier);
        parcel.writeString(name);
        parcel.writeString(ownerId);
        parcel.writeString(iconUrl);
        parcel.writeInt(battery);
        parcel.writeInt(temperature);
        parcel.writeString(uuid);
    }

}
