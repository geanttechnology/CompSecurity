// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;

// Referenced classes of package com.google.android.gms.wearable:
//            PutDataRequest, e

public interface c
{
    public static interface a
        extends g
    {
    }

    public static interface b
    {

        public abstract void a(com.google.android.gms.wearable.e e);
    }


    public abstract e a(com.google.android.gms.common.api.c c1, PutDataRequest putdatarequest);

    public abstract e a(com.google.android.gms.common.api.c c1, b b1);
}
