// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class val.cursor
    implements Continuation
{

    final then this$1;
    final Cursor val$cursor;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(val$cursor);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$cursor = Cursor.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseSQLiteDatabase$12

/* anonymous class */
    class ParseSQLiteDatabase._cls12
        implements Continuation
    {

        final ParseSQLiteDatabase this$0;

        public Task then(Task task)
            throws Exception
        {
            task = (Cursor)task.getResult();
            return Task.forResult(Integer.valueOf(task.getCount())).continueWithTask(task. new ParseSQLiteDatabase._cls12._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
    }

}
