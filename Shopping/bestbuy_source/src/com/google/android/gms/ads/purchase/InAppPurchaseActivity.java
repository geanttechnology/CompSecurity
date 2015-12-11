// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.purchase;

import acb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import p;
import ym;
import yz;

public final class InAppPurchaseActivity extends Activity
{

    private ym a;

    public InAppPurchaseActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        try
        {
            if (a != null)
            {
                a.a(i, j, intent);
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onActivityResult to in-app purchase manager:", remoteexception);
        }
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        a = yz.a(this);
        if (a == null)
        {
            acb.e("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try
        {
            a.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            acb.d("Could not forward onCreate to in-app purchase manager:", bundle);
        }
        finish();
    }

    protected void onDestroy()
    {
        p.d(this);
        try
        {
            if (a != null)
            {
                a.b();
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onDestroy to in-app purchase manager:", remoteexception);
        }
        super.onDestroy();
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
