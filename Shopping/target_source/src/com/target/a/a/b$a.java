// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.a.a;

import android.util.Log;

// Referenced classes of package com.target.a.a:
//            b

public static class 
    implements 
{

    public void a(int i, String s, String s1)
    {
        switch (i)
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown log level '").append(i).append("'!").toString());

        case 100: // 'd'
            Log.e(s, s1);
            return;

        case 80: // 'P'
            Log.w(s, s1);
            return;

        case 60: // '<'
            Log.i(s, s1);
            return;

        case 40: // '('
            Log.d(s, s1);
            return;

        case 20: // '\024'
            Log.v(s, s1);
            return;
        }
    }

    public void a(int i, String s, String s1, Throwable throwable)
    {
        a(i, s, b.a(s1, throwable));
    }

    public ()
    {
    }
}
