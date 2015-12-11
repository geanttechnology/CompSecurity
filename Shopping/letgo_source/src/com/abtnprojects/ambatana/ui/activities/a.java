// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.e;
import android.support.v7.aqo;
import android.support.v7.is;
import android.support.v7.iv;

public class a extends e
{

    private AlertDialog n;

    public a()
    {
    }

    static void a(a a1)
    {
        a1.l();
    }

    private void k()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            n = (new android.app.AlertDialog.Builder(this)).create();
            n.setTitle(0x7f0900aa);
            n.setMessage(getString(0x7f0900a9));
            n.setCancelable(false);
            n.setCanceledOnTouchOutside(false);
            n.setButton(-1, getString(0x7f0900ab), new android.content.DialogInterface.OnClickListener() {

                final a a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.a(a);
                    dialoginterface.dismiss();
                }

            
            {
                a = a.this;
                super();
            }
            });
            n.show();
            return;
        }
    }

    private void l()
    {
        Object obj = getPackageName();
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(((String) (obj))).toString()));
            intent.setFlags(0x10000000);
            startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("https://play.google.com/store/apps/details?id=").append(((String) (obj))).toString()));
        }
        ((Intent) (obj)).setFlags(0x10000000);
        startActivity(((Intent) (obj)));
    }

    protected void onDestroy()
    {
        iv.a(n);
        super.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
        if (is.c(getApplicationContext()))
        {
            aqo.a("Update needed", new Object[0]);
            k();
            return;
        } else
        {
            aqo.a("Update not needed", new Object[0]);
            iv.a(n);
            return;
        }
    }
}
