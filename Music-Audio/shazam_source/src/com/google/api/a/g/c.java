// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.io.OutputStream;

final class c extends OutputStream
{

    long a;

    c()
    {
    }

    public final void write(int i)
    {
        a = a + 1L;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        a = a + (long)j;
    }
}
