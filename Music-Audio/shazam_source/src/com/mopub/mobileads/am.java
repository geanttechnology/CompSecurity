// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.widget.VideoView;
import com.mopub.common.d.k;
import com.mopub.common.m;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package com.mopub.mobileads:
//            af

public final class am extends VideoView
{

    af a;
    MediaMetadataRetriever b;
    private int c;

    public am(Context context)
    {
        super(context);
        m.a(context, "context cannot be null");
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            context = new MediaMetadataRetriever();
        } else
        {
            context = null;
        }
        b = context;
    }

    final boolean a(MediaPlayer mediaplayer, int i, int j, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 || i != 1 || j != 0x80000000 || c > 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
        mediaplayer.reset();
        s = new FileInputStream(new File(s));
        mediaplayer.setDataSource(s.getFD());
        mediaplayer.prepareAsync();
        start();
        k.a(s);
        c = c + 1;
        return true;
        mediaplayer;
        mediaplayer = null;
_L6:
        k.a(mediaplayer);
        c = c + 1;
        return false;
        mediaplayer;
        s = obj;
_L4:
        k.a(s);
        c = c + 1;
        throw mediaplayer;
_L2:
        return false;
        mediaplayer;
        if (true) goto _L4; else goto _L3
_L3:
        mediaplayer;
        mediaplayer = s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    final af getBlurLastVideoFrameTask()
    {
        return a;
    }

    final int getVideoRetries()
    {
        return c;
    }

    final void setBlurLastVideoFrameTask(af af)
    {
        a = af;
    }

    final void setMediaMetadataRetriever(MediaMetadataRetriever mediametadataretriever)
    {
        b = mediametadataretriever;
    }
}
