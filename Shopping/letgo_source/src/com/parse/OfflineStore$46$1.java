// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase, ParseUser

class this._cls1
    implements ct
{

    final then this$1;

    public Integer then(cu cu1)
        throws Exception
    {
        return Integer.valueOf(((List)cu1.e()).size());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    e()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$46

/* anonymous class */
    class OfflineStore._cls46
        implements ct
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseQuery.State val$state;
        final ParseUser val$user;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParsePin)cu1.e();
            return OfflineStore.access$2300(OfflineStore.this, state, user, cu1, true, db).c(new OfflineStore._cls46._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
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
