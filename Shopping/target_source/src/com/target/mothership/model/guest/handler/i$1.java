// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.i.b.a;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            i, o

class this._cls0
    implements aa
{

    final i this$0;

    public volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    public List a(a a1)
    {
        if (a1 == null || a1.a() == null || a1.a().isEmpty())
        {
            return Collections.emptyList();
        } else
        {
            return (new o()).a(a1);
        }
    }

    ()
    {
        this$0 = i.this;
        super();
    }
}
