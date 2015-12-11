// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.et;

public final class AdActivity extends Activity
{

    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private cq dV;

    public AdActivity()
    {
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        dV = co.a(this);
        if (dV == null)
        {
            et.d("Could not create ad overlay.");
            finish();
            return;
        }
        try
        {
            dV.a(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            et.a("Could not forward onCreate to ad overlay:", bundle);
        }
        finish();
    }

    protected final void onDestroy()
    {
        try
        {
            if (dV != null)
            {
                dV.g();
            }
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected final void onPause()
    {
        try
        {
            if (dV != null)
            {
                dV.e();
            }
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onPause to ad overlay:", remoteexception);
            finish();
        }
        super.onPause();
    }

    protected final void onRestart()
    {
        super.onRestart();
        try
        {
            if (dV != null)
            {
                dV.b();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onRestart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected final void onResume()
    {
        super.onResume();
        try
        {
            if (dV != null)
            {
                dV.d();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected final void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (dV != null)
            {
                dV.b(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected final void onStart()
    {
        super.onStart();
        try
        {
            if (dV != null)
            {
                dV.c();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected final void onStop()
    {
        try
        {
            if (dV != null)
            {
                dV.f();
            }
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not forward onStop to ad overlay:", remoteexception);
            finish();
        }
        super.onStop();
    }
}
