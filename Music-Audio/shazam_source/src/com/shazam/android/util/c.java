// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util;

import android.os.Looper;

// Referenced classes of package com.shazam.android.util:
//            p

public final class c
    implements p
{

    public c()
    {
    }

    public final boolean a()
    {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
