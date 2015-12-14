// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.draw;

import android.view.MotionEvent;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import myobfuscated.bw.e;

// Referenced classes of package com.socialin.android.photo.effects.draw:
//            EffectsView, a, b

final class a
    implements e
{

    private EffectsView a;

    public final boolean a(MotionEvent motionevent)
    {
        if (EffectsView.a(a) != null)
        {
            EffectsView.a(a).t = false;
        }
        a.a(motionevent);
        return true;
    }

    public final boolean b(MotionEvent motionevent)
    {
        if (EffectsView.a(a) != null)
        {
            EffectsView.a(a).t = true;
        }
        return a.a(motionevent);
    }

    public final boolean c(MotionEvent motionevent)
    {
        a a1;
        if (EffectsView.a(a) != null)
        {
            EffectsView.a(a).t = true;
            if (EffectsView.a(a).b().v == com.picsart.effectnew.rushDrawMode.DRAW)
            {
                a1 = EffectsView.a(a);
                break MISSING_BLOCK_LABEL_48;
            }
        }
_L1:
        return a.a(motionevent);
        if ((a1.n == null || !a1.e && !a1.n.e() && !a1.i && (!a1.n.e() || !a1.n.f()) && a1.c.m == com.picsart.effectnew.troller.EffectsDrawMode.BRUSH) && a1.c.m == com.picsart.effectnew.troller.EffectsDrawMode.BRUSH && a1.n != null)
        {
            a1.n.h();
        }
          goto _L1
    }

    public final void d(MotionEvent motionevent)
    {
        if (EffectsView.a(a) != null)
        {
            EffectsView.a(a).f();
        }
    }

    wMode(EffectsView effectsview)
    {
        a = effectsview;
        super();
    }
}
