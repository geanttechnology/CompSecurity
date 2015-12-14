// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.b;


class c
{

    private Thread a;
    private boolean b;

    private void a()
    {
        b = true;
        a.interrupt();
    }

    static void a(c c1)
    {
        c1.a();
    }
}
