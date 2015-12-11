// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, ParseObject, OfflineQueryLogic, ParseUser

class val.db
    implements ct
{

    final then this$1;
    final ParseSQLiteDatabase val$db;
    final raintMatcher val$matcher;
    final ParseObject val$object;

    public cu then(cu cu1)
        throws Exception
    {
        if (((Boolean)cu1.e()).booleanValue())
        {
            return cu1;
        } else
        {
            return val$matcher.matchesAsync(val$object, val$db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    raintMatcher()
    {
        this$1 = final_raintmatcher;
        val$matcher = raintmatcher1;
        val$object = parseobject;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$11

/* anonymous class */
    class OfflineQueryLogic._cls11 extends OfflineQueryLogic.ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final ArrayList val$matchers;

        public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            cu cu1 = cu.a(Boolean.valueOf(false));
            for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
            {
                cu1 = cu1.d(parsesqlitedatabase. new OfflineQueryLogic._cls11._cls1());
            }

            return cu1;
        }

            
            {
                this$0 = final_offlinequerylogic;
                matchers = arraylist;
                super(final_offlinequerylogic, ParseUser.this);
            }
    }

}
