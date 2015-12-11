// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.math.BigInteger;

// Referenced classes of package org.msgpack:
//            MessagePackable, MessageTypeException

public abstract class MessagePackObject
    implements Cloneable, MessagePackable
{

    public MessagePackObject()
    {
    }

    public BigInteger bigIntegerValue()
    {
        throw new MessageTypeException("type error");
    }

    public abstract Object clone();

    public long longValue()
    {
        throw new MessageTypeException("type error");
    }
}
