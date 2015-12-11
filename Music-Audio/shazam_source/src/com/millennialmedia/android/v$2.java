// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            v

final class a
    implements Runnable
{

    final v a;

    public final void run()
    {
        Context context1 = (Context)v.a(a).get();
        Context context = context1;
        if (context1 == null)
        {
            context = (Context)v.b(a).get();
        }
        if (context != null)
        {
            v.a(context);
        }
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
