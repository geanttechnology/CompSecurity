// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.media.MediaPlayer;
import com.liverail.library.a.b;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a

class c
    implements android.media.MediaPlayer.OnErrorListener
{

    final com.liverail.library.f.a a;

    c(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (com.liverail.library.f.a.d(a) != null)
        {
            com.liverail.library.b.a.a((new StringBuilder("MediaPlayer onError() ")).append(i).append(" ").append(j).toString());
            if (j == -1004)
            {
                com.liverail.library.f.a.a(a, new b(com.liverail.library.a.c.b, (new StringBuilder("OnErrorListener() what=")).append(i).append(" extra=").append(j).append(" ").append(com.liverail.library.f.a.d(a).toString()).append(" url=").append(com.liverail.library.f.a.e(a)).toString()));
            } else
            {
                com.liverail.library.f.a.a(a, new b(com.liverail.library.a.c.d, (new StringBuilder("OnErrorListener() what=")).append(i).append(" extra=").append(j).append(" ").append(com.liverail.library.f.a.d(a).toString()).append(" url=").append(com.liverail.library.f.a.e(a)).toString()));
            }
        }
        return true;
    }
}
