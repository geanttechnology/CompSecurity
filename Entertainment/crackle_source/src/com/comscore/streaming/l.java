// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.streaming;

import java.util.HashMap;
import java.util.TimerTask;

// Referenced classes of package com.comscore.streaming:
//            StreamSenseMediaPlayer

class l extends TimerTask
{

    final long a;
    final HashMap b;
    final StreamSenseMediaPlayer c;

    l(StreamSenseMediaPlayer streamsensemediaplayer, long l1, HashMap hashmap)
    {
        c = streamsensemediaplayer;
        a = l1;
        b = hashmap;
        super();
    }

    public void run()
    {
        if (StreamSenseMediaPlayer.i(c) - a >= 500L)
        {
            StreamSenseMediaPlayer.j(c);
            StreamSenseMediaPlayer.a(c, b);
            StreamSenseMediaPlayer.k(c);
            return;
        } else
        {
            StreamSenseMediaPlayer.j(c);
            StreamSenseMediaPlayer.b(c, b);
            return;
        }
    }
}
