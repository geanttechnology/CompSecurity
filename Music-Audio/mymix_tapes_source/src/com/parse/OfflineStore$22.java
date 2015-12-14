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
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class ase
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final ArrayList val$objectsInTree;

    public Task then(Task task)
        throws Exception
    {
        task = (String)task.getResult();
        ArrayList arraylist = new ArrayList();
        ParseObject parseobject;
        for (Iterator iterator = val$objectsInTree.iterator(); iterator.hasNext(); arraylist.add(OfflineStore.access$800(OfflineStore.this, task, parseobject, val$db)))
        {
            parseobject = (ParseObject)iterator.next();
        }

        return Task.whenAll(arraylist);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$objectsInTree = arraylist;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
