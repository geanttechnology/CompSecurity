// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.c.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.services.e.c.a:
//            a

private class mShoppingId
{

    private String mShoppingId;
    private List mShoppingProducts;
    final a this$0;

    public void a(Integer integer, String s, String s1, String s2)
    {
        mShoppingProducts.add(new <init>(a.this, integer, s, s1, s2));
    }

    public (String s)
    {
        this$0 = a.this;
        super();
        mShoppingProducts = new ArrayList();
        mShoppingId = s;
    }
}
