// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import myobfuscated.aj.j;

// Referenced classes of package com.bumptech.glide.load.engine:
//            ah, ad

final class ag
{

    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new ah((byte)0));

    ag()
    {
    }

    public final void a(ad ad1)
    {
        j.a();
        if (a)
        {
            b.obtainMessage(1, ad1).sendToTarget();
            return;
        } else
        {
            a = true;
            ad1.d();
            a = false;
            return;
        }
    }
}
