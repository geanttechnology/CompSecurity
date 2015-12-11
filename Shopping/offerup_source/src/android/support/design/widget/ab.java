// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            b, aa

final class ab extends b
{

    private aa a;

    ab(aa aa1)
    {
        a = aa1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        aa.a(a, false);
        a.e.setVisibility(8);
    }

    public final void onAnimationStart(Animation animation)
    {
        aa.a(a, true);
    }
}
