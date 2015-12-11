// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.i.b.a;
import com.target.mothership.services.x;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            o

public class i extends b
{

    private final aa mSuccessTransformer = new aa() {

        final i this$0;

        public volatile Object a(Object obj)
        {
            return a((a)obj);
        }

        public List a(a a1)
        {
            if (a1 == null || a1.a() == null || a1.a().isEmpty())
            {
                return Collections.emptyList();
            } else
            {
                return (new o()).a(a1);
            }
        }

            
            {
                this$0 = i.this;
                super();
            }
    };

    public i(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    protected List a(a a1)
    {
        return (List)mSuccessTransformer.a(a1);
    }

    protected com.target.mothership.model.guest.interfaces.a.i b(x x)
    {
        return (new com.target.mothership.model.guest.a.i()).a(x);
    }
}
