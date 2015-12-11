// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.io.BufferReferer;
import java.io.IOException;

abstract class Accept
    implements BufferReferer
{

    private final String expected;

    Accept(String s)
    {
        expected = s;
    }

    void acceptArray(int i)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got array value", new Object[] {
            expected
        }));
    }

    void acceptBoolean(boolean flag)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got boolean", new Object[] {
            expected
        }));
    }

    void acceptDouble(double d)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got float value", new Object[] {
            expected
        }));
    }

    void acceptEmptyRaw()
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got raw value", new Object[] {
            expected
        }));
    }

    void acceptFloat(float f)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got float value", new Object[] {
            expected
        }));
    }

    void acceptInteger(byte byte0)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptInteger(int i)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptInteger(long l)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptInteger(short word0)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptMap(int i)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got map value", new Object[] {
            expected
        }));
    }

    void acceptNil()
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got nil value", new Object[] {
            expected
        }));
    }

    void acceptRaw(byte abyte0[])
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got raw value", new Object[] {
            expected
        }));
    }

    void acceptUnsignedInteger(byte byte0)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptUnsignedInteger(int i)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptUnsignedInteger(long l)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }

    void acceptUnsignedInteger(short word0)
        throws IOException
    {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", new Object[] {
            expected
        }));
    }
}
