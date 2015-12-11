// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;

import android.media.AudioTrack;

// Referenced classes of package shared_presage.com.google.android.exoplayer.audio:
//            AudioTrack

final class b extends Thread
{

    final AudioTrack a;
    final shared_presage.com.google.android.exoplayer.audio.AudioTrack b;

    b(shared_presage.com.google.android.exoplayer.audio.AudioTrack audiotrack, AudioTrack audiotrack1)
    {
        b = audiotrack;
        a = audiotrack1;
        super();
    }

    public final void run()
    {
        a.release();
    }
}
