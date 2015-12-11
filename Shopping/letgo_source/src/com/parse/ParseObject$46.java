// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseObject, Parse

static final class val.onlyIfNeeded
    implements ct
{

    final List val$objects;
    final boolean val$onlyIfNeeded;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public List then(cu cu1)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        ParseObject parseobject;
        for (cu1 = ((List)cu1.e()).iterator(); cu1.hasNext(); hashmap.put(parseobject.getObjectId(), parseobject))
        {
            parseobject = (ParseObject)cu1.next();
        }

        cu1 = val$objects.iterator();
        do
        {
            if (!cu1.hasNext())
            {
                break;
            }
            ParseObject parseobject1 = (ParseObject)cu1.next();
            if (!val$onlyIfNeeded || !parseobject1.isDataAvailable())
            {
                ParseObject parseobject2 = (ParseObject)hashmap.get(parseobject1.getObjectId());
                if (parseobject2 == null)
                {
                    throw new RuntimeException((new StringBuilder()).append("Object id ").append(parseobject1.getObjectId()).append(" does not exist").toString());
                }
                if (!Parse.isLocalDatastoreEnabled())
                {
                    parseobject1.mergeFromObject(parseobject2);
                }
            }
        } while (true);
        return val$objects;
    }

    n(List list, boolean flag)
    {
        val$objects = list;
        val$onlyIfNeeded = flag;
        super();
    }
}
