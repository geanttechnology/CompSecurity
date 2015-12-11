// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.guest.a.e;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.g;
import com.target.mothership.services.x;

public class d extends b
{

    private final aa mSuccessTransformer = new aa() {

        final d this$0;

        public volatile Object a(Object obj)
        {
            return a((g)obj);
        }

        public String a(g g1)
        {
            return g1.a();
        }

            
            {
                this$0 = d.this;
                super();
            }
    };

    public d(com.target.mothership.model.d d1)
    {
        super(d1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((g)obj);
    }

    protected String a(g g1)
    {
        return (String)mSuccessTransformer.a(g1);
    }

    protected com.target.mothership.model.guest.interfaces.a.e b(x x)
    {
        return (new e()).a(x);
    }
}
