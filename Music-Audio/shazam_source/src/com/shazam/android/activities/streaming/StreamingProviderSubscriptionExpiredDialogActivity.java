// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;


// Referenced classes of package com.shazam.android.activities.streaming:
//            d, b

public class StreamingProviderSubscriptionExpiredDialogActivity extends d
{

    public StreamingProviderSubscriptionExpiredDialogActivity()
    {
    }

    protected final d.d a(b b1, boolean flag)
    {
        String s = getString(0x7f0900ed);
        String s1 = getString(0x7f0900ec);
        String s2 = getString(0x7f090134);
        String s3 = getString(0x7f0900a9);
        if (flag)
        {
            b1 = com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.SUBSCRIBE;
        } else
        {
            b1 = com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.SUBSCRIBE_NO_APP_FOUND;
        }
        return new d.d(s, s1, s2, s3, b1);
    }

    protected final String b()
    {
        return "streamingsubscriptionrequired";
    }
}
