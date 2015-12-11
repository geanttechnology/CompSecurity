// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AdultFeaturedFragment

class this._cls0 extends Handler
{

    private String content;
    private String id;
    private String size;
    final AdultFeaturedFragment this$0;

    public void handleMessage(Message message)
    {
        id = message.getData().getString("id");
        size = message.getData().getString("size");
        content = message.getData().getString("content");
        message.what;
        JVM INSTR tableswitch 1212 1212: default 60
    //                   1212 66;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        (new Thread(new Runnable() {

            final AdultFeaturedFragment._cls3 this$1;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=action=download_invalid&type=app&id=")).append(id).append("&size=").append(size).append("&content=").append(content).toString());
            }

            
            {
                this$1 = AdultFeaturedFragment._cls3.this;
                super();
            }
        })).start();
        if (true) goto _L1; else goto _L3
_L3:
    }




    _cls1.this._cls1()
    {
        this$0 = AdultFeaturedFragment.this;
        super();
    }
}
