// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import a;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import vo;

public class NewVersionAvailableActivity extends Activity
    implements android.view.View.OnClickListener
{

    private TextView a;
    private TextView b;
    private boolean c;

    public NewVersionAvailableActivity()
    {
    }

    public static Intent a(Context context, int i)
    {
        boolean flag = true;
        if (i != 3)
        {
            context = new Intent(context, com/google/android/apps/youtube/kids/activities/NewVersionAvailableActivity);
            context.setFlags(0x10000000);
            if (i != 1)
            {
                flag = false;
            }
            context.putExtra("force_upgrade", flag);
            return context;
        } else
        {
            return null;
        }
    }

    public void onClick(View view)
    {
        if (view == a)
        {
            Uri uri = Uri.parse("https://play.google.com/store/").buildUpon().appendEncodedPath("apps").appendEncodedPath("details").appendQueryParameter("id", getApplication().getPackageName()).build();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("utm_source=app");
            stringbuilder.append("&");
            stringbuilder.append("utm_medium=prompt");
            stringbuilder.append("&");
            if (c)
            {
                view = "force";
            } else
            {
                view = "suggest";
            }
            view = String.valueOf(view);
            if (view.length() != 0)
            {
                view = "utm_campaign=".concat(view);
            } else
            {
                view = new String("utm_campaign=");
            }
            stringbuilder.append(view);
            stringbuilder.append("&");
            view = String.valueOf(a.g(this));
            if (view.length() != 0)
            {
                view = "utm_term=".concat(view);
            } else
            {
                view = new String("utm_term=");
            }
            stringbuilder.append(view);
            view = stringbuilder.toString();
            view = new Intent("android.intent.action.VIEW", uri.buildUpon().appendQueryParameter("referrer", Uri.encode(view)).build());
            if (vo.a(this, view))
            {
                try
                {
                    startActivity(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
            }
            finish();
        } else
        if (view == b)
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040047);
        setTitle(null);
        c = getIntent().getBooleanExtra("force_upgrade", false);
        a = (TextView)findViewById(0x7f100158);
        a.setOnClickListener(this);
        b = (TextView)findViewById(0x7f100157);
        if (c)
        {
            b.setVisibility(8);
            a.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2, 0.0F));
            return;
        } else
        {
            b.setOnClickListener(this);
            return;
        }
    }
}
