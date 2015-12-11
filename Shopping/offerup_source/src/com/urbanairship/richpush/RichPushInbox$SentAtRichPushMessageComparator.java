// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import java.util.Comparator;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushMessage

class 
    implements Comparator
{

    public int compare(RichPushMessage richpushmessage, RichPushMessage richpushmessage1)
    {
        if (richpushmessage1.getSentDateMS() == richpushmessage.getSentDateMS())
        {
            return richpushmessage.getMessageId().compareTo(richpushmessage1.getMessageId());
        } else
        {
            return Long.valueOf(richpushmessage1.getSentDateMS()).compareTo(Long.valueOf(richpushmessage.getSentDateMS()));
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((RichPushMessage)obj, (RichPushMessage)obj1);
    }

    ()
    {
    }
}
