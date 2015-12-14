// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager, AppStateBuffer

class zzQs
    implements istResult
{

    final Status zzQs;
    final zzQs zzQy;

    public AppStateBuffer getStateBuffer()
    {
        return new AppStateBuffer(null);
    }

    public Status getStatus()
    {
        return zzQs;
    }

    istResult(istResult istresult, Status status)
    {
        zzQy = istresult;
        zzQs = status;
        super();
    }
}
