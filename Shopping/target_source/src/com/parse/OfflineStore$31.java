// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject, ParsePin

class val.object
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final ParseObject val$object;

    public j then(j j1)
        throws Exception
    {
        j1 = (Cursor)j1.e();
        Object obj = new ArrayList();
        j1.moveToFirst();
        for (; !j1.isAfterLast(); j1.moveToNext())
        {
            ((List) (obj)).add(j1.getString(0));
        }

        j1.close();
        j1 = new ArrayList();
        final String uuid;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); j1.add(OfflineStore.access$600(OfflineStore.this, uuid, val$db).d(new i() {

        final OfflineStore._cls31 this$1;

        public j then(j j2)
            throws Exception
        {
            j2 = (ParsePin)j2.e();
            return fetchLocallyAsync(j2, db);
        }

        public volatile Object then(j j2)
            throws Exception
        {
            return then(j2);
        }

            
            {
                this$1 = OfflineStore._cls31.this;
                super();
            }
    }).b(new i() {

        final OfflineStore._cls31 this$1;
        final String val$uuid;

        public j then(j j2)
            throws Exception
        {
            ParsePin parsepin = (ParsePin)j2.e();
            List list = parsepin.getObjects();
            if (list == null || !list.contains(object))
            {
                return j2.j();
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

        public volatile Object then(j j2)
            throws Exception
        {
            return then(j2);
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

        return j.a(j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$db = parsesqlitedatabase;
        val$object = ParseObject.this;
        super();
    }
}
