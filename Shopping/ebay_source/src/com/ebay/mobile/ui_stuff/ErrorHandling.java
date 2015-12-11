// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.app.Activity;
import com.ebay.mobile.activities.ErrorDialogActivity;

public class ErrorHandling
{

    public ErrorHandling()
    {
    }

    public static void invalid_quantity(Activity activity)
    {
        ErrorDialogActivity.StartActivity(activity, "UI-11", activity.getString(0x7f070483));
    }
}
