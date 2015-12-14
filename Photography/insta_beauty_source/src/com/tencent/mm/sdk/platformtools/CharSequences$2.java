// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            CharSequences

final class W
    implements CharSequence
{

    final byte U[];
    final int V;
    final int W;

    public final char charAt(int i)
    {
        return (char)U[V + i];
    }

    public final int length()
    {
        return W - V;
    }

    public final CharSequence subSequence(int i, int j)
    {
        i -= V;
        j -= V;
        CharSequences.a(i, j, length());
        return CharSequences.forAsciiBytes(U, i, j);
    }

    public final String toString()
    {
        return new String(U, V, length());
    }

    (byte abyte0[], int i, int j)
    {
        U = abyte0;
        V = i;
        W = j;
        super();
    }
}
