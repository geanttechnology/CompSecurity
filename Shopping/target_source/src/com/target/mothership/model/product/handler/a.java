// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.Dpci;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTBlackFridayPrice

public class a extends f
{

    private final aa mTransformer = new aa() {

        final a this$0;

        public volatile Object a(Object obj)
        {
            return a((com.target.mothership.services.e.e.b.a)obj);
        }

        public List a(com.target.mothership.services.e.e.b.a a1)
        {
            if (a1 == null || a1.a() == null || a1.a().isEmpty())
            {
                return Collections.emptyList();
            }
            ArrayList arraylist = new ArrayList(a1.a().size());
            TGTBlackFridayPrice tgtblackfridayprice;
            for (a1 = a1.a().iterator(); a1.hasNext(); arraylist.add(tgtblackfridayprice))
            {
                com.target.mothership.services.e.e.b.a a2 = (com.target.mothership.services.e.e.b.a)a1.next();
                tgtblackfridayprice = new TGTBlackFridayPrice();
                tgtblackfridayprice.a(new Dpci(a2.a()));
                tgtblackfridayprice.a(a2.b());
            }

            return arraylist;
        }

            
            {
                this$0 = a.this;
                super();
            }
    };

    public a(h h)
    {
        super(h);
    }

    public Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.e.e.b.a)obj);
    }

    protected List a(com.target.mothership.services.e.e.b.a a1)
    {
        return (List)mTransformer.a(a1);
    }

    public x b(x x)
    {
        return x;
    }
}
