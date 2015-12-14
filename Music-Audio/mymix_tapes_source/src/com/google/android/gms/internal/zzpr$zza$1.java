// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.people.PersonBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            zzpr

class zzQs
    implements com.google.android.gms.plus.PeopleResult
{

    final Status zzQs;
    final zzQs zzaLR;

    public String getNextPageToken()
    {
        return null;
    }

    public PersonBuffer getPersonBuffer()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzQs;
    }

    public void release()
    {
    }

    rsonBuffer(rsonBuffer rsonbuffer, Status status)
    {
        zzaLR = rsonbuffer;
        zzQs = status;
        super();
    }
}
