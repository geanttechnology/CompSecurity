// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class StreamType extends Enum
{

    private static final StreamType $VALUES[];
    public static final StreamType LINEAR;
    public static final StreamType VOD;

    private StreamType(String s, int i)
    {
        super(s, i);
    }

    public static StreamType valueOf(String s)
    {
        return (StreamType)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/StreamType, s);
    }

    public static StreamType[] values()
    {
        return (StreamType[])$VALUES.clone();
    }

    static 
    {
        VOD = new StreamType("VOD", 0);
        LINEAR = new StreamType("LINEAR", 1);
        $VALUES = (new StreamType[] {
            VOD, LINEAR
        });
    }
}
