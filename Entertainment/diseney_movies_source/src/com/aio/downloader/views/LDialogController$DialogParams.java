// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            LDialogController

public static class mInflater
{

    public boolean centerMsg;
    public boolean clickPositiveBtnDismiss;
    public boolean mCancelable;
    public android.content. mCloseListener;
    public final Context mContext;
    public Drawable mIcon;
    public int mIconId;
    public final LayoutInflater mInflater;
    public CharSequence mMessage;
    public android.content. mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public android.content.r mOnCancelListener;
    public android.content. mOnClickListener;
    public android.content. mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public CharSequence mTitle;
    public View mView;
    public boolean visibleCallback;

    public void apply(LDialogController ldialogcontroller)
    {
        ldialogcontroller.setClickPositiveBtnDismiss(clickPositiveBtnDismiss);
        ldialogcontroller.setCenterMsg(centerMsg);
        if (mTitle != null)
        {
            ldialogcontroller.setTitle(mTitle);
        }
        if (mIcon != null)
        {
            ldialogcontroller.setIcon(mIcon);
        }
        ldialogcontroller.setCloseButton(visibleCallback);
        if (mIconId >= 0)
        {
            ldialogcontroller.setIcon(mIconId);
        }
        if (mMessage != null)
        {
            ldialogcontroller.setMessage(mMessage);
        }
        if (mPositiveButtonText != null)
        {
            ldialogcontroller.setButton(-1, mPositiveButtonText, mPositiveButtonListener, null);
        }
        if (mNegativeButtonText != null)
        {
            ldialogcontroller.setButton(-2, mNegativeButtonText, mNegativeButtonListener, null);
        }
        if (mView != null)
        {
            ldialogcontroller.setView(mView);
        }
    }

    public (Context context)
    {
        mIconId = 0;
        mContext = context;
        mCancelable = true;
        clickPositiveBtnDismiss = true;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
}
