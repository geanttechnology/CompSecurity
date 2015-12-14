// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.soundcloud.android.crop:
//            CropImageActivity, CropImageView

class this._cls0
    implements Runnable
{

    final CropImageActivity this$0;

    public void run()
    {
        final CountDownLatch latch = new CountDownLatch(1);
        CropImageActivity.access$200(CropImageActivity.this).post(new Runnable() {

            final CropImageActivity._cls4 this$1;
            final CountDownLatch val$latch;

            public void run()
            {
                if (CropImageActivity.access$100(this$0).getScale() == 1.0F)
                {
                    CropImageActivity.access$100(this$0).center(true, true);
                }
                latch.countDown();
            }

            
            {
                this$1 = CropImageActivity._cls4.this;
                latch = countdownlatch;
                super();
            }
        });
        try
        {
            latch.await();
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        (new opper(CropImageActivity.this, null)).crop();
    }

    _cls1.val.latch()
    {
        this$0 = CropImageActivity.this;
        super();
    }
}
