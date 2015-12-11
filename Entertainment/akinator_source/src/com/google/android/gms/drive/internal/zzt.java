// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

public abstract class zzt extends com.google.android.gms.internal.zzlb.zza
{
    public static abstract class zza extends zzt
    {

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzt(GoogleApiClient googleapiclient)
    {
        super(Drive.zzRk, googleapiclient);
    }
}
