// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            MarketingRulesAdapter

class this._cls1
    implements Runnable
{

    final .notifyDataSetChanged this$1;

    public void run()
    {
        adapter.updateDataSet();
        adapter.notifyDataSetChanged();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
