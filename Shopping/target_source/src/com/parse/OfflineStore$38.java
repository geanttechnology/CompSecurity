// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseObject, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final boolean val$includeChildren;
    final List val$objects;

    public j then(j j1)
        throws Exception
    {
        ParsePin parsepin = (ParsePin)j1.e();
        j1 = parsepin.getObjects();
        if (j1 == null)
        {
            j1 = new ArrayList(val$objects);
        } else
        {
            Iterator iterator = val$objects.iterator();
            while (iterator.hasNext()) 
            {
                ParseObject parseobject = (ParseObject)iterator.next();
                if (!j1.contains(parseobject))
                {
                    j1.add(parseobject);
                }
            }
        }
        parsepin.setObjects(j1);
        if (val$includeChildren)
        {
            return OfflineStore.access$1500(OfflineStore.this, parsepin, true, val$db);
        } else
        {
            return OfflineStore.access$1800(OfflineStore.this, parsepin, parsepin.getObjects(), val$db);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$objects = list;
        val$includeChildren = flag;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
