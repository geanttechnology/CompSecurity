// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseObject, ParseSQLiteDatabase

class val.queryConstraintValue
    implements straintMatcher
{

    final OfflineQueryLogic this$0;
    final String val$key;
    final Object val$queryConstraintValue;

    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        try
        {
            parseobject = ((ParseObject) (OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject, val$key)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            return Task.forError(parseobject);
        }
        return Task.forResult(Boolean.valueOf(OfflineQueryLogic.access$400(val$queryConstraintValue, parseobject)));
    }

    straintMatcher()
    {
        this$0 = final_offlinequerylogic;
        val$key = s;
        val$queryConstraintValue = Object.this;
        super();
    }
}
