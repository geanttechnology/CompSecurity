// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Bitmap;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMAdImpl

class val.adImpl
    implements Runnable
{

    final MMWebView this$0;
    final MMAdImpl val$adImpl;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap;
        buildDrawingCache();
        bitmap = getDrawingCache();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        bitmap = Bitmap.createBitmap(bitmap);
        val$adImpl.prepareTransition(bitmap);
        destroyDrawingCache();
        notify();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        stroyDrawingCache(((Throwable) (obj)));
        notify();
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    ()
    {
        this$0 = final_mmwebview;
        val$adImpl = MMAdImpl.this;
        super();
    }
}
