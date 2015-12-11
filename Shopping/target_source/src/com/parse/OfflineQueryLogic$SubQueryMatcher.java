// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, OfflineStore, ParseUser, 
//            ParseObject, ParseSQLiteDatabase

private abstract class subQuery extends r
{

    private final _cls1.then subQuery;
    private j subQueryResults;
    final OfflineQueryLogic this$0;

    protected abstract boolean matches(ParseObject parseobject, List list)
        throws ParseException;

    public j matchesAsync(final ParseObject object, ParseSQLiteDatabase parsesqlitedatabase)
    {
        if (subQueryResults == null)
        {
            subQueryResults = OfflineQueryLogic.access$100(OfflineQueryLogic.this).findAsync(subQuery, user, null, parsesqlitedatabase);
        }
        return subQueryResults.c(new i() {

            final OfflineQueryLogic.SubQueryMatcher this$1;
            final ParseObject val$object;

            public Boolean then(j j1)
                throws ParseException
            {
                return Boolean.valueOf(matches(object, (List)j1.e()));
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = OfflineQueryLogic.SubQueryMatcher.this;
                object = parseobject;
                super();
            }
        });
    }

    public _cls1.val.object(ParseUser parseuser, _cls1.val.object object)
    {
        this$0 = OfflineQueryLogic.this;
        super(OfflineQueryLogic.this, parseuser);
        subQueryResults = null;
        subQuery = object;
    }
}
