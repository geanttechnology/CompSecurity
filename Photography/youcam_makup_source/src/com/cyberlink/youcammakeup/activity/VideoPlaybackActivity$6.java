// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            VideoPlaybackActivity

class a
    implements Runnable
{

    final boolean a;
    final VideoPlaybackActivity b;

    public void run()
    {
        VideoPlaybackActivity videoplaybackactivity = b;
        boolean flag;
        if (!a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        VideoPlaybackActivity.a(videoplaybackactivity, flag);
    }

    A(VideoPlaybackActivity videoplaybackactivity, boolean flag)
    {
        b = videoplaybackactivity;
        a = flag;
        super();
    }
}
