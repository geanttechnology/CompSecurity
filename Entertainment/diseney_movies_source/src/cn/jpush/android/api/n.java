// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import cn.jpush.android.data.d;

// Referenced classes of package cn.jpush.android.api:
//            m

final class n
    implements Runnable
{

    final Context a;
    final d b;

    n(Context context, d d)
    {
        a = context;
        b = d;
        super();
    }

    public final void run()
    {
        m.b(a, b);
    }
}
