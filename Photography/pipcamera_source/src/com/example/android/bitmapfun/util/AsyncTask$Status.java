// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;


public final class _cls9 extends Enum
{

    private static final FINISHED $VALUES[];
    public static final FINISHED FINISHED;
    public static final FINISHED PENDING;
    public static final FINISHED RUNNING;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/example/android/bitmapfun/util/AsyncTask$Status, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        PENDING = new <init>("PENDING", 0);
        RUNNING = new <init>("RUNNING", 1);
        FINISHED = new <init>("FINISHED", 2);
        $VALUES = (new .VALUES[] {
            PENDING, RUNNING, FINISHED
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
