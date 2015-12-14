// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.PointF;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.util.Geom;
import com.socialin.android.util.l;
import java.util.ArrayList;

// Referenced classes of package com.picsart.collages:
//            CollageCreatorView, a

final class a
    implements b
{

    private CollageCreatorView a;

    public final void a()
    {
        CollageCreatorView.d(a, false);
        a.invalidate();
    }

    public final void a(float f, float f1, float f2, float f3)
    {
        if (!CollageCreatorView.h(a))
        {
            l.a(f, f1, f2, f3, CollageCreatorView.x(a));
            CollageCreatorView.y(a);
            CollageCreatorView.g(a, false);
            CollageCreatorView.z(a).x = f;
            CollageCreatorView.A(a).x = f2;
            CollageCreatorView.z(a).y = f1;
            CollageCreatorView.A(a).y = f3;
            CollageCreatorView.c(a, Geom.b(f, f1, f2, f3));
            if (CollageCreatorView.j(a) == -1)
            {
                com.picsart.collages.CollageCreatorView.b(a, CollageCreatorView.x(a).x, CollageCreatorView.x(a).y);
            }
            if (CollageCreatorView.j(a) != -1)
            {
                CollageCreatorView.d(a, true);
                a.invalidate();
                return;
            }
        }
    }

    public final void b(float f, float f1, float f2, float f3)
    {
        if (CollageCreatorView.j(a) != -1 && !CollageCreatorView.h(a) && CollageCreatorView.z(a) != null && CollageCreatorView.A(a) != null)
        {
            PointF pointf = new PointF();
            pointf.x = f;
            pointf.y = f1;
            PointF pointf1 = new PointF();
            pointf1.x = f2;
            pointf1.y = f3;
            float f4 = (CollageCreatorView.z(a).x + CollageCreatorView.A(a).x) / 2.0F;
            float f5 = (CollageCreatorView.z(a).y + CollageCreatorView.A(a).y) / 2.0F;
            float f6 = (pointf.x + pointf1.x) / 2.0F;
            float f7 = (pointf.y + pointf1.y) / 2.0F;
            CollageCreatorView.x(a).x = f6;
            CollageCreatorView.x(a).y = f7;
            ((a)com.picsart.collages.CollageCreatorView.l(a).get(CollageCreatorView.j(a))).a(f6 - f4, f7 - f5);
            f4 = l.a(CollageCreatorView.z(a), CollageCreatorView.A(a), pointf, pointf1);
            CollageCreatorView.z(a).x = f;
            CollageCreatorView.A(a).x = f2;
            CollageCreatorView.z(a).y = f1;
            CollageCreatorView.A(a).y = f3;
            CollageCreatorView.d(a, f4);
            if (Math.abs(CollageCreatorView.B(a)) > 20F)
            {
                CollageCreatorView.g(a, true);
            }
            if (CollageCreatorView.C(a))
            {
                ((a)com.picsart.collages.CollageCreatorView.l(a).get(CollageCreatorView.j(a))).b(f4, CollageCreatorView.x(a).x - CollageCreatorView.d(a), CollageCreatorView.x(a).y - CollageCreatorView.e(a));
            }
            f = Geom.a(pointf, pointf1);
            if (CollageCreatorView.D(a) != 0.0F && f / CollageCreatorView.D(a) != (0.0F / 0.0F))
            {
                ((a)com.picsart.collages.CollageCreatorView.l(a).get(CollageCreatorView.j(a))).a(f / CollageCreatorView.D(a), CollageCreatorView.x(a).x - CollageCreatorView.d(a), CollageCreatorView.x(a).y - CollageCreatorView.e(a));
                CollageCreatorView.c(a, f);
                a.invalidate();
                return;
            }
        }
    }

    e.b(CollageCreatorView collagecreatorview)
    {
        a = collagecreatorview;
        super();
    }
}
