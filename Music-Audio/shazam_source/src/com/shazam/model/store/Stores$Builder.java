// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.model.store:
//            Stores, Store

public static class stores
{

    public List stores;

    public static stores a()
    {
        return new <init>();
    }

    static List a(<init> <init>1)
    {
        return <init>1.stores;
    }

    public final stores a(Store store)
    {
        stores.add(store);
        return this;
    }

    public final Stores b()
    {
        return new Stores(this, null);
    }

    public ()
    {
        stores = new ArrayList();
    }
}
