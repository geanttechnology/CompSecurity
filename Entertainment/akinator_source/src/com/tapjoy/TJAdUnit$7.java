// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.media.MediaPlayer;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TJAdUnitJSBridge

final class >
    implements android.media..OnSeekCompleteListener
{

    final int a;
    final int b;
    final int c;
    final TJAdUnit d;

    public final void onSeekComplete(MediaPlayer mediaplayer)
    {
        TJAdUnit.i(d).onVideoReady(a, b, c);
    }

    yer(TJAdUnit tjadunit, int i, int j, int k)
    {
        d = tjadunit;
        a = i;
        b = j;
        c = k;
        super();
    }
}
