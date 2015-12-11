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

    public com.google.android.gms.common.api.h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, Object obj, com.google.android.gms.common.api.h h2, com.google.android.gms.common.api.h h3)
    {
        return a(context, looper, h1, (com.google.android.gms.common.api.)obj, h2, h3);
    }

    public h a(Context context, Looper looper, com.google.android.gms.common.internal.h h1, com.google.android.gms.common.api. , com.google.android.gms.common.api. 1, com.google.android.gms.common.api. 2)
    {
        return new h(context, looper, false, h1, dx.a, 1, 2, Executors.newSingleThreadExecutor());
    }

    internal.h()
    {
    }
}
