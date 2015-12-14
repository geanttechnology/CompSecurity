// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.Matrix;
import android.view.View;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a, SPArrow

final class a
    implements android.view..OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        view = e.b(a).e();
        if (view != null && ((a) (view)).d != null)
        {
            SPArrow sparrow = view.a(((a) (view)).c);
            ((a) (view)).i.postScale(-1F, 1.0F);
            view.a(sparrow.getX() * 2.0F, 0.0F);
        }
        e.b(a).invalidate();
    }

    row(e e1)
    {
        a = e1;
        super();
    }
}
