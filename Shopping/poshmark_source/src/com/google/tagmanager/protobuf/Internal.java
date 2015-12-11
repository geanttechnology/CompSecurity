// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            ByteString, LiteralByteString, AbstractMutableMessageLite, Utf8, 
//            MutableMessageLite, InvalidProtocolBufferException, MessageLite, CodedInputStream, 
//            ExtensionRegistryLite

public class Internal
{
    public static interface EnumLite
    {

        public abstract int getNumber();
    }

    public static interface EnumLiteMap
    {

        public abstract EnumLite findValueByNumber(int i);
    }


    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte EMPTY_BYTE_ARRAY[];
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    public Internal()
    {
    }

    public static byte[] byteArrayDefaultValue(String s)
    {
        try
        {
            s = s.getBytes("ISO-8859-1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException("Java VM does not support a standard character set.", s);
        }
        return s;
    }

    public static ByteBuffer byteBufferDefaultValue(String s)
    {
        return ByteBuffer.wrap(byteArrayDefaultValue(s));
    }

    public static ByteString bytesDefaultValue(String s)
    {
        try
        {
            s = ByteString.copyFrom(s.getBytes("ISO-8859-1"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException("Java VM does not support a standard character set.", s);
        }
        return s;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer bytebuffer)
    {
        bytebuffer = bytebuffer.duplicate();
        bytebuffer.clear();
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(bytebuffer.capacity());
        bytebuffer1.put(bytebuffer);
        bytebuffer1.clear();
        return bytebuffer1;
    }

    public static boolean equals(List list, List list1)
    {
        if (list.size() != list1.size())
        {
            return false;
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (!Arrays.equals((byte[])list.get(i), (byte[])list1.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer bytebuffer, ByteBuffer bytebuffer1)
    {
        if (bytebuffer.capacity() != bytebuffer1.capacity())
        {
            return false;
        } else
        {
            return bytebuffer.duplicate().clear().equals(bytebuffer1.duplicate().clear());
        }
    }

    public static boolean equalsByteBuffer(List list, List list1)
    {
        if (list.size() != list1.size())
        {
            return false;
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (!equalsByteBuffer((ByteBuffer)list.get(i), (ByteBuffer)list1.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static int hashBoolean(boolean flag)
    {
        return !flag ? 1237 : 1231;
    }

    public static int hashCode(List list)
    {
        int i = 1;
        for (list = list.iterator(); list.hasNext();)
        {
            i = i * 31 + hashCode((byte[])list.next());
        }

        return i;
    }

    public static int hashCode(byte abyte0[])
    {
        return LiteralByteString.hashCode(abyte0);
    }

    public static int hashCodeByteBuffer(ByteBuffer bytebuffer)
    {
        int i = 4096;
        boolean flag = true;
        if (bytebuffer.hasArray())
        {
            int j = LiteralByteString.hashCode(bytebuffer.capacity(), bytebuffer.array(), bytebuffer.arrayOffset(), bytebuffer.capacity());
            i = j;
            if (j == 0)
            {
                i = 1;
            }
            return i;
        }
        byte abyte0[];
        ByteBuffer bytebuffer1;
        int k;
        if (bytebuffer.capacity() <= 4096)
        {
            i = bytebuffer.capacity();
        }
        abyte0 = new byte[i];
        bytebuffer1 = bytebuffer.duplicate();
        bytebuffer1.clear();
        k = bytebuffer.capacity();
        while (bytebuffer1.remaining() > 0) 
        {
            int l;
            if (bytebuffer1.remaining() <= i)
            {
                l = bytebuffer1.remaining();
            } else
            {
                l = i;
            }
            bytebuffer1.get(abyte0, 0, l);
            k = LiteralByteString.hashCode(k, abyte0, 0, l);
        }
        if (k == 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = k;
        }
        return i;
    }

    public static int hashCodeByteBuffer(List list)
    {
        int i = 1;
        for (list = list.iterator(); list.hasNext();)
        {
            i = i * 31 + hashCodeByteBuffer((ByteBuffer)list.next());
        }

        return i;
    }

    public static int hashEnum(EnumLite enumlite)
    {
        return enumlite.getNumber();
    }

    public static int hashEnumList(List list)
    {
        int i = 1;
        for (list = list.iterator(); list.hasNext();)
        {
            i = i * 31 + hashEnum((EnumLite)list.next());
        }

        return i;
    }

    public static int hashLong(long l)
    {
        return (int)(l >>> 32 ^ l);
    }

    static boolean isProto1Group(MessageLite messagelite)
    {
        return (messagelite instanceof AbstractMutableMessageLite) && ((AbstractMutableMessageLite)messagelite).isProto1Group();
    }

    public static boolean isValidUtf8(ByteString bytestring)
    {
        return bytestring.isValidUtf8();
    }

    public static boolean isValidUtf8(byte abyte0[])
    {
        return Utf8.isValidUtf8(abyte0);
    }

    public static MutableMessageLite mergeFrom(MutableMessageLite mutablemessagelite, CodedInputStream codedinputstream)
        throws IOException
    {
        if (!mutablemessagelite.mergeFrom(codedinputstream))
        {
            throw InvalidProtocolBufferException.parseFailure();
        } else
        {
            return mutablemessagelite;
        }
    }

    public static MutableMessageLite mergeFrom(MutableMessageLite mutablemessagelite, CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        if (!mutablemessagelite.mergeFrom(codedinputstream, extensionregistrylite))
        {
            throw InvalidProtocolBufferException.parseFailure();
        } else
        {
            return mutablemessagelite;
        }
    }

    public static MutableMessageLite mergeFrom(MutableMessageLite mutablemessagelite, byte abyte0[])
        throws IOException
    {
        if (!mutablemessagelite.mergeFrom(abyte0))
        {
            throw InvalidProtocolBufferException.parseFailure();
        } else
        {
            return mutablemessagelite;
        }
    }

    public static String stringDefaultValue(String s)
    {
        try
        {
            s = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException("Java VM does not support a standard character set.", s);
        }
        return s;
    }

    public static byte[] toByteArray(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported?", s);
        }
        return s;
    }

    public static String toStringUtf8(byte abyte0[])
    {
        try
        {
            abyte0 = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("UTF-8 not supported?", abyte0);
        }
        return abyte0;
    }

    static 
    {
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
    }
}
