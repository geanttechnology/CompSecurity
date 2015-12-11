// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            MiniGameDetails

class this._cls0
    implements Runnable
{

    final MiniGameDetails this$0;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(((MiniGameModel)MiniGameDetails.access$0(MiniGameDetails.this).get(MiniGameDetails.access$1(MiniGameDetails.this))).getSerial()).append("&title=").append(((MiniGameModel)MiniGameDetails.access$0(MiniGameDetails.this).get(MiniGameDetails.access$1(MiniGameDetails.this))).getTitle()).toString());
    }

    ()
    {
        this$0 = MiniGameDetails.this;
        super();
    }
}
