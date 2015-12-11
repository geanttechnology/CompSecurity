// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import com.groupon.util.Function0;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

class this._cls0
    implements Function0
{

    final EmailSubscriptions this$0;

    public void execute()
    {
        Ln.d("SUBSCRIPTIONS: finally", new Object[0]);
        EmailSubscriptions.access$300(EmailSubscriptions.this).notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    ut()
    {
        this$0 = EmailSubscriptions.this;
        super();
    }
}
