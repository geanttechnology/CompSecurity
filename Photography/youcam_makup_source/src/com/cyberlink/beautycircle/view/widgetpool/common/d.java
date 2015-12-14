// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.b.a;

public class d
    implements a
{

    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private boolean e;

    public d(int i, boolean flag, boolean flag1, boolean flag2)
    {
        e = true;
        a = i;
        b = flag;
        c = flag1;
        d = flag2;
    }

    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.c.a a1, LoadedFrom loadedfrom)
    {
        a1.a(bitmap);
        if (b && loadedfrom == LoadedFrom.a || c && loadedfrom == LoadedFrom.b || d && loadedfrom == LoadedFrom.c)
        {
            a(a1.d(), a);
        }
    }

    public void a(View view)
    {
        if (view != null && e)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.5F, 1.0F);
            alphaanimation.setDuration(a);
            alphaanimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaanimation);
        }
    }

    public void a(View view, int i)
    {
        if (view != null)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(i);
            alphaanimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaanimation);
        }
    }

    public void a(boolean flag)
    {
        e = flag;
    }
}
