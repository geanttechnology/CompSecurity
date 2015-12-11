// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.content.Context;
import com.groupon.util.DialogManager;

public class MobileJSBridge
{

    DialogManager dialogManager;
    Context mContext;

    public MobileJSBridge(Context context)
    {
        mContext = context;
    }

    public void androidBack()
    {
        ((Activity)mContext).finish();
    }

    public void androidClose()
    {
        ((Activity)mContext).finish();
    }

    public void androidError(String s)
    {
        dialogManager.showAlertDialog(mContext.getString(0x7f080341));
        ((Activity)mContext).finish();
    }
}
