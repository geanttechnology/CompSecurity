// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.os.Handler;
import com.facebook.ads.a.b.u;
import com.facebook.ads.a.b.v;

// Referenced classes of package com.facebook.ads.a:
//            i, b

final class 
    implements v
{

    final Runnable a;
    final i b;

    public final void a(u u)
    {
        i.g();
        i.e(b).removeCallbacks(a);
        i.a(b, u);
        b.a.a();
    }

    public final void b(u u)
    {
        i.g();
        i.e(b).removeCallbacks(a);
        i.a(u);
        i.d(b);
    }

    (i j, Runnable runnable)
    {
        b = j;
        a = runnable;
        super();
    }
}
