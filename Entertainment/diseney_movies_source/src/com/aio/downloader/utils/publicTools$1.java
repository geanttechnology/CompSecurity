// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.utils:
//            publicTools, Myutils

class offset extends AsyncTask
{

    private long offset;
    private String server_time;

    protected transient Long doInBackground(Void avoid[])
    {
        long l;
        l = System.currentTimeMillis();
        server_time = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/time.php?")).append(l).toString());
        if (server_time == null) goto _L2; else goto _L1
_L1:
        offset = (long)((double)Long.parseLong(server_time.trim()) - Math.floor(l / 1000L));
_L4:
        return Long.valueOf(offset);
_L2:
        server_time = publicTools.getUrl((new StringBuilder("http://93app.com/time.php?")).append(l).toString());
        if (server_time != null)
        {
            offset = (long)((double)Long.parseLong(server_time.trim()) - Math.floor(l / 1000L));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            server_time = publicTools.getUrl("http://www.convert-unix-time.com/api?timestamp=now");
            if (server_time != null)
            {
                offset = (long)((double)Long.parseLong((new JSONObject(server_time)).getString("timestamp").trim()) - Math.floor(l / 1000L));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Long long1)
    {
        super.onPostExecute(long1);
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        if (System.currentTimeMillis() - Myutils.setting_json.getLong("system_time") > 0x36ee80L)
        {
            Myutils.setting_json.put("time_offset", long1);
            Myutils.setting_json.put("system_time", System.currentTimeMillis());
            Myutils.saveSetting();
            Log.v("erer", "aaaaaaaaaa");
        }
        return;
        Exception exception;
        exception;
        try
        {
            Log.v("erer", "bbbbbbbbb");
            Myutils.setting_json.put("time_offset", long1);
            Myutils.setting_json.put("system_time", System.currentTimeMillis());
            Myutils.saveSetting();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Long long1)
        {
            long1.printStackTrace();
        }
        return;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Long)obj);
    }

    protected void onPreExecute()
    {
        publicTools.sp.edit().putLong("time_offset", 0L).commit();
        super.onPreExecute();
    }

    r()
    {
        server_time = null;
        offset = 0L;
    }
}
