// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.message;

import android.os.Bundle;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

public class PlaceOfferResultStatus extends ResultStatusOwner
{

    public static String KEY_FINISH = "finish";
    public static String KEY_MSG = "message";
    public static String KEY_RESULT_CODE = "result_code";
    private Bundle bundle;

    public PlaceOfferResultStatus()
    {
        bundle = new Bundle();
    }

    public PlaceOfferResultStatus(int i, boolean flag, String s)
    {
        this();
        bundle.putInt(KEY_RESULT_CODE, i);
        bundle.putBoolean(KEY_FINISH, flag);
        bundle.putString(KEY_MSG, s);
    }

    public PlaceOfferResultStatus(Bundle bundle1)
    {
        this();
        bundle = bundle1;
    }

    public Bundle getBundle()
    {
        return bundle;
    }

    public String getMessage()
    {
        return bundle.getString(KEY_MSG);
    }

    public int getResultCode()
    {
        return bundle.getInt(KEY_RESULT_CODE);
    }

    public boolean isFinish()
    {
        return bundle.getBoolean(KEY_FINISH);
    }

    public void putMessage(String s)
    {
        bundle.putString(KEY_MSG, s);
    }

}
