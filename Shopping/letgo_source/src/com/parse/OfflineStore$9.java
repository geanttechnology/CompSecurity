// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseException, WeakValueHashMap, ParseObject

class val.object
    implements ct
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public String then(cu cu1)
        throws Exception
    {
        Cursor cursor = (Cursor)cu1.e();
        cursor.moveToFirst();
        if (cursor.isAfterLast())
        {
            cursor.close();
            throw new ParseException(120, "This object is not available in the offline cache.");
        }
        cu1 = cursor.getString(0);
        String s = cursor.getString(1);
        cursor.close();
        synchronized (OfflineStore.access$300(OfflineStore.this))
        {
            OfflineStore.access$500(OfflineStore.this).put(val$object, cu.a(s));
            OfflineStore.access$400(OfflineStore.this).put(s, val$object);
        }
        return cu1;
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
    }

    p()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
