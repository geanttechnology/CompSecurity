// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.people.PersonBuffer;

// Referenced classes of package com.google.android.gms.plus.internal:
//            zze

static final class zzaLt
    implements com.google.android.gms.plus.oadPeopleResult
{

    private final Status zzQA;
    private final String zzaLq;
    private final PersonBuffer zzaLt;

    public String getNextPageToken()
    {
        return zzaLq;
    }

    public PersonBuffer getPersonBuffer()
    {
        return zzaLt;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public void release()
    {
        if (zzaLt != null)
        {
            zzaLt.release();
        }
    }

    public (Status status, DataHolder dataholder, String s)
    {
        zzQA = status;
        zzaLq = s;
        if (dataholder != null)
        {
            status = new PersonBuffer(dataholder);
        } else
        {
            status = null;
        }
        zzaLt = status;
    }
}
