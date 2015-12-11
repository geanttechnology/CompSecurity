// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a, i

class d
    implements android.media.MediaPlayer.OnPreparedListener
{

    final com.liverail.library.f.a a;

    d(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        com.liverail.library.b.a.a("MediaPlayer.onPrepared()");
        com.liverail.library.f.a.a(a, com.liverail.library.f.a.f(a).getDuration());
        StringBuilder stringbuilder = (new StringBuilder("Retrieved video duration ")).append(com.liverail.library.f.a.g(a)).append("ms");
        if (com.liverail.library.f.a.h(a) > 0)
        {
            mediaplayer = (new StringBuilder(" / last position=")).append(com.liverail.library.f.a.h(a)).toString();
        } else
        {
            mediaplayer = "";
        }
        com.liverail.library.b.a.a(stringbuilder.append(mediaplayer).toString());
        if (com.liverail.library.f.a.i(a)) goto _L2; else goto _L1
_L1:
        com.liverail.library.f.a.b(a, true);
        com.liverail.library.b.a.a("videoView.start()");
        com.liverail.library.f.a.f(a).start();
        if (com.liverail.library.f.a.c(a) != null)
        {
            com.liverail.library.f.a.c(a).a();
        }
_L4:
        com.liverail.library.f.a.j(a);
        return;
_L2:
        com.liverail.library.b.a.b((new StringBuilder("isStarted=true / fix videoView.seekTo() ")).append(com.liverail.library.f.a.h(a)).toString());
        com.liverail.library.f.a.f(a).seekTo(com.liverail.library.f.a.h(a));
        com.liverail.library.f.a.f(a).start();
        if (com.liverail.library.f.a.c(a) != null)
        {
            com.liverail.library.f.a.c(a).d();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
