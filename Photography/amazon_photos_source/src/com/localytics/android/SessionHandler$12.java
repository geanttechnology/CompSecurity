// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            SessionHandler, LocalyticsProvider

class val.customerID
    implements Runnable
{

    final SessionHandler this$0;
    final int val$action;
    final JSONObject val$attributeJSON;
    final String val$customerID;

    public void run()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("attribute", val$attributeJSON.toString());
        contentvalues.put("action", Integer.valueOf(val$action));
        contentvalues.put("customer_id", val$customerID);
        mProvider.insert("profile", contentvalues);
    }

    ()
    {
        this$0 = final_sessionhandler;
        val$attributeJSON = jsonobject;
        val$action = i;
        val$customerID = String.this;
        super();
    }
}
