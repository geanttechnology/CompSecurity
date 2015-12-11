// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

class straintMatcher extends straintMatcher
{

    final OfflineQueryLogic this$0;
    final ArrayList val$matchers;

    public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
    {
        cu cu1 = cu.a(Boolean.valueOf(true));
        for (Iterator iterator = val$matchers.iterator(); iterator.hasNext();)
        {
            cu1 = cu1.d(new ct() {

                final OfflineQueryLogic._cls14 this$1;
                final ParseSQLiteDatabase val$db;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final ParseObject val$object;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (!((Boolean)cu2.e()).booleanValue())
                    {
                        return cu2;
                    } else
                    {
                        return matcher.matchesAsync(object, db);
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
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

        return cu1;
    }

    _cls1.val.db(ArrayList arraylist)
    {
        this$0 = final_offlinequerylogic;
        val$matchers = arraylist;
        super(final_offlinequerylogic, ParseUser.this);
    }
}
