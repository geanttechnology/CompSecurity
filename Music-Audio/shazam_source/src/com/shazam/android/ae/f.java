// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import android.util.Log;

// Referenced classes of package com.shazam.android.ae:
//            l, q

final class f
    implements l
{

    f()
    {
    }

    public final void a(String s, String s1)
    {
        Log.e(s, s1);
    }

    public final void a(String s, String s1, Throwable throwable)
    {
        Log.e(s, q.a(s1, throwable), throwable);
    }
}
