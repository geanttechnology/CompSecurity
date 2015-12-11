// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.wishabi.flipp.widget:
//            CollectionView, o, j

final class k
    implements android.view.View.OnClickListener
{

    static final boolean a;
    final j b;

    k(j j1)
    {
        b = j1;
        super();
    }

    public final void onClick(View view)
    {
        o o1 = (o)view.getLayoutParams();
        if (!a && o1 == null)
        {
            throw new AssertionError();
        }
        int i = o1.d;
        if (j.b(b) != null && i >= 0)
        {
            j.b(b).getItemId(i);
        }
        b.h.a(view, i);
    }

    static 
    {
        boolean flag;
        if (!com/wishabi/flipp/widget/CollectionView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
