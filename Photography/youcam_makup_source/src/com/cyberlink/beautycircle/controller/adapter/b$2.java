// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            b

class a
    implements Comparator
{

    final b a;

    public int a(com.cyberlink.beautycircle.model.t.BrandEvent brandevent, com.cyberlink.beautycircle.model.t.BrandEvent brandevent1)
    {
        boolean flag1 = true;
        boolean flag = false;
        int k = brandevent.a(b.a(a));
        int l = brandevent1.a(b.a(a));
        int i;
        int j;
        if (brandevent.priority != null)
        {
            i = brandevent.priority.intValue();
        } else
        {
            i = 0;
        }
        if (brandevent1.priority != null)
        {
            j = brandevent1.priority.intValue();
        } else
        {
            j = 0;
        }
        if (i != j)
        {
            if (i < j)
            {
                i = 1;
            } else
            {
                i = -1;
            }
        } else
        {
            if (k != l)
            {
                if (k < l)
                {
                    i = ((flag1) ? 1 : 0);
                } else
                {
                    i = -1;
                }
                return i;
            }
            i = ((flag) ? 1 : 0);
            if (brandevent.startTime != null)
            {
                i = ((flag) ? 1 : 0);
                if (brandevent.endTime != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (brandevent1.startTime != null)
                    {
                        i = ((flag) ? 1 : 0);
                        if (brandevent1.endTime != null)
                        {
                            if (k == com.cyberlink.beautycircle.model.t.BrandEvent.EVENT_ONGOING)
                            {
                                return brandevent.endTime.compareTo(brandevent1.endTime);
                            }
                            if (k == com.cyberlink.beautycircle.model.t.BrandEvent.EVENT_UPCOMING)
                            {
                                return brandevent.startTime.compareTo(brandevent1.startTime);
                            }
                            i = ((flag) ? 1 : 0);
                            if (k == com.cyberlink.beautycircle.model.t.BrandEvent.EVENT_EXPIRED)
                            {
                                return brandevent1.endTime.compareTo(brandevent.endTime);
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((com.cyberlink.beautycircle.model.t.BrandEvent)obj, (com.cyberlink.beautycircle.model.t.BrandEvent)obj1);
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
