// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import com.bitstrips.imoji.models.Imoji;
import com.google.common.base.Function;

// Referenced classes of package com.bitstrips.imoji.manager:
//            RecentImojiesManager

class this._cls0
    implements Function
{

    final RecentImojiesManager this$0;

    public volatile Object apply(Object obj)
    {
        return apply((Imoji)obj);
    }

    public String apply(Imoji imoji)
    {
        return imoji.getTemplateId();
    }

    ()
    {
        this$0 = RecentImojiesManager.this;
        super();
    }
}
