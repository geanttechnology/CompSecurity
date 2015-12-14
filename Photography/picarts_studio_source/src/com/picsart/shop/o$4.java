// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.view.View;

// Referenced classes of package com.picsart.shop:
//            o

final class t>
    implements android.view..OnClickListener
{

    private String a;
    private String b;
    private int c;
    private o d;

    public final void onClick(View view)
    {
        o.a(d, true);
        o.b(d, a, b, c);
    }

    lickListener(o o1, String s, String s1, int i)
    {
        d = o1;
        a = s;
        b = s1;
        c = i;
        super();
    }
}
