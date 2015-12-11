// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af

class a
    implements Runnable
{

    final af a;

    public void run()
    {
        if (!af.c(a))
        {
            int i = a.f;
            a.a.pause();
            a.a.setVisibility(4);
            a.a.setVisibility(0);
            a.a.seekTo(i);
            a.a.start();
        }
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
