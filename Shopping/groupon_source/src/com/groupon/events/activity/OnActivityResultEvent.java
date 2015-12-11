// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events.activity;

import android.app.Activity;
import android.content.Intent;

public class OnActivityResultEvent
{

    protected final Activity activity;
    protected final Intent data;
    protected final int requestCode;
    protected final int resultCode;

    public OnActivityResultEvent(Activity activity1, int i, int j, Intent intent)
    {
        activity = activity1;
        requestCode = i;
        resultCode = j;
        data = intent;
    }

    public Activity getActivity()
    {
        return activity;
    }

    public Intent getData()
    {
        return data;
    }

    public int getRequestCode()
    {
        return requestCode;
    }

    public int getResultCode()
    {
        return resultCode;
    }
}
