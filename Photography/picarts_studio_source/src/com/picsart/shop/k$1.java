// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.view.View;

// Referenced classes of package com.picsart.shop:
//            k, l, v

final class t>
    implements android.view..OnClickListener
{

    private l a;
    private k b;

    public final void onClick(View view)
    {
        if (b.c != null)
        {
            b.c.a(a.getPosition());
        }
    }

    lickListener(k k1, l l1)
    {
        b = k1;
        a = l1;
        super();
    }
}
