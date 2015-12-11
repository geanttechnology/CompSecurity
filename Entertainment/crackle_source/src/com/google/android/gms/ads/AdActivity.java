// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.ct;

public final class AdActivity extends Activity
{

    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private bs dV;

    public AdActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        dV = br.a(this);
        if (dV == null)
        {
            ct.v("Could not create ad overlay.");
            finish();
            return;
        }
        try
        {
            dV.onCreate(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ct.b("Could not forward onCreate to ad overlay:", bundle);
        }
        finish();
    }

    protected void onDestroy()
    {
        try
        {
            if (dV != null)
            {
                dV.onDestroy();
            }
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (dV != null)
            {
                dV.onPause();
            }
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onPause to ad overlay:", remoteexception);
            finish();
        }
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
        try
        {
            if (dV != null)
            {
                dV.onRestart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onRestart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            if (dV != null)
            {
                dV.onResume();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (dV != null)
            {
                dV.onSaveInstanceState(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        try
        {
            if (dV != null)
            {
                dV.onStart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onStop()
    {
        try
        {
            if (dV != null)
            {
                dV.onStop();
            }
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not forward onStop to ad overlay:", remoteexception);
            finish();
        }
        super.onStop();
    }
}
