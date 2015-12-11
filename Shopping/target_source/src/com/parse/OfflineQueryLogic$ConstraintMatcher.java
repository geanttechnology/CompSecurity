// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

abstract class user
{

    final OfflineQueryLogic this$0;
    final ParseUser user;

    abstract j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase);

    public (ParseUser parseuser)
    {
        this$0 = OfflineQueryLogic.this;
        super();
        user = parseuser;
    }
}
