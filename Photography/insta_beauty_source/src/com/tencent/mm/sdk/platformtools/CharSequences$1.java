// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            CharSequences

final class U
    implements CharSequence
{

    final byte U[];

    public final char charAt(int i)
    {
        return (char)U[i];
    }

    public final int length()
    {
        return U.length;
    }

    public final CharSequence subSequence(int i, int j)
    {
        return CharSequences.forAsciiBytes(U, i, j);
    }

    public final String toString()
    {
        return new String(U);
    }

    (byte abyte0[])
    {
        U = abyte0;
        super();
    }
}
