// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.metrics;

import android.os.Parcel;
import android.os.Parcelable;

public class MetricIdentifier
    implements Parcelable
{
    public static final class Level extends Enum
    {

        private static final Level $VALUES[];
        public static final Level CRITICAL;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level WARN;

        public static Level fromCode(int i)
        {
            Level alevel[] = values();
            int k = alevel.length;
            for (int j = 0; j < k; j++)
            {
                Level level = alevel[j];
                if (level.ordinal() == i)
                {
                    return level;
                }
            }

            throw new IllegalArgumentException();
        }

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/amazon/dcp/metrics/MetricIdentifier$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        static 
        {
            INFO = new Level("INFO", 0);
            WARN = new Level("WARN", 1);
            ERROR = new Level("ERROR", 2);
            CRITICAL = new Level("CRITICAL", 3);
            $VALUES = (new Level[] {
                INFO, WARN, ERROR, CRITICAL
            });
        }

        private Level(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MetricIdentifier createFromParcel(Parcel parcel)
        {
            return new MetricIdentifier(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MetricIdentifier[] newArray(int i)
        {
            return new MetricIdentifier[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final String mComponent;
    final String mDomain;
    final Level mLevel;
    final String mName;
    String mPackage;

    public MetricIdentifier(Parcel parcel)
    {
        this(Level.fromCode(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
    }

    public MetricIdentifier(Level level, String s, String s1, String s2)
    {
        if (level == null || s == null || s1 == null || s2 == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            mLevel = level;
            mDomain = s;
            mComponent = s1;
            mName = s2;
            mPackage = "unknown";
            return;
        }
    }

    private static boolean equivalentStrings(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null;
        } else
        {
            return s.equals(s1);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof MetricIdentifier)
        {
            if (equivalentStrings(mDomain, ((MetricIdentifier) (obj = (MetricIdentifier)obj)).getDomain()) && equivalentStrings(mComponent, ((MetricIdentifier) (obj)).getComponent()) && equivalentStrings(mName, ((MetricIdentifier) (obj)).getName()))
            {
                return true;
            }
        }
        return false;
    }

    public String getComponent()
    {
        return mComponent;
    }

    public String getDomain()
    {
        return mDomain;
    }

    public String getName()
    {
        return mName;
    }

    public int hashCode()
    {
        return ((mComponent.hashCode() + 31) * 31 + mDomain.hashCode()) * 31 + mName.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(").append(mLevel.toString().charAt(0)).append(") ").append(mDomain).append(":").append(mComponent).append(":").append(mName);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mLevel.ordinal());
        parcel.writeString(mDomain);
        parcel.writeString(mComponent);
        parcel.writeString(mName);
    }

}
