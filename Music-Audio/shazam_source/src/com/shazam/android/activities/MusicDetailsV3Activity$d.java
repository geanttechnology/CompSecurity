// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.shazam.android.util.h.b;
import com.shazam.android.widget.scroll.ObservableScrollView;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

private final class <init>
    implements com.shazam.android.widget.scroll.it>
{

    final MusicDetailsV3Activity a;
    private final int b;
    private final int c;

    public final void a(ObservableScrollView observablescrollview, int i, int j)
    {
        float f = Math.min(1.0F, (float)Math.max(0, i - b) / (float)c);
        MusicDetailsV3Activity.h(a).setBackgroundColor(MusicDetailsV3Activity.k(a) & 0xffffff | (int)(255F * f) << 24);
        MusicDetailsV3Activity.l(a).setAlpha(f);
    }

    private (MusicDetailsV3Activity musicdetailsv3activity)
    {
        a = musicdetailsv3activity;
        super();
        b = com.shazam.android.util.h.b.a(8);
        c = (MusicDetailsV3Activity.i(a).getHeight() + MusicDetailsV3Activity.j(a).getHeight()) - b;
    }

    b(MusicDetailsV3Activity musicdetailsv3activity, byte byte0)
    {
        this(musicdetailsv3activity);
    }
}
