// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.os.Looper;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            d

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        Looper.myLooper().quit();
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
