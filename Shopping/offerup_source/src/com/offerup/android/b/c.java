// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.b;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.b:
//            d

public final class c extends Bus
{

    private Handler a;

    public c()
    {
        a = new Handler(Looper.getMainLooper());
    }

    public final void post(Object obj)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            super.post(obj);
            return;
        } else
        {
            a.post(new d(this, obj));
            return;
        }
    }
}
