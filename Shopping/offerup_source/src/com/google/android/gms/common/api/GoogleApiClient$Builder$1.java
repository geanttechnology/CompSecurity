// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.support.v4.app.aa;
import android.support.v4.app.t;
import com.google.android.gms.internal.zzlp;

// Referenced classes of package com.google.android.gms.common.api:
//            GoogleApiClient

class zzWT
    implements Runnable
{

    final GoogleApiClient zzWT;
    final zzWT zzaaU;

    public void run()
    {
        if (a(zzaaU).isFinishing() || a(zzaaU).getSupportFragmentManager().e())
        {
            return;
        } else
        {
            a(zzaaU, zzlp.zzb(a(zzaaU)), zzWT);
            return;
        }
    }

    A(A a, GoogleApiClient googleapiclient)
    {
        zzaaU = a;
        zzWT = googleapiclient;
        super();
    }
}
