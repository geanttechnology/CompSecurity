// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, ParseObject, OfflineQueryLogic, ParseUser

class val.db
    implements i
{

    final then this$1;
    final ParseSQLiteDatabase val$db;
    final raintMatcher val$matcher;
    final ParseObject val$object;

    public j then(j j1)
        throws Exception
    {
        if (!((Boolean)j1.e()).booleanValue())
        {
            return j1;
        } else
        {
            return val$matcher.matchesAsync(val$object, val$db);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    raintMatcher()
    {
        this$1 = final_raintmatcher;
        val$matcher = raintmatcher1;
        val$object = parseobject;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$14

/* anonymous class */
    class OfflineQueryLogic._cls14 extends OfflineQueryLogic.ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final ArrayList val$matchers;

        public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            j j1 = j.a(Boolean.valueOf(true));
            for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
            {
                j1 = j1.d(parsesqlitedatabase. new OfflineQueryLogic._cls14._cls1());
            }

            return j1;
        }

            
            {
                this$0 = final_offlinequerylogic;
                matchers = arraylist;
                super(final_offlinequerylogic, ParseUser.this);
            }
    }

}
