// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseObject, ParseUser

class bQueryMatcher extends bQueryMatcher
{

    final OfflineQueryLogic this$0;
    final String val$key;
    final String val$resultKey;

    protected boolean matches(ParseObject parseobject, List list)
        throws ParseException
    {
        parseobject = ((ParseObject) (OfflineQueryLogic.access$200(parseobject, val$key)));
        for (list = list.iterator(); list.hasNext();)
        {
            if (OfflineQueryLogic.access$400(parseobject, OfflineQueryLogic.access$200((ParseObject)list.next(), val$resultKey)))
            {
                return true;
            }
        }

        return false;
    }

    bQueryMatcher(String s, String s1)
    {
        this$0 = final_offlinequerylogic;
        val$key = s;
        val$resultKey = s1;
        super(final_offlinequerylogic, final_parseuser, bQueryMatcher.this);
    }
}
