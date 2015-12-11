// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;

public final class zzpa
    implements Account
{

    public zzpa()
    {
    }

    public void clearDefaultAccount(GoogleApiClient googleapiclient)
    {
        googleapiclient = Plus.zzf(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzxr();
        }
    }
}
