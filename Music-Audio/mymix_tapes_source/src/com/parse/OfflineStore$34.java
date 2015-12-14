// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseException, OfflineSQLiteOpenHelper, ParseObject, 
//            ParseSQLiteDatabase

class val.object
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
            return OfflineStore.access$1300(OfflineStore.this).getWritableDatabaseAsync().continueWithTask(new Continuation() {

                final OfflineStore._cls34 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    task1 = (ParseSQLiteDatabase)task1.getResult();
                    return task1.beginTransactionAsync().onSuccessTask(task1. new Continuation() {

                        final _cls1 this$2;
                        final ParseSQLiteDatabase val$db;

                        public Task then(Task task)
                            throws Exception
                        {
                            return OfflineStore.access$1200(this$0, object, db).onSuccessTask(new Continuation() {

                                final _cls1 this$3;

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
                this$3 = _cls1.this;
                super();
            }
                            }).continueWithTask(new Continuation() {

                                final _cls1 this$3;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    db.endTransactionAsync();
                                    db.close();
                                    return task;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$3 = _cls1.this;
                super();
            }
                            });
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$2 = final__pcls1;
                db = ParseSQLiteDatabase.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls34.this;
                super();
            }
            });
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls1()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
