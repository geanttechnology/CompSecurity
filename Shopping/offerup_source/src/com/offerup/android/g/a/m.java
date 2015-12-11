// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.graphics.RectF;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.offerup.android.g.a:
//            l, o

final class m
    implements uk.co.senab.photoview.PhotoViewAttacher.OnMatrixChangedListener
{

    private l a;

    m(l l1)
    {
        a = l1;
        super();
    }

    public final void onMatrixChanged(RectF rectf)
    {
        if (l.a(a).getScale() <= 1.0F)
        {
            if (l.b(a) != null)
            {
                l.b(a).a();
            }
        } else
        if (l.b(a) != null)
        {
            l.b(a).f();
            return;
        }
    }
}
