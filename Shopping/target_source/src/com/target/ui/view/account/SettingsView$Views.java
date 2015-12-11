// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.account:
//            SettingsView

static class  extends a
{

    View instoreLocation;
    SwitchCompat instoreLocationToggle;
    private notificationToggle mListener;
    View notification;
    SwitchCompat notificationToggle;

    public void a( )
    {
        mListener = ;
    }

    protected void inStoreLocationChanged(boolean flag)
    {
        if (mListener != null)
        {
            mListener.mListener(flag);
        }
    }

    protected void notificationChanged(boolean flag)
    {
        if (mListener != null)
        {
            mListener.mListener(flag);
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

    protected (View view)
    {
        super(view);
    }
}
