// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;


// Referenced classes of package com.google.common.hash:
//            Hasher, PrimitiveSink

abstract class AbstractHasher
    implements Hasher
{

    AbstractHasher()
    {
    }

    public Hasher putString(CharSequence charsequence)
    {
        int i = 0;
        for (int j = charsequence.length(); i < j; i++)
        {
            putChar(charsequence.charAt(i));
        }

        return this;
    }

    public volatile PrimitiveSink putString(CharSequence charsequence)
    {
        return putString(charsequence);
    }
}
