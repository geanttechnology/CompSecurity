// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.dialog.g;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a

final class a
    implements Runnable
{

    private e a;

    public final void run()
    {
        e.l(a).show();
        CollageCreatorView collagecreatorview = e.b(a);
        float f = collagecreatorview.b();
        for (Iterator iterator = collagecreatorview.b.iterator(); iterator.hasNext(); ((a)iterator.next()).b(f)) { }
        float f1;
        if (collagecreatorview.b.size() > 0)
        {
            a a1 = (a)collagecreatorview.b.get(0);
            f = a1.k;
            f1 = a1.l;
        } else
        {
            f = 0.0F;
            f1 = 0.0F;
        }
        collagecreatorview.g.set(0.0F, 0.0F, f + (collagecreatorview.e + collagecreatorview.f) * 2.0F, f1 + (collagecreatorview.e + collagecreatorview.f) * 2.0F);
        if (collagecreatorview.k != null)
        {
            collagecreatorview.l.set(0, 0, collagecreatorview.k.getWidth(), collagecreatorview.k.getHeight());
            if ((float)collagecreatorview.k.getWidth() < collagecreatorview.g.width() || (float)collagecreatorview.k.getHeight() < collagecreatorview.g.height())
            {
                f1 = Math.max(collagecreatorview.g.width() / (float)collagecreatorview.k.getWidth(), collagecreatorview.g.height() / (float)collagecreatorview.k.getHeight());
                f = (float)collagecreatorview.k.getWidth() * f1;
                f1 *= collagecreatorview.k.getHeight();
                collagecreatorview.h.set((collagecreatorview.g.width() - f) / 2.0F, (collagecreatorview.g.height() - f1) / 2.0F, (f + collagecreatorview.g.width()) / 2.0F, (f1 + collagecreatorview.g.height()) / 2.0F);
            } else
            {
                RectF rectf = collagecreatorview.h;
                f = (collagecreatorview.g.width() - (float)collagecreatorview.k.getWidth()) / 2.0F;
                f1 = (collagecreatorview.g.height() - (float)collagecreatorview.k.getHeight()) / 2.0F;
                float f2 = (collagecreatorview.g.width() + (float)collagecreatorview.k.getWidth()) / 2.0F;
                float f3 = collagecreatorview.g.height();
                rectf.set(f, f1, f2, ((float)collagecreatorview.k.getHeight() + f3) / 2.0F);
            }
        }
        e.a(a, e.q(a));
        e.l(a).dismiss();
    }

    geCreatorView(e e1)
    {
        a = e1;
        super();
    }
}
