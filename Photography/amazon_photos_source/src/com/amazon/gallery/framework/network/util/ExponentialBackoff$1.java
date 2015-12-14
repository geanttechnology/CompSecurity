// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.util;

import android.os.SystemClock;
import java.util.Random;

// Referenced classes of package com.amazon.gallery.framework.network.util:
//            ExponentialBackoff

class this._cls0 extends ThreadLocal
{

    final ExponentialBackoff this$0;

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Random initialValue()
    {
        return new Random(Thread.currentThread().getId() * SystemClock.uptimeMillis());
    }

    ()
    {
        this$0 = ExponentialBackoff.this;
        super();
    }
}
