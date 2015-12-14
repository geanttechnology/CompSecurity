// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.picsart.studio.gifencoder:
//            d, GifDrawable, GifInfoHandle, b

final class c extends d
{

    private final Runnable b = new Runnable() {

        private c a;

        public final void run()
        {
            for (Iterator iterator = a.a.mListeners.iterator(); iterator.hasNext(); iterator.next()) { }
        }

            
            {
                a = c.this;
                super();
            }
    };

    c(GifDrawable gifdrawable)
    {
        super(gifdrawable);
    }

    public final void a()
    {
        long l = a.mNativeInfoHandle.renderFrame(a.mBuffer);
        if (l >= 0L)
        {
            a.mNextFrameRenderTime = SystemClock.uptimeMillis() + l;
            if (a.isVisible() && a.mIsRunning && !a.mIsRenderingTriggeredOnDraw)
            {
                a.mExecutor.schedule(this, l, TimeUnit.MILLISECONDS);
            }
            if (!a.mListeners.isEmpty() && a.getCurrentFrameIndex() == a.mNativeInfoHandle.frameCount - 1)
            {
                a.scheduleSelf(b, a.mNextFrameRenderTime);
            }
        } else
        {
            a.mNextFrameRenderTime = 0x8000000000000000L;
            a.mIsRunning = false;
        }
        if (a.isVisible() && !a.mInvalidationHandler.hasMessages(0))
        {
            a.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
    }
}
