// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;


// Referenced classes of package org.apache.james.mime4j.util:
//            ByteSequence

final class EmptyByteSequence
    implements ByteSequence
{

    private static final byte EMPTY_BYTES[] = new byte[0];

    EmptyByteSequence()
    {
    }

    public int length()
    {
        return 0;
    }

    public byte[] toByteArray()
    {
        return EMPTY_BYTES;
    }

}
