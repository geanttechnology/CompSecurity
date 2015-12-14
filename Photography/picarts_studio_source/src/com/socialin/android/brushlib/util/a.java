// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import android.util.Log;

public final class a
{

    private static final String b = com/socialin/android/brushlib/util/a.getSimpleName();
    public boolean a;
    private final String c;
    private boolean d;
    private boolean e;
    private int f;

    public a()
    {
        this(b);
    }

    public a(String s)
    {
        a = true;
        d = true;
        e = true;
        f = 3;
        c = s;
    }

    public final void a(String s)
    {
        StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
        int i = f;
        String s1 = c;
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = new StringBuilder("At ");
        if (a)
        {
            stringbuilder1.append(stacktraceelement.getClassName());
        }
        if (d)
        {
            stringbuilder1.append((new StringBuilder(".")).append(stacktraceelement.getMethodName()).toString());
        }
        if (e)
        {
            stringbuilder1.append((new StringBuilder(":")).append(stacktraceelement.getLineNumber()).toString());
        }
        stringbuilder1.append(" > ");
        Log.println(i, s1, stringbuilder.append(stringbuilder1.toString()).append(s).toString());
    }

}
