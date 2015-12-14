// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;


// Referenced classes of package org.apache.james.mime4j.util:
//            EmptyByteSequence

public interface ByteSequence
{

    public static final ByteSequence EMPTY = new EmptyByteSequence();

    public abstract int length();

    public abstract byte[] toByteArray();

}
