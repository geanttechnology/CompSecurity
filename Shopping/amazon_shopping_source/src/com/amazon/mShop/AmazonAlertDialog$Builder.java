// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package com.amazon.mShop:
//            AmazonAlertDialog

public static class myContext
{
    private class ButtonData
    {

        public final android.content.DialogInterface.OnClickListener listener;
        public final int textResId;
        final AmazonAlertDialog.Builder this$0;

        private ButtonData(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            this$0 = AmazonAlertDialog.Builder.this;
            super();
            textResId = i;
            listener = onclicklistener;
        }

        ButtonData(int i, android.content.DialogInterface.OnClickListener onclicklistener, AmazonAlertDialog._cls1 _pcls1)
        {
            this(i, onclicklistener);
        }
    }


    private View mContentView;
    private Drawable mIcon;
    private Boolean myCancelable;
    private final Context myContext;
    private CharSequence myMessage;
    private ButtonData myNegativeButton;
    private ButtonData myNeutralButton;
    private android.content.stener myOnCancelListener;
    private ButtonData myPositiveButton;
    private CharSequence myTitle;

    public AmazonAlertDialog create()
    {
        return init(new AmazonAlertDialog(myContext));
    }

    public AmazonAlertDialog init(AmazonAlertDialog amazonalertdialog)
    {
        if (mContentView != null)
        {
            amazonalertdialog.setView(mContentView);
        }
        if (myTitle != null)
        {
            amazonalertdialog.setTitle(myTitle);
        }
        if (myMessage != null)
        {
            amazonalertdialog.setMessage(myMessage);
        }
        if (myPositiveButton != null)
        {
            amazonalertdialog.setButton(-1, myContext.getText(myPositiveButton.textResId), myPositiveButton.listener);
        }
        if (myNeutralButton != null)
        {
            amazonalertdialog.setButton(-3, myContext.getText(myNeutralButton.textResId), myNeutralButton.listener);
        }
        if (myNegativeButton != null)
        {
            amazonalertdialog.setButton(-2, myContext.getText(myNegativeButton.textResId), myNegativeButton.listener);
        }
        if (myCancelable != null)
        {
            amazonalertdialog.setCancelable(myCancelable.booleanValue());
        }
        if (myOnCancelListener != null)
        {
            amazonalertdialog.setOnCancelListener(myOnCancelListener);
        }
        if (mIcon != null)
        {
            amazonalertdialog.setIcon(mIcon);
        }
        return amazonalertdialog;
    }

    public mIcon setCancelable(boolean flag)
    {
        myCancelable = Boolean.valueOf(flag);
        return this;
    }

    public myCancelable setMessage(int i)
    {
        return setMessage(myContext.getText(i));
    }

    public myContext setMessage(CharSequence charsequence)
    {
        myMessage = charsequence;
        return this;
    }

    public ener setNegativeButton(int i, android.content.tener tener)
    {
        myNegativeButton = new ButtonData(i, tener, null);
        return this;
    }

    public ener setNeutralButton(int i, android.content.tener tener)
    {
        myNeutralButton = new ButtonData(i, tener, null);
        return this;
    }

    public tener setOnCancelListener(android.content.stener stener)
    {
        myOnCancelListener = stener;
        return this;
    }

    public ener setPositiveButton(int i, android.content.tener tener)
    {
        myPositiveButton = new ButtonData(i, tener, null);
        return this;
    }

    public ener setTitle(int i)
    {
        return setTitle(myContext.getText(i));
    }

    public myContext setTitle(CharSequence charsequence)
    {
        myTitle = charsequence;
        return this;
    }

    public myTitle setView(View view)
    {
        mContentView = view;
        return this;
    }

    public ener(Context context)
    {
        myContext = context;
    }
}
