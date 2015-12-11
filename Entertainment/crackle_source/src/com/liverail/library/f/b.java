// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.media.MediaPlayer;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a, i

class b
    implements android.media.MediaPlayer.OnCompletionListener
{

    final com.liverail.library.f.a a;

    b(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        com.liverail.library.b.a.a("MediaPlayer.onCompletion()");
        com.liverail.library.f.a.a(a);
        if (!com.liverail.library.f.a.b(a))
        {
            com.liverail.library.f.a.a(a, true);
            if (com.liverail.library.f.a.c(a) != null)
            {
                com.liverail.library.f.a.c(a).h();
            }
        }
        if (com.liverail.library.f.a.c(a) != null)
        {
            com.liverail.library.f.a.c(a).j();
        }
    }
}
