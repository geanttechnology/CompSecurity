// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            MarketingCallable, MarketingHandler, MessagingListener

class nit> extends MarketingCallable
{

    final MarketingHandler this$0;

    public Object call(Object aobj[])
    {
        ((MessagingListener)listeners).localyticsDidDisplayInAppMessage();
        return null;
    }

    ()
    {
        this$0 = MarketingHandler.this;
        super();
    }
}
