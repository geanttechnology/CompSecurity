// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;


// Referenced classes of package com.socialin.android.views:
//            PredicateLayout

final class a
{

    final int a;
    final int b;
    int c;
    int d;
    private PredicateLayout e;

    public a(PredicateLayout predicatelayout, int i, int j)
    {
        e = predicatelayout;
        super();
        a = i;
        b = j;
    }

    final int a(int i)
    {
        if (c == 0)
        {
            return i;
        } else
        {
            return i + (c + PredicateLayout.a(e));
        }
    }
}
