// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.kt;

public class AdActivity extends Activity
{

    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private kt a;

    public AdActivity()
    {
    }

    private void a()
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        a.zzaE();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Could not forward setContentViewSet to ad overlay:", remoteexception);
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
                flag = a.zzeF();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", remoteexception);
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
        a = kr.a(this);
        if (a == null)
        {
            zzb.zzaH("Could not create ad overlay.");
            finish();
            return;
        }
        try
        {
            a.onCreate(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            zzb.zzd("Could not forward onCreate to ad overlay:", bundle);
        }
        finish();
    }

    protected void onDestroy()
    {
        try
        {
            if (a != null)
            {
                a.onDestroy();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (a != null)
            {
                a.onPause();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onPause to ad overlay:", remoteexception);
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
                a.onRestart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onRestart to ad overlay:", remoteexception);
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
                a.onResume();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (a != null)
            {
                a.onSaveInstanceState(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
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
                a.onStart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onStop()
    {
        try
        {
            if (a != null)
            {
                a.onStop();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onStop to ad overlay:", remoteexception);
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
