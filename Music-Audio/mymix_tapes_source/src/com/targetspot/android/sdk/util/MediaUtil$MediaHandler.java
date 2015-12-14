// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.targetspot.android.sdk.util:
//            MediaUtil

public static abstract class  extends Handler
    implements android.media.nListener, android.media.ener
{

    public static final int ASYNCERROR = -2;
    public static final int COMPLETE = 0;
    public static final int ERROR = -1;

    public void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            onPlaybackComplete();
            return;
        } else
        {
            onPlaybackError();
            return;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        sendEmptyMessage(0);
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        sendEmptyMessage(-2);
        return true;
    }

    public void onPlaybackComplete()
    {
    }

    public void onPlaybackError()
    {
    }

    public ()
    {
    }
}
