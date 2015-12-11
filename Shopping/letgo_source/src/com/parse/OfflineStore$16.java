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
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$objects;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        ArrayList arraylist = new ArrayList();
        ParseObject parseobject;
        for (Iterator iterator = val$objects.iterator(); iterator.hasNext(); arraylist.add(OfflineStore.access$900(OfflineStore.this, cu1, parseobject, val$db)))
        {
            parseobject = (ParseObject)iterator.next();
        }

        return cu.a(arraylist);
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
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
