// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, ParseSQLiteDatabase

class this._cls1
    implements Continuation
{

    final then this$1;

    public Boolean then(Task task)
        throws Exception
    {
        boolean flag;
        if (!((Boolean)task.getResult()).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    her()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$9

/* anonymous class */
    class OfflineQueryLogic._cls9
        implements OfflineQueryLogic.ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final OfflineQueryLogic.ConstraintMatcher val$selectMatcher;

        public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            return selectMatcher.matchesAsync(parseobject, parsesqlitedatabase).onSuccess(new OfflineQueryLogic._cls9._cls1());
        }

            
            {
                this$0 = final_offlinequerylogic;
                selectMatcher = OfflineQueryLogic.ConstraintMatcher.this;
                super();
            }
    }

}
