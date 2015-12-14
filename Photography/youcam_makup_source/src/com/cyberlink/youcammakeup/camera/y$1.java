// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            y, aa

class a
    implements android.hardware.ra.PreviewCallback
{

    final y a;

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        y.a(a).set(false);
        y.c(a).a(abyte0, y.b(a).width, y.b(a).height);
    }

    ean(y y1)
    {
        a = y1;
        super();
    }
}
