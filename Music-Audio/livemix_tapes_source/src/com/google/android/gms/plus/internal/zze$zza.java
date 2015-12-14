// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.plus.internal:
//            zze

static final class zzaLs
    implements com.google.android.gms.plus.LoadMomentsResult
{

    private final Status zzQA;
    private final String zzaLq;
    private final String zzaLr;
    private final MomentBuffer zzaLs;

    public MomentBuffer getMomentBuffer()
    {
        return zzaLs;
    }

    public String getNextPageToken()
    {
        return zzaLq;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public String getUpdated()
    {
        return zzaLr;
    }

    public void release()
    {
        if (zzaLs != null)
        {
            zzaLs.release();
        }
    }

    public (Status status, DataHolder dataholder, String s, String s1)
    {
        zzQA = status;
        zzaLq = s;
        zzaLr = s1;
        if (dataholder != null)
        {
            status = new MomentBuffer(dataholder);
        } else
        {
            status = null;
        }
        zzaLs = status;
    }
}
