// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;


public final class  extends Enum
{

    public static final NONE NONE;
    public static final NONE OBJECT;
    public static final NONE USER;
    private static final NONE eN[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flurry/android/caching/ObjectData$ExecutorType, s);
    }

    public static [] values()
    {
        return ([])eN.clone();
    }

    static 
    {
        OBJECT = new <init>("OBJECT", 0);
        USER = new <init>("USER", 1);
        NONE = new <init>("NONE", 2);
        eN = (new eN[] {
            OBJECT, USER, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
