// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.brushlib.input.gesture.h;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.picsart.collages:
//            CollageCreatorView, ControlPoint, a, ControlItem, 
//            SPArrow, g

final class a
    implements h
{

    private CollageCreatorView a;

    public final void a(float f, float f1)
    {
        if (!CollageCreatorView.a(a) || CollageCreatorView.b(a) == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i;
        int j;
        arraylist = CollageCreatorView.c(a);
        CollageCreatorView.a(a, false);
        j = arraylist.size();
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        PointF pointf = (PointF)arraylist.get(i);
        if (Math.pow(f - CollageCreatorView.d(a) - pointf.x, 2D) + Math.pow(f1 - CollageCreatorView.e(a) - pointf.y, 2D) > (double)CollageCreatorView.f(a)) goto _L5; else goto _L4
_L4:
        CollageCreatorView.a(a, true);
        CollageCreatorView.a(a, (ControlPoint)CollageCreatorView.b(a).get(i));
_L2:
        CollageCreatorView.b(a, false);
        CollageCreatorView.c(a, true);
        CollageCreatorView.g(a).x = f;
        CollageCreatorView.g(a).y = f1;
        if (!com.picsart.collages.CollageCreatorView.h(a) && !CollageCreatorView.i(a))
        {
            CollageCreatorView.d(a, true);
        }
        CollageCreatorView collagecreatorview = a;
        boolean flag;
        if (CollageCreatorView.j(a) == -1)
        {
            flag = false;
        } else
        {
            flag = a.e().a((int)(f - CollageCreatorView.d(a)), (int)(f1 - CollageCreatorView.e(a)));
        }
        CollageCreatorView.e(collagecreatorview, flag);
        a.invalidate();
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void b(float f, float f1)
    {
        CollageCreatorView.c(a, false);
        CollageCreatorView.d(a, false);
        CollageCreatorView.a(a, false);
        a.invalidate();
    }

    public final void c(float f, float f1)
    {
        float f2;
        float f4;
        int i;
        i = 0;
        f2 = f - CollageCreatorView.g(a).x;
        f4 = f1 - CollageCreatorView.g(a).y;
        if (!com.picsart.collages.CollageCreatorView.h(a)) goto _L2; else goto _L1
_L1:
        CollageCreatorView.k(a).set(CollageCreatorView.k(a).left + f2, CollageCreatorView.k(a).top + f4, f2 + CollageCreatorView.k(a).left + CollageCreatorView.k(a).width(), f4 + CollageCreatorView.k(a).top + CollageCreatorView.k(a).height());
        for (int j = CollageCreatorView.l(a).size(); i < j; i++)
        {
            if (((a)CollageCreatorView.l(a).get(i)).a((int)(f - CollageCreatorView.d(a)), (int)(f1 - CollageCreatorView.e(a))))
            {
                CollageCreatorView.a(a, i);
            }
        }

          goto _L3
_L2:
        if (!CollageCreatorView.i(a)) goto _L5; else goto _L4
_L4:
        Object obj = CollageCreatorView.m(a).controlItems;
        Iterator iterator1 = ((ArrayList) (obj)).iterator();
        boolean flag = true;
        while (iterator1.hasNext()) 
        {
            ControlItem controlitem1 = (ControlItem)iterator1.next();
            if (flag && ((a)CollageCreatorView.l(a).get(controlitem1.cellIndex)).a(controlitem1.verticeIndex, SPArrow.getInstance().setXY(f2, f4), false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            if (CollageCreatorView.n(a) != null)
            {
                for (Iterator iterator2 = CollageCreatorView.l(a).iterator(); iterator2.hasNext();)
                {
                    a a2 = (a)iterator2.next();
                    a2.u = a2.u;
                }

            }
            ControlItem controlitem;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((a)CollageCreatorView.l(a).get(controlitem.cellIndex)).a(controlitem.verticeIndex, SPArrow.getInstance().setXY(f2, f4), true))
            {
                controlitem = (ControlItem)((Iterator) (obj)).next();
            }

            if (CollageCreatorView.n(a) != null)
            {
                Iterator iterator = CollageCreatorView.l(a).iterator();
                float f3 = 3.402823E+38F;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    a a1 = (a)iterator.next();
                    float f5 = a1.d();
                    a1.u = f5;
                    if (f3 > f5)
                    {
                        f3 = f5;
                    }
                } while (true);
                CollageCreatorView.n(a).a(f3);
            }
        }
_L3:
        CollageCreatorView.g(a).x = f;
        CollageCreatorView.g(a).y = f1;
        a.invalidate();
        CollageCreatorView.w(a);
        return;
_L5:
        if (CollageCreatorView.o(a) && CollageCreatorView.j(a) != -1)
        {
            boolean flag1;
            if (!com.picsart.collages.CollageCreatorView.h(a))
            {
                flag1 = ((a)CollageCreatorView.l(a).get(CollageCreatorView.j(a))).a(f - CollageCreatorView.g(a).x, f1 - CollageCreatorView.g(a).y);
            } else
            {
                flag1 = false;
            }
            if (CollageCreatorView.p(a) && !flag1 && !((a)CollageCreatorView.l(a).get(CollageCreatorView.j(a))).a((int)(f - CollageCreatorView.d(a)), (int)(f1 - CollageCreatorView.e(a))))
            {
                if (!CollageCreatorView.q(a))
                {
                    CollageCreatorView.f(a, true);
                    CollageCreatorView.a(a, f);
                    CollageCreatorView.b(a, f1);
                }
                if ((float)(Math.pow(f - CollageCreatorView.r(a), 2D) + Math.pow(f1 - CollageCreatorView.s(a), 2D)) > (float)CollageCreatorView.t(a) || !CollageCreatorView.u(a))
                {
                    CollageCreatorView.a(a, ((a)CollageCreatorView.l(a).get(CollageCreatorView.j(a))).d);
                    if (CollageCreatorView.v(a) != null)
                    {
                        CollageCreatorView.a(a, f, f1);
                    }
                }
            } else
            {
                CollageCreatorView.f(a, false);
                if (!CollageCreatorView.u(a))
                {
                    CollageCreatorView.b(a, flag1);
                }
            }
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    e.h(CollageCreatorView collagecreatorview)
    {
        a = collagecreatorview;
        super();
    }
}
