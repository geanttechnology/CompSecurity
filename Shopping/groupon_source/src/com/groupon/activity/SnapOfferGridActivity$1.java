// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.manager.UniversalSyncManager;

// Referenced classes of package com.groupon.activity:
//            SnapOfferGridActivity

class this._cls0
    implements android.view.ivity._cls1
{

    final SnapOfferGridActivity this$0;

    public void onClick(View view)
    {
        universalSyncManager.requestSync(SnapOfferGridActivity.this, null);
    }

    ()
    {
        this$0 = SnapOfferGridActivity.this;
        super();
    }
}
