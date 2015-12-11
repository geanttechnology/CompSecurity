// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.SharedPreferences;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.utils:
//            publicTools

class r
    implements Runnable
{

    public void run()
    {
        publicTools.access$0((new JSONObject(publicTools.getUrl("http://android.downloadatoz.com/_201409/api/_maket_process/aio_fingerprint_verify.php"))).getString("key"));
        publicTools.spkey.edit().putString("aiokey", publicTools.access$1()).commit();
        if (publicTools.access$1() != null)
        {
            publicTools.downkey = publicTools.access$1();
            return;
        }
        try
        {
            publicTools.downkey = "aio_fingerprint";
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }

    r()
    {
    }
}
