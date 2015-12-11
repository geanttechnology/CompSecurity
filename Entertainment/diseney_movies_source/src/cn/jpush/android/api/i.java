// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;

// Referenced classes of package cn.jpush.android.api:
//            e

final class i
    implements Runnable
{

    final Context a;
    final e b;

    i(e e1, Context context)
    {
        b = e1;
        a = context;
        super();
    }

    public final void run()
    {
        e.b(b, a);
    }
}
