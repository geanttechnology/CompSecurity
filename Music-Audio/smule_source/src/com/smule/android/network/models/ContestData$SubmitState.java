// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;


public final class  extends Enum
{

    private static final SUBMIT_ERROR $VALUES[];
    public static final SUBMIT_ERROR NOT_SUBMITTED;
    public static final SUBMIT_ERROR SUBMIT_ERROR;
    public static final SUBMIT_ERROR SUBMIT_EXPIRED;
    public static final SUBMIT_ERROR SUBMIT_SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/smule/android/network/models/ContestData$SubmitState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_SUBMITTED = new <init>("NOT_SUBMITTED", 0);
        SUBMIT_SUCCESS = new <init>("SUBMIT_SUCCESS", 1);
        SUBMIT_EXPIRED = new <init>("SUBMIT_EXPIRED", 2);
        SUBMIT_ERROR = new <init>("SUBMIT_ERROR", 3);
        $VALUES = (new .VALUES[] {
            NOT_SUBMITTED, SUBMIT_SUCCESS, SUBMIT_EXPIRED, SUBMIT_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
