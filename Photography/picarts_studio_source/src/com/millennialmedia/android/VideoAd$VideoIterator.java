// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            VideoAd, AdCache, MMLog, CachedAd

class b extends b
{

    private WeakReference a;
    private WeakReference b;
    private boolean c;

    final void a()
    {
        if (!c)
        {
            Context context = (Context)b.get();
            if (context != null)
            {
                VideoAd videoad = (VideoAd)a.get();
                if (videoad != null && AdCache.h(context, (new StringBuilder()).append(VideoAd.access$000(videoad)).append("video.dat").toString()))
                {
                    MMLog.a("VideoAd", String.format("VideoAd video file %s was deleted.", new Object[] {
                        VideoAd.access$000(videoad)
                    }));
                }
            }
        }
        super.a();
    }

    final boolean a(CachedAd cachedad)
    {
        if (cachedad != null && (cachedad instanceof VideoAd))
        {
            VideoAd videoad = (VideoAd)cachedad;
            VideoAd videoad1 = (VideoAd)a.get();
            if (videoad1 != null && VideoAd.access$000(videoad).equals(VideoAd.access$000(videoad1)))
            {
                c = true;
            }
        }
        return super.c(cachedad);
    }

    public (Context context, VideoAd videoad)
    {
        c = false;
        a = new WeakReference(videoad);
        b = new WeakReference(context);
    }
}
