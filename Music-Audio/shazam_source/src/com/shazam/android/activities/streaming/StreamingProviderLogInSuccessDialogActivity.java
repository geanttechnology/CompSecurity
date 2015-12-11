// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;


// Referenced classes of package com.shazam.android.activities.streaming:
//            d, b

public class StreamingProviderLogInSuccessDialogActivity extends d
{

    public StreamingProviderLogInSuccessDialogActivity()
    {
    }

    protected final d.d a(b b1, boolean flag)
    {
        b1 = getString(b1.d);
        String s = getString(0x7f0900dd);
        String s1 = getString(0x7f0900dc, new Object[] {
            b1
        });
        String s2;
        String s3;
        int i;
        if (flag)
        {
            i = 0x7f0900cf;
        } else
        {
            i = 0x7f09006f;
        }
        s2 = getString(i, new Object[] {
            b1
        });
        if (flag)
        {
            i = 0x7f0900bb;
        } else
        {
            i = 0x7f0900a9;
        }
        s3 = getString(i);
        if (flag)
        {
            b1 = com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.OPEN_APP;
        } else
        {
            b1 = com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.DOWNLOAD_APP;
        }
        return new d.d(s, s1, s2, s3, b1);
    }

    protected final String b()
    {
        return "streamingloginsuccess";
    }
}
