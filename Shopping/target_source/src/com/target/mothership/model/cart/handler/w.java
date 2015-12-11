// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.n;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.c;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            d, TGTAppliedTenders, t, f

public class w extends b
{

    private final aa mTransformer = new aa() {

        final w this$0;

        private List a(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            ArrayList arraylist = new ArrayList();
            com.target.mothership.model.cart.handler.d d1 = new com.target.mothership.model.cart.handler.d();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                z z1 = (z)list.next();
                if (z1.i().c() == a.TARGET_GIFT_CARD)
                {
                    arraylist.add(d1.a(z1));
                }
            } while (true);
            return arraylist;
        }

        public AppliedTenders a(c c1)
        {
            TGTAppliedTenders tgtappliedtenders = new TGTAppliedTenders();
            tgtappliedtenders.a(c1.b());
            z z1 = (new t()).a(c1.a());
            tgtappliedtenders.a((new f()).a(z1));
            tgtappliedtenders.a(a(c1.a()));
            return tgtappliedtenders;
        }

        public volatile Object a(Object obj)
        {
            return a((c)obj);
        }

            
            {
                this$0 = w.this;
                super();
            }
    };

    public w(d d)
    {
        super(d);
    }

    protected AppliedTenders a(c c1)
    {
        return (AppliedTenders)mTransformer.a(c1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((c)obj);
    }

    protected i b(x x)
    {
        return (new n()).a(x);
    }
}
