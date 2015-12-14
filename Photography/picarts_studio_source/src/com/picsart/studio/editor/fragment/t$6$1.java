// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.picsart.studio.editor.view.PerspectiveView;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            t

final class a extends ag
{

    private a a;

    public final void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        t.e(a.a);
    }

    eView._cls2(eView._cls2 _pcls2)
    {
        a = _pcls2;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/t$6

/* anonymous class */
    final class t._cls6
        implements android.view.View.OnClickListener
    {

        final t a;

        public final void onClick(View view)
        {
            PerspectiveView perspectiveview = t.b(a);
            boolean flag;
            if (perspectiveview.i == null && !perspectiveview.h)
            {
                float f;
                ValueAnimator valueanimator;
                if (perspectiveview.g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                {
                    f = perspectiveview.d;
                } else
                {
                    f = perspectiveview.c;
                }
                perspectiveview.i = ValueAnimator.ofFloat(new float[] {
                    f, 0.0F
                });
                perspectiveview.i.addUpdateListener(new com.picsart.studio.editor.view.PerspectiveView._cls1(perspectiveview));
                perspectiveview.i.addListener(new com.picsart.studio.editor.view.PerspectiveView._cls2(perspectiveview, null));
                valueanimator = perspectiveview.i;
                if (perspectiveview.g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                {
                    f = perspectiveview.d;
                } else
                {
                    f = perspectiveview.c;
                }
                valueanimator.setDuration((long)((Math.abs(f) * 500F) / 45F));
                perspectiveview.i.start();
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                t.a(a, "reset_angle");
                t.d(a).setOnClickListener(null);
                view.animate().alpha(0.0F).setListener(new t._cls6._cls1(this));
            }
        }

            
            {
                a = t1;
                super();
            }
    }

}
