// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.draw;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.effectnew.EffectsDrawController;
import myobfuscated.bw.d;

// Referenced classes of package com.socialin.android.photo.effects.draw:
//            EffectsView, a, b

final class a
    implements d
{

    private EffectsView a;

    public final void a()
    {
        if (EffectsView.a(a) != null)
        {
            EffectsView.a(a).f();
        }
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (EffectsView.a(a) == null)
        {
            return false;
        }
        view = EffectsView.a(a);
        if (motionevent.getAction() != 10 && !((a) (view)).n.e() && !((a) (view)).i && (!((a) (view)).n.e() || !((a) (view)).n.f()) && ((a) (view)).c.m == com.picsart.effectnew.troller.EffectsDrawMode.BRUSH)
        {
            view.t = true;
            view.c(true);
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            ((a) (view)).v.x = f;
            ((a) (view)).v.y = f1;
        } else
        {
            view.t = true;
            view.c(false);
        }
        view.e();
        return false;
    }

    wMode(EffectsView effectsview)
    {
        a = effectsview;
        super();
    }
}
