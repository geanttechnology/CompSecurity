// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.widget.VideoView;
import java.util.TimerTask;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TJAdUnitJSBridge

final class nit> extends TimerTask
{

    final TJAdUnit a;

    public final void run()
    {
        TJAdUnit.i(a).onVideoProgress(TJAdUnit.f(a).getCurrentPosition());
    }

    ridge(TJAdUnit tjadunit)
    {
        a = tjadunit;
        super();
    }
}
