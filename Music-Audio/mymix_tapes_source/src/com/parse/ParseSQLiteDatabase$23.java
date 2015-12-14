// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class this._cls0
    implements Continuation
{

    final ParseSQLiteDatabase this$0;

    public Task then(final Task cursor)
        throws Exception
    {
        cursor = (Cursor)cursor.getResult();
        return Task.forResult(Integer.valueOf(cursor.getCount())).continueWithTask(new Continuation() {

            final ParseSQLiteDatabase._cls23 this$1;
            final Cursor val$cursor;

            public Task then(Task task)
                throws Exception
            {
                return Task.forResult(cursor);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$1 = ParseSQLiteDatabase._cls23.this;
                cursor = cursor1;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.val.cursor()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
