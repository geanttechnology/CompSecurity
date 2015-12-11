// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            LiteralByteString, InvalidProtocolBufferException, MutableMessageLite, Internal, 
//            ByteString, BoundedByteString, Parser, MessageLite, 
//            WireFormat, CodedOutputStream, ExtensionRegistryLite

public final class CodedInputStream
{
    private static interface RefillCallback
    {

        public abstract void onRefill();
    }

    private class SkippedDataSink
        implements RefillCallback
    {

        private ByteArrayOutputStream byteArrayStream;
        private int lastPos;
        final CodedInputStream this$0;

        ByteBuffer getSkippedData()
        {
            if (byteArrayStream == null)
            {
                return ByteBuffer.wrap(buffer, lastPos, bufferPos - lastPos);
            } else
            {
                byteArrayStream.write(buffer, lastPos, bufferPos);
                return ByteBuffer.wrap(byteArrayStream.toByteArray());
            }
        }

        public void onRefill()
        {
            if (byteArrayStream == null)
            {
                byteArrayStream = new ByteArrayOutputStream();
            }
            byteArrayStream.write(buffer, lastPos, bufferPos - lastPos);
            lastPos = 0;
        }

        private SkippedDataSink()
        {
            this$0 = CodedInputStream.this;
            super();
            lastPos = bufferPos;
        }

    }


    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 0x4000000;
    private final byte buffer[];
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    private CodedInputStream(LiteralByteString literalbytestring)
    {
        enableAliasing = false;
        currentLimit = 0x7fffffff;
        recursionLimit = 64;
        sizeLimit = 0x4000000;
        refillCallback = null;
        buffer = literalbytestring.bytes;
        bufferPos = literalbytestring.getOffsetIntoBytes();
        bufferSize = literalbytestring.getOffsetIntoBytes() + literalbytestring.size();
        totalBytesRetired = -bufferPos;
        input = null;
        bufferIsImmutable = true;
    }

    private CodedInputStream(InputStream inputstream)
    {
        enableAliasing = false;
        currentLimit = 0x7fffffff;
        recursionLimit = 64;
        sizeLimit = 0x4000000;
        refillCallback = null;
        buffer = new byte[4096];
        bufferSize = 0;
        bufferPos = 0;
        totalBytesRetired = 0;
        input = inputstream;
        bufferIsImmutable = false;
    }

    private CodedInputStream(byte abyte0[], int i, int j)
    {
        enableAliasing = false;
        currentLimit = 0x7fffffff;
        recursionLimit = 64;
        sizeLimit = 0x4000000;
        refillCallback = null;
        buffer = abyte0;
        bufferSize = i + j;
        bufferPos = i;
        totalBytesRetired = -i;
        input = null;
        bufferIsImmutable = false;
    }

    public static int decodeZigZag32(int i)
    {
        return i >>> 1 ^ -(i & 1);
    }

