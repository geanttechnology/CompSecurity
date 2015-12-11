// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

class straintMatcher extends straintMatcher
{

    final OfflineQueryLogic this$0;
    final ArrayList val$matchers;

    public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        j j1 = j.a(Boolean.valueOf(true));
        for (Iterator iterator = val$matchers.iterator(); iterator.hasNext();)
        {
            j1 = j1.d(new i() {

                final OfflineQueryLogic._cls14 this$1;
                final ParseSQLiteDatabase val$db;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final ParseObject val$object;

                public j then(j j2)
                    throws Exception
                {
                    if (!((Boolean)j2.e()).booleanValue())
                    {
                        return j2;
                    } else
                    {
                        return matcher.matchesAsync(object, db);
                    }
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$1 = OfflineQueryLogic._cls14.this;
                matcher = constraintmatcher;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
            });
        }

        return j1;
    }

    _cls1.val.db(ArrayList arraylist)
    {
        this$0 = final_offlinequerylogic;
        val$matchers = arraylist;
        super(final_offlinequerylogic, ParseUser.this);
    }
}
