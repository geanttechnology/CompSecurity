// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseRelation, ParseObject, ParseSQLiteDatabase

class nstraint
    implements straintMatcher
{

    final OfflineQueryLogic this$0;
    final nstraint val$relation;

    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        return Task.forResult(Boolean.valueOf(val$relation.getRelation().hasKnownObject(parseobject)));
    }

    nstraint()
    {
        this$0 = final_offlinequerylogic;
        val$relation = nstraint.this;
        super();
    }
}
