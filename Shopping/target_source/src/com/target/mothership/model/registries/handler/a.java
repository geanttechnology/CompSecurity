// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import com.target.a.a.b;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.RegistryRecipientId;
import com.target.mothership.common.registries.g;
import com.target.mothership.model.h;
import com.target.mothership.model.product.handler.e;
import com.target.mothership.model.registries.interfaces.RegistryDetailWrapper;
import com.target.mothership.services.aa;
import com.target.mothership.services.c.a.a.c;
import com.target.mothership.services.c.a.a.f;
import com.target.mothership.util.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistryDetails, TGTRegistryRecipient, TGTRegistryProductDetails, TGTRegistryDetail

public class a extends e
{

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    private static String TAG = com/target/mothership/model/registries/handler/a.getSimpleName();
    private aa mTransformer;

    public a(h h)
    {
        super(h);
        mTransformer = new aa() {

            final a this$0;

            public RegistryDetailWrapper a(com.target.mothership.services.e.g.b.a a1)
            {
                TGTRegistryDetail tgtregistrydetail = new TGTRegistryDetail();
                tgtregistrydetail.a(a.a(a.this, a1.a()));
                tgtregistrydetail.a(a.a(a.this, a1.b()));
                int j = a1.d();
                int k = a1.e();
                tgtregistrydetail.c(j);
                tgtregistrydetail.d(k);
                tgtregistrydetail.a(a1.c());
                tgtregistrydetail.e(a1.f());
                tgtregistrydetail.a(a1.g());
                int i = 0;
                if (j > 0)
                {
                    i = (int)Math.ceil((float)k / (float)j);
                }
                tgtregistrydetail.b(i);
                return tgtregistrydetail;
            }

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.e.g.b.a)obj);
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
    }

    static TGTRegistryDetails a(a a1, com.target.mothership.services.c.a.a.a a2)
    {
        return a1.a(a2);
    }

    private TGTRegistryDetails a(com.target.mothership.services.c.a.a.a a1)
    {
        TGTRegistryDetails tgtregistrydetails;
        int i;
        tgtregistrydetails = new TGTRegistryDetails();
        tgtregistrydetails.a(new RegistryId(a1.b()));
        tgtregistrydetails.a(a1.f().a());
        String s = a1.f().b();
        if (s != null)
        {
            tgtregistrydetails.a(new RegistryAlternateId(s));
        }
        tgtregistrydetails.a(g.a(a1.e()));
        i = 0;
        int j = Integer.valueOf(Integer.parseInt(a1.h())).intValue();
        i = j;
_L2:
        Object obj;
        tgtregistrydetails.a(i);
        tgtregistrydetails.b(a1.a().d());
        tgtregistrydetails.c(a1.a().a());
        tgtregistrydetails.d(a1.a().b());
        tgtregistrydetails.a(d.a("yyyy-MM-dd", a1.a().c()));
        tgtregistrydetails.b(d.a("yyyy-MM-dd", a1.c()));
        tgtregistrydetails.a(com.target.mothership.common.registries.c.a(a1.d()));
        obj = new ArrayList();
        a1 = a1.g();
        if (a1 != null)
        {
            TGTRegistryRecipient tgtregistryrecipient;
            for (Iterator iterator = a1.iterator(); iterator.hasNext(); ((List) (obj)).add(tgtregistryrecipient))
            {
                com.target.mothership.services.c.a.a.g g1 = (com.target.mothership.services.c.a.a.g)iterator.next();
                tgtregistryrecipient = new TGTRegistryRecipient();
                tgtregistryrecipient.a(g1.c());
                tgtregistryrecipient.b(g1.d());
                a1 = null;
                if (g1.b() != null)
                {
                    a1 = new RegistryRecipientId(g1.b());
                }
                tgtregistryrecipient.a(a1);
                tgtregistryrecipient.a(com.target.mothership.common.registries.d.a(g1.a()));
                tgtregistryrecipient.a(com.target.mothership.common.registries.a.a(g1.e()));
            }

        }
        break; /* Loop/switch isn't completed */
        obj;
        b.a(TAG, "Unable to parse item count");
        if (true) goto _L2; else goto _L1
_L1:
        tgtregistrydetails.a(((List) (obj)));
        return tgtregistrydetails;
    }

    static List a(a a1, List list)
    {
        return a1.a(list);
    }

    private List a(List list)
    {
        ArrayList arraylist;
        if (list == null)
        {
            return Collections.emptyList();
        }
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        TGTRegistryProductDetails tgtregistryproductdetails;
        Object obj;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (f)list.next();
        tgtregistryproductdetails = new TGTRegistryProductDetails();
        a(((com.target.mothership.model.product.handler.TGTProductDetails) (tgtregistryproductdetails)), ((com.target.mothership.services.e.e.b.b) (obj)));
        int i;
        Integer integer = Integer.valueOf(((f) (obj)).b());
        obj = Integer.valueOf(((f) (obj)).a());
        i = integer.intValue();
        int j = ((Integer) (obj)).intValue();
_L3:
        tgtregistryproductdetails.b(i);
        tgtregistryproductdetails.a(j);
        arraylist.add(tgtregistryproductdetails);
        if (true) goto _L2; else goto _L1
        NumberFormatException numberformatexception;
        numberformatexception;
        i = 0;
_L4:
        b.a(TAG, "Unable to parse purchase & requested quantity");
        j = 0;
          goto _L3
_L1:
        return arraylist;
        numberformatexception;
          goto _L4
    }

    protected RegistryDetailWrapper a(com.target.mothership.services.e.g.b.a a1)
    {
        return (RegistryDetailWrapper)mTransformer.a(a1);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.e.g.b.a)obj);
    }

}
