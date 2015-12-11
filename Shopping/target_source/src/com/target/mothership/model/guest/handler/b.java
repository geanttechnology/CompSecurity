// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.f;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.d;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuest

public class b extends f
{

    private final aa mTransformer = new aa() {

        final b this$0;

        public Guest a(d d1)
        {
            TGTGuest tgtguest = new TGTGuest();
            tgtguest.a(d1.b());
            tgtguest.a(d1.d());
            tgtguest.b(d1.a());
            tgtguest.c(d1.c());
            tgtguest.a(true);
            tgtguest.a(null);
            return tgtguest;
        }

        public volatile Object a(Object obj)
        {
            return a((d)obj);
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

    protected Guest a(d d1)
    {
        return (Guest)mTransformer.a(d1);
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }
}
