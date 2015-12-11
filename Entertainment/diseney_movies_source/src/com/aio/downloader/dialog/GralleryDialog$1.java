// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.dialog:
//            GralleryDialog

class this._cls0 extends Thread
{

    final GralleryDialog this$0;

    public void run()
    {
        super.run();
        publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=gallery");
    }

    ()
    {
        this$0 = GralleryDialog.this;
        super();
    }
}
