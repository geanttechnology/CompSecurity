// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            DataFileConstants, CodecFactory, Codec

public class DataFileStream
    implements Iterator, Iterable, Closeable
{
    static class DataBlock
    {

        private int blockSize;
        private byte data[];
        private long numEntries;
        private int offset;

        void compressUsing(Codec codec1)
            throws IOException
        {
            codec1 = codec1.compress(getAsByteBuffer());
            data = codec1.array();
            blockSize = codec1.remaining();
        }

        void decompressUsing(Codec codec1)
            throws IOException
        {
            codec1 = codec1.decompress(getAsByteBuffer());
            data = codec1.array();
            blockSize = codec1.remaining();
        }

        ByteBuffer getAsByteBuffer()
        {
            return ByteBuffer.wrap(data, offset, blockSize);
        }

        int getBlockSize()
        {
            return blockSize;
        }

        byte[] getData()
        {
            return data;
        }

        long getNumEntries()
        {
            return numEntries;
        }

        void writeBlockTo(BinaryEncoder binaryencoder, byte abyte0[])
            throws IOException
        {
            binaryencoder.writeLong(numEntries);
            binaryencoder.writeLong(blockSize);
            binaryencoder.writeFixed(data, offset, blockSize);
            binaryencoder.writeFixed(abyte0);
            binaryencoder.flush();
        }



/*
        static long access$402(DataBlock datablock, long l)
        {
            datablock.numEntries = l;
            return l;
        }

*/



/*
        static int access$502(DataBlock datablock, int i)
        {
            datablock.blockSize = i;
            return i;
        }

*/

        private DataBlock(long l, int i)
        {
            offset = 0;
            data = new byte[i];
            numEntries = l;
            blockSize = i;
        }

        DataBlock(long l, int i, _cls1 _pcls1)
        {
            this(l, i);
        }

        DataBlock(ByteBuffer bytebuffer, long l)
        {
            offset = 0;
            data = bytebuffer.array();
            blockSize = bytebuffer.remaining();
            offset = bytebuffer.arrayOffset() + bytebuffer.position();
            numEntries = l;
        }
    }

    public static final class Header
    {

        Map meta;
        private transient List metaKeyList;
        Schema schema;
        byte sync[];



/*
        static List access$102(Header header1, List list)
        {
            header1.metaKeyList = list;
            return list;
        }

*/

        private Header()
        {
            meta = new HashMap();
            metaKeyList = new ArrayList();
            sync = new byte[16];
        }

    }


    private boolean availableBlock;
    private DataBlock block;
    ByteBuffer blockBuffer;
    long blockCount;
    long blockRemaining;
    private long blockSize;
    private Codec codec;
    BinaryDecoder datumIn;
    private Header header;
    private DatumReader reader;
    byte syncBuffer[];
    BinaryDecoder vin;

    protected DataFileStream(DatumReader datumreader)
        throws IOException
    {
        availableBlock = false;
        datumIn = null;
        syncBuffer = new byte[16];
        block = null;
        reader = datumreader;
    }

    public DataFileStream(InputStream inputstream, DatumReader datumreader)
        throws IOException
    {
        availableBlock = false;
        datumIn = null;
        syncBuffer = new byte[16];
        block = null;
        reader = datumreader;
        initialize(inputstream);
    }

    protected void blockFinished()
        throws IOException
    {
    }

    public void close()
        throws IOException
    {
        vin.inputStream().close();
    }

    public long getBlockCount()
    {
        return blockCount;
    }

    public Header getHeader()
    {
        return header;
    }

    public byte[] getMeta(String s)
    {
        return (byte[])header.meta.get(s);
    }

    public List getMetaKeys()
    {
        return header.metaKeyList;
    }

    public long getMetaLong(String s)
    {
        return Long.parseLong(getMetaString(s));
    }

    public String getMetaString(String s)
    {
        s = getMeta(s);
        if (s == null)
        {
            return null;
        }
        try
        {
            s = new String(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public Schema getSchema()
    {
        return header.schema;
    }

    public boolean hasNext()
    {
        long l;
        if (blockRemaining == 0L)
        {
            if (datumIn != null && !datumIn.isEnd())
            {
                throw new IOException("Block read partially, the data may be corrupt");
            }
            if (hasNextBlock())
            {
                block = nextRawBlock(block);
                block.decompressUsing(codec);
                blockBuffer = block.getAsByteBuffer();
                datumIn = DecoderFactory.get().binaryDecoder(blockBuffer.array(), blockBuffer.arrayOffset() + blockBuffer.position(), blockBuffer.remaining(), datumIn);
            }
        }
        l = blockRemaining;
        if (l != 0L)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_144;
        Object obj;
        obj;
        throw new AvroRuntimeException(((Throwable) (obj)));
        obj;
        return false;
    }

    boolean hasNextBlock()
    {
        if (availableBlock)
        {
            return true;
        }
        if (vin.isEnd())
        {
            return false;
        }
        try
        {
            blockRemaining = vin.readLong();
            blockSize = vin.readLong();
            if (blockSize > 0x7fffffffL || blockSize < 0L)
            {
                throw new IOException((new StringBuilder()).append("Block size invalid or too large for this implementation: ").append(blockSize).toString());
            }
            blockCount = blockRemaining;
            availableBlock = true;
        }
        catch (EOFException eofexception)
        {
            return false;
        }
        catch (IOException ioexception)
        {
            throw new AvroRuntimeException(ioexception);
        }
        return true;
    }

    void initialize(InputStream inputstream)
        throws IOException
    {
        header = new Header();
        vin = DecoderFactory.get().binaryDecoder(inputstream, vin);
        inputstream = new byte[DataFileConstants.MAGIC.length];
        try
        {
            vin.readFixed(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException("Not a data file.");
        }
        if (!Arrays.equals(DataFileConstants.MAGIC, inputstream))
        {
            throw new IOException("Not a data file.");
        }
        long l = vin.readMapStart();
        long l2;
        if (l > 0L)
        {
            do
            {
                for (long l1 = 0L; l1 < l; l1++)
                {
                    inputstream = vin.readString(null).toString();
                    ByteBuffer bytebuffer = vin.readBytes(null);
                    byte abyte0[] = new byte[bytebuffer.remaining()];
                    bytebuffer.get(abyte0);
                    header.meta.put(inputstream, abyte0);
                    header.metaKeyList.add(inputstream);
                }

                l2 = vin.mapNext();
                l = l2;
            } while (l2 != 0L);
        }
        vin.readFixed(header.sync);
        header.metaKeyList = Collections.unmodifiableList(header.metaKeyList);
        header.schema = Schema.parse(getMetaString("avro.schema"), false);
        codec = resolveCodec();
        reader.setSchema(header.schema);
    }

    void initialize(InputStream inputstream, Header header1)
        throws IOException
    {
        header = header1;
        codec = resolveCodec();
        reader.setSchema(header1.schema);
    }

    public Iterator iterator()
    {
        return this;
    }

    public Object next()
    {
        Object obj;
        try
        {
            obj = next(null);
        }
        catch (IOException ioexception)
        {
            throw new AvroRuntimeException(ioexception);
        }
        return obj;
    }

    public Object next(Object obj)
        throws IOException
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        obj = reader.read(obj, datumIn);
        long l = blockRemaining - 1L;
        blockRemaining = l;
        if (0L == l)
        {
            blockFinished();
        }
        return obj;
    }

    public ByteBuffer nextBlock()
        throws IOException
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        if (blockRemaining != blockCount)
        {
            throw new IllegalStateException("Not at block start.");
        } else
        {
            blockRemaining = 0L;
            datumIn = null;
            return blockBuffer;
        }
    }

    DataBlock nextRawBlock(DataBlock datablock)
        throws IOException
    {
        if (!hasNextBlock())
        {
            throw new NoSuchElementException();
        }
        if (datablock == null || datablock.data.length < (int)blockSize)
        {
            datablock = new DataBlock(blockRemaining, (int)blockSize);
        } else
        {
            datablock.numEntries = blockRemaining;
            datablock.blockSize = (int)blockSize;
        }
        vin.readFixed(datablock.data, 0, datablock.blockSize);
        vin.readFixed(syncBuffer);
        if (!Arrays.equals(syncBuffer, header.sync))
        {
            throw new IOException("Invalid sync!");
        } else
        {
            availableBlock = false;
            return datablock;
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    Codec resolveCodec()
    {
        String s = getMetaString("avro.codec");
        if (s != null)
        {
            return CodecFactory.fromString(s).createInstance();
        } else
        {
            return CodecFactory.nullCodec().createInstance();
        }
    }
}
