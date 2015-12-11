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
    final String val$key;
    final Object val$queryConstraintValue;

    public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        try
        {
            parseobject = ((ParseObject) (OfflineQueryLogic.access$200(parseobject, val$key)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            return j.a(parseobject);
        }
        return j.a(Boolean.valueOf(OfflineQueryLogic.access$400(val$queryConstraintValue, parseobject)));
    }

    straintMatcher(Object obj)
    {
        this$0 = final_offlinequerylogic;
        val$key = String.this;
        val$queryConstraintValue = obj;
        super(final_offlinequerylogic, final_parseuser);
    }
}
