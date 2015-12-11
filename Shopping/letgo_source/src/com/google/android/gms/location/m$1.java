// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.location.internal.j;

// Referenced classes of package com.google.android.gms.location:
//            m

static final class rnal.j extends com.google.android.gms.common.api.al.j
{

    public com.google.android.gms.common.api..h a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api..h h1, com.google.android.gms.common.api..h h2)
    {
        return a(context, looper, h, (com.google.android.gms.common.api.b)obj, h1, h2);
    }

    public j a(Context context, Looper looper, h h, com.google.android.gms.common.api.b b, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.b b2)
    {
        return new j(context, looper, b1, b2, "locationServices", h);
    }

    rnal.j()
    {
    }
}
