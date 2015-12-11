// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.internal.zzlc;

// Referenced classes of package com.google.android.gms.common.api:
//            Status, Result

final class zzaaW extends zzlc
{

    private final Result zzaaW;

    protected final Result zzb(Status status)
    {
        if (status.getStatusCode() != zzaaW.getStatus().getStatusCode())
        {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        } else
        {
            return zzaaW;
        }
    }

    public (Result result)
    {
        super(Looper.getMainLooper());
        zzaaW = result;
    }
}
