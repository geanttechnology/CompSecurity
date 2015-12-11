// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, BaseProvider, MarketingMessage

class this._cls0
    implements Callable
{

    final MarketingHandler this$0;

    public volatile Object call()
    {
        return call();
    }

    public List call()
    {
        Cursor cursor;
        ArrayList arraylist;
        cursor = null;
        arraylist = new ArrayList();
        Cursor cursor1 = mProvider.query("marketing_rules", null, null, null, "campaign_id");
        cursor = cursor1;
        while (cursor.moveToNext()) 
        {
            MarketingMessage marketingmessage = new MarketingMessage();
            marketingmessage.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
            marketingmessage.put("campaign_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id"))));
            marketingmessage.put("expiration", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("expiration"))));
            marketingmessage.put("display_seconds", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_seconds"))));
            marketingmessage.put("display_session", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_session"))));
            marketingmessage.put("version", cursor.getString(cursor.getColumnIndexOrThrow("version")));
            marketingmessage.put("phone_location", cursor.getString(cursor.getColumnIndexOrThrow("phone_location")));
            marketingmessage.put("phone_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_width"))));
            marketingmessage.put("phone_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_height"))));
            marketingmessage.put("tablet_location", cursor.getString(cursor.getColumnIndexOrThrow("tablet_location")));
            marketingmessage.put("tablet_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_width"))));
            marketingmessage.put("tablet_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_height"))));
            marketingmessage.put("time_to_display", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("time_to_display"))));
            marketingmessage.put("internet_required", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("internet_required"))));
            marketingmessage.put("ab_test", cursor.getString(cursor.getColumnIndexOrThrow("ab_test")));
            marketingmessage.put("rule_name_non_unique", cursor.getString(cursor.getColumnIndexOrThrow("rule_name_non_unique")));
            marketingmessage.put("location", cursor.getString(cursor.getColumnIndexOrThrow("location")));
            marketingmessage.put("devices", cursor.getString(cursor.getColumnIndexOrThrow("devices")));
            marketingmessage.put("control_group", cursor.getString(cursor.getColumnIndexOrThrow("control_group")));
            marketingmessage.put("schema_version", cursor.getString(cursor.getColumnIndexOrThrow("schema_version")));
            arraylist.add(marketingmessage);
        }
          goto _L1
        Object obj;
        obj;
_L4:
        Exception exception;
        if (cursor != null)
        {
            cursor.close();
            return null;
        } else
        {
            return null;
        }
_L1:
        if (cursor != null)
        {
            cursor.close();
            return arraylist;
        } else
        {
            return arraylist;
        }
        obj;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        exception;
        exception = null;
          goto _L4
    }

    ()
    {
        this$0 = MarketingHandler.this;
        super();
    }
}
