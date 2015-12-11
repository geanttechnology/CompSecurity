// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ed;
import com.google.android.gms.d.ee;

public class AdActivity extends Activity
{

    private ee a;

    public AdActivity()
    {
    }

    private void a()
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        a.l();
        return;
        RemoteException remoteexception;
        remoteexception;
        b.a(5);
        return;
    }

    public void onBackPressed()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        try
        {
            if (a != null)
            {
                flag = a.e();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
            flag = flag1;
        }
        if (flag)
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = ed.a(this);
        if (a == null)
        {
            b.a(5);
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
            b.a(5);
        }
        finish();
    }

    protected void onDestroy()
    {
        try
        {
            if (a != null)
            {
                a.k();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (a != null)
            {
                a.i();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
            finish();
        }
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
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
            b.a(5);
        }
        finish();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            if (a != null)
            {
                a.h();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
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
            b.a(5);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        try
        {
            if (a != null)
            {
                a.g();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
        }
        finish();
    }

    protected void onStop()
    {
        try
        {
            if (a != null)
            {
                a.j();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.a(5);
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
