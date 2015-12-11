// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            y, al, ak

private static final class t>
    implements Runnable
{

    WeakReference a;
    Double b;
    boolean c;

    public final void run()
    {
        Object obj;
        y y1;
        if (!c)
        {
            (new StringBuilder("Reporting disabled, shutting down seek reporting runnable <")).append(this).append(">");
            al.b();
            return;
        }
        y1 = (y)a.get();
        if (y1 == null)
        {
            al.a("InlineVideoView", (new StringBuilder("Video view instance is null, shutting down seek reporting runnable <")).append(this).append(">").toString());
            return;
        }
        obj = null;
        if (!y1.isPlaying()) goto _L2; else goto _L1
_L1:
        double d = Math.floor((float)y1.getCurrentPosition() / 1000F);
        obj = Double.valueOf(d);
_L4:
        if (obj == null)
        {
            (new StringBuilder("No valid seek time found, shutting down seek reporting runnable <")).append(this).append(">");
            al.b();
            return;
        }
        break MISSING_BLOCK_LABEL_188;
_L2:
        if (!y1.e) goto _L4; else goto _L3
_L3:
        d = Math.ceil((float)y1.g / 1000F);
        obj = Double.valueOf(d);
          goto _L4
        obj;
        al.a("InlineVideoView", (new StringBuilder("Illegal exception encountered when trying to get play state, shutting down seek reporting runnable <")).append(this).append(">").toString());
        return;
        if (!y1.i)
        {
            if (y.c(y1) && y.d(y1))
            {
                y.e(y1);
            } else
            if (!y.c(y1))
            {
                y.e(y1);
            }
        }
        if (b == null || Double.compare(((Double) (obj)).doubleValue(), b.doubleValue()) != 0)
        {
            ak ak1 = (ak)y.f(y1).get();
            if (ak1 == null)
            {
                al.a("InlineVideoView", (new StringBuilder("Unable to send video seek time, no valid layout.  Shutting down seek reporting runnable <")).append(this).append(">").toString());
                return;
            }
            ak1.a((new StringBuilder("javascript:MMJS.inlineVideo.updateVideoSeekTime(")).append(obj).append(");").toString());
            b = ((Double) (obj));
        }
        y.g(y1).postDelayed(this, 1000L);
        return;
    }

    (y y1)
    {
        b = null;
        c = true;
        if (y1 == null)
        {
            al.a("InlineVideoView", "Created seek reporting runnable with a null video view instance");
        }
        a = new WeakReference(y1);
    }
}
