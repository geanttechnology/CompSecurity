// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import java.util.Set;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            RequestsImpl

class zzQs
    implements com.google.android.gms.games.request.pl._cls1
{

    final Status zzQs;
    final zzQs zzavU;

    public Set getRequestIds()
    {
        return null;
    }

    public int getRequestOutcome(String s)
    {
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown request ID ").append(s).toString());
    }

    public Status getStatus()
    {
        return zzQs;
    }

    public void release()
    {
    }

    Q(Q q, Status status)
    {
        zzavU = q;
        zzQs = status;
        super();
    }
}
