// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v4.view:
//            cy, db, dh, cx, 
//            dk

class da extends cy
{

    da()
    {
    }

    public final long a(View view)
    {
        return view.animate().getDuration();
    }

    public final void a(cx cx, View view)
    {
        view.animate().cancel();
    }

    public final void a(cx cx, View view, float f)
    {
        view.animate().alpha(f);
    }

    public void a(cx cx, View view, dk dk)
    {
        view.setTag(0x7e000000, dk);
        cx = new db(cx);
        view.animate().setListener(new dh(cx, view));
    }

    public final void a(View view, long l)
    {
        view.animate().setDuration(l);
    }

    public final void a(View view, Interpolator interpolator)
    {
        view.animate().setInterpolator(interpolator);
    }

    public final void b(cx cx, View view)
    {
        view.animate().start();
    }

    public final void b(cx cx, View view, float f)
    {
        view.animate().translationX(f);
    }

    public final void b(View view, long l)
    {
        view.animate().setStartDelay(l);
    }

    public final void c(cx cx, View view, float f)
    {
        view.animate().translationY(f);
    }

    public final void d(cx cx, View view, float f)
    {
        view.animate().scaleX(f);
    }

    public final void e(cx cx, View view, float f)
    {
        view.animate().scaleY(f);
    }
}
