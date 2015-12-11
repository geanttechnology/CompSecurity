// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;
import com.shazam.android.widget.advert.AdOverlayView;
import com.shazam.android.widget.musicdetails.InteractiveInfoView;
import com.shazam.android.widget.scroll.ObservableScrollView;
import com.shazam.android.widget.scroll.b;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

private final class <init>
    implements android.view.wListener
{
    private final class a
        implements com.shazam.android.widget.scroll.ObservableScrollView.a
    {

        final MusicDetailsV3Activity.b a;

        public final void a(ObservableScrollView observablescrollview, int i, int j)
        {
            if (j != 0)
            {
                MusicDetailsV3Activity.d(a.a).requestLayout();
            }
        }

        private a()
        {
            a = MusicDetailsV3Activity.b.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    final MusicDetailsV3Activity a;

    public final boolean onPreDraw()
    {
        MusicDetailsV3Activity.f(a).getViewTreeObserver().removeOnPreDrawListener(this);
        if (MusicDetailsV3Activity.g(a))
        {
            MusicDetailsV3Activity.c(a).a(com.shazam.android.widget.scroll.b.a(MusicDetailsV3Activity.f(a), a.findViewById(0x7f1100b0), a));
            MusicDetailsV3Activity.c(a).a(new <init>(a, (byte)0));
            MusicDetailsV3Activity.c(a).a(new a((byte)0));
        }
        MusicDetailsV3Activity.d(a).setMinOffsetY(MusicDetailsV3Activity.h(a).getHeight() + MusicDetailsV3Activity.f(a).getHeight());
        return true;
    }

    private a(MusicDetailsV3Activity musicdetailsv3activity)
    {
        a = musicdetailsv3activity;
        super();
    }

    a(MusicDetailsV3Activity musicdetailsv3activity, byte byte0)
    {
        this(musicdetailsv3activity);
    }
}
