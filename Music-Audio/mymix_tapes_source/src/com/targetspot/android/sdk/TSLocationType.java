// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSLocationType extends Enum
{

    private static final TSLocationType $VALUES[];
    public static final TSLocationType TSLocationBestAvailable;
    public static final TSLocationType TSLocationLastKnown;
    public static final TSLocationType TSLocationPostalCode;
    public static final TSLocationType TSLocationUnknown;
    public static final TSLocationType TSLocationUseNetowrk;
    private final int locationType;

    private TSLocationType(String s, int i, int j)
    {
        super(s, i);
        locationType = j;
    }

    public static TSLocationType valueOf(String s)
    {
        return (TSLocationType)Enum.valueOf(com/targetspot/android/sdk/TSLocationType, s);
    }

    public static TSLocationType[] values()
    {
        return (TSLocationType[])$VALUES.clone();
    }

    public int getLocationType()
    {
        return locationType;
    }

    static 
    {
        TSLocationBestAvailable = new TSLocationType("TSLocationBestAvailable", 0, 0);
        TSLocationUseNetowrk = new TSLocationType("TSLocationUseNetowrk", 1, 1);
        TSLocationLastKnown = new TSLocationType("TSLocationLastKnown", 2, 2);
        TSLocationPostalCode = new TSLocationType("TSLocationPostalCode", 3, 3);
        TSLocationUnknown = new TSLocationType("TSLocationUnknown", 4, 4);
        $VALUES = (new TSLocationType[] {
            TSLocationBestAvailable, TSLocationUseNetowrk, TSLocationLastKnown, TSLocationPostalCode, TSLocationUnknown
        });
    }
}
