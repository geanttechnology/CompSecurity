// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;

public class b extends f
{

    private final aa mTransformer = new aa() {

        final b this$0;

        public com.target.mothership.model.store.interfaces.b a(com.target.mothership.services.e.h.b.f f1)
        {
            return f1. new com.target.mothership.model.store.interfaces.b() {

                final _cls1 this$1;
                final com.target.mothership.services.e.h.b.f val$data;

                public String a()
                {
                    return data.a();
                }

                public int b()
                {
                    int i;
                    try
                    {
                        i = Integer.parseInt(data.b());
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        return -1;
                    }
                    return i;
                }

            
            {
                this$1 = final__pcls1;
                data = com.target.mothership.services.e.h.b.f.this;
                super();
            }
            };
        }

        public volatile Object a(Object obj)
        {
            return a((com.target.mothership.services.e.h.b.f)obj);
        }

            
            {
                this$0 = b.this;
                super();
            }
    };

    public b(h h)
    {
        super(h);
    }

    protected com.target.mothership.model.store.interfaces.b a(com.target.mothership.services.e.h.b.f f1)
    {
        return (com.target.mothership.model.store.interfaces.b)mTransformer.a(f1);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.e.h.b.f)obj);
    }
}
