// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.support.v4.a.a;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class SettingsView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View instoreLocation;
        SwitchCompat instoreLocationToggle;
        private a mListener;
        View notification;
        SwitchCompat notificationToggle;

        public void a(a a1)
        {
            mListener = a1;
        }

        protected void inStoreLocationChanged(boolean flag)
        {
            if (mListener != null)
            {
                mListener.b(flag);
            }
        }

        protected void notificationChanged(boolean flag)
        {
            if (mListener != null)
            {
                mListener.a(flag);
            }
        }

        void onLocationViewClicked()
        {
            instoreLocationToggle.toggle();
        }

        void onSettingsViewClicked()
        {
            notificationToggle.toggle();
        }

        protected Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(boolean flag);

        public abstract void b(boolean flag);
    }


    private Views mViews;

    public SettingsView(Context context)
    {
        super(context);
        a(context);
    }

    public SettingsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public SettingsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        setOrientation(1);
        setShowDividers(2);
        setDividerDrawable(android.support.v4.a.a.a(context, 0x7f0201b2));
        inflate(context, 0x7f0301f2, this);
        mViews = new Views(this);
    }

    public void setInStoreLocationEnabled(boolean flag)
    {
        mViews.instoreLocationToggle.setChecked(flag);
    }

    public void setNotificationEnabled(boolean flag)
    {
        mViews.notificationToggle.setChecked(flag);
    }

    public void setSettingsViewListener(a a1)
    {
        mViews.a(a1);
    }
}
