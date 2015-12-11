// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zze

private static final class zzZb
    implements com.google.android.gms.cast.licationConnectionResult
{

    private final String zzHP;
    private final Status zzSC;
    private final ApplicationMetadata zzYZ;
    private final String zzZa;
    private final boolean zzZb;

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzYZ;
    }

    public String getApplicationStatus()
    {
        return zzZa;
    }

    public String getSessionId()
    {
        return zzHP;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public boolean getWasLaunched()
    {
        return zzZb;
    }

    public ta(Status status)
    {
        this(status, null, null, null, false);
    }

    public ta(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        zzSC = status;
        zzYZ = applicationmetadata;
        zzZa = s;
        zzHP = s1;
        zzZb = flag;
    }
}
