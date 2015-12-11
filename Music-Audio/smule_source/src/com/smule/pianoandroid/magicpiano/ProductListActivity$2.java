// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.pianoandroid.data.db.h;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class a
    implements h
{

    final Runnable a;
    final ProductListActivity b;

    public void a()
    {
        ProductListActivity.a(b, a);
    }

    (ProductListActivity productlistactivity, Runnable runnable)
    {
        b = productlistactivity;
        a = runnable;
        super();
    }
}
