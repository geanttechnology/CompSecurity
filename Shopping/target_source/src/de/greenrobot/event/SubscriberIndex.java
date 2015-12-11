// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package de.greenrobot.event:
//            SubscriberMethod, EventBusException, ThreadMode

abstract class SubscriberIndex
{

    private Map map;

    SubscriberIndex()
    {
        map = new HashMap();
    }

    SubscriberMethod createSubscriberMethod(Class class1, String s, Class class2, ThreadMode threadmode, int i, boolean flag)
    {
        try
        {
            s = new SubscriberMethod(class1.getDeclaredMethod(s, new Class[] {
                class2
            }), class2, threadmode, i, flag);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new EventBusException((new StringBuilder()).append("Could not find subscriber method in ").append(class1).append(". Maybe a missing ProGuard rule?").toString(), s);
        }
        return s;
    }

    abstract SubscriberMethod[] createSubscribersFor(Class class1);

    SubscriberMethod[] getSubscribersFor(Class class1)
    {
        SubscriberMethod asubscribermethod1[] = (SubscriberMethod[])map.get(class1);
        SubscriberMethod asubscribermethod[] = asubscribermethod1;
        if (asubscribermethod1 == null)
        {
            SubscriberMethod asubscribermethod2[] = createSubscribersFor(class1);
            asubscribermethod = asubscribermethod2;
            if (asubscribermethod2 != null)
            {
                map.put(class1, asubscribermethod2);
                asubscribermethod = asubscribermethod2;
            }
        }
        return asubscribermethod;
    }
}
