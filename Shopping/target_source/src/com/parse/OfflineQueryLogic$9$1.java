// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseUser, ParseObject, ParseSQLiteDatabase

class this._cls1
    implements i
{

    final then this$1;

    public Boolean then(j j1)
        throws Exception
    {
        boolean flag;
        if (!((Boolean)j1.e()).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    her()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$9

/* anonymous class */
    class OfflineQueryLogic._cls9 extends OfflineQueryLogic.ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final OfflineQueryLogic.ConstraintMatcher val$selectMatcher;

        public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            return selectMatcher.matchesAsync(parseobject, parsesqlitedatabase).c(new OfflineQueryLogic._cls9._cls1());
        }

            
            {
                this$0 = final_offlinequerylogic;
                selectMatcher = constraintmatcher;
                super(final_offlinequerylogic, ParseUser.this);
            }
    }

}
