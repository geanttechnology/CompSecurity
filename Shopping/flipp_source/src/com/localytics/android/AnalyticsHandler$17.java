// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler, BaseProvider

class val.key
    implements Callable
{

    final AnalyticsHandler this$0;
    final String val$key;

    public volatile Object call()
    {
        return call();
    }

    public String call()
    {
        String s = null;
        Cursor cursor = mProvider.query("identifiers", AnalyticsHandler.access$1600(), AnalyticsHandler.access$1700(), new String[] {
            val$key
        }, null);
        if (cursor.moveToFirst())
        {
            s = cursor.getString(cursor.getColumnIndexOrThrow("value"));
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return s;
        Exception exception;
        exception;
        cursor = null;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$key = String.this;
        super();
    }
}
