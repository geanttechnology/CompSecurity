// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import com.target.mothership.common.page_item.c;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.d.b.a.e;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            a, TGTImageInfo

class this._cls0
    implements aa
{

    final a this$0;

    public TGTImageInfo a(e e1)
    {
        TGTImageInfo tgtimageinfo = new TGTImageInfo();
        if (e1 != null && o.g(e1.c()))
        {
            tgtimageinfo.a(e1.a());
            tgtimageinfo.a(c.a(e1.b()));
            tgtimageinfo.b(e1.c());
            return tgtimageinfo;
        } else
        {
            return null;
        }
    }

    public volatile Object a(Object obj)
    {
        return a((e)obj);
    }

    mageInfo()
    {
        this$0 = a.this;
        super();
    }
}
