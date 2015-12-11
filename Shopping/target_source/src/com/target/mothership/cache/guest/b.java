// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import com.target.mothership.cache.c;
import com.target.mothership.model.d;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.util.a;

public class b extends c
{

    public b(h h)
    {
        super(h);
    }

    public void onError(final x error)
    {
        a.a(new com.target.mothership.util.a.a() {

            final b this$0;
            final x val$error;

            public void runTask()
            {
                getReceiver().b(error);
            }

            
            {
                this$0 = b.this;
                error = x1;
                super();
            }
        });
    }

    public volatile void onError(Object obj)
    {
        onError((x)obj);
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
