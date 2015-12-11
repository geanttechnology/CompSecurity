// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            cn, cw

final class cq
    implements android.view.View.OnClickListener
{

    final cn a;

    cq(cn cn1)
    {
        a = cn1;
        super();
    }

    public final void onClick(View view)
    {
        if (a.n != null)
        {
            a.n.b();
        }
    }
}
