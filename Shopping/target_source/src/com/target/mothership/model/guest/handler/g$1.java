// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.j;
import com.target.mothership.services.apigee.f.b.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            g, TGTGiftCardTender

class this._cls0
    implements aa
{

    final g this$0;

    public volatile Object a(Object obj)
    {
        return a((j)obj);
    }

    public List a(j j1)
    {
        if (j1 == null || j1.a() == null || j1.a().isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        TGTGiftCardTender tgtgiftcardtender;
        for (j1 = j1.a().iterator(); j1.hasNext(); arraylist.add(tgtgiftcardtender))
        {
            l l1 = (l)j1.next();
            tgtgiftcardtender = new TGTGiftCardTender();
            tgtgiftcardtender.a(l1.a());
            tgtgiftcardtender.b(l1.b());
            tgtgiftcardtender.c(l1.c());
            tgtgiftcardtender.d(l1.d());
            tgtgiftcardtender.e(l1.e());
            tgtgiftcardtender.f(l1.f());
        }

        return arraylist;
    }

    iftCardTender()
    {
        this$0 = g.this;
        super();
    }
}
