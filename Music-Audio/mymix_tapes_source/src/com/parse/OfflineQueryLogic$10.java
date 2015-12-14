// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseObject, ParseSQLiteDatabase

class ints
    implements straintMatcher
{

    final OfflineQueryLogic this$0;
    final ints val$allKeyConstraints;
    final Object val$constraint;
    final String val$key;
    final String val$operator;

    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        try
        {
            parseobject = ((ParseObject) (OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject, val$key)));
            parseobject = Task.forResult(Boolean.valueOf(OfflineQueryLogic.access$500(val$operator, val$constraint, parseobject, val$allKeyConstraints)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            return Task.forError(parseobject);
        }
        return parseobject;
    }

    ints()
    {
        this$0 = final_offlinequerylogic;
        val$key = s;
        val$operator = s1;
        val$constraint = obj;
        val$allKeyConstraints = ints.this;
        super();
    }
}
