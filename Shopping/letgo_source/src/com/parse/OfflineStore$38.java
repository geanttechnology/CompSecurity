// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseObject, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final boolean val$includeChildren;
    final List val$objects;

    public cu then(cu cu1)
        throws Exception
    {
        ParsePin parsepin = (ParsePin)cu1.e();
        cu1 = parsepin.getObjects();
        if (cu1 == null)
        {
            cu1 = new ArrayList(val$objects);
        } else
        {
            Iterator iterator = val$objects.iterator();
            while (iterator.hasNext()) 
            {
                ParseObject parseobject = (ParseObject)iterator.next();
                if (!cu1.contains(parseobject))
                {
                    cu1.add(parseobject);
                }
            }
        }
        parsepin.setObjects(cu1);
        if (val$includeChildren)
        {
            return OfflineStore.access$1500(OfflineStore.this, parsepin, true, val$db);
        } else
        {
            return OfflineStore.access$1800(OfflineStore.this, parsepin, parsepin.getObjects(), val$db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
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
