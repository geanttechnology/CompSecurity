// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AmazonAlertDialog extends AlertDialog
{
    public static class Builder
    {

        private View mContentView;
        private Drawable mIcon;
        private Boolean myCancelable;
        private final Context myContext;
        private CharSequence myMessage;
        private ButtonData myNegativeButton;
        private ButtonData myNeutralButton;
        private android.content.DialogInterface.OnCancelListener myOnCancelListener;
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

        public Builder setCancelable(boolean flag)
        {
            myCancelable = Boolean.valueOf(flag);
            return this;
        }

        public Builder setMessage(int i)
        {
            return setMessage(myContext.getText(i));
        }

        public Builder setMessage(CharSequence charsequence)
        {
            myMessage = charsequence;
            return this;
        }

        public Builder setNegativeButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            myNegativeButton = new ButtonData(i, onclicklistener);
            return this;
        }

        public Builder setNeutralButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            myNeutralButton = new ButtonData(i, onclicklistener);
            return this;
        }

        public Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
        {
            myOnCancelListener = oncancellistener;
            return this;
        }

        public Builder setPositiveButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            myPositiveButton = new ButtonData(i, onclicklistener);
            return this;
        }

        public Builder setTitle(int i)
        {
            return setTitle(myContext.getText(i));
        }

        public Builder setTitle(CharSequence charsequence)
        {
            myTitle = charsequence;
            return this;
        }

        public Builder setView(View view)
        {
            mContentView = view;
            return this;
        }

        public Builder(Context context)
        {
            myContext = context;
        }
    }

    private class Builder.ButtonData
    {

        public final android.content.DialogInterface.OnClickListener listener;
        public final int textResId;
        final Builder this$0;

        private Builder.ButtonData(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            this$0 = Builder.this;
            super();
            textResId = i;
            listener = onclicklistener;
        }

    }


    public final int BUTTON_TEXT_LINE_NUM = 2;
    private boolean dismissedOnTrackBall;
    private Context mContext;

    public AmazonAlertDialog(Context context)
    {
        super(context);
        dismissedOnTrackBall = false;
        mContext = context;
    }

    public static void customizeAlertDialog(Context context, AmazonAlertDialog amazonalertdialog, String s, ListAdapter listadapter, android.widget.AdapterView.OnItemClickListener onitemclicklistener, int i)
    {
        if (listadapter != null)
        {
            ListView listview = new ListView(context);
            listview.setOnItemClickListener(onitemclicklistener);
            listview.setBackgroundResource(com.amazon.mShop.android.lib.R.color.white);
            listview.setCacheColorHint(context.getResources().getColor(com.amazon.mShop.android.lib.R.color.white));
            listview.setSelector(com.amazon.mShop.android.lib.R.color.common_selector);
            listview.setAdapter(listadapter);
            listview.setScrollbarFadingEnabled(false);
            if (i >= 0)
            {
                listview.setSelection(i);
            }
            amazonalertdialog.setView(listview, 0, 0, 0, 0);
        }
        amazonalertdialog.setTitle(s);
    }

    protected void adjustWidgets()
    {
        Button button = getButton(-1);
        if (button != null)
        {
            button.setLines(BUTTON_TEXT_LINE_NUM);
        }
        button = getButton(-3);
        if (button != null)
        {
            button.setLines(BUTTON_TEXT_LINE_NUM);
        }
        button = getButton(-2);
        if (button != null)
        {
            button.setLines(BUTTON_TEXT_LINE_NUM);
        }
    }

    public void dismiss()
    {
        try
        {
            super.dismiss();
            return;
        }
        catch (Exception exception)
        {
            Log.e("AmazonAlertDialog", exception.getMessage());
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adjustWidgets();
    }

    public boolean onSearchRequested()
    {
        dismiss();
        return ((Activity)mContext).onSearchRequested();
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (dismissedOnTrackBall && motionevent.getAction() == 0)
        {
            super.cancel();
        }
        return super.onTrackballEvent(motionevent);
    }

    public void setDismissedOnTrackBall(boolean flag)
    {
        dismissedOnTrackBall = flag;
    }

    public void show()
    {
        try
        {
            super.show();
            return;
        }
        catch (Exception exception)
        {
            Log.e("AmazonAlertDialog", exception.getMessage());
        }
    }
}
