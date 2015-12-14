// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity

class a extends Handler
{

    private WeakReference a;

    public void handleMessage(Message message)
    {
        VideoPlayerActivity videoplayeractivity = (VideoPlayerActivity)a.get();
        if (videoplayeractivity != null)
        {
            videoplayeractivity.a(message);
        }
    }

    public (VideoPlayerActivity videoplayeractivity)
    {
        a = new WeakReference(videoplayeractivity);
    }
}
