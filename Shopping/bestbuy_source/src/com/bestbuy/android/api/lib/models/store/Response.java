// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            BBYStore

public class Response
    implements gu, Serializable
{

    private String next;
    private BBYStore stores[];

    public Response()
    {
    }

    public String getNext()
    {
        return next;
    }

    public BBYStore[] getStores()
    {
        return stores;
    }

    public void setNext(String s)
    {
        next = s;
    }

    public void setStores(BBYStore abbystore[])
    {
        stores = abbystore;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [next = ").append(next).append(", stores = ").append(stores).append("]").toString();
    }
}
