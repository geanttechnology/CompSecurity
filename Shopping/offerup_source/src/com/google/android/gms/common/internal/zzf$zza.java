// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.Collections;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public final class zzafk
{

    public final Set zzTm;
    public final boolean zzafk;

    public (Set set, boolean flag)
    {
        zzx.zzw(set);
        zzTm = Collections.unmodifiableSet(set);
        zzafk = flag;
    }
}
