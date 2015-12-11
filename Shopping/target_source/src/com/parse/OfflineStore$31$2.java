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
//            ParsePin, OfflineStore, ParseSQLiteDatabase, ParseObject

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        j1 = (ParsePin)j1.e();
        return fetchLocallyAsync(j1, db);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.object()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$31

/* anonymous class */
    class OfflineStore._cls31
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
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); j1.add(OfflineStore.access$600(OfflineStore.this, uuid, db).d(new OfflineStore._cls31._cls2()).b(new OfflineStore._cls31._cls1())))
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

            
            {
                this$0 = final_offlinestore;
                db = parsesqlitedatabase;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$31$1

/* anonymous class */
        class OfflineStore._cls31._cls1
            implements i
        {

            final OfflineStore._cls31 this$1;
            final String val$uuid;

            public j then(j j1)
                throws Exception
            {
                ParsePin parsepin = (ParsePin)j1.e();
                List list = parsepin.getObjects();
                if (list == null || !list.contains(object))
                {
                    return j1.j();
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

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = OfflineStore._cls31.this;
                        uuid = s;
                        super();
                    }
        }

    }

}
