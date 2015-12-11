// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;
import android.widget.Toast;

final class vu
    implements Runnable
{

    private MediaPlayer a;
    private vq b;

    vu(vq vq1, MediaPlayer mediaplayer)
    {
        b = vq1;
        a = mediaplayer;
        super();
    }

    public final void run()
    {
        vq.c(b).show();
        a.start();
    }
}
