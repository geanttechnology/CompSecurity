// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

class val.activity
    implements com.bitstrips.imoji.auth.lback
{

    final IntentCreatorService this$0;
    final Activity val$activity;
    final Intent val$intent;

    public void error()
    {
        val$activity.startActivityForResult(val$intent, 1);
    }

    public void success(JSONObject jsonobject)
    {
        val$intent.putExtra(val$activity.getString(0x7f06007c), jsonobject.optString("first_name"));
        val$intent.putExtra(val$activity.getString(0x7f06007d), jsonobject.optString("last_name"));
        val$activity.startActivityForResult(val$intent, 1);
    }

    allback()
    {
        this$0 = final_intentcreatorservice;
        val$intent = intent1;
        val$activity = Activity.this;
        super();
    }
}
