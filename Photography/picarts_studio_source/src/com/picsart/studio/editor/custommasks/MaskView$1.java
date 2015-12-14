// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.view.MotionEvent;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import myobfuscated.bw.e;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            MaskView

final class a
    implements e
{

    private MaskView a;

    public final boolean a(MotionEvent motionevent)
    {
        if (MaskView.a(a) != null)
        {
            MaskView.a(a).l = false;
        }
        a.a(motionevent);
        return true;
    }

    public final boolean b(MotionEvent motionevent)
    {
        if (MaskView.a(a) != null)
        {
            MaskView.a(a).l = true;
        }
        return a.a(motionevent);
    }

    public final boolean c(MotionEvent motionevent)
    {
        if (MaskView.a(a) != null)
        {
            MaskView.a(a).l = true;
            if (MaskView.a(a).b().v == com.picsart.effectnew.w.BrushDrawMode.DRAW)
            {
                Object obj = MaskView.a(a);
                if (((com.picsart.effectnew.e) (obj)).k == null || !((com.picsart.effectnew.e) (obj)).e && !((com.picsart.effectnew.e) (obj)).h && ((com.picsart.effectnew.e) (obj)).c.m == com.picsart.effectnew.Controller.EffectsDrawMode.BRUSH)
                {
                    obj = com.picsart.effectnew.Controller.EffectsDrawMode.BRUSH;
                }
            }
        }
        return a.a(motionevent);
    }

    public final void d(MotionEvent motionevent)
    {
        if (MaskView.a(a) != null)
        {
            MaskView.a(a).d();
        }
    }

    tsDrawMode(MaskView maskview)
    {
        a = maskview;
        super();
    }
}
