// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead.handler;

import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.model.h;
import com.target.mothership.model.product.handler.e;
import com.target.mothership.services.aa;
import com.target.mothership.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.typeahead.handler:
//            TGTProductSubSuggestion, TGTProductSuggestion

public class a extends e
{

    private final aa mTransformer = new aa() {

        final a this$0;

        public volatile Object a(Object obj)
        {
            return a((List)obj);
        }

        public List a(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            ArrayList arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (com.target.mothership.services.apigee.m.b.a)iterator.next();
                TGTProductSuggestion tgtproductsuggestion = new TGTProductSuggestion();
                tgtproductsuggestion.a(((com.target.mothership.services.apigee.m.b.a) (obj)).a());
                if (((com.target.mothership.services.apigee.m.b.a) (obj)).b() != null)
                {
                    list = new ArrayList();
                    TGTProductSubSuggestion tgtproductsubsuggestion;
                    for (obj = ((com.target.mothership.services.apigee.m.b.a) (obj)).b().iterator(); ((Iterator) (obj)).hasNext(); list.add(tgtproductsubsuggestion))
                    {
                        com.target.mothership.services.apigee.m.b.a.a a1 = (com.target.mothership.services.apigee.m.b.a.a)((Iterator) (obj)).next();
                        tgtproductsubsuggestion = new TGTProductSubSuggestion();
                        tgtproductsubsuggestion.a(a1.a());
                        a.a(a.this, tgtproductsubsuggestion, a1.b());
                    }

                    tgtproductsuggestion.a(list);
                } else
                {
                    list = null;
                }
                tgtproductsuggestion.a(list);
                arraylist.add(tgtproductsuggestion);
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

    private void a(TGTProductSubSuggestion tgtproductsubsuggestion, String s)
    {
        com.google.a.a.e e1 = q.b(s);
        if (e1.b())
        {
            tgtproductsubsuggestion.a((CategoryId)e1.c());
        } else
        {
            tgtproductsubsuggestion.a(null);
        }
        s = q.a(s);
        if (s.b())
        {
            tgtproductsubsuggestion.a((EndecaId)s.c());
            return;
        } else
        {
            tgtproductsubsuggestion.a(null);
            return;
        }
    }

    static void a(a a1, TGTProductSubSuggestion tgtproductsubsuggestion, String s)
    {
        a1.a(tgtproductsubsuggestion, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((List)obj);
    }

    protected List a(List list)
    {
        return (List)mTransformer.a(list);
    }
}
