// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.util.Log;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.common.registries.RegistryHashedId;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.RegistryRecipientId;
import com.target.mothership.common.registries.a;
import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.e;
import com.target.mothership.common.registries.g;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.registries.interfaces.RegistrySearchWrapper;
import com.target.mothership.services.aa;
import com.target.mothership.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistrySearchSummary, TGTRegistryRecipient, TGTRegistrySearchWrapper

public class b extends f
{

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    private static final String TAG = com/target/mothership/model/registries/handler/b.getSimpleName();
    private aa mTransformer;

    public b(h h)
    {
        super(h);
        mTransformer = new aa() {

            final b this$0;

            public RegistrySearchWrapper a(com.target.mothership.services.apigee.k.b.a a1)
            {
                TGTRegistrySearchWrapper tgtregistrysearchwrapper = new TGTRegistrySearchWrapper();
                a1 = a1.a();
                if (a1 == null)
                {
                    return tgtregistrysearchwrapper;
                } else
                {
                    com.target.mothership.model.registries.handler.b.a(b.this, a1, tgtregistrysearchwrapper);
                    return tgtregistrysearchwrapper;
                }
            }

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.apigee.k.b.a)obj);
            }

            
            {
                this$0 = b.this;
                super();
            }
        };
    }

    private TGTRegistrySearchSummary a(com.target.mothership.services.apigee.k.b.a.b b1)
    {
        TGTRegistrySearchSummary tgtregistrysearchsummary = new TGTRegistrySearchSummary();
        tgtregistrysearchsummary.a(b1.d());
        Object obj;
        Iterator iterator;
        com.target.mothership.services.apigee.k.b.a.c c1;
        TGTRegistryRecipient tgtregistryrecipient;
        int i;
        int j;
        if (b1.a() != null)
        {
            obj = new RegistryId(b1.a());
        } else
        {
            obj = null;
        }
        tgtregistrysearchsummary.a(((RegistryId) (obj)));
        tgtregistrysearchsummary.a(g.a(b1.e()));
        if (b1.c() != null)
        {
            obj = new RegistryHashedId(b1.c());
        } else
        {
            obj = null;
        }
        tgtregistrysearchsummary.a(((RegistryHashedId) (obj)));
        if (b1.b() != null)
        {
            obj = new RegistryAlternateId(b1.b());
        } else
        {
            obj = null;
        }
        tgtregistrysearchsummary.a(((RegistryAlternateId) (obj)));
        i = 0;
        j = Integer.valueOf(b1.o()).intValue();
        i = j;
_L1:
        tgtregistrysearchsummary.a(Integer.valueOf(i));
        tgtregistrysearchsummary.a(d.a("yyyy-MM-dd", b1.n()));
        tgtregistrysearchsummary.b(d.a("yyyy-MM-dd", b1.p()));
        tgtregistrysearchsummary.c(d.a("yyyy-MM-dd", b1.q()));
        tgtregistrysearchsummary.d(d.a("yyyy-MM-dd", b1.h()));
        tgtregistrysearchsummary.b(b1.k());
        tgtregistrysearchsummary.c(b1.j());
        tgtregistrysearchsummary.d(b1.i());
        tgtregistrysearchsummary.e(b1.l());
        tgtregistrysearchsummary.f(b1.m());
        tgtregistrysearchsummary.a(c.a(b1.g()));
        obj = new ArrayList();
        b1 = b1.f();
        if (b1 != null)
        {
            iterator = b1.iterator();
            while (iterator.hasNext()) 
            {
                c1 = (com.target.mothership.services.apigee.k.b.a.c)iterator.next();
                tgtregistryrecipient = new TGTRegistryRecipient();
                tgtregistryrecipient.a(c1.d());
                tgtregistryrecipient.b(c1.e());
                if (c1.c() != null)
                {
                    b1 = new RegistryRecipientId(c1.c());
                } else
                {
                    b1 = null;
                }
                tgtregistryrecipient.a(b1);
                tgtregistryrecipient.a(com.target.mothership.common.registries.d.a(c1.a()));
                tgtregistryrecipient.a(com.target.mothership.common.registries.a.a(c1.b()));
                ((List) (obj)).add(tgtregistryrecipient);
            }
        }
        break MISSING_BLOCK_LABEL_384;
        obj;
        Log.e(TAG, "Unable to parse quantity");
          goto _L1
        tgtregistrysearchsummary.a(((List) (obj)));
        return tgtregistrysearchsummary;
    }

    static void a(b b1, com.target.mothership.services.apigee.k.b.a.a a1, TGTRegistrySearchWrapper tgtregistrysearchwrapper)
    {
        b1.a(a1, tgtregistrysearchwrapper);
    }

    private void a(com.target.mothership.services.apigee.k.b.a.a a1, TGTRegistrySearchWrapper tgtregistrysearchwrapper)
    {
        int j = 0;
        int i;
        int k;
        try
        {
            i = Integer.parseInt(a1.b());
        }
        catch (NumberFormatException numberformatexception)
        {
            com.target.a.a.b.a(TAG, "Unable to parse page size");
            i = 0;
        }
        k = Integer.parseInt(a1.c());
        j = k;
_L2:
        tgtregistrysearchwrapper.a(Integer.valueOf(i));
        tgtregistrysearchwrapper.a(a1.a());
        tgtregistrysearchwrapper.b(j);
        tgtregistrysearchwrapper.a(e.a(a1.d()));
        tgtregistrysearchwrapper.a(com.target.mothership.common.registries.f.a(a1.e()));
        b(a1, tgtregistrysearchwrapper);
        return;
        NumberFormatException numberformatexception1;
        numberformatexception1;
        com.target.a.a.b.a(TAG, "Unable to current page size");
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void b(com.target.mothership.services.apigee.k.b.a.a a1, TGTRegistrySearchWrapper tgtregistrysearchwrapper)
    {
        ArrayList arraylist = new ArrayList();
        a1 = a1.f();
        if (a1 != null)
        {
            for (a1 = a1.iterator(); a1.hasNext(); arraylist.add(a((com.target.mothership.services.apigee.k.b.a.b)a1.next()))) { }
        }
        tgtregistrysearchwrapper.a(arraylist);
    }

    protected RegistrySearchWrapper a(com.target.mothership.services.apigee.k.b.a a1)
    {
        return (RegistrySearchWrapper)mTransformer.a(a1);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.k.b.a)obj);
    }

}
