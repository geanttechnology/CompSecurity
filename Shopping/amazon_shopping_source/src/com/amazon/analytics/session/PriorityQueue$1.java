// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import java.util.Comparator;
import java.util.Map;

// Referenced classes of package com.amazon.analytics.session:
//            PriorityQueue

class this._cls0
    implements Comparator
{

    final PriorityQueue this$0;

    public int compare(Message message, Message message1)
    {
        message = (Long)message.getExtras().get("TimeStamp");
        message1 = (Long)message1.getExtras().get("TimeStamp");
        if (message == null && message1 == null)
        {
            return 0;
        }
        if (message == null)
        {
            return 1;
        }
        if (message1 == null)
        {
            return -1;
        } else
        {
            return message.compareTo(message1);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Message)obj, (Message)obj1);
    }

    ()
    {
        this$0 = PriorityQueue.this;
        super();
    }
}
