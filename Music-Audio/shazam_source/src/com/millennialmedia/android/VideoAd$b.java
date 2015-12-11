// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            VideoAd, a, al, r

private static final class c extends c
{

    boolean a;
    private WeakReference b;
    private WeakReference c;

    final void a()
    {
        if (!a)
        {
            Context context = (Context)c.get();
            if (context != null)
            {
                VideoAd videoad = (VideoAd)b.get();
                if (videoad != null && com.millennialmedia.android.a.g(context, (new StringBuilder()).append(VideoAd.a(videoad)).append("video.dat").toString()))
                {
                    String.format("VideoAd video file %s was deleted.", new Object[] {
                        VideoAd.a(videoad)
                    });
                    al.a();
                }
            }
        }
        super.b();
    }

    final boolean a(r r)
    {
        if (r != null && (r instanceof VideoAd))
        {
            VideoAd videoad = (VideoAd)r;
            VideoAd videoad1 = (VideoAd)b.get();
            if (videoad1 != null && VideoAd.a(videoad).equals(VideoAd.a(videoad1)))
            {
                a = true;
            }
        }
        return super.a(r);
    }

    public (Context context, VideoAd videoad)
    {
        a = false;
        b = new WeakReference(videoad);
        c = new WeakReference(context);
    }
}
