// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            bc, ba

final class bb
    implements android.view.View.OnClickListener
{

    final bc a;
    final ba b;

    bb(ba ba, bc bc1)
    {
        b = ba;
        a = bc1;
        super();
    }

    public final void onClick(View view)
    {
        a.a(b);
    }
}
