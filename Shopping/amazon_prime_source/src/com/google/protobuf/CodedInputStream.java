// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            InvalidProtocolBufferException, ByteString, WireFormat, Parser, 
//            MessageLite, ExtensionRegistryLite

public final class CodedInputStream
{

    private final byte buffer[];
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private int totalBytesRetired;

    private CodedInputStream(InputStream inputstream)
    {
        currentLimit = 0x7fffffff;
        recursionLimit = 64;
        sizeLimit = 0x4000000;
        buffer = new byte[4096];
        bufferSize = 0;
        bufferPos = 0;
        totalBytesRetired = 0;
        input = inputstream;
    }

    private CodedInputStream(byte abyte0[], int i, int j)
    {
        currentLimit = 0x7fffffff;
        recursionLimit = 64;
        sizeLimit = 0x4000000;
        buffer = abyte0;
        bufferSize = i + j;
        bufferPos = i;
        totalBytesRetired = -i;
        input = null;
    }

    public static int decodeZigZag32(int i)
    {
        return i >>> 1 ^ -(i & 1);
    }

    public static long decodeZigZag64(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public static CodedInputStream newInstance(InputStream inputstream)
    {
        return new CodedInputStream(inputstream);
    }

    public static CodedInputStream newInstance(byte abyte0[], int i, int j)
    {
        abyte0 = new CodedInputStream(abyte0, i, j);
        try
        {
            abyte0.pushLimit(j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException(abyte0);
        }
        return abyte0;
    }

    public static int readRawVarint32(int i, InputStream inputstream)
        throws IOException
    {
        if ((i & 0x80) != 0) goto _L2; else goto _L1
_L1:
        int k = i;
_L4:
        return k;
_L2:
        int j;
        j = i & 0x7f;
        i = 7;
        do
        {
            k = i;
            if (i >= 32)
            {
                break; /* Loop/switch isn't completed */
            }
            int l = inputstream.read();
            if (l == -1)
            {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            j |= (l & 0x7f) << i;
            k = j;
            if ((l & 0x80) == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i += 7;
        } while (true);
        if (true) goto _L4; else goto _L3
_L6:
        k += 7;
_L3:
        if (k < 64)
        {
            i = inputstream.read();
            if (i == -1)
            {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i & 0x80) == 0)
            {
                return j;
            }
        } else
        {
            throw InvalidProtocolBufferException.malformedVarint();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void recomputeBufferSizeAfterLimit()
    {
        bufferSize = bufferSize + bufferSizeAfterLimit;
        int i = totalBytesRetired + bufferSize;
        if (i > currentLimit)
        {
            bufferSizeAfterLimit = i - currentLimit;
            bufferSize = bufferSize - bufferSizeAfterLimit;
            return;
        } else
        {
            bufferSizeAfterLimit = 0;
            return;
        }
    }

    private boolean refillBuffer(boolean flag)
        throws IOException
    {
        if (bufferPos < bufferSize)
        {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (totalBytesRetired + bufferSize == currentLimit)
        {
            if (flag)
            {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else
            {
                return false;
            }
        }
        totalBytesRetired = totalBytesRetired + bufferSize;
        bufferPos = 0;
        int i;
        if (input == null)
        {
            i = -1;
        } else
        {
            i = input.read(buffer);
        }
        bufferSize = i;
        if (bufferSize == 0 || bufferSize < -1)
        {
            throw new IllegalStateException((new StringBuilder()).append("InputStream#read(byte[]) returned invalid result: ").append(bufferSize).append("\nThe InputStream implementation is buggy.").toString());
        }
        if (bufferSize == -1)
        {
            bufferSize = 0;
            if (flag)
            {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else
            {
                return false;
            }
        }
        recomputeBufferSizeAfterLimit();
        i = totalBytesRetired + bufferSize + bufferSizeAfterLimit;
        if (i > sizeLimit || i < 0)
        {
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        } else
        {
            return true;
        }
    }

    public void checkLastTagWas(int i)
        throws InvalidProtocolBufferException
    {
        if (lastTag != i)
        {
            throw InvalidProtocolBufferException.invalidEndTag();
        } else
        {
            return;
        }
    }

    public int getBytesUntilLimit()
    {
        if (currentLimit == 0x7fffffff)
        {
            return -1;
        } else
        {
            int i = totalBytesRetired;
            int j = bufferPos;
            return currentLimit - (i + j);
        }
    }

    public boolean isAtEnd()
        throws IOException
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (bufferPos == bufferSize)
        {
            flag = flag1;
            if (!refillBuffer(false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public void popLimit(int i)
    {
        currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i)
        throws InvalidProtocolBufferException
    {
        if (i < 0)
        {
            throw InvalidProtocolBufferException.negativeSize();
        }
        i = totalBytesRetired + bufferPos + i;
        int j = currentLimit;
        if (i > j)
        {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else
        {
            currentLimit = i;
            recomputeBufferSizeAfterLimit();
            return j;
        }
    }

    public boolean readBool()
        throws IOException
    {
        return readRawVarint32() != 0;
    }

    public ByteString readBytes()
        throws IOException
    {
        int i = readRawVarint32();
        if (i == 0)
        {
            return ByteString.EMPTY;
        }
        if (i <= bufferSize - bufferPos && i > 0)
        {
            ByteString bytestring = ByteString.copyFrom(buffer, bufferPos, i);
            bufferPos = i + bufferPos;
            return bytestring;
        } else
        {
            return ByteString.copyFrom(readRawBytes(i));
        }
    }

    public double readDouble()
        throws IOException
    {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum()
        throws IOException
    {
        return readRawVarint32();
    }

    public int readFixed32()
        throws IOException
    {
        return readRawLittleEndian32();
    }

    public long readFixed64()
        throws IOException
    {
        return readRawLittleEndian64();
    }

    public float readFloat()
        throws IOException
    {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        if (recursionDepth >= recursionLimit)
        {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else
        {
            recursionDepth = recursionDepth + 1;
            builder.mergeFrom(this, extensionregistrylite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            recursionDepth = recursionDepth - 1;
            return;
        }
    }

    public int readInt32()
        throws IOException
    {
        return readRawVarint32();
    }

    public long readInt64()
        throws IOException
    {
        return readRawVarint64();
    }

    public MessageLite readMessage(Parser parser, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        int i = readRawVarint32();
        if (recursionDepth >= recursionLimit)
        {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else
        {
            i = pushLimit(i);
            recursionDepth = recursionDepth + 1;
            parser = (MessageLite)parser.parsePartialFrom(this, extensionregistrylite);
            checkLastTagWas(0);
            recursionDepth = recursionDepth - 1;
            popLimit(i);
            return parser;
        }
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        int i = readRawVarint32();
        if (recursionDepth >= recursionLimit)
        {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else
        {
            i = pushLimit(i);
            recursionDepth = recursionDepth + 1;
            builder.mergeFrom(this, extensionregistrylite);
            checkLastTagWas(0);
            recursionDepth = recursionDepth - 1;
            popLimit(i);
            return;
        }
    }

    public byte readRawByte()
        throws IOException
    {
        if (bufferPos == bufferSize)
        {
            refillBuffer(true);
        }
        byte abyte0[] = buffer;
        int i = bufferPos;
        bufferPos = i + 1;
        return abyte0[i];
    }

    public byte[] readRawBytes(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (totalBytesRetired + bufferPos + i > currentLimit)
        {
            skipRawBytes(currentLimit - totalBytesRetired - bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i <= bufferSize - bufferPos)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, bufferPos, abyte0, 0, i);
            bufferPos = bufferPos + i;
            return abyte0;
        }
        if (i < 4096)
        {
            byte abyte1[] = new byte[i];
            int j = bufferSize - bufferPos;
            System.arraycopy(buffer, bufferPos, abyte1, 0, j);
            bufferPos = bufferSize;
            refillBuffer(true);
            while (i - j > bufferSize) 
            {
                System.arraycopy(buffer, 0, abyte1, j, bufferSize);
                j += bufferSize;
                bufferPos = bufferSize;
                refillBuffer(true);
            }
            System.arraycopy(buffer, 0, abyte1, j, i - j);
            bufferPos = i - j;
            return abyte1;
        }
        int k1 = bufferPos;
        int l1 = bufferSize;
        totalBytesRetired = totalBytesRetired + bufferSize;
        bufferPos = 0;
        bufferSize = 0;
        Object obj = new ArrayList();
        int i1;
        for (int k = i - (l1 - k1); k > 0; k -= i1)
        {
            byte abyte2[] = new byte[Math.min(k, 4096)];
            int j1;
            for (int l = 0; l < abyte2.length; l += j1)
            {
                if (input == null)
                {
                    j1 = -1;
                } else
                {
                    j1 = input.read(abyte2, l, abyte2.length - l);
                }
                if (j1 == -1)
                {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                totalBytesRetired = totalBytesRetired + j1;
            }

            i1 = abyte2.length;
            ((List) (obj)).add(abyte2);
        }

        byte abyte3[] = new byte[i];
        i = l1 - k1;
        System.arraycopy(buffer, k1, abyte3, 0, i);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            byte abyte4[] = (byte[])((Iterator) (obj)).next();
            System.arraycopy(abyte4, 0, abyte3, i, abyte4.length);
            i = abyte4.length + i;
        }

        return abyte3;
    }

    public int readRawLittleEndian32()
        throws IOException
    {
        return readRawByte() & 0xff | (readRawByte() & 0xff) << 8 | (readRawByte() & 0xff) << 16 | (readRawByte() & 0xff) << 24;
    }

    public long readRawLittleEndian64()
        throws IOException
    {
        int i = readRawByte();
        int j = readRawByte();
        int k = readRawByte();
        int l = readRawByte();
        int i1 = readRawByte();
        int j1 = readRawByte();
        int k1 = readRawByte();
        int l1 = readRawByte();
        long l2 = i;
        return ((long)j & 255L) << 8 | l2 & 255L | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
    }

    public int readRawVarint32()
        throws IOException
    {
        int i = readRawByte();
        if (i < 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i &= 0x7f;
        byte byte0 = readRawByte();
        if (byte0 >= 0)
        {
            return i | byte0 << 7;
        }
        i |= (byte0 & 0x7f) << 7;
        byte0 = readRawByte();
        if (byte0 >= 0)
        {
            return i | byte0 << 14;
        }
        i |= (byte0 & 0x7f) << 14;
        int k = readRawByte();
        if (k >= 0)
        {
            return i | k << 21;
        }
        byte0 = readRawByte();
        k = i | (k & 0x7f) << 21 | byte0 << 28;
        i = k;
        if (byte0 < 0)
        {
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= 5)
                    {
                        break label1;
                    }
                    i = k;
                    if (readRawByte() >= 0)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public long readRawVarint64()
        throws IOException
    {
        int i = 0;
        long l = 0L;
        for (; i < 64; i += 7)
        {
            byte byte0 = readRawByte();
            l |= (long)(byte0 & 0x7f) << i;
            if ((byte0 & 0x80) == 0)
            {
                return l;
            }
        }

        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32()
        throws IOException
    {
        return readRawLittleEndian32();
    }

    public long readSFixed64()
        throws IOException
    {
        return readRawLittleEndian64();
    }

    public int readSInt32()
        throws IOException
    {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64()
        throws IOException
    {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString()
        throws IOException
    {
        int i = readRawVarint32();
        if (i <= bufferSize - bufferPos && i > 0)
        {
            String s = new String(buffer, bufferPos, i, "UTF-8");
            bufferPos = i + bufferPos;
            return s;
        } else
        {
            return new String(readRawBytes(i), "UTF-8");
        }
    }

    public int readTag()
        throws IOException
    {
        if (isAtEnd())
        {
            lastTag = 0;
            return 0;
        }
        lastTag = readRawVarint32();
        if (WireFormat.getTagFieldNumber(lastTag) == 0)
        {
            throw InvalidProtocolBufferException.invalidTag();
        } else
        {
            return lastTag;
        }
    }

    public int readUInt32()
        throws IOException
    {
        return readRawVarint32();
    }

    public long readUInt64()
        throws IOException
    {
        return readRawVarint64();
    }

    public boolean skipField(int i)
        throws IOException
    {
        switch (WireFormat.getTagWireType(i))
        {
        default:
            throw InvalidProtocolBufferException.invalidWireType();

        case 0: // '\0'
            readInt32();
            return true;

        case 1: // '\001'
            readRawLittleEndian64();
            return true;

        case 2: // '\002'
            skipRawBytes(readRawVarint32());
            return true;

        case 3: // '\003'
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            readRawLittleEndian32();
            break;
        }
        return true;
    }

    public void skipMessage()
        throws IOException
    {
        int i;
        do
        {
            i = readTag();
        } while (i != 0 && skipField(i));
    }

    public void skipRawBytes(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (totalBytesRetired + bufferPos + i > currentLimit)
        {
            skipRawBytes(currentLimit - totalBytesRetired - bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i <= bufferSize - bufferPos)
        {
            bufferPos = bufferPos + i;
            return;
        }
        int j = bufferSize - bufferPos;
        bufferPos = bufferSize;
        refillBuffer(true);
        while (i - j > bufferSize) 
        {
            j += bufferSize;
            bufferPos = bufferSize;
            refillBuffer(true);
        }
        bufferPos = i - j;
    }
}