    public static long decodeZigZag64(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    static CodedInputStream newInstance(LiteralByteString literalbytestring)
    {
        CodedInputStream codedinputstream = new CodedInputStream(literalbytestring);
        try
        {
            codedinputstream.pushLimit(literalbytestring.size());
        }
        // Misplaced declaration of an exception variable
        catch (LiteralByteString literalbytestring)
        {
            throw new IllegalArgumentException(literalbytestring);
        }
        return codedinputstream;
    }

    public static CodedInputStream newInstance(InputStream inputstream)
    {
        return new CodedInputStream(inputstream);
    }

    public static CodedInputStream newInstance(ByteBuffer bytebuffer)
    {
        if (bytebuffer.hasArray())
        {
            return newInstance(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer.remaining());
        } else
        {
            bytebuffer = bytebuffer.duplicate();
            byte abyte0[] = new byte[bytebuffer.remaining()];
            bytebuffer.get(abyte0);
            return newInstance(abyte0);
        }
    }

    public static CodedInputStream newInstance(byte abyte0[])
    {
        return newInstance(abyte0, 0, abyte0.length);
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

    static int readRawVarint32(InputStream inputstream)
        throws IOException
    {
        int i = inputstream.read();
        if (i == -1)
        {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else
        {
            return readRawVarint32(i, inputstream);
        }
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
        if (refillCallback != null)
        {
            refillCallback.onRefill();
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

    private void skipRawVarint()
        throws IOException
    {
        for (int i = 0; i < 10; i++)
        {
            if (readRawByte() >= 0)
            {
                return;
            }
        }

        throw InvalidProtocolBufferException.malformedVarint();
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

    public void enableAliasing(boolean flag)
    {
        enableAliasing = flag;
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

    public int getLastTag()
    {
        return lastTag;
    }

    public int getTotalBytesRead()
    {
        return totalBytesRetired + bufferPos;
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

    public void mergeToMessage(MutableMessageLite mutablemessagelite)
        throws IOException
    {
        Object obj = new SkippedDataSink();
        refillCallback = ((RefillCallback) (obj));
        skipMessage();
        refillCallback = null;
        obj = ((SkippedDataSink) (obj)).getSkippedData();
        if (!mutablemessagelite.mergeFrom(((ByteBuffer) (obj)).array(), ((ByteBuffer) (obj)).position(), ((ByteBuffer) (obj)).remaining()))
        {
            throw InvalidProtocolBufferException.parseFailure();
        } else
        {
            return;
        }
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
        i += totalBytesRetired + bufferPos;
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

    public byte[] readByteArray()
        throws IOException
    {
        int i = readRawVarint32();
        if (i == 0)
        {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        if (i <= bufferSize - bufferPos && i > 0)
        {
            byte abyte0[] = Arrays.copyOfRange(buffer, bufferPos, bufferPos + i);
            bufferPos = bufferPos + i;
            return abyte0;
        } else
        {
            return readRawBytes(i);
        }
    }

    public ByteBuffer readByteBuffer()
        throws IOException
    {
        int i = readRawVarint32();
        if (i == 0)
        {
            return Internal.EMPTY_BYTE_BUFFER;
        }
        if (i <= bufferSize - bufferPos && i > 0)
        {
            ByteBuffer bytebuffer;
            if (input == null && !bufferIsImmutable && enableAliasing)
            {
                bytebuffer = ByteBuffer.wrap(buffer, bufferPos, i).slice();
            } else
            {
                bytebuffer = ByteBuffer.wrap(Arrays.copyOfRange(buffer, bufferPos, bufferPos + i));
            }
            bufferPos = bufferPos + i;
            return bytebuffer;
        } else
        {
            return ByteBuffer.wrap(readRawBytes(i));
        }
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
            Object obj;
            if (bufferIsImmutable && enableAliasing)
            {
                obj = new BoundedByteString(buffer, bufferPos, i);
            } else
            {
                obj = ByteString.copyFrom(buffer, bufferPos, i);
            }
            bufferPos = bufferPos + i;
            return ((ByteString) (obj));
        } else
        {
            return new LiteralByteString(readRawBytes(i));
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

    public MessageLite readGroup(int i, Parser parser, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        if (recursionDepth >= recursionLimit)
        {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else
        {
            recursionDepth = recursionDepth + 1;
            parser = (MessageLite)parser.parsePartialFrom(this, extensionregistrylite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            recursionDepth = recursionDepth - 1;
            return parser;
        }
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

    public void readGroup(int i, MutableMessageLite mutablemessagelite, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        if (recursionDepth >= recursionLimit)
        {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else
        {
            recursionDepth = recursionDepth + 1;
            mutablemessagelite.mergeFrom(this, extensionregistrylite);
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

    public void readMessage(MutableMessageLite mutablemessagelite, ExtensionRegistryLite extensionregistrylite)
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
            mutablemessagelite.mergeFrom(this, extensionregistrylite);
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
        if (i > bufferSize - bufferPos) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new byte[i];
        System.arraycopy(buffer, bufferPos, obj, 0, i);
        bufferPos = bufferPos + i;
_L4:
        return ((byte []) (obj));
_L2:
        if (i < 4096)
        {
            obj = new byte[i];
            int j = bufferSize - bufferPos;
            System.arraycopy(buffer, bufferPos, obj, 0, j);
            bufferPos = bufferSize;
            refillBuffer(true);
            while (i - j > bufferSize) 
            {
                System.arraycopy(buffer, 0, obj, j, bufferSize);
                j += bufferSize;
                bufferPos = bufferSize;
                refillBuffer(true);
            }
            System.arraycopy(buffer, 0, obj, j, i - j);
            bufferPos = i - j;
            return ((byte []) (obj));
        }
        int j1 = bufferPos;
        int k1 = bufferSize;
        totalBytesRetired = totalBytesRetired + bufferSize;
        bufferPos = 0;
        bufferSize = 0;
        int k = i - (k1 - j1);
        obj = new ArrayList();
        while (k > 0) 
        {
            byte abyte1[] = new byte[Math.min(k, 4096)];
            int i1;
            for (int l = 0; l < abyte1.length; l += i1)
            {
                if (input == null)
                {
                    i1 = -1;
                } else
                {
                    i1 = input.read(abyte1, l, abyte1.length - l);
                }
                if (i1 == -1)
                {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                totalBytesRetired = totalBytesRetired + i1;
            }

            k -= abyte1.length;
            ((List) (obj)).add(abyte1);
        }
        byte abyte2[] = new byte[i];
        i = k1 - j1;
        System.arraycopy(buffer, j1, abyte2, 0, i);
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = abyte2;
            if (!iterator.hasNext())
            {
                continue;
            }
            byte abyte0[] = (byte[])iterator.next();
            System.arraycopy(abyte0, 0, abyte2, i, abyte0.length);
            i += abyte0.length;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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
        return (long)i & 255L | ((long)j & 255L) << 8 | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
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
            bufferPos = bufferPos + i;
            return s;
        } else
        {
            return new String(readRawBytes(i), "UTF-8");
        }
    }

    public String readStringRequireUtf8()
        throws IOException
    {
        int i = readRawVarint32();
        Object obj;
        if (i <= bufferSize - bufferPos && i > 0)
        {
            obj = ByteString.copyFrom(buffer, bufferPos, i);
            bufferPos = bufferPos + i;
        } else
        {
            obj = new LiteralByteString(readRawBytes(i));
        }
        if (!((ByteString) (obj)).isValidUtf8())
        {
            throw InvalidProtocolBufferException.invalidUtf8();
        } else
        {
            return ((ByteString) (obj)).toStringUtf8();
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

    public void readUnknownGroup(int i, MessageLite.Builder builder)
        throws IOException
    {
        readGroup(i, builder, null);
    }

    public void resetSizeCounter()
    {
        totalBytesRetired = -bufferPos;
    }

    public int setRecursionLimit(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Recursion limit cannot be negative: ").append(i).toString());
        } else
        {
            int j = recursionLimit;
            recursionLimit = i;
            return j;
        }
    }

    public int setSizeLimit(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Size limit cannot be negative: ").append(i).toString());
        } else
        {
            int j = sizeLimit;
            sizeLimit = i;
            return j;
        }
    }

    public boolean skipField(int i)
        throws IOException
    {
        switch (WireFormat.getTagWireType(i))
        {
        default:
            throw InvalidProtocolBufferException.invalidWireType();

        case 0: // '\0'
            skipRawVarint();
            return true;

        case 1: // '\001'
            skipRawBytes(8);
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
            skipRawBytes(4);
            break;
        }
        return true;
    }

    public boolean skipField(int i, CodedOutputStream codedoutputstream)
        throws IOException
    {
        int j;
        switch (WireFormat.getTagWireType(i))
        {
        default:
            throw InvalidProtocolBufferException.invalidWireType();

        case 0: // '\0'
            long l = readInt64();
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeUInt64NoTag(l);
            return true;

        case 1: // '\001'
            long l1 = readRawLittleEndian64();
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeFixed64NoTag(l1);
            return true;

        case 2: // '\002'
            ByteString bytestring = readBytes();
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeBytesNoTag(bytestring);
            return true;

        case 3: // '\003'
            codedoutputstream.writeRawVarint32(i);
            skipMessage(codedoutputstream);
            i = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
            checkLastTagWas(i);
            codedoutputstream.writeRawVarint32(i);
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            j = readRawLittleEndian32();
            break;
        }
        codedoutputstream.writeRawVarint32(i);
        codedoutputstream.writeFixed32NoTag(j);
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

    public void skipMessage(CodedOutputStream codedoutputstream)
        throws IOException
    {
        int i;
        do
        {
            i = readTag();
        } while (i != 0 && skipField(i, codedoutputstream));
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
