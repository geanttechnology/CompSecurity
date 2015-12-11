// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import aql;
import aqv;
import p;

public class PreviewActivity extends Activity
{

    public PreviewActivity()
    {
    }

    private void a(String s, String s1, String s2)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog.setTitle(s);
        alertdialog.setMessage(s1);
        alertdialog.setButton(-1, s2, new android.content.DialogInterface.OnClickListener() {

            final PreviewActivity a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                a = PreviewActivity.this;
                super();
            }
        });
        alertdialog.show();
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        aqv.c("Preview activity");
        bundle = getIntent().getData();
        if (!aql.a(this).a(bundle))
        {
            bundle = (new StringBuilder()).append("Cannot preview the app with the uri: ").append(bundle).append(". Launching current version instead.").toString();
            aqv.b(bundle);
            a("Preview failure", bundle, "Continue");
        }
        bundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (bundle != null)
        {
            try
            {
                aqv.c((new StringBuilder()).append("Invoke the launch activity for package name: ").append(getPackageName()).toString());
                startActivity(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                aqv.a((new StringBuilder()).append("Calling preview threw an exception: ").append(bundle.getMessage()).toString());
            }
            break MISSING_BLOCK_LABEL_170;
        }
        aqv.c((new StringBuilder()).append("No launch activity found for package name: ").append(getPackageName()).toString());
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        p.d(this);
    }

    protected void onPause()
    {
        super.onPause();
        p.g(this);
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    protected void onResume()
    {
        super.onResume();
        p.f(this);
    }

    protected void onStart()
    {
        super.onStart();
        p.b(this);
    }

    protected void onStop()
    {
        super.onStop();
        p.c(this);
    }
}
