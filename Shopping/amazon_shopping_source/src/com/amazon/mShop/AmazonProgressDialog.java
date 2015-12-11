// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amazon.mShop.debug.DebugSettings;

public class AmazonProgressDialog extends AlertDialog
{

    private Context mContext;

    public AmazonProgressDialog(Context context)
    {
        super(context);
        mContext = context;
        context = new RelativeLayout(mContext);
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        context.setGravity(17);
        int i = (int)mContext.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding);
        context.setPadding(i, i, i, i);
        ProgressBar progressbar = new ProgressBar(mContext, null, 0x1010077);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        progressbar.setLayoutParams(layoutparams);
        context.addView(progressbar);
        setView(context);
    }

    public void dismiss()
    {
        super.dismiss();
_L1:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        if (DebugSettings.isDebugEnabled())
        {
            Log.e("AmazonProgressDialog", runtimeexception.getMessage());
            return;
        }
          goto _L1
    }

    public boolean onSearchRequested()
    {
        dismiss();
        return ((Activity)mContext).onSearchRequested();
    }
}
