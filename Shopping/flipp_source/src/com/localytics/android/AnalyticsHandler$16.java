// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
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

    public String call()
    {
        Cursor cursor = mProvider.query("info", new String[] {
            "registration_id"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        Object obj = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        return ((String) (obj));
        obj;
        obj = null;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        obj;
        obj = cursor;
        if (true) goto _L3; else goto _L2
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    ()
    {
        this$0 = AnalyticsHandler.this;
        super();
    }
}
