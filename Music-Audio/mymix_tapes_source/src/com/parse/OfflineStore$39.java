// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject, ParsePin

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final ParseObject val$object;

    public Task then(Task task)
        throws Exception
    {
        task = (Cursor)task.getResult();
        ArrayList arraylist = new ArrayList();
        task.moveToFirst();
        for (; !task.isAfterLast(); task.moveToNext())
        {
            final String uuid = task.getString(0);
            arraylist.add(OfflineStore.access$600(OfflineStore.this, uuid, val$db).onSuccessTask(new Continuation() {

                final OfflineStore._cls39 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    task1 = (ParsePin)task1.getResult();
                    return fetchLocallyAsync(task1, db);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls39.this;
                super();
            }
            }).continueWithTask(new Continuation() {

                final OfflineStore._cls39 this$1;
                final String val$uuid;

                public Task then(Task task1)
                    throws Exception
                {
                    ParsePin parsepin = (ParsePin)task1.getResult();
                    List list = parsepin.getObjects();
                    if (list == null || !list.contains(object))
                    {
                        return task1.makeVoid();
                    }
                    list.remove(object);
                    if (list.size() == 0)
                    {
                        return OfflineStore.access$900(this$0, uuid, db);
                    } else
                    {
                        parsepin.setObjects(list);
                        return saveLocallyAsync(parsepin, true, db);
                    }
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls39.this;
                uuid = s;
                super();
            }
            }));
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
        val$db = parsesqlitedatabase;
        val$object = ParseObject.this;
        super();
    }
}
