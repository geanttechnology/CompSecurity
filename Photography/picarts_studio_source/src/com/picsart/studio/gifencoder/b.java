// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.picsart.studio.gifencoder:
//            GifDrawable

final class b extends Handler
{

    private final WeakReference a;

    public b(GifDrawable gifdrawable)
    {
        super(Looper.getMainLooper());
        a = new WeakReference(gifdrawable);
    }

    public final void handleMessage(Message message)
    {
        message = (GifDrawable)a.get();
        if (message != null)
        {
            message.invalidateSelf();
        }
    }
}
