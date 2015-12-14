// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content.cache;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;

// Referenced classes of package com.aviary.android.feather.library.content.cache:
//            DownloadManager

class val.id
    implements FutureListener
{

    final DownloadManager this$0;
    final DownloadListener val$downloadCallback;
    final String val$file;
    final int val$id;

    public void onFutureDone(Future future)
    {
        handleResult(future, val$file, val$downloadCallback, val$id);
    }

    DownloadListener()
    {
        this$0 = final_downloadmanager;
        val$file = s;
        val$downloadCallback = downloadlistener;
        val$id = I.this;
        super();
    }
}
