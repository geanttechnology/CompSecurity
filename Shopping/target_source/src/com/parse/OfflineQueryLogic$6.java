// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseUser, ParseObject

class bQueryMatcher extends bQueryMatcher
{

    final OfflineQueryLogic this$0;
    final String val$key;

    protected boolean matches(ParseObject parseobject, List list)
        throws ParseException
    {
        return OfflineQueryLogic.access$300(list, OfflineQueryLogic.access$200(parseobject, val$key));
    }

    bQueryMatcher(bQueryMatcher bquerymatcher, String s)
    {
        this$0 = final_offlinequerylogic;
        val$key = s;
        super(final_offlinequerylogic, ParseUser.this, bquerymatcher);
    }
}
