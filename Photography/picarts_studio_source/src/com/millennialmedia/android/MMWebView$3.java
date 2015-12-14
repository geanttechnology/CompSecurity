// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Bitmap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMAdImpl, MMLog

class a
    implements Callable
{

    private MMAdImpl a;
    private MMWebView b;

    public volatile Object call()
    {
        return call();
    }

    public Void call()
    {
        Bitmap bitmap;
        b.buildDrawingCache();
        bitmap = b.getDrawingCache();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        bitmap = Bitmap.createBitmap(bitmap);
        a.a(bitmap);
        b.destroyDrawingCache();
_L2:
        return null;
        Exception exception;
        exception;
        MMLog.a("MMWebView", "Animation exception: ", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    (MMWebView mmwebview, MMAdImpl mmadimpl)
    {
        b = mmwebview;
        a = mmadimpl;
        super();
    }
}
