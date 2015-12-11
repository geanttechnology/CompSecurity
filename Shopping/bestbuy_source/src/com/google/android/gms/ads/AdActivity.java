// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import acb;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import p;
import xk;
import xm;

public final class AdActivity extends Activity
{

    private xm a;

    public AdActivity()
    {
    }

    private void a()
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        a.j();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not forward setContentViewSet to ad overlay:", remoteexception);
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        a = xk.a(this);
        if (a == null)
        {
            acb.e("Could not create ad overlay.");
            finish();
            return;
        }
        try
        {
            a.a(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            acb.d("Could not forward onCreate to ad overlay:", bundle);
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
                a.i();
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        p.g(this);
        try
        {
            if (a != null)
            {
                a.g();
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onPause to ad overlay:", remoteexception);
            finish();
        }
        super.onPause();
    }

    protected void onRestart()
    {
        p.e(this);
        super.onRestart();
        try
        {
            if (a != null)
            {
                a.d();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onRestart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onResume()
    {
        p.f(this);
        super.onResume();
        try
        {
            if (a != null)
            {
                a.f();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (a != null)
            {
                a.b(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        p.b(this);
        super.onStart();
        try
        {
            if (a != null)
            {
                a.e();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onStop()
    {
        p.c(this);
        try
        {
            if (a != null)
            {
                a.h();
            }
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not forward onStop to ad overlay:", remoteexception);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        a();
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        a();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        a();
    }
}
