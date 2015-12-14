// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            Indicator

public class NetworkIndicator extends Indicator
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status OFFLINE;
        public static final Status UNRELIABLE;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/gallery/framework/kindle/ui/NetworkIndicator$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            OFFLINE = new Status("OFFLINE", 0);
            UNRELIABLE = new Status("UNRELIABLE", 1);
            $VALUES = (new Status[] {
                OFFLINE, UNRELIABLE
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private Context activityContext;
    private Runnable hideOnUIThread;
    private final TextView indicatorText;
    private volatile boolean isLocalView;
    private boolean isPortrait;
    private final ViewGroup layout;
    private final SharedPreferences mSharedPreferences;
    private NetworkConnectivity networkConnectivity;
    private AlertDialog noWifiDialog;
    private Runnable showOnUIThread;
    private boolean showing;
    private Status status;

    public NetworkIndicator(Activity activity, NetworkConnectivity networkconnectivity, ViewGroup viewgroup)
    {
        showing = false;
        status = Status.OFFLINE;
        noWifiDialog = null;
        isLocalView = false;
        showOnUIThread = new Runnable() {

            final NetworkIndicator this$0;

            public void run()
            {
                layout.setClickable(true);
                layout.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        noWifiDialog = networkConnectivity.promptNoWifi(activityContext);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                layout.setVisibility(0);
            }

            
            {
                this$0 = NetworkIndicator.this;
                super();
            }
        };
        hideOnUIThread = new Runnable() {

            final NetworkIndicator this$0;

            public void run()
            {
                layout.setVisibility(8);
            }

            
            {
                this$0 = NetworkIndicator.this;
                super();
            }
        };
        activityContext = activity;
        networkConnectivity = networkconnectivity;
        layout = viewgroup;
        indicatorText = (TextView)viewgroup.findViewById(0x7f0c018b);
        mSharedPreferences = activity.getSharedPreferences("galleryKindleSharedPrefs", 0);
        boolean flag;
        if (activity.getResources().getConfiguration().orientation == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPortrait = flag;
        hide();
    }

    private void hide()
    {
        showing = false;
        layout.setVisibility(8);
    }

    private void hideOnUIThread()
    {
        showing = false;
        layout.post(hideOnUIThread);
    }

    private void show(final Status status)
    {
        showing = true;
        layout.post(new Runnable() {

            final NetworkIndicator this$0;
            final Status val$status;

            public void run()
            {
                updateText(status);
            }

            
            {
                this$0 = NetworkIndicator.this;
                status = status1;
                super();
            }
        });
        layout.post(showOnUIThread);
    }

    public View getView()
    {
        return layout;
    }

    public void onDestroy()
    {
        if (noWifiDialog != null)
        {
            noWifiDialog.dismiss();
        }
        activityContext = null;
    }

    public void setIsLocalView(boolean flag)
    {
        isLocalView = flag;
    }

    public void showIndicator(boolean flag, Status status1)
    {
        if (isEnabled())
        {
            if (!mSharedPreferences.getBoolean("coldBootStatus", false) && isPortrait)
            {
                hideOnUIThread();
                return;
            }
            if (activityContext != null && (activityContext instanceof CommonActivity) && ((CommonActivity)activityContext).getLocalView())
            {
                hideOnUIThread();
                return;
            }
            if (flag && !showing)
            {
                show(status1);
                return;
            }
            if (!flag && showing)
            {
                hideOnUIThread();
                return;
            }
        }
    }

    public void updateText(Status status1)
    {
        if (status != status1)
        {
            int i;
            if (status1 == Status.UNRELIABLE)
            {
                i = 0x7f0e0054;
            } else
            {
                i = 0x7f0e0053;
            }
            indicatorText.setText(i);
            status = status1;
        }
    }



/*
    static AlertDialog access$102(NetworkIndicator networkindicator, AlertDialog alertdialog)
    {
        networkindicator.noWifiDialog = alertdialog;
        return alertdialog;
    }

*/


}
