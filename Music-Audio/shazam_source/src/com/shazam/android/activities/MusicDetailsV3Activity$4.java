// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

final class a
    implements android.animation.ateListener
{

    final View a;
    final MusicDetailsV3Activity b;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.setBackgroundColor(((Integer)valueanimator.getAnimatedValue()).intValue());
    }

    (MusicDetailsV3Activity musicdetailsv3activity, View view)
    {
        b = musicdetailsv3activity;
        a = view;
        super();
    }
}
