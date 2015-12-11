// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            ct, cv

final class cu
    implements android.view.View.OnClickListener
{

    final ct a;

    cu(ct ct1)
    {
        a = ct1;
        super();
    }

    public final void onClick(View view)
    {
        if (a.l == null)
        {
            return;
        } else
        {
            a.l.a(a);
            return;
        }
    }
}
