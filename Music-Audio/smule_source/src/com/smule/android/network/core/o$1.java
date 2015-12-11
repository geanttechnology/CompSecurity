// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.util.Log;

// Referenced classes of package com.smule.android.network.core:
//            o

class a
    implements Runnable
{

    final o a;

    public void run()
    {
        Log.i("NetworkResponse", String.format("response (delayed log) (%s) : %s", new Object[] {
            o.a(a), a.a(a.k)
        }));
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
