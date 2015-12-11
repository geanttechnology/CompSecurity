// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;

// Referenced classes of package com.bitstrips.imoji.ui:
//            LoginActivity

class this._cls0
    implements com.bitstrips.imoji.auth.SessionOpenCallback
{

    final LoginActivity this$0;

    public void onOpened()
    {
        analytics.sendEvent(Category.AUTH, Action.LOGIN, "Facebook login");
        LoginActivity.access$300(LoginActivity.this);
    }

    Service()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
