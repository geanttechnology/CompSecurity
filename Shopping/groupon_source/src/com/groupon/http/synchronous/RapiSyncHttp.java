// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http.synchronous;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.groupon.http.synchronous:
//            SyncHttp

public class RapiSyncHttp extends SyncHttp
{

    SharedPreferences prefs;

    public transient RapiSyncHttp(Context context, Class class1, String s, Object aobj[])
    {
        super(context, class1, s, aobj);
    }

    public String getBaseUrl()
        throws Exception
    {
        return prefs.getString("baseRapiUrl", context.getString(0x7f0804c6));
    }
}
