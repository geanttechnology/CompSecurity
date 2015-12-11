// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import com.target.mothership.model.d;
import com.target.mothership.util.a;

public class c
{

    private d mReceiver;

    public c(d d)
    {
        mReceiver = d;
    }

    protected d getReceiver()
    {
        return mReceiver;
    }

    public void onError(final Object error)
    {
        a.a(new com.target.mothership.util.a.a() {

            final c this$0;
            final Object val$error;

            public void runTask()
            {
                mReceiver.b(error);
            }

            
            {
                this$0 = c.this;
                error = obj;
                super();
            }
        });
    }

    public void onResponse(final Object response)
    {
        a.a(new com.target.mothership.util.a.a() {

            final c this$0;
            final Object val$response;

            public void runTask()
            {
                mReceiver.a(response);
            }

            
            {
                this$0 = c.this;
                response = obj;
                super();
            }
        });
    }

}
