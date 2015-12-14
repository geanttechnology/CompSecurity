// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseException, OfflineSQLiteOpenHelper, 
//            ParseObject

class val.db
    implements Continuation
{

    final then this$2;
    final ParseSQLiteDatabase val$db;

    public Task then(Task task)
        throws Exception
    {
        return OfflineStore.access$1200(_fld0, object, val$db).onSuccessTask(new Continuation() {

            final OfflineStore._cls34._cls1._cls1 this$3;

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
                this$3 = OfflineStore._cls34._cls1._cls1.this;
                super();
            }
        }).continueWithTask(new Continuation() {

            final OfflineStore._cls34._cls1._cls1 this$3;

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
                this$3 = OfflineStore._cls34._cls1._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    object()
    {
        this$2 = final_object;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$34

/* anonymous class */
    class OfflineStore._cls34
        implements Continuation
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public Task then(Task task)
            throws Exception
        {
            if (task.isFaulted())
            {
                if ((task.getError() instanceof ParseException) && ((ParseException)task.getError()).getCode() == 120)
                {
                    return Task.forResult(null);
                } else
                {
                    return task.makeVoid();
                }
            } else
            {
                return OfflineStore.access$1300(OfflineStore.this).getWritableDatabaseAsync().continueWithTask(new OfflineStore._cls34._cls1());
            }
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                object = ParseObject.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/OfflineStore$34$1

/* anonymous class */
    class OfflineStore._cls34._cls1
        implements Continuation
    {

        final OfflineStore._cls34 this$1;

        public Task then(Task task)
            throws Exception
        {
            task = (ParseSQLiteDatabase)task.getResult();
            return task.beginTransactionAsync().onSuccessTask(task. new OfflineStore._cls34._cls1._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$1 = OfflineStore._cls34.this;
                super();
            }
    }

}
