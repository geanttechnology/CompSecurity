// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.abtnprojects.ambatana.models.chat:
//            Message

public class MessageComparator
    implements Comparator
{

    public MessageComparator()
    {
    }

    public int compare(Message message, Message message1)
    {
        boolean flag = false;
        long l = message.getCreatedAt().getTime();
        long l1 = message1.getCreatedAt().getTime();
        if (l == l1)
        {
            return 0;
        }
        if (l > l1)
        {
            flag = true;
        }
        return !flag ? -1 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Message)obj, (Message)obj1);
    }
}
