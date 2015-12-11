// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.Handler;
import android.os.Looper;
import com.a.a.n;
import java.util.HashMap;

public final class h
{
    public static interface a
    {
    }


    private final n a;
    private int b;
    private final a c;
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();
    private final Handler f = new Handler(Looper.getMainLooper());

    public h(n n, a a1)
    {
        b = 100;
        a = n;
        c = a1;
    }
}
