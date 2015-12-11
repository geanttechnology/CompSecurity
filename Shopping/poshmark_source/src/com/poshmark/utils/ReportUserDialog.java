// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ReportUserDialog
{
    public static interface ReportReasonListener
    {

        public abstract void reasonPicked(String s);
    }


    static android.view.View.OnClickListener reportUserOrListingListener = new android.view.View.OnClickListener() {

        public void onClick(View view)
        {
        }

    };
    View alertView;
    AlertDialog dialog;
    int layoutId;
    ReportReasonListener listener;
    Activity parent;
    android.view.View.OnClickListener reasonButtonListener;

    public ReportUserDialog(Activity activity, ReportReasonListener reportreasonlistener)
    {
        reasonButtonListener = new android.view.View.OnClickListener() {

            final ReportUserDialog this$0;

            public void onClick(View view)
            {
                listener.reasonPicked((String)view.getTag());
                dialog.hide();
            }

            
            {
                this$0 = ReportUserDialog.this;
                super();
            }
        };
        layoutId = layoutId;
        parent = activity;
        listener = reportreasonlistener;
        alertView = activity.getLayoutInflater().inflate(0x7f0300a7, null);
        dialog = (new android.app.AlertDialog.Builder(activity)).setView(alertView).setTitle("Report User").create();
        setupButtonHandlers();
    }

    private void setupButtonHandlers()
    {
        Button button = (Button)alertView.findViewById(0x7f0c0274);
        button.setOnClickListener(reasonButtonListener);
        button.setTag("replica");
        button = (Button)alertView.findViewById(0x7f0c0275);
        button.setOnClickListener(reasonButtonListener);
        button.setTag("offline_transaction");
        button = (Button)alertView.findViewById(0x7f0c0276);
        button.setOnClickListener(reasonButtonListener);
        button.setTag("not_allowed_items");
        button = (Button)alertView.findViewById(0x7f0c0277);
        button.setOnClickListener(reasonButtonListener);
        button.setTag("spam");
        button = (Button)alertView.findViewById(0x7f0c0278);
        button.setOnClickListener(reasonButtonListener);
        button.setTag("harassment");
    }

    public void show()
    {
        dialog.show();
    }

}
