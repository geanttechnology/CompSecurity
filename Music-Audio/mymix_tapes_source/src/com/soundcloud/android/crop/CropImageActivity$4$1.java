// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.soundcloud.android.crop:
//            CropImageActivity, CropImageView

class val.latch
    implements Runnable
{

    final val.latch this$1;
    final CountDownLatch val$latch;

    public void run()
    {
        if (CropImageActivity.access$100(_fld0).getScale() == 1.0F)
        {
            CropImageActivity.access$100(_fld0).center(true, true);
        }
        val$latch.countDown();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$latch = CountDownLatch.this;
        super();
    }

    // Unreferenced inner class com/soundcloud/android/crop/CropImageActivity$4

/* anonymous class */
    class CropImageActivity._cls4
        implements Runnable
    {

        final CropImageActivity this$0;

        public void run()
        {
            CountDownLatch countdownlatch = new CountDownLatch(1);
            CropImageActivity.access$200(CropImageActivity.this).post(countdownlatch. new CropImageActivity._cls4._cls1());
            try
            {
                countdownlatch.await();
            }
            catch (InterruptedException interruptedexception)
            {
                throw new RuntimeException(interruptedexception);
            }
            (new CropImageActivity.Cropper(CropImageActivity.this, null)).crop();
        }

            
            {
                this$0 = CropImageActivity.this;
                super();
            }
    }

}
