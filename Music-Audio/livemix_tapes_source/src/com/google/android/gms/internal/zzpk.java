// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

class zzpk
    implements com.google.android.gms.panorama.PanoramaApi.PanoramaResult
{

    private final Status zzQA;
    private final Intent zzaKB;

    public zzpk(Status status, Intent intent)
    {
        zzQA = (Status)zzx.zzv(status);
        zzaKB = intent;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public Intent getViewerIntent()
    {
        return zzaKB;
    }
}
