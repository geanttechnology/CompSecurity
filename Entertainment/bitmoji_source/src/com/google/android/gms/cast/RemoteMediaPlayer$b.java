// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dx;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static abstract class j extends j
{

    dx xy;

    public Result d(Status status)
    {
        return j(status);
    }

    public diaChannelResult j(Status status)
    {
        return new RemoteMediaPlayer.MediaChannelResult(status) {

            final Status vb;
            final RemoteMediaPlayer.b xz;

            public Status getStatus()
            {
                return vb;
            }

            
            {
                xz = RemoteMediaPlayer.b.this;
                vb = status;
                super();
            }
        };
    }

    _cls2.vb()
    {
        xy = new dx() {

            final RemoteMediaPlayer.b xz;

            public void a(long l, int i, JSONObject jsonobject)
            {
                xz.a(new RemoteMediaPlayer.c(new Status(i), jsonobject));
            }

            public void k(long l)
            {
                xz.a(xz.j(new Status(4)));
            }

            
            {
                xz = RemoteMediaPlayer.b.this;
                super();
            }
        };
    }
}
