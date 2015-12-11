// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.models.a;
import java.util.Comparator;

// Referenced classes of package com.smule.android.network.managers:
//            PurchasesManager

class a
    implements Comparator
{

    final PurchasesManager a;

    public int a(a a1, a a2)
    {
        return a1.position - a2.position;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((a)obj, (a)obj1);
    }

    (PurchasesManager purchasesmanager)
    {
        a = purchasesmanager;
        super();
    }
}
