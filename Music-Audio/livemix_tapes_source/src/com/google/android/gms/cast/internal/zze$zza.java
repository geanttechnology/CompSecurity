// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zze

private static final class zzXj
    implements com.google.android.gms.cast.licationConnectionResult
{

    private final String zzGY;
    private final Status zzQA;
    private final ApplicationMetadata zzXh;
    private final String zzXi;
    private final boolean zzXj;

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzXh;
    }

    public String getApplicationStatus()
    {
        return zzXi;
    }

    public String getSessionId()
    {
        return zzGY;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public boolean getWasLaunched()
    {
        return zzXj;
    }

    public ta(Status status)
    {
        this(status, null, null, null, false);
    }

    public ta(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        zzQA = status;
        zzXh = applicationmetadata;
        zzXi = s;
        zzGY = s1;
        zzXj = flag;
    }
}
