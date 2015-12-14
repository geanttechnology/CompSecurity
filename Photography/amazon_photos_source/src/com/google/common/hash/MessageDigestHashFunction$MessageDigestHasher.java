// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

// Referenced classes of package com.google.common.hash:
//            Hasher, MessageDigestHashFunction, HashCodes, Funnel, 
//            HashCode, PrimitiveSink

private static class <init>
    implements Hasher
{

    private final MessageDigest digest;
    private boolean done;
    private final ByteBuffer scratch;

    private void checkNotDone()
    {
        boolean flag;
        if (!done)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Cannot use Hasher after calling #hash() on it");
    }

    public HashCode hash()
    {
        done = true;
        return HashCodes.fromBytesNoCopy(digest.digest());
    }

    public Hasher putChar(char c)
    {
        checkNotDone();
        scratch.putChar(c);
        digest.update(scratch.array(), 0, 2);
        scratch.clear();
        return this;
    }

    public Hasher putObject(Object obj, Funnel funnel)
    {
        checkNotDone();
        funnel.funnel(obj, this);
        return this;
    }

    public Hasher putString(CharSequence charsequence)
    {
        for (int i = 0; i < charsequence.length(); i++)
        {
            putChar(charsequence.charAt(i));
        }

        return this;
    }

    public volatile PrimitiveSink putString(CharSequence charsequence)
    {
        return putString(charsequence);
    }

    private (MessageDigest messagedigest)
    {
        digest = messagedigest;
        scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    scratch(MessageDigest messagedigest, scratch scratch1)
    {
        this(messagedigest);
    }
}
