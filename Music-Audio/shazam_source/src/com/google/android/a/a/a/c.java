// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.app.Activity;
import android.content.Context;

// Referenced classes of package com.google.android.a.a.a:
//            a, q, z, d, 
//            b, w, v, x, 
//            f

public final class c extends a
{

    public c()
    {
    }

    public final d a(Context context, String s, u.a a1, u.b b1)
    {
        return new q(context, s, context.getPackageName(), z.d(context), a1, b1);
    }

    public final f a(Activity activity, d d1, boolean flag)
    {
        d1 = d1.a();
        b.a(activity);
        b.a(d1);
        Context context = z.b(activity);
        if (context == null)
        {
            throw new x.a("Could not create remote context");
        } else
        {
            return f.a.a(x.a(context.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", w.a(context).asBinder(), w.a(activity).asBinder(), d1, flag));
        }
    }
}
