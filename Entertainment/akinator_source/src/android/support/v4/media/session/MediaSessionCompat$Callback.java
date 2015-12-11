// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, MediaSessionCompatApi23, MediaSessionCompatApi21

public static abstract class mCallbackObj
{

    final Object mCallbackObj;

    public void onCommand(String s, Bundle bundle, ResultReceiver resultreceiver)
    {
    }

    public void onCustomAction(String s, Bundle bundle)
    {
    }

    public void onFastForward()
    {
    }

    public boolean onMediaButtonEvent(Intent intent)
    {
        return false;
    }

    public void onPause()
    {
    }

    public void onPlay()
    {
    }

    public void onPlayFromMediaId(String s, Bundle bundle)
    {
    }

    public void onPlayFromSearch(String s, Bundle bundle)
    {
    }

    public void onPlayFromUri(Uri uri, Bundle bundle)
    {
    }

    public void onRewind()
    {
    }

    public void onSeekTo(long l)
    {
    }

    public void onSetRating(RatingCompat ratingcompat)
    {
    }

    public void onSkipToNext()
    {
    }

    public void onSkipToPrevious()
    {
    }

    public void onSkipToQueueItem(long l)
    {
    }

    public void onStop()
    {
    }

    public back()
    {
        if (android.os.essionCompat.Callback >= 23)
        {
    /* block-local class not found */
    class StubApi23 {}

            mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(null));
            return;
        }
        if (android.os.essionCompat._fld1 >= 21)
        {
    /* block-local class not found */
    class StubApi21 {}

            mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(null));
            return;
        } else
        {
            mCallbackObj = null;
            return;
        }
    }
}
