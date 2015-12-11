// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import at.markushi.ui.RevealColorView;
import com.shazam.android.ad.d.d;
import com.shazam.android.widget.share.ShareBarView;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

private final class <init>
    implements d
{

    final MusicDetailsV3Activity a;

    public final void a(int i)
    {
        int k = 0x7f1100e7;
        if (a.findViewById(0x7f1100e7) != null)
        {
            android.widget.ms ms = (android.widget.ms)MusicDetailsV3Activity.m(a).getLayoutParams();
            int j;
            if (i == 8)
            {
                j = 0x7f1100e7;
            } else
            {
                j = 0x7f1100e6;
            }
            ms.addRule(8, j);
            ms = (android.widget.ms)MusicDetailsV3Activity.n(a).getLayoutParams();
            if (i == 8)
            {
                i = k;
            } else
            {
                i = 0x7f1100e6;
            }
            ms.addRule(3, i);
        }
    }

    private (MusicDetailsV3Activity musicdetailsv3activity)
    {
        a = musicdetailsv3activity;
        super();
    }

    a(MusicDetailsV3Activity musicdetailsv3activity, byte byte0)
    {
        this(musicdetailsv3activity);
    }
}
