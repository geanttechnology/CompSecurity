// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import com.target.mothership.services.aa;
import com.target.mothership.services.e.d.b.a.a;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            a, TGTAction

class this._cls0
    implements aa
{

    final com.target.mothership.model.page_item.handler.a this$0;

    public TGTAction a(a a1)
    {
        TGTAction tgtaction = new TGTAction();
        if (a1 != null && o.g(a1.b()))
        {
            tgtaction.a(a1.a());
            tgtaction.b(a1.b());
            tgtaction.c(a1.c());
            return tgtaction;
        } else
        {
            return null;
        }
    }

    public volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    ction()
    {
        this$0 = com.target.mothership.model.page_item.handler.a.this;
        super();
    }
}
