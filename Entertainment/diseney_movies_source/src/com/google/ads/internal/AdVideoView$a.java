// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.os.Handler;
import com.google.ads.m;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.ads.internal:
//            AdVideoView

private static class a
    implements Runnable
{

    private final WeakReference a;

    public void a()
    {
        ((Handler)m.a().c.a()).postDelayed(this, 250L);
    }

    public void run()
    {
        AdVideoView advideoview = (AdVideoView)a.get();
        if (advideoview == null)
        {
            b.d("The video must be gone, so cancelling the timeupdate task.");
            return;
        } else
        {
            advideoview.f();
            ((Handler)m.a().c.f()).postDelayed(this, 250L);
            return;
        }
    }

    public (AdVideoView advideoview)
    {
        a = new WeakReference(advideoview);
    }
}
