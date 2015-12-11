// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.media.MediaPlayer;

// Referenced classes of package jumiomobile:
//            dm

class dr
    implements android.media.MediaPlayer.OnCompletionListener
{

    final dm a;

    dr(dm dm)
    {
        a = dm;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        mediaplayer.release();
    }
}
