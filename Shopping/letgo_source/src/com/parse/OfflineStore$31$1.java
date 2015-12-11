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
//            ParsePin, OfflineStore, ParseSQLiteDatabase, ParseObject

class val.uuid
    implements ct
{

    final then this$1;
    final String val$uuid;

    public cu then(cu cu1)
        throws Exception
    {
        ParsePin parsepin = (ParsePin)cu1.e();
        List list = parsepin.getObjects();
        if (list == null || !list.contains(object))
        {
            return cu1.j();
        }
        list.remove(object);
        if (list.size() == 0)
        {
            return OfflineStore.access$1000(_fld0, val$uuid, db);
        } else
        {
            parsepin.setObjects(list);
            return OfflineStore.access$1500(_fld0, parsepin, true, db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    l.object()
    {
        this$1 = final_object;
        val$uuid = String.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$31

/* anonymous class */
    class OfflineStore._cls31
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
            String s;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cu1.add(OfflineStore.access$600(OfflineStore.this, s, db).d(new OfflineStore._cls31._cls2()).b(s. new OfflineStore._cls31._cls1())))
            {
                s = (String)((Iterator) (obj)).next();
            }

            return cu.a(cu1);
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_offlinestore;
                db = parsesqlitedatabase;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$31$2

/* anonymous class */
        class OfflineStore._cls31._cls2
            implements ct
        {

            final OfflineStore._cls31 this$1;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParsePin)cu1.e();
                return fetchLocallyAsync(cu1, db);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$1 = OfflineStore._cls31.this;
                        super();
                    }
        }

    }

}
