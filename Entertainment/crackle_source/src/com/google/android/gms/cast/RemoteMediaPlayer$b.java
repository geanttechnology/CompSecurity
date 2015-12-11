// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dn;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static abstract class k extends k
{

    dn lv;

    public Result e(Status status)
    {
        return k(status);
    }

    public diaChannelResult k(Status status)
    {
        return new RemoteMediaPlayer.MediaChannelResult(status) {

            final Status jP;
            final RemoteMediaPlayer.b lw;

            public Status getStatus()
            {
                return jP;
            }

            
            {
                lw = RemoteMediaPlayer.b.this;
                jP = status;
                super();
            }
        };
    }

    _cls2.jP()
    {
        lv = new dn() {

            final RemoteMediaPlayer.b lw;

            public void a(long l, int i, JSONObject jsonobject)
            {
                lw.a(new RemoteMediaPlayer.c(new Status(i), jsonobject));
            }

            public void g(long l)
            {
                lw.a(lw.k(new Status(4)));
            }

            
            {
                lw = RemoteMediaPlayer.b.this;
                super();
            }
        };
    }
}
