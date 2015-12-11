// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package net.singular.sdk:
//            SingularLog

class FacebookAttributionIdGetter
{

    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private final Context context;
    private final SingularLog log;

    public FacebookAttributionIdGetter(Context context1, SingularLog singularlog)
    {
        log = singularlog;
        context = context1;
    }

    public String getAdvertisingId()
    {
        Object obj = null;
        Cursor cursor = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[] {
            "androidid", "limit_tracking"
        }, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        obj = cursor;
        log.d("singular_sdk", "Couldn't connect to facebook attribution content provider");
        if (cursor != null)
        {
            cursor.close();
        }
        obj = null;
_L4:
        return ((String) (obj));
_L2:
        obj = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = cursor;
        log.d("singular_sdk", "Couldn't get google aid from Facebook");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        int i = cursor.getColumnIndex("androidid");
        obj = cursor;
        int j = cursor.getColumnIndex("limit_tracking");
        if (i <= 0 || j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        if (Boolean.parseBoolean(cursor.getString(j)))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        String s = cursor.getString(i);
        obj = s;
        if (cursor != null)
        {
            cursor.close();
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
    }

    public String getAttributionId()
    {
        Object obj = null;
        Cursor cursor = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[] {
            "aid"
        }, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        obj = cursor;
        log.d("singular_sdk", "Couldn't connect to facebook attribution content provider");
        if (cursor != null)
        {
            cursor.close();
        }
        obj = null;
_L4:
        return ((String) (obj));
_L2:
        obj = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj = cursor;
        log.d("singular_sdk", "Couldn't get attribution id from Facebook");
        obj = cursor;
        cursor.close();
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        String s = cursor.getString(cursor.getColumnIndex("aid"));
        obj = s;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return s;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
    }

}
