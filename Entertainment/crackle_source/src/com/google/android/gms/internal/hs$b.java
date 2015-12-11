// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            hs

final class DN extends DN
    implements com.google.android.gms.plus.ts.LoadMomentsResult
{

    final hs DM;
    private final String DN;
    private MomentBuffer DO;
    private final Status jY;
    private final String qT;

    protected void a(com.google.android.gms.common.api.r r, DataHolder dataholder)
    {
        if (dataholder != null)
        {
            dataholder = new MomentBuffer(dataholder);
        } else
        {
            dataholder = null;
        }
        DO = dataholder;
        r.(this);
    }

    protected volatile void a(Object obj, DataHolder dataholder)
    {
        a((com.google.android.gms.common.api.r)obj, dataholder);
    }

    public MomentBuffer getMomentBuffer()
    {
        return DO;
    }

    public String getNextPageToken()
    {
        return qT;
    }

    public Status getStatus()
    {
        return jY;
    }

    public String getUpdated()
    {
        return DN;
    }

    public void release()
    {
        if (DO != null)
        {
            DO.close();
        }
    }

    public taHolder(hs hs1, com.google.android.gms.common.api.r r, Status status, DataHolder dataholder, String s, String s1)
    {
        DM = hs1;
        super(hs1, r, dataholder);
        jY = status;
        qT = s;
        DN = s1;
    }
}
