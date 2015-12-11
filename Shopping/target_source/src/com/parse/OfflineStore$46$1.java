// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase, ParseUser

class this._cls1
    implements i
{

    final then this$1;

    public Integer then(j j1)
        throws Exception
    {
        return Integer.valueOf(((List)j1.e()).size());
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    e()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$46

/* anonymous class */
    class OfflineStore._cls46
        implements i
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseQuery.State val$state;
        final ParseUser val$user;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParsePin)j1.e();
            return OfflineStore.access$2300(OfflineStore.this, state, user, j1, true, db).c(new OfflineStore._cls46._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_offlinestore;
                state = state1;
                user = parseuser;
                db = ParseSQLiteDatabase.this;
                super();
            }
    }

}
