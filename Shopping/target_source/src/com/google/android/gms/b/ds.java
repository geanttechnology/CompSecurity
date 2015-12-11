// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

// Referenced classes of package com.google.android.gms.b:
//            dr

public class ds extends l
{

    public ds(Context context, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1, h h)
    {
        super(context, context.getMainLooper(), 73, b1, d1, h);
    }

    protected IInterface a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected dr b(IBinder ibinder)
    {
        return dr.a.a(ibinder);
    }

    protected String d()
    {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String e()
    {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
