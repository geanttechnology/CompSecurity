// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer, Cast

private class ls
    implements dm
{
    private final class a
        implements ResultCallback
    {

        private final long lt;
        final RemoteMediaPlayer.a lu;

        public void j(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.e(lu.lh).a(lt, status.getStatusCode());
            }
        }

        public void onResult(Result result)
        {
            j((Status)result);
        }

        a(long l)
        {
            lu = RemoteMediaPlayer.a.this;
            super();
            lt = l;
        }
    }


    final RemoteMediaPlayer lh;
    private GoogleApiClient lr;
    private long ls;

    public void a(String s, String s1, long l, String s2)
        throws IOException
    {
        if (lr == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            Cast.CastApi.sage(lr, s, s1).setResultCallback(new a(l));
            return;
        }
    }

    public long aR()
    {
        long l = ls + 1L;
        ls = l;
        return l;
    }

    public void b(GoogleApiClient googleapiclient)
    {
        lr = googleapiclient;
    }

    public a.lt(RemoteMediaPlayer remotemediaplayer)
    {
        lh = remotemediaplayer;
        super();
        ls = 0L;
    }
}
