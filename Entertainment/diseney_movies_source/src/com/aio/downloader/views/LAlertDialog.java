// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.aio.downloader.views:
//            LDialogController

public class LAlertDialog extends Dialog
    implements DialogInterface
{
    public static class Builder
    {

        private final LDialogController.DialogParams P;

        public LAlertDialog create()
        {
            LAlertDialog lalertdialog = new LAlertDialog(P.mContext);
            P.apply(lalertdialog.control);
            lalertdialog.setCancelable(P.mCancelable);
            if (P.mCancelable)
            {
                lalertdialog.setCanceledOnTouchOutside(true);
            }
            lalertdialog.setOnCancelListener(P.mOnCancelListener);
            return lalertdialog;
        }

        public Builder setCancelable(boolean flag)
        {
            P.mCancelable = flag;
            return this;
        }

        public Builder setCenterMsg(boolean flag)
        {
            P.centerMsg = flag;
            return this;
        }

        public Builder setClickPositiveBtnDismiss(boolean flag)
        {
            P.clickPositiveBtnDismiss = flag;
            return this;
        }

        public Builder setIcon(int i)
        {
            P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable)
        {
            P.mIcon = drawable;
            return this;
        }

        public Builder setMessage(int i)
        {
            P.mMessage = P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charsequence)
        {
            P.mMessage = charsequence;
            return this;
        }

        public Builder setNegativeButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            P.mNegativeButtonText = P.mContext.getText(i);
            P.mNegativeButtonListener = onclicklistener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            P.mNegativeButtonText = charsequence;
            P.mNegativeButtonListener = onclicklistener;
            return this;
        }

        public Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
        {
            P.mOnCancelListener = oncancellistener;
            return this;
        }

        public Builder setPositiveButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            P.mPositiveButtonText = P.mContext.getText(i);
            P.mPositiveButtonListener = onclicklistener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            P.mPositiveButtonText = charsequence;
            P.mPositiveButtonListener = onclicklistener;
            return this;
        }

        public Builder setTitle(int i)
        {
            P.mTitle = P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charsequence)
        {
            P.mTitle = charsequence;
            return this;
        }

        public Builder setView(View view)
        {
            P.mView = view;
            return this;
        }

        public LAlertDialog show()
        {
            LAlertDialog lalertdialog = create();
            lalertdialog.show();
            return lalertdialog;
        }

        public Builder showCloseButton(boolean flag)
        {
            P.visibleCallback = flag;
            return this;
        }

        public Builder(Context context)
        {
            P = new LDialogController.DialogParams(context);
        }
    }

    public static interface VisibleCallback
    {

        public abstract void onclick();
    }


    private static final int default_theme = 0;
    private LDialogController control;

    protected LAlertDialog(Context context)
    {
        this(context, 0);
        getWindow().setBackgroundDrawableResource(0x7f020145);
    }

    protected LAlertDialog(Context context, int i)
    {
        super(context, i);
        control = new LDialogController(context, this, getWindow());
    }

    protected LAlertDialog(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, 0);
        setCancelable(flag);
        setOnCancelListener(oncancellistener);
        control = new LDialogController(context, this, getWindow());
    }

    public LDialogController getController()
    {
        return control;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        control.installContent();
    }

    public void setPositiveButtonEnable(boolean flag)
    {
        control.setPositiveButtonEnable(flag);
    }

}
