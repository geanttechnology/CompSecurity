// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.hh;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.abtnprojects.ambatana.ui.activities.ContactActivity;

public class b extends Dialog
{

    private final hh a;

    public b(Context context, hh hh1)
    {
        super(context);
        requestWindowFeature(1);
        setCancelable(true);
        setContentView(0x7f040038);
        a = hh1;
    }

    static hh a(b b1)
    {
        return b1.a;
    }

    public void a(Activity activity)
    {
        ((RelativeLayout)findViewById(0x7f1000f5)).setOnClickListener(new android.view.View.OnClickListener(activity) {

            final Activity a;
            final b b;

            public void onClick(View view)
            {
                b.a(b).b(a);
                b.dismiss();
                b.b(a);
            }

            
            {
                b = b.this;
                a = activity;
                super();
            }
        });
        ((RelativeLayout)findViewById(0x7f1000f9)).setOnClickListener(new android.view.View.OnClickListener(activity) {

            final Activity a;
            final b b;

            public void onClick(View view)
            {
                b.a(b).c(a);
                b.dismiss();
                view = new Intent(a, com/abtnprojects/ambatana/ui/activities/ContactActivity);
                a.startActivity(view);
            }

            
            {
                b = b.this;
                a = activity;
                super();
            }
        });
        ((TextView)findViewById(0x7f1000fc)).setOnClickListener(new android.view.View.OnClickListener(activity) {

            final Activity a;
            final b b;

            public void onClick(View view)
            {
                b.a(b).d(a);
                b.dismiss();
            }

            
            {
                b = b.this;
                a = activity;
                super();
            }
        });
        show();
        a.a(activity);
    }

    protected void b(Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(activity.getPackageName()).toString()));
        intent.addFlags(0x48080000);
        try
        {
            activity.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(activity.getPackageName()).toString())));
        }
    }
}
