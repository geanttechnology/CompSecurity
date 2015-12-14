// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.media.MediaMetadataRetriever;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            SeekBarThumbnailStore

class val.retriever
    implements Runnable
{

    final val.retriever this$1;
    final CountDownLatch val$latch;
    final MediaMetadataRetriever val$retriever;

    public void run()
    {
        while (val$latch.getCount() > 0L) 
        {
            try
            {
                val$latch.await();
            }
            catch (InterruptedException interruptedexception)
            {
                GLogger.w(SeekBarThumbnailStore.access$100(), "Thread interrupted...", new Object[0]);
            }
        }
        val$retriever.release();
    }

    Q()
    {
        this$1 = final_q;
        val$latch = countdownlatch;
        val$retriever = MediaMetadataRetriever.this;
        super();
    }
}
