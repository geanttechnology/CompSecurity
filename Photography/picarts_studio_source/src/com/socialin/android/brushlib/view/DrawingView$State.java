// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;


public final class  extends Enum
{

    private static final INITIALIZED $VALUES[];
    public static final INITIALIZED INITIALIZED;
    public static final INITIALIZED INITIALIZING;
    public static final INITIALIZED UNINITIALIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNINITIALIZED = new <init>("UNINITIALIZED", 0);
        INITIALIZING = new <init>("INITIALIZING", 1);
        INITIALIZED = new <init>("INITIALIZED", 2);
        $VALUES = (new .VALUES[] {
            UNINITIALIZED, INITIALIZING, INITIALIZED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
