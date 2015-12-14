// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

class straintMatcher
    implements straintMatcher
{

    final OfflineQueryLogic this$0;
    final straintMatcher val$constraintMatcher;
    final boolean val$ignoreACLs;
    final ParseUser val$user;

    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        if (!val$ignoreACLs && !OfflineQueryLogic.hasReadAccess(val$user, parseobject))
        {
            return Task.forResult(Boolean.valueOf(false));
        } else
        {
            return val$constraintMatcher.matchesAsync(parseobject, parsesqlitedatabase);
        }
    }

    straintMatcher()
    {
        this$0 = final_offlinequerylogic;
        val$ignoreACLs = flag;
        val$user = parseuser;
        val$constraintMatcher = straintMatcher.this;
        super();
    }
}
