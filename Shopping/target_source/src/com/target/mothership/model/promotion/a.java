// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.c;
import com.target.mothership.model.h;
import java.util.List;

public abstract class a extends c
{

    public a()
    {
    }

    public abstract void a(StoreIdentifier storeidentifier, Tcin tcin, h h);

    public abstract void a(StoreIdentifier storeidentifier, String s, h h);

    public abstract void a(StoreIdentifier storeidentifier, List list, List list1, h h);
}
