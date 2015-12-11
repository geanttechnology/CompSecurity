// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;

class BasicIdGenerator
{

    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public void generate(StringBuilder stringbuilder)
    {
        this;
        JVM INSTR monitorenter ;
        count = count + 1L;
        int i = rnd.nextInt();
        stringbuilder.append(System.currentTimeMillis());
        stringbuilder.append('.');
        (new Formatter(stringbuilder, Locale.US)).format("%1$016x-%2$08x", new Object[] {
            Long.valueOf(count), Integer.valueOf(i)
        });
        stringbuilder.append('.');
        stringbuilder.append(hostname);
        this;
        JVM INSTR monitorexit ;
        return;
        stringbuilder;
        throw stringbuilder;
    }
}
