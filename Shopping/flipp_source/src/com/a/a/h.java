// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.i;
import java.io.FilterInputStream;
import java.io.InputStream;

final class h extends FilterInputStream
{

    final i a;

    h(InputStream inputstream, i j)
    {
        a = j;
        super(inputstream);
    }

    public final void close()
    {
        a.close();
        super.close();
    }
}
