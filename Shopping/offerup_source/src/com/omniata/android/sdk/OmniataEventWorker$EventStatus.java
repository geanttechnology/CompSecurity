// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;


final class  extends Enum
{

    private static final DISCARD $VALUES[];
    public static final DISCARD DISCARD;
    public static final DISCARD RETRY;
    public static final DISCARD SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/omniata/android/sdk/OmniataEventWorker$EventStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0);
        RETRY = new <init>("RETRY", 1);
        DISCARD = new <init>("DISCARD", 2);
        $VALUES = (new .VALUES[] {
            SUCCESS, RETRY, DISCARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
