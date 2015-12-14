// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseUser, OfflineStore, 
//            ParseQuery, ParseObject, ParseSQLiteDatabase

private abstract class subQuery
    implements r
{

    private final ParseQuery subQuery;
    private Task subQueryResults;
    final OfflineQueryLogic this$0;

    protected abstract boolean matches(ParseObject parseobject, List list)
        throws ParseException;

    public Task matchesAsync(final ParseObject object, ParseSQLiteDatabase parsesqlitedatabase)
    {
        if (subQueryResults == null)
        {
            ParseUser parseuser = ParseUser.getCurrentUser();
            subQueryResults = OfflineQueryLogic.access$100(OfflineQueryLogic.this).findAsync(subQuery, parseuser, null, false, false, false, parsesqlitedatabase);
        }
        return subQueryResults.onSuccess(new Continuation() {

            final OfflineQueryLogic.SubQueryMatcher this$1;
            final ParseObject val$object;

            public Boolean then(Task task)
                throws ParseException
            {
                return Boolean.valueOf(matches(object, (List)task.getResult()));
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$1 = OfflineQueryLogic.SubQueryMatcher.this;
                object = parseobject;
                super();
            }
        });
    }

    public _cls1.val.object(ParseQuery parsequery)
    {
        this$0 = OfflineQueryLogic.this;
        super();
        subQueryResults = null;
        subQuery = parsequery;
    }
}
