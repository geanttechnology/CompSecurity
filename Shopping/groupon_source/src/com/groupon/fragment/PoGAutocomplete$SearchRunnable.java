// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;

// Referenced classes of package com.groupon.fragment:
//            PoGAutocomplete

public class this._cls0
    implements Runnable
{

    final PoGAutocomplete this$0;

    public void run()
    {
        universalSyncManager.requestSync(PoGAutocomplete.this, (new UniversalInfo()).put("query", latestQuery).put("place", latestLocation));
    }

    public _cls9()
    {
        this$0 = PoGAutocomplete.this;
        super();
    }
}
