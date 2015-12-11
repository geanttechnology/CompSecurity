// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VODMediaPlayer

class session
{

    String host;
    String session;
    final VODMediaPlayer this$0;

    public Future ping(final int playerTime, final String event)
    {
        return ThreadPoolAccessor.getManager().execute(new Callable() {

            final VODMediaPlayer.PingUplynk this$1;
            final String val$event;
            final int val$playerTime;

            public Integer call()
                throws Exception
            {
                Object obj;
                Object obj1;
                StringBuilder stringbuilder;
                obj = "";
                obj1 = String.format("%s/session/ping/%s.json?v=1&pt=%s", new Object[] {
                    host, session, Integer.valueOf(playerTime)
                });
                String s = ((String) (obj1));
                if (!TextUtils.isEmpty(event))
                {
                    s = (new StringBuilder()).append(((String) (obj1))).append("&ev=").append(event).toString();
                }
                BufferedReader bufferedreader;
                String s1;
                int i;
                try
                {
                    obj1 = (new DefaultHttpClient()).execute(new HttpGet(s)).getEntity().getContent();
                }
                catch (Exception exception)
                {
                    LogUtils.LOGE(VODMediaPlayer.access$000(), exception.getMessage());
                    return Integer.valueOf(-1);
                }
                bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj1)), "utf-8"), 8);
                stringbuilder = new StringBuilder();
_L3:
                s1 = bufferedreader.readLine();
                if (s1 == null) goto _L2; else goto _L1
_L1:
                stringbuilder.append((new StringBuilder()).append(s1).append("\n").toString());
                  goto _L3
                obj1;
                nextPingTime = -1;
_L9:
                obj = new JSONObject(((String) (obj)));
                LogUtils.LOGD(VODMediaPlayer.access$000(), String.format("result of uplynk pint ss-ad %s -- %s", new Object[] {
                    s, ((JSONObject) (obj)).toString()
                }));
                i = ((JSONObject) (obj)).getInt("next_time");
                if (i >= 0) goto _L5; else goto _L4
_L4:
                needsPing = false;
_L7:
                return Integer.valueOf(i);
_L2:
                ((InputStream) (obj1)).close();
                obj1 = stringbuilder.toString();
                obj = obj1;
                continue; /* Loop/switch isn't completed */
_L5:
                needsPing = true;
                if (true) goto _L7; else goto _L6
_L6:
                JSONException jsonexception;
                jsonexception;
                LogUtils.LOGE(VODMediaPlayer.access$000(), jsonexception.getMessage());
                return Integer.valueOf(-1);
                if (true) goto _L9; else goto _L8
_L8:
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$1 = VODMediaPlayer.PingUplynk.this;
                playerTime = i;
                event = s;
                super();
            }
        });
    }

    public _cls1.val.event(String s, String s1)
    {
        this$0 = VODMediaPlayer.this;
        super();
        host = s;
        session = s1;
    }
}
