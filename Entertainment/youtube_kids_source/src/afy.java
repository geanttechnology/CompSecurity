// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import com.google.android.apps.youtube.kids.ui.SlidingFrameLayout;

public final class afy
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private SlidingFrameLayout a;

    public afy(SlidingFrameLayout slidingframelayout)
    {
        a = slidingframelayout;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(SlidingFrameLayout.a(a));
        a.setXFraction(SlidingFrameLayout.b(a));
        return true;
    }
}
