// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.deviceinfo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.HashMap;
import java.util.Map;

public class DeviceInfoClient
{

    private static final String DEVICE_INFO_URL = "content://com.amazon.mas.client.framework.DeviceInfoContentProvider";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/deviceinfo/DeviceInfoClient);

    public DeviceInfoClient()
    {
    }

    public Map getDeviceInfo(Context context)
    {
        return getDeviceInfo(context, getDeviceInfoUrl(context));
    }

    public Map getDeviceInfo(Context context, String s)
    {
        if (context != null)
        {
            if ((context = context.getContentResolver().query(Uri.parse(s), null, null, null, null)) != null)
            {
                s = new HashMap();
                context.moveToFirst();
                for (; !context.isAfterLast(); context.moveToNext())
                {
                    String as[] = context.getColumnNames();
                    if (as == null || as.length <= 0)
                    {
                        continue;
                    }
                    for (int i = 0; i < as.length; i++)
                    {
                        s.put(as[i], context.getString(i));
                    }

                    if (!DebugMode.enabled())
                    {
                        continue;
                    }
                    StringBuilder stringbuilder = (new StringBuilder("DeviceInfoContentProvider fields (")).append(as.length).append("): ");
                    for (int j = 0; j < as.length; j++)
                    {
                        stringbuilder.append(as[j]).append(": ").append(context.getString(j));
                        if (j < as.length - 1)
                        {
                            stringbuilder.append(", ");
                        }
                    }

                    log.debug(stringbuilder.toString());
                }

                context.close();
                return s;
            }
        }
        return null;
    }

    public String getDeviceInfoUrl()
    {
        return "content://com.amazon.mas.client.framework.DeviceInfoContentProvider";
    }

    public String getDeviceInfoUrl(Context context)
    {
        return (new StringBuilder()).append("content://com.amazon.mas.client.framework.DeviceInfoContentProvider-").append(context.getPackageName()).toString();
    }

}
