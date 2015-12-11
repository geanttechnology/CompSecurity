// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.x;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.service:
//            k

class l.h extends h
{

    final k this$0;

    public void a(e e1)
    {
        Object obj = k.a(k.this, e1);
        k.a(k.this, ((this._cls0) (obj)));
        k.b(k.this, ((this._cls0) (obj)));
        k.c(k.this, ((this._cls0) (obj)));
        k.d(k.this, ((this._cls0) (obj)));
        obj = k.d();
        StringBuilder stringbuilder = (new StringBuilder()).append("Set most relevant store to ");
        if (e1.b())
        {
            e1 = (new StringBuilder()).append(((RelevantStoreSummary)e1.c()).getStoreId().a()).append(" (").append(((RelevantStoreSummary)e1.c()).getName()).append("), inside: ").append(((RelevantStoreSummary)e1.c()).a()).toString();
        } else
        {
            e1 = "none";
        }
        q.d(((String) (obj)), stringbuilder.append(e1).toString());
        com.target.ui.service.k.e(k.this);
    }

    public void a(x x1)
    {
        q.a(k.d(), (new StringBuilder()).append("Error getting most relevant store! ").append(x1).toString());
        com.target.ui.service.k.e(k.this);
    }

    public volatile void a(Object obj)
    {
        a((e)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ices.x()
    {
        this$0 = k.this;
        super();
    }
}
