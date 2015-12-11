// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.common.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.a.j;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.c;
import com.target.mothership.services.apigee.f.b.i;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuestAddress, TGTPersonName, TGTPhoneNumber

public class f extends b
{

    private aa mTransformer;

    public f(d d)
    {
        super(d);
        mTransformer = new aa() {

            final f this$0;

            public volatile Object a(Object obj)
            {
                return a((c)obj);
            }

            public List a(c c1)
            {
                ArrayList arraylist;
                Iterator iterator;
                arraylist = new ArrayList();
                if (c1.a() == null)
                {
                    return arraylist;
                }
                iterator = c1.a().iterator();
_L8:
                i k;
                TGTGuestAddress tgtguestaddress;
                int l;
                int i1;
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_310;
                }
                k = (i)iterator.next();
                tgtguestaddress = new TGTGuestAddress();
                tgtguestaddress.e(k.a());
                c1 = com.target.mothership.model.common.a.values();
                i1 = c1.length;
                l = 0;
_L5:
                if (l >= i1) goto _L2; else goto _L1
_L1:
                a a1 = c1[l];
                if (!a1.toString().equals(k.c())) goto _L4; else goto _L3
_L3:
                tgtguestaddress.a(a1);
_L2:
                com.target.mothership.model.common.c ac[];
                tgtguestaddress.a(k.b());
                tgtguestaddress.a(k.d());
                c1 = new TGTPersonName();
                c1.a(k.g());
                c1.b(k.i());
                c1.c(k.h());
                tgtguestaddress.a(c1);
                a1 = null;
                ac = com.target.mothership.model.common.c.values();
                i1 = ac.length;
                l = 0;
_L6:
                c1 = a1;
                if (l < i1)
                {
                    com.target.mothership.model.common.c c2 = ac[l];
                    if (!c2.name().equals(k.k()))
                    {
                        break MISSING_BLOCK_LABEL_301;
                    }
                    c1 = new TGTPhoneNumber();
                    c1.a(k.j());
                    c1.a(c2);
                }
                tgtguestaddress.a(c1);
                tgtguestaddress.c(k.f());
                tgtguestaddress.b(k.e());
                tgtguestaddress.a(k.l());
                arraylist.add(tgtguestaddress);
                continue; /* Loop/switch isn't completed */
_L4:
                l++;
                  goto _L5
                l++;
                  goto _L6
                return arraylist;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                this$0 = f.this;
                super();
            }
        };
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((c)obj);
    }

    protected List a(c c1)
    {
        return (List)mTransformer.a(c1);
    }

    protected com.target.mothership.model.guest.interfaces.a.j b(x x)
    {
        return (new j()).a(x);
    }
}
