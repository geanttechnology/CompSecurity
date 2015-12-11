// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.a.q;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.p;
import com.target.mothership.services.x;

public class t extends b
{

    private final aa mTransformer = new aa() {

        final t this$0;

        public volatile Object a(Object obj)
        {
            return a((p)obj);
        }

        public String a(p p1)
        {
            return p1.a();
        }

            
            {
                this$0 = t.this;
                super();
            }
    };

    public t(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((p)obj);
    }

    protected String a(p p1)
    {
        return (String)mTransformer.a(p1);
    }

    protected l b(x x)
    {
        return (new q()).a(x);
    }
}
