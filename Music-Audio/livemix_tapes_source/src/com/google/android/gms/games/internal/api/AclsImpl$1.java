// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AclsImpl

static final class zzQs
    implements com.google.android.gms.games.internal.game.lResult
{

    final Status zzQs;

    public Status getStatus()
    {
        return zzQs;
    }

    public void release()
    {
    }

    clResult(Status status)
    {
        zzQs = status;
        super();
    }
}
