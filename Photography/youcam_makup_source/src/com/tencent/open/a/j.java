// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.util.Log;

// Referenced classes of package com.tencent.open.a:
//            n

public final class j extends n
{

    public static final j a = new j();

    public j()
    {
    }

    protected void a(int i, Thread thread, long l, String s, String s1, Throwable throwable)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            Log.v(s, s1, throwable);
            return;

        case 2: // '\002'
            Log.d(s, s1, throwable);
            return;

        case 4: // '\004'
            Log.i(s, s1, throwable);
            return;

        case 8: // '\b'
            Log.w(s, s1, throwable);
            return;

        case 16: // '\020'
            Log.e(s, s1, throwable);
            return;

        case 32: // ' '
            Log.e(s, s1, throwable);
            break;
        }
    }

}
