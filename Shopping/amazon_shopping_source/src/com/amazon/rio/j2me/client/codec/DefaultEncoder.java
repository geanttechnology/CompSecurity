// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder

public class DefaultEncoder
{

    private static final Encoder booleanEncoder = new Encoder() {

        public void encode(Boolean boolean1, DataOutputStream dataoutputstream)
            throws IOException
        {
            dataoutputstream.writeBoolean(boolean1.booleanValue());
        }

        public volatile void encode(Object obj, DataOutputStream dataoutputstream)
            throws IOException
        {
            encode((Boolean)obj, dataoutputstream);
        }

    };
    private static final Encoder octetArrayEncoder = new Encoder() {

        public volatile void encode(Object obj, DataOutputStream dataoutputstream)
            throws IOException
        {
            encode((byte[])obj, dataoutputstream);
        }

        public void encode(byte abyte0[], DataOutputStream dataoutputstream)
            throws IOException
        {
            dataoutputstream.writeInt(abyte0.length);
            dataoutputstream.write(abyte0);
        }

    };
    private static final Encoder octetEncoder = new Encoder() {

        public void encode(Byte byte1, DataOutputStream dataoutputstream)
            throws IOException
        {
            dataoutputstream.writeByte(byte1.byteValue());
        }

        public volatile void encode(Object obj, DataOutputStream dataoutputstream)
            throws IOException
        {
            encode((Byte)obj, dataoutputstream);
        }

    };
    private static final Encoder stringEncoder = new Encoder() {

        public volatile void encode(Object obj, DataOutputStream dataoutputstream)
            throws IOException
        {
            encode((String)obj, dataoutputstream);
        }

        public void encode(String s, DataOutputStream dataoutputstream)
            throws IOException
        {
            dataoutputstream.writeUTF(s);
        }

    };

    public DefaultEncoder()
    {
    }

    private static void encodeIntegerInRange(long l, long l1, long l2, DataOutputStream dataoutputstream)
        throws IOException
    {
        int i = numBytesPerValueInRange(l1, l2);
        int j = (int)(l - l1);
        if (i == 1)
        {
            dataoutputstream.writeByte(j);
            return;
        }
        if (i == 2)
        {
            dataoutputstream.writeShort(j);
            return;
        }
        if (i == 4)
        {
            dataoutputstream.writeInt(j);
            return;
        } else
        {
            dataoutputstream.writeLong(l);
            return;
        }
    }

    public static Encoder getArrayInstance(Encoder encoder)
    {
        return new Encoder(encoder) {

            final Encoder val$elementEncoder;

            public volatile void encode(Object obj, DataOutputStream dataoutputstream)
                throws IOException
            {
                encode((List)obj, dataoutputstream);
            }

            public void encode(List list, DataOutputStream dataoutputstream)
                throws IOException
            {
                int j = list.size();
                dataoutputstream.writeInt(j);
                for (int i = 0; i < j; i++)
                {
                    elementEncoder.encode(list.get(i), dataoutputstream);
                }

            }

            
            {
                elementEncoder = encoder;
                super();
            }
        };
    }

    public static Encoder getBooleanInstance()
    {
        return booleanEncoder;
    }

    public static Encoder getEnumInstance(int i)
    {
        return getIntegerInstance(0L, i - 1);
    }

    public static Encoder getIntegerInstance(long l, long l1)
    {
        return new Encoder(l, l1) {

            final long val$lowerBound;
            final long val$upperBound;

            public void encode(Integer integer, DataOutputStream dataoutputstream)
                throws IOException
            {
                DefaultEncoder.encodeIntegerInRange(integer.intValue(), lowerBound, upperBound, dataoutputstream);
            }

            public volatile void encode(Object obj, DataOutputStream dataoutputstream)
                throws IOException
            {
                encode((Integer)obj, dataoutputstream);
            }

            
            {
                lowerBound = l;
                upperBound = l1;
                super();
            }
        };
    }

    public static Encoder getOctetArrayInstance()
    {
        return octetArrayEncoder;
    }

    public static Encoder getStringInstance()
    {
        return stringEncoder;
    }

    public static int numBytesPerValueInRange(long l, long l1)
    {
        l = (l1 - l) + 1L;
        if (l > 0L)
        {
            if (l <= 256L)
            {
                return 1;
            }
            if (l <= 0x10000L)
            {
                return 2;
            }
            if (l <= 0x100000000L)
            {
                return 4;
            }
        }
        return 8;
    }


}
