// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.media.MediaPlayer;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.app:
//            fr

final class fs
    implements android.media.MediaPlayer.OnPreparedListener
{

    final fr a;

    fs(fr fr1)
    {
        a = fr1;
        super();
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        fr.a(a).setVisibility(8);
        fr.b(a).setVisibility(8);
        fr.c(a).show();
    }
}
