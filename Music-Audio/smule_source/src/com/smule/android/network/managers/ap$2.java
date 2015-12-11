// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.os.SystemClock;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.network.managers:
//            ap

class a
    implements Observer
{

    final ap a;

    public void update(Observable observable, Object obj)
    {
        ap.a(a, SystemClock.elapsedRealtime());
    }

    (ap ap1)
    {
        a = ap1;
        super();
    }
}
