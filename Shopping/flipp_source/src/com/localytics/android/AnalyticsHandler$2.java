// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler, BaseProvider

class this._cls0
    implements Callable
{

    final AnalyticsHandler this$0;

    public volatile Object call()
    {
        return call();
    }

    public Map call()
    {
        HashMap hashmap = new HashMap();
        Cursor cursor = mProvider.query("identifiers", null, null, null, null);
        while (cursor.moveToNext()) 
        {
            hashmap.put(cursor.getString(cursor.getColumnIndexOrThrow("key")), cursor.getString(cursor.getColumnIndexOrThrow("value")));
        }
          goto _L1
        Exception exception1;
        exception1;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        return hashmap;
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        return hashmap;
        Exception exception;
        exception;
        exception = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    ()
    {
        this$0 = AnalyticsHandler.this;
        super();
    }
}
