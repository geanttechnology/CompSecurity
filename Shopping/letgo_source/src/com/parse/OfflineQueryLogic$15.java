// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

class straintMatcher extends straintMatcher
{

    final OfflineQueryLogic this$0;
    final straintMatcher val$constraintMatcher;
    final boolean val$ignoreACLs;

    public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        if (!val$ignoreACLs && !OfflineQueryLogic.hasReadAccess(user, parseobject))
        {
            return cu.a(Boolean.valueOf(false));
        } else
        {
            return val$constraintMatcher.matchesAsync(parseobject, parsesqlitedatabase);
        }
    }

    straintMatcher(straintMatcher straintmatcher)
    {
        this$0 = final_offlinequerylogic;
        val$ignoreACLs = Z.this;
        val$constraintMatcher = straintmatcher;
        super(final_offlinequerylogic, final_parseuser);
    }
}
