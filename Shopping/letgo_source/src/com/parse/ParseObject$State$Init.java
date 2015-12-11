// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, ParseFieldOperation

static abstract class className
{

    private final String className;
    private long createdAt;
    private boolean isComplete;
    private String objectId;
    Map serverData;
    private long updatedAt;

    public className apply(className classname)
    {
        if (classname.tId() != null)
        {
            objectId(classname.tId());
        }
        if (classname.edAt() > 0L)
        {
            createdAt(classname.edAt());
        }
        if (classname.edAt() > 0L)
        {
            updatedAt(classname.edAt());
        }
        boolean flag;
        if (isComplete || classname.plete())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isComplete(flag);
        String s;
        for (Iterator iterator = classname.t().iterator(); iterator.hasNext(); put(s, classname.put(s)))
        {
            s = (String)iterator.next();
        }

        return self();
    }

    public self apply(ParseOperationSet parseoperationset)
    {
        for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = ((ParseFieldOperation)parseoperationset.get(s)).apply(serverData.get(s), s);
            if (obj != null)
            {
                put(s, obj);
            } else
            {
                remove(s);
            }
        }

        return self();
    }

    abstract self build();

    public self clear()
    {
        objectId = null;
        createdAt = -1L;
        updatedAt = -1L;
        isComplete = false;
        serverData.clear();
        return self();
    }

    public self createdAt(long l)
    {
        createdAt = l;
        return self();
    }

    public self createdAt(Date date)
    {
        createdAt = date.getTime();
        return self();
    }

    public self isComplete(boolean flag)
    {
        isComplete = flag;
        return self();
    }

    public self objectId(String s)
    {
        objectId = s;
        return self();
    }

    public self put(String s, Object obj)
    {
        serverData.put(s, obj);
        return self();
    }

    public self remove(String s)
    {
        serverData.remove(s);
        return self();
    }

    abstract self self();

    public self updatedAt(long l)
    {
        updatedAt = l;
        return self();
    }

    public self updatedAt(Date date)
    {
        updatedAt = date.getTime();
        return self();
    }






    ( )
    {
        createdAt = -1L;
        updatedAt = -1L;
        serverData = new HashMap();
        className = .Name();
        objectId = .tId();
        createdAt = .edAt();
        updatedAt = .edAt();
        String s;
        for (Iterator iterator = .t().iterator(); iterator.hasNext(); serverData.put(s, .serverData(s)))
        {
            s = (String)iterator.next();
        }

        isComplete = .plete();
    }

    public plete(String s)
    {
        createdAt = -1L;
        updatedAt = -1L;
        serverData = new HashMap();
        className = s;
    }
}
