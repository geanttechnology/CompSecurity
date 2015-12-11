// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.common.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.c;
import com.target.mothership.services.apigee.f.b.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            f, TGTGuestAddress, TGTPersonName, TGTPhoneNumber

class this._cls0
    implements aa
{

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
        i j;
        TGTGuestAddress tgtguestaddress;
        int k;
        int l;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_310;
        }
        j = (i)iterator.next();
        tgtguestaddress = new TGTGuestAddress();
        tgtguestaddress.e(j.a());
        c1 = com.target.mothership.model.common.a.values();
        l = c1.length;
        k = 0;
_L5:
        if (k >= l) goto _L2; else goto _L1
_L1:
        a a1 = c1[k];
        if (!a1.toString().equals(j.c())) goto _L4; else goto _L3
_L3:
        tgtguestaddress.a(a1);
_L2:
        com.target.mothership.model.common.c ac[];
        tgtguestaddress.a(j.b());
        tgtguestaddress.a(j.d());
        c1 = new TGTPersonName();
        c1.a(j.g());
        c1.b(j.i());
        c1.c(j.h());
        tgtguestaddress.a(c1);
        a1 = null;
        ac = com.target.mothership.model.common.c.values();
        l = ac.length;
        k = 0;
_L6:
        c1 = a1;
        if (k < l)
        {
            com.target.mothership.model.common.c c2 = ac[k];
            if (!c2.name().equals(j.k()))
            {
                break MISSING_BLOCK_LABEL_301;
            }
            c1 = new TGTPhoneNumber();
            c1.a(j.j());
            c1.a(c2);
        }
        tgtguestaddress.a(c1);
        tgtguestaddress.c(j.f());
        tgtguestaddress.b(j.e());
        tgtguestaddress.a(j.l());
        arraylist.add(tgtguestaddress);
        continue; /* Loop/switch isn't completed */
_L4:
        k++;
          goto _L5
        k++;
          goto _L6
        return arraylist;
        if (true) goto _L8; else goto _L7
_L7:
    }

    honeNumber()
    {
        this$0 = f.this;
        super();
    }
}
