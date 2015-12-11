// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends Thread
{

    final MyMainActivity this$0;

    public void run()
    {
        super.run();
        StringBuffer stringbuffer;
        Object obj;
        InputStream inputstream;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        obj = (HttpURLConnection)(new URL("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1")).openConnection();
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        ((HttpURLConnection) (obj)).setConnectTimeout(5000);
        ((HttpURLConnection) (obj)).setReadTimeout(5000);
        if (((HttpURLConnection) (obj)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        inputstream = ((HttpURLConnection) (obj)).getInputStream();
        inputstreamreader = new InputStreamReader(inputstream);
        bufferedreader = new BufferedReader(inputstreamreader);
        stringbuffer = new StringBuffer();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            try
            {
                bufferedreader.close();
                inputstreamreader.close();
                inputstream.close();
                ((HttpURLConnection) (obj)).disconnect();
                obj = handler.obtainMessage();
                obj.what = 250;
                obj.obj = stringbuffer.toString();
                handler.sendMessage(((Message) (obj)));
                return;
            }
            catch (MalformedURLException malformedurlexception)
            {
                malformedurlexception.printStackTrace();
                return;
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_174;
        }
        stringbuffer.append(s);
          goto _L1
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
