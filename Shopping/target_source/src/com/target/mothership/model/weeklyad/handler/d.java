// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import java.util.List;

public class d extends b
{

    private aa mTransformer;

    public d(com.target.mothership.model.d d1)
    {
        super(d1);
        mTransformer = new aa() {

            final d this$0;

            public StoreSlug a(com.target.mothership.services.apigee.n.b.d d2)
            {
                if (d2.a() == null || d2.a().isEmpty())
                {
                    return null;
                } else
                {
                    return new StoreSlug(((com.target.mothership.services.apigee.n.b.a)d2.a().get(0)).a());
                }
            }

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.apigee.n.b.d)obj);
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
    }

    public StoreSlug a(com.target.mothership.services.apigee.n.b.d d1)
    {
        return (StoreSlug)mTransformer.a(d1);
    }

    protected com.target.mothership.model.weeklyad.interfaces.a.b a(StoreSlug storeslug)
    {
        return (new com.target.mothership.model.weeklyad.a.b()).a(storeslug);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.n.b.d)obj);
    }

    protected com.target.mothership.model.weeklyad.interfaces.a.b b(x x)
    {
        return (new com.target.mothership.model.weeklyad.a.b()).a(x);
    }

    protected Object b(Object obj)
    {
        return a((StoreSlug)obj);
    }

    protected boolean b(StoreSlug storeslug)
    {
        return storeslug != null && o.g(storeslug.a());
    }

    protected boolean d(Object obj)
    {
        return b((StoreSlug)obj);
    }
}
