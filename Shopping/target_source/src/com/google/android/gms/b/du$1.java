// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.signin.internal.h;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.b:
//            du, dx

static final class internal.h
    implements com.google.android.gms.common.api.h
{

    public int a()
    {
        return 0x7fffffff;
    }

    public volatile com.google.android.gms.common.api.h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.h h2, com.google.android.gms.common.api.h h3)
    {
        return a(context, looper, h1, (dx)obj, h2, h3);
    }

    public h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, dx dx1, com.google.android.gms.common.api.h h2, com.google.android.gms.common.api.h h3)
    {
        if (dx1 == null)
        {
            dx1 = dx.a;
        }
        return new h(context, looper, true, h1, dx1, h2, h3, Executors.newSingleThreadExecutor());
    }

    internal.h()
    {
    }
}
