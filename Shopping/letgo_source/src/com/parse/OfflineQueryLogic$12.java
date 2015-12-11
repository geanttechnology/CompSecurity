// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseRelation, ParseUser, ParseObject, 
//            ParseSQLiteDatabase

class straintMatcher extends straintMatcher
{

    final OfflineQueryLogic this$0;
    final nstraint val$relation;

    public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        return cu.a(Boolean.valueOf(val$relation.getRelation().hasKnownObject(parseobject)));
    }

    nstraint(nstraint nstraint)
    {
        this$0 = final_offlinequerylogic;
        val$relation = nstraint;
        super(final_offlinequerylogic, ParseUser.this);
    }
}
