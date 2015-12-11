// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Trace;

class ap
{

    public static void a()
    {
        Trace.endSection();
    }

    public static void a(String s)
    {
        Trace.beginSection(s);
    }
}
