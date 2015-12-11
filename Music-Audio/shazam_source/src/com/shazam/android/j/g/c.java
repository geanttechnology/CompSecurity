// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.g;

import android.os.Build;

// Referenced classes of package com.shazam.android.j.g:
//            b

public final class c
    implements b
{

    public c()
    {
    }

    public final int a()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public final String b()
    {
        return Build.CPU_ABI;
    }

    public final String[] c()
    {
        return Build.SUPPORTED_ABIS;
    }
}
