// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

// Referenced classes of package com.amazon.gallery.framework.network:
//            RetryWatchdog

class this._cls0
    implements Funnel
{

    final RetryWatchdog this$0;

    public void funnel(Object obj, PrimitiveSink primitivesink)
    {
        primitivesink.putString(obj.toString());
    }

    ()
    {
        this$0 = RetryWatchdog.this;
        super();
    }
}
