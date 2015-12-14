// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;


// Referenced classes of package com.cyberlink.youcammakeup.database.more.types:
//            CollageType, CollageLayoutType, OrderType, CategoryType

public class a
{

    private final OrderType a;
    private final CategoryType b;
    private final CollageType c;
    private final CollageLayoutType d;

    public a(OrderType ordertype, CategoryType categorytype)
    {
        this(ordertype, categorytype, CollageType.c, CollageLayoutType.c);
    }

    public a(OrderType ordertype, CategoryType categorytype, CollageType collagetype, CollageLayoutType collagelayouttype)
    {
        a = ordertype;
        b = categorytype;
        c = collagetype;
        d = collagelayouttype;
    }

    public OrderType a()
    {
        return a;
    }

    public CategoryType b()
    {
        return b;
    }

    public CollageLayoutType c()
    {
        return d;
    }
}
