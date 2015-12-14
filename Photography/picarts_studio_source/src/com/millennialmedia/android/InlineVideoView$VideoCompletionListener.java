// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class a
    implements android.media.etionListener
{

    private WeakReference a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        InlineVideoView inlinevideoview = (InlineVideoView)a.get();
        if (inlinevideoview != null)
        {
            inlinevideoview.onCompletion(mediaplayer);
        }
    }

    public I(InlineVideoView inlinevideoview)
    {
        a = new WeakReference(inlinevideoview);
    }
}
