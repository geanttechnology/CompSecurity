// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class e
    implements Continuation
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public Task then(Task task)
        throws Exception
    {
        return OfflineStore.access$900(_fld0, key, val$db).onSuccessTask(new Continuation() {

            final OfflineStore._cls28._cls1 this$2;

            public Task then(Task task1)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$2 = OfflineStore._cls28._cls1.this;
                super();
            }
        }).continueWithTask(new Continuation() {

            final OfflineStore._cls28._cls1 this$2;

            public Task then(Task task1)
                throws Exception
            {
                db.endTransactionAsync();
                db.close();
                return task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$2 = OfflineStore._cls28._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$28

/* anonymous class */
    class OfflineStore._cls28
        implements Continuation
    {

        final OfflineStore this$0;
        final String val$key;

        public Task then(Task task)
            throws Exception
        {
            task = (ParseSQLiteDatabase)task.getResult();
            return task.beginTransactionAsync().onSuccessTask(task. new OfflineStore._cls28._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                key = String.this;
                super();
            }
    }

}
