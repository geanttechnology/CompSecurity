// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.a.f;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.h;
import com.target.mothership.services.x;
import java.util.List;

public class e extends b
{

    private final aa mTransformer = new aa() {

        final e this$0;

        public volatile Object a(Object obj)
        {
            return a((h)obj);
        }

        public String a(h h1)
        {
            return (String)h1.a().get(0);
        }

            
            {
                this$0 = e.this;
                super();
            }
    };

    public e(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((h)obj);
    }

    protected String a(h h1)
    {
        return (String)mTransformer.a(h1);
    }

    protected com.target.mothership.model.guest.interfaces.a.f b(x x)
    {
        return (new f()).a(x);
    }
}
