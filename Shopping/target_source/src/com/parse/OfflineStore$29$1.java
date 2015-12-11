// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject

class e
    implements i
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public j then(j j1)
        throws Exception
    {
        return OfflineStore.access$1400(_fld0, object, val$db).d(new i() {

            final OfflineStore._cls29._cls1 this$2;

            public j then(j j2)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$2 = OfflineStore._cls29._cls1.this;
                super();
            }
        }).b(new i() {

            final OfflineStore._cls29._cls1 this$2;

            public j then(j j2)
                throws Exception
            {
                db.endTransactionAsync();
                db.closeAsync();
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$2 = OfflineStore._cls29._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$29

/* anonymous class */
    class OfflineStore._cls29
        implements i
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseSQLiteDatabase)j1.e();
            return j1.beginTransactionAsync().d(j1. new OfflineStore._cls29._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_offlinestore;
                object = ParseObject.this;
                super();
            }
    }

}
