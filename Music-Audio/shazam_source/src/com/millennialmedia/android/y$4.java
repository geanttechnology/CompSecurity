// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            y, ak, al

final class a
    implements android.media.aPlayer.OnErrorListener
{

    final y a;

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        mediaplayer = (ak)y.f(a).get();
        if (mediaplayer == null)
        {
            al.a("InlineVideoView", "Unable to handle error, MMLayout weak reference broken");
            return true;
        } else
        {
            mediaplayer.a((new StringBuilder("javascript:MMJS.setError(")).append(String.format("Error while playing, %d - %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            })).append(");").toString());
            return true;
        }
    }

    rListener(y y1)
    {
        a = y1;
        super();
    }
}
