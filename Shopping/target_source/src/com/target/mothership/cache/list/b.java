// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import com.target.mothership.cache.c;
import com.target.mothership.model.d;
import com.target.mothership.util.a;

public class b extends c
{

    public b(d d)
    {
        super(d);
    }

    public void onError(final com.target.mothership.model.list.interfaces.a.a error)
    {
        a.a(new com.target.mothership.util.a.a() {

            final b this$0;
            final com.target.mothership.model.list.interfaces.a.a val$error;

            public void runTask()
            {
                getReceiver().b(error);
            }

            
            {
                this$0 = b.this;
                error = a1;
                super();
            }
        });
    }

    public volatile void onError(Object obj)
    {
        onError((com.target.mothership.model.list.interfaces.a.a)obj);
    }

    public void onResponse(final Object response)
    {
        a.a(new com.target.mothership.util.a.a() {

            final b this$0;
            final Object val$response;

            public void runTask()
            {
                getReceiver().a(response);
            }

            
            {
                this$0 = b.this;
                response = obj;
                super();
            }
        });
    }


}
