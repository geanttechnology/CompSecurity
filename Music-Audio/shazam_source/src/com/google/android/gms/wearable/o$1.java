// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.wearable.internal.ao;

// Referenced classes of package com.google.android.gms.wearable:
//            o

static final class b extends com.google.android.gms.common.api..h
{

    public final com.google.android.gms.common.api..h a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api..h h1, com.google.android.gms.common.api..h h2)
    {
        if ((al.h)obj == null)
        {
            new a();
            new <init>((byte)0);
        }
        return new ao(context, looper, h1, h2, h);
    }

    b()
    {
    }
}
