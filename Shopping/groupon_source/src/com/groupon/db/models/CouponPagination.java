// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Pagination

public class CouponPagination extends Pagination
{

    public int total;

    public CouponPagination()
    {
    }

    public Pagination toPagination()
        throws CloneNotSupportedException
    {
        setCount(total);
        return this;
    }
}
