// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ag

class a
    implements Runnable
{

    final ag a;

    public void run()
    {
        a.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.getCurrentTime();");
    }

    (ag ag1)
    {
        a = ag1;
        super();
    }
}
