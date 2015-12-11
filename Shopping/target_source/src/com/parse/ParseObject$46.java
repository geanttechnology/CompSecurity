// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseObject, ParseException, Parse

static final class val.onlyIfNeeded
    implements i
{

    final List val$objects;
    final boolean val$onlyIfNeeded;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public List then(j j1)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        ParseObject parseobject;
        for (j1 = ((List)j1.e()).iterator(); j1.hasNext(); hashmap.put(parseobject.getObjectId(), parseobject))
        {
            parseobject = (ParseObject)j1.next();
        }

        j1 = val$objects.iterator();
        do
        {
            if (!j1.hasNext())
            {
                break;
            }
            ParseObject parseobject1 = (ParseObject)j1.next();
            if (!val$onlyIfNeeded || !parseobject1.isDataAvailable())
            {
                ParseObject parseobject2 = (ParseObject)hashmap.get(parseobject1.getObjectId());
                if (parseobject2 == null)
                {
                    throw new ParseException(101, (new StringBuilder()).append("Object id ").append(parseobject1.getObjectId()).append(" does not exist").toString());
                }
                if (!Parse.isLocalDatastoreEnabled())
                {
                    parseobject1.mergeFromObject(parseobject2);
                }
            }
        } while (true);
        return val$objects;
    }

    (List list, boolean flag)
    {
        val$objects = list;
        val$onlyIfNeeded = flag;
        super();
    }
}
