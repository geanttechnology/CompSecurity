// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsTokener, Expression

private static final class pe
{

    public final Object condition;
    public final int type;
    public final Object value;

    public (Object obj, Object obj1)
    {
        condition = obj;
        value = obj1;
        type = Expression.getType(obj1);
    }
}
