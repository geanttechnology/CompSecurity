// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject, ParsePin

class val.object
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final ParseObject val$object;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (Cursor)cu1.e();
        Object obj = new ArrayList();
        cu1.moveToFirst();
        for (; !cu1.isAfterLast(); cu1.moveToNext())
        {
            ((List) (obj)).add(cu1.getString(0));
        }

        cu1.close();
        cu1 = new ArrayList();
        final String uuid;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cu1.add(OfflineStore.access$600(OfflineStore.this, uuid, val$db).d(new ct() {

        final OfflineStore._cls31 this$1;

        public cu then(cu cu2)
            throws Exception
        {
            cu2 = (ParsePin)cu2.e();
            return fetchLocallyAsync(cu2, db);
        }

        public volatile Object then(cu cu2)
            throws Exception
        {
            return then(cu2);
        }

            
            {
                this$1 = OfflineStore._cls31.this;
                super();
            }
    }).b(new ct() {

        final OfflineStore._cls31 this$1;
        final String val$uuid;

        public cu then(cu cu2)
            throws Exception
        {
            ParsePin parsepin = (ParsePin)cu2.e();
            List list = parsepin.getObjects();
            if (list == null || !list.contains(object))
            {
                return cu2.j();
            }
            list.remove(object);
            if (list.size() == 0)
            {
                return OfflineStore.access$1000(this$0, uuid, db);
            } else
            {
                parsepin.setObjects(list);
                return OfflineStore.access$1500(this$0, parsepin, true, db);
            }
        }

        public volatile Object then(cu cu2)
            throws Exception
        {
            return then(cu2);
        }

            
            {
                this$1 = OfflineStore._cls31.this;
                uuid = s;
                super();
            }
    })))
        {
            uuid = (String)((Iterator) (obj)).next();
        }

        return cu.a(cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$db = parsesqlitedatabase;
        val$object = ParseObject.this;
        super();
    }
}
