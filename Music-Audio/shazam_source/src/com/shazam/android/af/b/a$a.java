// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import android.media.MediaPlayer;

// Referenced classes of package com.shazam.android.af.b:
//            a

private final class b
    implements Runnable
{

    final a a;
    private final MediaPlayer b;

    public final void run()
    {
        b.release();
    }

    public (a a1, MediaPlayer mediaplayer)
    {
        a = a1;
        super();
        b = mediaplayer;
    }
}
