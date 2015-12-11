// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.people.PersonBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            hs

final class qT extends qT
    implements com.google.android.gms.plus.e.LoadPeopleResult
{

    final hs DM;
    private PersonBuffer DP;
    private final Status jY;
    private final String qT;

    protected void a(com.google.android.gms.common.api.r r, DataHolder dataholder)
    {
        if (dataholder != null)
        {
            dataholder = new PersonBuffer(dataholder);
        } else
        {
            dataholder = null;
        }
        DP = dataholder;
        r.(this);
    }

    protected volatile void a(Object obj, DataHolder dataholder)
    {
        a((com.google.android.gms.common.api.r)obj, dataholder);
    }

    public String getNextPageToken()
    {
        return qT;
    }

    public PersonBuffer getPersonBuffer()
    {
        return DP;
    }

    public Status getStatus()
    {
        return jY;
    }

    public void release()
    {
        if (DP != null)
        {
            DP.close();
        }
    }

    public taHolder(hs hs1, com.google.android.gms.common.api.r r, Status status, DataHolder dataholder, String s)
    {
        DM = hs1;
        super(hs1, r, dataholder);
        jY = status;
        qT = s;
    }
}
