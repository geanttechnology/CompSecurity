// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.b.ds;
import com.google.android.gms.common.internal.h;

// Referenced classes of package com.google.android.gms.search:
//            a

static final class b.b
    implements com.google.android.gms.common.api..h
{

    public int a()
    {
        return 0x7fffffff;
    }

    public ds a(Context context, Looper looper, h h, com.google.android.gms.common.api.b b, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.b b2)
    {
        return new ds(context, b1, b2, h);
    }

    public com.google.android.gms.common.api..h a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api..h h1, com.google.android.gms.common.api..h h2)
    {
        return a(context, looper, h, (com.google.android.gms.common.api.b)obj, h1, h2);
    }

    b.b()
    {
    }
}
