// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.animation.Animation;
import com.offerup.android.views.GalleryViewPager;

// Referenced classes of package com.offerup.android.activities:
//            GalleryActivity

final class cm
    implements android.view.animation.Animation.AnimationListener
{

    private GalleryActivity a;

    cm(GalleryActivity galleryactivity)
    {
        a = galleryactivity;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        GalleryActivity.d(a).setVisibility(8);
        a.finish();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
