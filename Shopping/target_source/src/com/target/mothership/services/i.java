// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.target.a.a.b;

// Referenced classes of package com.target.mothership.services:
//            p, u, j, q, 
//            v, x

public class i
    implements p
{

    private static final String TAG = com/target/mothership/services/i.getSimpleName();
    private final p decoratedSender;
    private final j interceptor;

    public i(j j1, p p1)
    {
        interceptor = j1;
        decoratedSender = p1;
    }

    static j a(i k)
    {
        return k.interceptor;
    }

    static void a(i k, String s, u u1)
    {
        k.a(s, u1);
    }

    private void a(String s, u u1)
    {
        b.b(TAG, (new StringBuilder()).append(s).append(" short-circuited by interceptor").toString(), u1);
    }

    public void a(com.target.mothership.services.f.a.b.b b1, final q responseHandler, String s)
    {
        responseHandler = new q() {

            final i this$0;
            final q val$responseHandler;

            public void a(v v, boolean flag, com.target.mothership.services.f.a.b.b b2)
            {
                try
                {
                    responseHandler.a(i.a(i.this).a(v, b2), flag, b2);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (v v)
                {
                    i.a(i.this, "Request", v);
                }
            }

            public void a(x x, com.target.mothership.services.f.a.b.b b2)
            {
                try
                {
                    responseHandler.a(i.a(i.this).a(x, b2), b2);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (x x)
                {
                    i.a(i.this, "Error response ", x);
                }
            }

            
            {
                this$0 = i.this;
                responseHandler = q1;
                super();
            }
        };
        try
        {
            decoratedSender.a(interceptor.a(b1), responseHandler, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.target.mothership.services.f.a.b.b b1)
        {
            a("Response ", ((u) (b1)));
        }
    }

    public void a(String s)
        throws IllegalArgumentException
    {
        decoratedSender.a(s);
    }

}
