// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;


public final class _cls9 extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN GIF;
    public static final UNKNOWN JPEG;
    public static final UNKNOWN PNG;
    public static final UNKNOWN RAW;
    public static final UNKNOWN UNKNOWN;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/socialin/android/util/FileUtils$ImageFileFormat, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        PNG = new <init>("PNG", 0);
        JPEG = new <init>("JPEG", 1);
        GIF = new <init>("GIF", 2);
        RAW = new <init>("RAW", 3);
        UNKNOWN = new <init>("UNKNOWN", 4);
        $VALUES = (new .VALUES[] {
            PNG, JPEG, GIF, RAW, UNKNOWN
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
