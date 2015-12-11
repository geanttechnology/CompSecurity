// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.view.ViewTreeObserver;
import com.shazam.android.widget.advert.AdOverlayView;
import com.shazam.android.widget.scroll.ObservableScrollView;
import com.shazam.android.widget.tagging.a;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

final class a
    implements android.view.wListener
{

    final MusicDetailsV3Activity a;

    public final boolean onPreDraw()
    {
        MusicDetailsV3Activity.c(a).getViewTreeObserver().removeOnPreDrawListener(this);
        if (MusicDetailsV3Activity.d(a).getVisibility() != 0)
        {
            MusicDetailsV3Activity.e(a).a();
        }
        return true;
    }

    (MusicDetailsV3Activity musicdetailsv3activity)
    {
        a = musicdetailsv3activity;
        super();
    }
}
