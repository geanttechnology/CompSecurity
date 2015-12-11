// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Log;

// Referenced classes of package android.support.v7:
//            aho

class ahk
{

    private static final ahk b = new ahk();
    public volatile boolean a;

    private ahk()
    {
        a = false;
    }

    public static ahk a()
    {
        return b;
    }

    public void a(String s, Throwable throwable)
    {
        if (a)
        {
            Log.e(android/support/v7/aho.getSimpleName(), s, throwable);
        }
    }

    public void b(String s, Throwable throwable)
    {
        if (a)
        {
            Log.w(android/support/v7/aho.getSimpleName(), s, throwable);
        }
    }

}
