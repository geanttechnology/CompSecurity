// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.help;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.MenuUtil;

// Referenced classes of package com.amazon.mShop.help:
//            HelpActivity

class this._cls0
    implements android.view.tener
{

    final HelpActivity this$0;

    public void onClick(View view)
    {
        RefMarkerObserver.logRefMarker("mr_app_fbk");
        MenuUtil.provideFeedBack(HelpActivity.this);
    }

    r()
    {
        this$0 = HelpActivity.this;
        super();
    }
}
