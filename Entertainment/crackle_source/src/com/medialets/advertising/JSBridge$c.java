// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;


// Referenced classes of package com.medialets.advertising:
//            JSBridge

private final class b
    implements Runnable
{

    private String a;
    private boolean b;
    private JSBridge c;

    public final void run()
    {
        if (b)
        {
            c.openVideoPlayer(a);
            return;
        } else
        {
            c.openEmbeddedBrowser(a);
            return;
        }
    }

    public (JSBridge jsbridge, String s, boolean flag)
    {
        c = jsbridge;
        super();
        a = s;
        b = flag;
    }
}
