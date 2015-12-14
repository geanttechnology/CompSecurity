// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;


public final class ProcessType extends Enum
{

    private static final ProcessType $VALUES[];
    public static final ProcessType TGifType;
    public static final ProcessType TLightStream;
    public static final ProcessType TSingleType;

    private ProcessType(String s, int i)
    {
        super(s, i);
    }

    public static ProcessType valueOf(String s)
    {
        return (ProcessType)Enum.valueOf(com/wantu/imagelib/filter/ProcessType, s);
    }

    public static ProcessType[] values()
    {
        return (ProcessType[])$VALUES.clone();
    }

    static 
    {
        TSingleType = new ProcessType("TSingleType", 0);
        TGifType = new ProcessType("TGifType", 1);
        TLightStream = new ProcessType("TLightStream", 2);
        $VALUES = (new ProcessType[] {
            TSingleType, TGifType, TLightStream
        });
    }
}
