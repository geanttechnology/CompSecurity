// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity

class a
    implements Runnable
{

    private String a;
    private VideoPlayerActivity b;

    public void run()
    {
        if (a.equalsIgnoreCase("restartVideo"))
        {
            b.h();
        } else
        if (a.equalsIgnoreCase("endVideo"))
        {
            b.k();
            return;
        }
    }

    (VideoPlayerActivity videoplayeractivity, String s)
    {
        b = videoplayeractivity;
        a = s;
        super();
    }
}
