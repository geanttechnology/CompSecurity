// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParseObject

class e
    implements Continuation
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public Task then(Task task)
        throws Exception
    {
        val$db.endTransactionAsync();
        val$db.close();
        return task;
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

    // Unreferenced inner class com/parse/OfflineStore$20

/* anonymous class */
    class OfflineStore._cls20
        implements Continuation
    {

        final OfflineStore this$0;
        final boolean val$includeAllChildren;
        final ParseObject val$object;

        public Task then(final Task db)
            throws Exception
        {
            db = (ParseSQLiteDatabase)db.getResult();
            return db.beginTransactionAsync().onSuccessTask(new OfflineStore._cls20._cls3()).onSuccessTask(new OfflineStore._cls20._cls2()).continueWithTask(db. new OfflineStore._cls20._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                object = parseobject;
                includeAllChildren = Z.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$20$2

/* anonymous class */
        class OfflineStore._cls20._cls2
            implements Continuation
        {

            final OfflineStore._cls20 this$1;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls20.this;
                        db = parsesqlitedatabase;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$20$3

/* anonymous class */
        class OfflineStore._cls20._cls3
            implements Continuation
        {

            final OfflineStore._cls20 this$1;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                return saveLocallyAsync(object, includeAllChildren, db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls20.this;
                        db = parsesqlitedatabase;
                        super();
                    }
        }

    }

}
