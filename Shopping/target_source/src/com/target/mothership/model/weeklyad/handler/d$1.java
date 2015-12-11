// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.n.b.d;
import java.util.List;

// Referenced classes of package com.target.mothership.model.weeklyad.handler:
//            d

class this._cls0
    implements aa
{

    final com.target.mothership.model.weeklyad.handler.d this$0;

    public StoreSlug a(d d1)
    {
        if (d1.a() == null || d1.a().isEmpty())
        {
            return null;
        } else
        {
            return new StoreSlug(((com.target.mothership.services.apigee.n.b.g)d1.a().get(0)).a());
        }
    }

    public volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    ()
    {
        this$0 = com.target.mothership.model.weeklyad.handler.d.this;
        super();
    }
}
