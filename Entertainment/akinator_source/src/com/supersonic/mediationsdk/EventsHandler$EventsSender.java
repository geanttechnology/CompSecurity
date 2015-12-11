// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import com.supersonic.mediationsdk.server.HttpFunctions;

// Referenced classes of package com.supersonic.mediationsdk:
//            EventsHandler

private class mEventsToSend
    implements Runnable
{

    private String mEventsToSend;
    private String mEventsUrl;
    final EventsHandler this$0;

    public void run()
    {
        HttpFunctions.getStringFromPost(mEventsUrl, mEventsToSend);
    }

    public (String s, String s1)
    {
        this$0 = EventsHandler.this;
        super();
        mEventsUrl = s;
        mEventsToSend = s1;
    }
}
