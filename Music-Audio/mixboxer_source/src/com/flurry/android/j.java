// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            cf, h, FlurryFullscreenTakeoverActivity

final class j
    implements Runnable
{

    private cf B;
    private h C;

    j(h h1, cf cf1)
    {
        C = h1;
        B = cf1;
        super();
    }

    public final void run()
    {
        if (B.canGoBack())
        {
            B.goBack();
            return;
        } else
        {
            C.u.finish();
            return;
        }
    }
}
