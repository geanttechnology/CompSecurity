// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android;

import com.gimbal.proguard.Keep;

public class Beacon
    implements Keep
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/gimbal/android/Beacon$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("LOW", 0);
            b = new a("MEDIUM_LOW", 1);
            c = new a("MEDIUM_HIGH", 2);
            d = new a("HIGH", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a batteryLevel;
    private String iconURL;
    private String identifier;
    private String name;
    private int temperature;
    private String uuid;

    public Beacon()
    {
    }

    private void setBatteryLevel(a a1)
    {
        batteryLevel = a1;
    }

    private void setIconURL(String s)
    {
        iconURL = s;
    }

    private void setIdentifier(String s)
    {
        identifier = s;
    }

    private void setName(String s)
    {
        name = s;
    }

    private void setTemperature(int i)
    {
        temperature = i;
    }

    private void setUuid(String s)
    {
        uuid = s;
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
            obj = (Beacon)obj;
            if (!identifier.equals(((Beacon) (obj)).identifier))
            {
                return false;
            }
        }
        return true;
    }

    public a getBatteryLevel()
    {
        return batteryLevel;
    }

    public String getIconURL()
    {
        return iconURL;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getName()
    {
        return name;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public String getUuid()
    {
        return uuid;
    }

    public String toString()
    {
        if (temperature == 0x7fffffff)
        {
            return (new StringBuilder("Beacon [identifier=")).append(identifier).append(", name=").append(name).append(", iconURL=").append(iconURL).append(", batteryLevel=").append(batteryLevel).append(", temperature=N/A]").toString();
        } else
        {
            return (new StringBuilder("Beacon [identifier=")).append(identifier).append(", name=").append(name).append(", iconURL=").append(iconURL).append(", batteryLevel=").append(batteryLevel).append(", temperature=").append(temperature).append("]").toString();
        }
    }
}
