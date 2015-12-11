// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.util.Log;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.publicTools;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package net.tsz.afinal:
//            FinalHttp

class this._cls0
    implements HttpRequestInterceptor
{

    final FinalHttp this$0;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        httprequest.addHeader("AIO", MD5.getMD5((new StringBuilder(String.valueOf(publicTools.keyid))).append(publicTools.downkey).toString()));
        httprequest.addHeader("User-Agent", (new StringBuilder(String.valueOf(FinalHttp.set_a_random_user_agent()))).append("AIOCLEANER").toString());
        Log.e("vfvf", (new StringBuilder("id=====")).append(publicTools.keyid).append("///////md5id=====").append(MD5.getMD5(publicTools.keyid)).append("//////webkey====").append(publicTools.downkey).append("\u4E24\u4E2A=====").append(MD5.getMD5((new StringBuilder(String.valueOf(publicTools.keyid))).append(publicTools.downkey).toString())).toString());
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        httpcontext = FinalHttp.access$0(FinalHttp.this).keySet().iterator();
        do
        {
            if (!httpcontext.hasNext())
            {
                return;
            }
            String s = (String)httpcontext.next();
            httprequest.addHeader(s, (String)FinalHttp.access$0(FinalHttp.this).get(s));
        } while (true);
    }

    tpContext()
    {
        this$0 = FinalHttp.this;
        super();
    }
}
