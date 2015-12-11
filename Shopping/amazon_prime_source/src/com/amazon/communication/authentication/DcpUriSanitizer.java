// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import android.net.Uri;
import com.amazon.dp.logger.DPLogger;

class DcpUriSanitizer
{

    private static final Uri FAKE_URI = Uri.parse("http://www.amazon.com/workAroundDcpBlackList");
    private static final DPLogger log = new DPLogger("TComm.DcpUriUtil");

    DcpUriSanitizer()
    {
    }

    static Uri sanitizeUriForDcp(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        if (uri.getPath().contains("DeviceEventProxy"))
        {
            log.info("sanitizeUriForDcp", "Using fake URI to work-around DCP blacklist.", new Object[0]);
            return FAKE_URI;
        }
        boolean flag = false;
        Object obj = uri.getPath();
        if (obj == null || ((String) (obj)).trim().length() == 0)
        {
            log.debug("signRequest", "No path or null path in URI, appending / as a workaround", new Object[0]);
            flag = true;
        }
        obj = (new StringBuilder()).append(uri.toString().replace("ws://", "http://").replace("wss://", "https://"));
        if (flag)
        {
            uri = "/";
        } else
        {
            uri = "";
        }
        return Uri.parse(((StringBuilder) (obj)).append(uri).toString());
    }

}
