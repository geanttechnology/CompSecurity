// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public class hh
{

    private static int Bj = 10000;
    private static int Bk = 1000;
    private final int Be;
    private final String Bl;
    private final BlockingQueue Bm;

    public void a(hd.a.a a1)
    {
        a1.as(Bl);
        a1.bd(Be);
        Bm.offer(a1.ek());
    }

}
