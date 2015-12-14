// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.objects
    implements Continuation
{

    final List val$objects;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public List then(Task task)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        ParseObject parseobject;
        for (task = ((List)task.getResult()).iterator(); task.hasNext(); hashmap.put(parseobject.getObjectId(), parseobject))
        {
            parseobject = (ParseObject)task.next();
        }

        task = val$objects.iterator();
        do
        {
            if (!task.hasNext())
            {
                break;
            }
            ParseObject parseobject1 = (ParseObject)task.next();
            if (!parseobject1.isDataAvailable())
            {
                ParseObject parseobject2 = (ParseObject)hashmap.get(parseobject1.getObjectId());
                if (parseobject2 == null)
                {
                    throw new RuntimeException((new StringBuilder()).append("Object id ").append(parseobject1.getObjectId()).append(" does not exist").toString());
                }
                parseobject1.mergeFromObject(parseobject2);
                parseobject1.hasBeenFetched = true;
            }
        } while (true);
        return val$objects;
    }

    n(List list)
    {
        val$objects = list;
        super();
    }
}
