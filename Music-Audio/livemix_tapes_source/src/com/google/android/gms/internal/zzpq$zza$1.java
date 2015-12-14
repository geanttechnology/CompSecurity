// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            zzpq

class zzQs
    implements com.google.android.gms.plus.dMomentsResult
{

    final Status zzQs;
    final zzQs zzaLM;

    public MomentBuffer getMomentBuffer()
    {
        return null;
    }

    public String getNextPageToken()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzQs;
    }

    public String getUpdated()
    {
        return null;
    }

    public void release()
    {
    }

    omentBuffer(omentBuffer omentbuffer, Status status)
    {
        zzaLM = omentbuffer;
        zzQs = status;
        super();
    }
}
