// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, ParseObject, OfflineQueryLogic

class val.db
    implements Continuation
{

    final then this$1;
    final ParseSQLiteDatabase val$db;
    final raintMatcher val$matcher;
    final ParseObject val$object;

    public Task then(Task task)
        throws Exception
    {
        if (!((Boolean)task.getResult()).booleanValue())
        {
            return task;
        } else
        {
            return val$matcher.matchesAsync(val$object, val$db);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    raintMatcher()
    {
        this$1 = final_raintmatcher;
        val$matcher = raintmatcher1;
        val$object = parseobject;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$14

/* anonymous class */
    class OfflineQueryLogic._cls14
        implements OfflineQueryLogic.ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final ArrayList val$matchers;

        public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            Task task = Task.forResult(Boolean.valueOf(true));
            for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
            {
                task = task.onSuccessTask(parsesqlitedatabase. new OfflineQueryLogic._cls14._cls1());
            }

            return task;
        }

            
            {
                this$0 = final_offlinequerylogic;
                matchers = ArrayList.this;
                super();
            }
    }

}
