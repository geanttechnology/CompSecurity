// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSAdType extends Enum
{

    private static final TSAdType $VALUES[];
    public static final TSAdType TSAdTypeAudio;
    public static final TSAdType TSAdTypeGraphic;
    public static final TSAdType TSAdTypeText;
    public static final TSAdType TSAdTypeVideo;
    private final int adType;

    private TSAdType(String s, int i, int j)
    {
        super(s, i);
        adType = j;
    }

    public static TSAdType valueOf(String s)
    {
        return (TSAdType)Enum.valueOf(com/targetspot/android/sdk/TSAdType, s);
    }

    public static TSAdType[] values()
    {
        return (TSAdType[])$VALUES.clone();
    }

    public int getAdType()
    {
        return adType;
    }

    static 
    {
        TSAdTypeAudio = new TSAdType("TSAdTypeAudio", 0, 0);
        TSAdTypeVideo = new TSAdType("TSAdTypeVideo", 1, 1);
        TSAdTypeText = new TSAdType("TSAdTypeText", 2, 2);
        TSAdTypeGraphic = new TSAdType("TSAdTypeGraphic", 3, 3);
        $VALUES = (new TSAdType[] {
            TSAdTypeAudio, TSAdTypeVideo, TSAdTypeText, TSAdTypeGraphic
        });
    }
}
