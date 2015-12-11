// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzle
    implements Releasable, Result
{

    protected final Status zzSC;
    protected final DataHolder zzabq;

    protected zzle(DataHolder dataholder, Status status)
    {
        zzSC = status;
        zzabq = dataholder;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void release()
    {
        if (zzabq != null)
        {
            zzabq.close();
        }
    }
}
