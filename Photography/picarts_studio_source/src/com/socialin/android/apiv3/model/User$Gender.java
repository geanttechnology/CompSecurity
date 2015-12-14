// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN FEMALE;
    public static final UNKNOWN MALE;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/apiv3/model/User$Gender, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FEMALE = new <init>("FEMALE", 0);
        MALE = new <init>("MALE", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            FEMALE, MALE, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
