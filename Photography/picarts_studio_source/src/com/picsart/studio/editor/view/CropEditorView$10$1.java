// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class d
    implements android.animation.orUpdateListener
{

    private RectF a;
    private RectF b;
    private RectF c;
    private RectF d;
    private e e;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction();
        float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
        CropEditorView.a(e.e, (int)f1);
        CropEditorView.b(e.e, f1 * 90F);
        Geom.a(CropEditorView.k(e.e), a, b, f);
        Geom.a(CropEditorView.b(e.e), c, d, f);
        e.e.invalidate();
        CropEditorView.g(e.e);
    }

    a(a a1, RectF rectf, RectF rectf1, RectF rectf2, RectF rectf3)
    {
        e = a1;
        a = rectf;
        b = rectf1;
        c = rectf2;
        d = rectf3;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$10

/* anonymous class */
    public final class CropEditorView._cls10
        implements Runnable
    {

        final CropEditorView a;

        public final void run()
        {
            RectF rectf = new RectF(CropEditorView.k(a));
            RectF rectf1 = new RectF();
            RectF rectf2 = new RectF(CropEditorView.b(a));
            RectF rectf3 = new RectF();
            int i;
            if (CropEditorView.e(a))
            {
                rectf3.set(0.0F, 0.0F, 1.0F, CropEditorView.l(a));
                Geom.a(rectf3, CropEditorView.m(a), com.socialin.android.util.Geom.Fit.CENTER);
                rectf1.set(0.0F, 0.0F, CropEditorView.n(a), CropEditorView.o(a));
                Geom.a(rectf1, rectf3.centerX(), rectf3.centerY());
                Geom.a(rectf1, Math.max(rectf3.width() / rectf1.width(), rectf3.height() / rectf1.height()));
            } else
            {
                CropEditorView.p(a);
                rectf1.set(0.0F, 0.0F, CropEditorView.n(a), CropEditorView.o(a));
                Geom.a(rectf1, CropEditorView.m(a), com.socialin.android.util.Geom.Fit.CENTER);
                rectf3.set(rectf1);
            }
            CropEditorView.a(a, rectf1.width() / CropEditorView.n(a));
            CropEditorView.q(a);
            if (CropEditorView.r(a) <= 2)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            CropEditorView.a(a, ValueAnimator.ofFloat(new float[] {
                (float)CropEditorView.r(a), (float)i
            }));
            CropEditorView.j(a).addUpdateListener(new CropEditorView._cls10._cls1(this, rectf, rectf1, rectf2, rectf3));
            CropEditorView.j(a).addListener(new CropEditorView._cls10._cls2());
            CropEditorView.j(a).setDuration(300L);
            CropEditorView.j(a).start();
        }

            public 
            {
                a = cropeditorview;
                super();
            }

        // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$10$2

/* anonymous class */
        final class CropEditorView._cls10._cls2 extends ag
        {

            private CropEditorView._cls10 a;

            public final void onAnimationCancel(Animator animator)
            {
                super.onAnimationCancel(animator);
                CropEditorView.a(a.a, false);
            }

            public final void onAnimationEnd(Animator animator)
            {
                CropEditorView.a(a.a, false);
                CropEditorView.j(a.a).removeAllListeners();
                CropEditorView.j(a.a).removeAllUpdateListeners();
                CropEditorView.a(a.a, null);
                CropEditorView.a(a.a, 0);
                CropEditorView.b(a.a, 0.0F);
            }

            public final void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                CropEditorView.a(a.a, true);
            }

                    
                    {
                        a = CropEditorView._cls10.this;
                        super();
                    }
        }

    }

}
