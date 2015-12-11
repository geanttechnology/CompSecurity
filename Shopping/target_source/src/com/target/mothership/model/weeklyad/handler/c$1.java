// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.n.b.a.e;
import com.target.mothership.services.apigee.n.b.a.k;
import com.target.mothership.services.apigee.n.b.c;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.weeklyad.handler:
//            c, TGTWeeklyAdPage, TGTWeeklyAdListing

class this._cls0
    implements aa
{

    final com.target.mothership.model.weeklyad.handler.c this$0;

    public volatile Object a(Object obj)
    {
        return a((c)obj);
    }

    public List a(c c1)
    {
        ArrayList arraylist = new ArrayList();
        if (c1.a() != null)
        {
            TGTWeeklyAdPage tgtweeklyadpage;
            for (Iterator iterator = c1.a().iterator(); iterator.hasNext(); arraylist.add(tgtweeklyadpage))
            {
                c1 = (e)iterator.next();
                tgtweeklyadpage = new TGTWeeklyAdPage();
                tgtweeklyadpage.b(c1.b());
                tgtweeklyadpage.a(c1.a());
                ArrayList arraylist1 = new ArrayList();
                if (c1.c() != null)
                {
                    Iterator iterator1 = c1.c().iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        c1 = (com.target.mothership.services.apigee.n.b.a.c)iterator1.next();
                        if (c1.a() != null)
                        {
                            TGTWeeklyAdListing tgtweeklyadlisting = new TGTWeeklyAdListing();
                            tgtweeklyadlisting.c(c1.a().e());
                            tgtweeklyadlisting.b(c1.a().a());
                            tgtweeklyadlisting.a(new ProductSlug(c1.a().c()));
                            tgtweeklyadlisting.a(c1.a().b());
                            tgtweeklyadlisting.d(c1.a().f());
                            c1 = c1.a().d();
                            if (o.f(c1))
                            {
                                c1 = new Tcin(c1);
                            } else
                            {
                                c1 = null;
                            }
                            tgtweeklyadlisting.a(c1);
                            arraylist1.add(tgtweeklyadlisting);
                        }
                    } while (true);
                }
                tgtweeklyadpage.a(arraylist1);
            }

        }
        return arraylist;
    }

    ()
    {
        this$0 = com.target.mothership.model.weeklyad.handler.c.this;
        super();
    }
}
