// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.wishabi.flipp.widget:
//            ab, af, ae

final class ad
    implements android.view.View.OnClickListener
{

    final ab a;

    ad(ab ab1)
    {
        a = ab1;
        super();
    }

    public final void onClick(View view)
    {
        af af1;
        int i;
        int j;
        int k;
        if (a.l == null)
        {
            return;
        }
        j = a.c();
        af1 = a.k;
        k = af1.c.getChildCount();
        i = 0;
_L3:
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (view != af1.c.getChildAt(i)) goto _L2; else goto _L1
_L1:
        a.l.a(j, i);
        return;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }
}
