// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, ParseSQLiteDatabase

class val.matchers
    implements straintMatcher
{

    final OfflineQueryLogic this$0;
    final ArrayList val$matchers;

    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Task task = Task.forResult(Boolean.valueOf(true));
        for (Iterator iterator = val$matchers.iterator(); iterator.hasNext();)
        {
            task = task.onSuccessTask(new Continuation() {

                final OfflineQueryLogic._cls14 this$1;
                final ParseSQLiteDatabase val$db;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final ParseObject val$object;

                public Task then(Task task1)
                    throws Exception
                {
                    if (!((Boolean)task1.getResult()).booleanValue())
                    {
                        return task1;
                    } else
                    {
                        return matcher.matchesAsync(object, db);
                    }
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineQueryLogic._cls14.this;
                matcher = constraintmatcher;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
            });
        }

        return task;
    }

    _cls1.val.db()
    {
        this$0 = final_offlinequerylogic;
        val$matchers = ArrayList.this;
        super();
    }
}
