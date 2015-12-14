// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, CachedVideoPlayerActivity

class a extends a
{

    private WeakReference a;

    public void onPageFinished(String s)
    {
        MMLog.b("CachedVideoPlayerActivity", (new StringBuilder("@@ ON PAGE FINISHED")).append(s).toString());
        CachedVideoPlayerActivity cachedvideoplayeractivity = (CachedVideoPlayerActivity)a.get();
        if (cachedvideoplayeractivity != null)
        {
            CachedVideoPlayerActivity.a(cachedvideoplayeractivity, s);
        }
    }

    (CachedVideoPlayerActivity cachedvideoplayeractivity)
    {
        a = new WeakReference(cachedvideoplayeractivity);
    }
}
