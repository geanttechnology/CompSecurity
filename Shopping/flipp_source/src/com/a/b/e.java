// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;


final class e
    implements Runnable
{

    final StringBuilder a;

    e(StringBuilder stringbuilder)
    {
        a = stringbuilder;
        super();
    }

    public final void run()
    {
        throw new NullPointerException(a.toString());
    }
}
