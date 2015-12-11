// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            FileReader, SeekableInput

public class DataFileReader12
    implements FileReader, Closeable
{

    private static final String CODEC = "codec";
    private static final String COUNT = "count";
    private static final long FOOTER_BLOCK = -1L;
    static final byte MAGIC[] = {
        79, 98, 106, 0
    };
    private static final String NULL_CODEC = "null";
    private static final String SCHEMA = "schema";
    private static final String SYNC = "sync";
    private static final int SYNC_INTERVAL = 16000;
    private static final int SYNC_SIZE = 16;
    private static final byte VERSION = 0;
    private long blockCount;
    private long blockStart;
    private long count;
    private DataFileReader.SeekableInputStream in;
    private Map meta;
    private Object peek;
    private DatumReader reader;
    private Schema schema;
    private byte sync[];
    private byte syncBuffer[];
    private BinaryDecoder vin;

    public DataFileReader12(SeekableInput seekableinput, DatumReader datumreader)
        throws IOException
    {
        meta = new HashMap();
        sync = new byte[16];
        syncBuffer = new byte[16];
        in = new DataFileReader.SeekableInputStream(seekableinput);
        seekableinput = new byte[4];
        in.read(seekableinput);
        if (!Arrays.equals(MAGIC, seekableinput))
        {
            throw new IOException("Not a data file.");
        }
        long l = in.length();
        in.seek(l - 4L);
        seek(l - (long)((in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read()));
        l = vin.readMapStart();
        long l2;
        if (l > 0L)
        {
            do
            {
                for (long l1 = 0L; l1 < l; l1++)
                {
                    seekableinput = vin.readString(null).toString();
                    ByteBuffer bytebuffer = vin.readBytes(null);
                    byte abyte0[] = new byte[bytebuffer.remaining()];
                    bytebuffer.get(abyte0);
                    meta.put(seekableinput, abyte0);
                }

                l2 = vin.mapNext();
                l = l2;
            } while (l2 != 0L);
        }
        sync = getMeta("sync");
        count = getMetaLong("count");
        seekableinput = getMetaString("codec");
        if (seekableinput != null && !seekableinput.equals("null"))
        {
            throw new IOException((new StringBuilder()).append("Unknown codec: ").append(seekableinput).toString());
        } else
        {
            schema = Schema.parse(getMetaString("schema"));
            reader = datumreader;
            datumreader.setSchema(schema);
            seek(MAGIC.length);
            return;
        }
    }

    private void skipSync()
        throws IOException
    {
        vin.readFixed(syncBuffer);
        if (!Arrays.equals(syncBuffer, sync))
        {
            throw new IOException("Invalid sync!");
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        in.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public byte[] getMeta(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (byte[])meta.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public long getMetaLong(String s)
    {
        this;
        JVM INSTR monitorenter ;
        long l = Long.parseLong(getMetaString(s));
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public String getMetaString(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = getMeta(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = new String(s, "UTF-8");
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw new RuntimeException(s);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Schema getSchema()
    {
        return schema;
    }

    public boolean hasNext()
    {
        if (peek == null && blockCount == 0L)
        {
            peek = next();
            if (peek == null)
            {
                return false;
            }
        }
        return true;
    }

    public Iterator iterator()
    {
        return this;
    }

    public Object next()
    {
        if (peek != null)
        {
            Object obj = peek;
            peek = null;
            return obj;
        }
        Object obj1;
        try
        {
            obj1 = next(null);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        return obj1;
    }

    public Object next(Object obj)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
_L3:
        long l;
        long l1;
        if (blockCount != 0L)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        l = in.tell();
        l1 = in.length();
        if (l != l1) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        skipSync();
        blockCount = vin.readLong();
        if (blockCount == -1L)
        {
            seek(vin.readLong() + in.tell());
        }
          goto _L3
        obj;
        throw obj;
        blockCount = blockCount - 1L;
        obj = reader.read(obj, vin);
          goto _L4
    }

    public boolean pastSync(long l)
        throws IOException
    {
        return blockStart >= 16L + l || blockStart >= in.length();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public void seek(long l)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        in.seek(l);
        blockCount = 0L;
        blockStart = l;
        vin = DecoderFactory.get().binaryDecoder(in, vin);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void sync(long l)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (in.tell() + 16L < in.length()) goto _L2; else goto _L1
_L1:
        seek(in.length());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        in.seek(l);
        vin.readFixed(syncBuffer);
        int i = 0;
_L5:
        if (in.tell() >= in.length())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        int j = 0;
_L4:
        if (j < sync.length && sync[j] == syncBuffer[(i + j) % sync.length])
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (j != sync.length)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        seek(in.tell() - 16L);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        j++;
          goto _L4
        syncBuffer[i % sync.length] = (byte)in.read();
        i++;
          goto _L5
        seek(in.length());
          goto _L3
    }

    public long tell()
        throws IOException
    {
        return in.tell();
    }

}
