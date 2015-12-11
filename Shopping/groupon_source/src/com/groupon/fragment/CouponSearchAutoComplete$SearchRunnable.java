// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;

// Referenced classes of package com.groupon.fragment:
//            CouponSearchAutoComplete

public class this._cls0
    implements Runnable
{

    final CouponSearchAutoComplete this$0;

    public void run()
    {
        universalSyncManager.requestSync(CouponSearchAutoComplete.this, (new UniversalInfo()).put("query", latestQuery));
    }

    public ()
    {
        this$0 = CouponSearchAutoComplete.this;
        super();
    }
}
