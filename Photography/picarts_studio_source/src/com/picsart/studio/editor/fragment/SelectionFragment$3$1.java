// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.SelectionHistoryStack;
import com.socialin.android.photo.select.c;
import com.socialin.android.photo.select.g;
import java.util.ArrayList;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        float f1 = -1F;
        if (SelectionFragment.x(a.a))
        {
            return;
        }
        Object obj1 = SelectionFragment.p(a.a);
        if (((SelectionDrawController) (obj1)).u != null)
        {
            Object obj = new Canvas(((SelectionDrawController) (obj1)).a);
            (new Paint()).setFilterBitmap(true);
            c c1 = ((SelectionDrawController) (obj1)).u;
            int i = ((SelectionDrawController) (obj1)).a.getWidth();
            ((SelectionDrawController) (obj1)).a.getHeight();
            obj1 = ((SelectionDrawController) (obj1)).f;
            float f2 = c1.l.centerX();
            float f3 = c1.l.centerY();
            float f6 = ((RectF) (obj1)).left;
            float f4 = ((RectF) (obj1)).top;
            float f = (float)i / ((RectF) (obj1)).width();
            f2 = (f2 - f6) * f;
            f3 = (f3 - f4) * f;
            f4 = c1.l.width() * f;
            f *= c1.l.height();
            obj1 = new RectF(f2 - f4 / 2.0F, f3 - f / 2.0F, f4 / 2.0F + f2, f / 2.0F + f3);
            ((Canvas) (obj)).save();
            if (c1.n != 0.0F)
            {
                f = c1.o.x;
                float f5 = ((RectF) (obj1)).width();
                float f7 = ((RectF) (obj1)).left;
                float f8 = c1.o.y;
                float f9 = ((RectF) (obj1)).height();
                float f10 = ((RectF) (obj1)).top;
                ((Canvas) (obj)).rotate(c1.n, f * f5 + f7, f8 * f9 + f10);
            }
            if (c1.x)
            {
                f = -1F;
            } else
            {
                f = 1.0F;
            }
            if (!c1.y)
            {
                f1 = 1.0F;
            }
            ((Canvas) (obj)).scale(f, f1, f2, f3);
            ((Canvas) (obj)).drawBitmap(c1.F, c1.m, ((RectF) (obj1)), c1.p);
            ((Canvas) (obj)).restore();
        }
        obj = SelectionFragment.p(a.a).q();
        if (((ArrayList) (obj)).size() > 0)
        {
            SelectionFragment.y(a.a).b(((ArrayList) (obj)));
        }
        SelectionFragment.p(a.a).a(SelectionFragment.G(a.a));
        if (SelectionFragment.p(a.a).n == com.socialin.android.photo.select.r.FILL_TYPE.CLEAR)
        {
            SelectionFragment.p(a.a).a(com.socialin.android.photo.select.r.FILL_TYPE.ADD);
        }
        SelectionFragment.a(a.a, mentUIMode.SELECTION);
        SelectionFragment.p(a.a).t.invalidate();
        SelectionFragment.a(a.a, false);
        SelectionFragment.z(a.a);
        SelectionFragment.A(a.a);
        SelectionFragment.B(a.a);
    }

    mentUIMode(mentUIMode mentuimode)
    {
        a = mentuimode;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$3

/* anonymous class */
    final class SelectionFragment._cls3
        implements android.view.View.OnClickListener
    {

        final SelectionFragment a;

        public final void onClick(View view)
        {
            if (SelectionFragment.p(a) != null)
            {
                view = new SelectionFragment._cls3._cls1(this);
                SelectionFragment.a(a, true);
                g.a(view, false, SelectionFragment.D(a));
                SelectionFragment.H(a);
            }
        }

            
            {
                a = selectionfragment;
                super();
            }
    }

}
