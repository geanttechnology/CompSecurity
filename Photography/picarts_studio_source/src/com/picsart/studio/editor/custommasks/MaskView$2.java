// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.e;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            MaskView

final class a
    implements d
{

    private MaskView a;

    public final void a()
    {
        if (MaskView.a(a) != null)
        {
            MaskView.a(a).d();
        }
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (MaskView.a(a) == null)
        {
            return false;
        }
        view = MaskView.a(a);
        if (motionevent.getAction() != 10 && !((e) (view)).h && ((e) (view)).c.m == com.picsart.effectnew.Controller.EffectsDrawMode.BRUSH)
        {
            view.l = true;
            view.a(true);
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            ((e) (view)).n.x = f;
            ((e) (view)).n.y = f1;
        } else
        {
            view.l = true;
            view.a(false);
        }
        view.c();
        return false;
    }

    tsDrawMode(MaskView maskview)
    {
        a = maskview;
        super();
    }
}
