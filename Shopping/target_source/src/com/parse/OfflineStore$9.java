// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.Cursor;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseException, WeakValueHashMap, ParseObject

class val.object
    implements i
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public String then(j j1)
        throws Exception
    {
        Cursor cursor = (Cursor)j1.e();
        cursor.moveToFirst();
        if (cursor.isAfterLast())
        {
            cursor.close();
            throw new ParseException(120, "This object is not available in the offline cache.");
        }
        j1 = cursor.getString(0);
        String s = cursor.getString(1);
        cursor.close();
        synchronized (OfflineStore.access$300(OfflineStore.this))
        {
            OfflineStore.access$500(OfflineStore.this).put(val$object, j.a(s));
            OfflineStore.access$400(OfflineStore.this).put(s, val$object);
        }
        return j1;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }

    p()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
