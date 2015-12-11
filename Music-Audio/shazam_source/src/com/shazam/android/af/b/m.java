// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import android.content.Context;
import android.media.MediaPlayer;

// Referenced classes of package com.shazam.android.af.b:
//            b

public final class m
    implements b
{

    private final Context a;

    public m(Context context)
    {
        a = context;
    }

    public final MediaPlayer a()
    {
        MediaPlayer mediaplayer = new MediaPlayer();
        mediaplayer.setWakeMode(a, 6);
        return mediaplayer;
    }
}
