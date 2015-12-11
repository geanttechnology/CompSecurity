// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.Log;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbh

public class zzy
    implements zzbh
{

    private int zzNW;

    public zzy()
    {
        zzNW = 5;
    }

    public void e(String s)
    {
        if (zzNW <= 6)
        {
            Log.e("GoogleTagManager", s);
        }
    }

    public void setLogLevel(int i)
    {
        zzNW = i;
    }

    public void v(String s)
    {
        if (zzNW <= 2)
        {
            Log.v("GoogleTagManager", s);
        }
    }

    public void zzaF(String s)
    {
        if (zzNW <= 3)
        {
            Log.d("GoogleTagManager", s);
        }
    }

    public void zzaG(String s)
    {
        if (zzNW <= 4)
        {
            Log.i("GoogleTagManager", s);
        }
    }

    public void zzaH(String s)
    {
        if (zzNW <= 5)
        {
            Log.w("GoogleTagManager", s);
        }
    }

    public void zzb(String s, Throwable throwable)
    {
        if (zzNW <= 6)
        {
            Log.e("GoogleTagManager", s, throwable);
        }
    }

    public void zzd(String s, Throwable throwable)
    {
        if (zzNW <= 5)
        {
            Log.w("GoogleTagManager", s, throwable);
        }
    }
}
