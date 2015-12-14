// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePin, OfflineStore, ParseObject

static final class t>
    implements Continuation
{

    final List val$objects;

    public Task then(Task task)
        throws Exception
    {
        List list;
        ParsePin parsepin;
        OfflineStore offlinestore;
        parsepin = (ParsePin)task.getResult();
        offlinestore = OfflineStore.getCurrent();
        list = parsepin.getObjects();
        if (list != null) goto _L2; else goto _L1
_L1:
        task = new ArrayList(val$objects);
_L4:
        parsepin.setObjects(task);
        return offlinestore.saveLocallyAsync(parsepin, true);
_L2:
        Iterator iterator = val$objects.iterator();
        do
        {
            task = list;
            if (!iterator.hasNext())
            {
                continue;
            }
            task = (ParseObject)iterator.next();
            if (!list.contains(task))
            {
                list.add(task);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (List list)
    {
        val$objects = list;
        super();
    }
}
