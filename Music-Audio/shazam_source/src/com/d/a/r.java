// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package com.d.a:
//            aj, ae, ah

final class r
    implements Runnable
{

    final String a;
    final Context b;
    final ah c;
    final aj d;

    r(aj aj1, String s, Context context, ah ah)
    {
        d = aj1;
        a = s;
        b = context;
        c = ah;
        super();
    }

    public final void run()
    {
        String s = aj.a(d, a);
        (new Handler()).post(new ae(this, s));
    }
}
