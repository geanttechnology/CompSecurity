// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.MomentBuffer;

final class zzazb
    implements com.google.android.gms.plus.LoadMomentsResult
{

    private final Status zzKr;
    private final String zzayZ;
    private final String zzaza;
    private final MomentBuffer zzazb;

    public MomentBuffer getMomentBuffer()
    {
        return zzazb;
    }

    public String getNextPageToken()
    {
        return zzayZ;
    }

    public Status getStatus()
    {
        return zzKr;
    }

    public String getUpdated()
    {
        return zzaza;
    }

    public void release()
    {
        if (zzazb != null)
        {
            zzazb.release();
        }
    }

    public (Status status, DataHolder dataholder, String s, String s1)
    {
        zzKr = status;
        zzayZ = s;
        zzaza = s1;
        if (dataholder != null)
        {
            status = new MomentBuffer(dataholder);
        } else
        {
            status = null;
        }
        zzazb = status;
    }
}
