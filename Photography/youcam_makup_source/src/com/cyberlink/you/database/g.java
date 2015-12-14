// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.cyberlink.you.database:
//            MessageObj

public class g
    implements Comparator
{

    public g()
    {
    }

    public int a(MessageObj messageobj, MessageObj messageobj1)
    {
        if (messageobj == null)
        {
            messageobj = new Date(0L);
        } else
        {
            messageobj = messageobj.d();
        }
        if (messageobj1 == null)
        {
            messageobj1 = new Date(0L);
        } else
        {
            messageobj1 = messageobj1.d();
        }
        if (messageobj.before(messageobj1))
        {
            return -1;
        }
        return !messageobj.after(messageobj1) ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((MessageObj)obj, (MessageObj)obj1);
    }
}
