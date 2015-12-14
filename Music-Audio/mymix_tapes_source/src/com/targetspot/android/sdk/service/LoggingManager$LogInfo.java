// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.targetspot.android.sdk.service:
//            LoggingManager

abstract class attempts
{

    int attempts;
    final LoggingManager this$0;

    abstract void fromJSON(JSONObject jsonobject)
        throws JSONException;

    abstract JSONObject toJSON()
        throws JSONException;

    (int i)
    {
        this$0 = LoggingManager.this;
        super();
        attempts = i;
    }
}
