// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseUser, ParseObject, 
//            ParseSQLiteDatabase

class straintMatcher extends straintMatcher
{

    final OfflineQueryLogic this$0;
    final ints val$allKeyConstraints;
    final Object val$constraint;
    final String val$key;
    final String val$operator;

    public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        try
        {
            parseobject = ((ParseObject) (OfflineQueryLogic.access$200(parseobject, val$key)));
            parseobject = j.a(Boolean.valueOf(OfflineQueryLogic.access$500(val$operator, val$constraint, parseobject, val$allKeyConstraints)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            return j.a(parseobject);
        }
        return parseobject;
    }

    ints(ints ints)
    {
        this$0 = final_offlinequerylogic;
        val$key = s;
        val$operator = s1;
        val$constraint = Object.this;
        val$allKeyConstraints = ints;
        super(final_offlinequerylogic, final_parseuser);
    }
}
