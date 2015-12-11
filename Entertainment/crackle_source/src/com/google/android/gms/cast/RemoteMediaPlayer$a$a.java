// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private final class lt
    implements ResultCallback
{

    private final long lt;
    final j lu;

    public void j(Status status)
    {
        if (!status.isSuccess())
        {
            RemoteMediaPlayer.e(lu.).a(lt, status.getStatusCode());
        }
    }

    public void onResult(Result result)
    {
        j((Status)result);
    }

    ( , long l)
    {
        lu = ;
        super();
        lt = l;
    }
}
