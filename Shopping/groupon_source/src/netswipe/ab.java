// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.media.MediaPlayer;

// Referenced classes of package netswipe:
//            o

class ab
    implements android.media.MediaPlayer.OnCompletionListener
{

    final o a;

    ab(o o)
    {
        a = o;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        mediaplayer.release();
    }
}
