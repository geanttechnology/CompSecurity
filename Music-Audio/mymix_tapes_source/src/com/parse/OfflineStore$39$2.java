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
//            ParsePin, OfflineStore, ParseSQLiteDatabase, ParseObject

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        task = (ParsePin)task.getResult();
        return fetchLocallyAsync(task, db);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.object()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$39

/* anonymous class */
    class OfflineStore._cls39
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
                arraylist.add(OfflineStore.access$600(OfflineStore.this, uuid, db).onSuccessTask(new OfflineStore._cls39._cls2()).continueWithTask(new OfflineStore._cls39._cls1()));
            }

            return Task.whenAll(arraylist);
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                db = parsesqlitedatabase;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$39$1

/* anonymous class */
        class OfflineStore._cls39._cls1
            implements Continuation
        {

            final OfflineStore._cls39 this$1;
            final String val$uuid;

            public Task then(Task task)
                throws Exception
            {
                ParsePin parsepin = (ParsePin)task.getResult();
                List list = parsepin.getObjects();
                if (list == null || !list.contains(object))
                {
                    return task.makeVoid();
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

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls39.this;
                        uuid = s;
                        super();
                    }
        }

    }

}
