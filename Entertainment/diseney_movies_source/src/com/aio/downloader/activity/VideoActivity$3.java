// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aio.downloader.model.VideoModel;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class val.list
    implements Runnable
{

    final VideoActivity this$0;
    private final ArrayList val$list;

    public void run()
    {
        int i = 0;
        do
        {
            if (i >= val$list.size())
            {
                return;
            }
            try
            {
                Object obj = (HttpURLConnection)(new URL(((VideoModel)val$list.get(i)).getVideo_item_url())).openConnection();
                ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "identity");
                ((HttpURLConnection) (obj)).connect();
                obj = (new StringBuilder(String.valueOf(((HttpURLConnection) (obj)).getContentLength()))).toString();
                Log.v("sss", (new StringBuilder(String.valueOf(((VideoModel)val$list.get(i)).getVideo_item_url()))).append(":").append(((String) (obj))).toString());
                ((VideoModel)val$list.get(i)).setVideo_item_size(((String) (obj)));
                obj = new Message();
                obj.what = 3;
                hander.sendMessage(((Message) (obj)));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            i++;
        } while (true);
    }

    ()
    {
        this$0 = final_videoactivity;
        val$list = ArrayList.this;
        super();
    }
}
