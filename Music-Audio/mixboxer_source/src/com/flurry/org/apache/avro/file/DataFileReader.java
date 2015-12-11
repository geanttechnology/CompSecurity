// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            DataFileStream, FileReader, SeekableFileInput, SeekableInput, 
//            DataFileConstants, DataFileReader12

public class DataFileReader extends DataFileStream
    implements FileReader
{
    static class SeekableInputStream extends InputStream
        implements SeekableInput
    {

        private SeekableInput in;
        private final byte oneByte[] = new byte[1];

        public int available()
            throws IOException
        {
            long l = in.length() - in.tell();
            if (l > 0x7fffffffL)
            {
                return 0x7fffffff;
            } else
            {
                return (int)l;
            }
        }

        public void close()
            throws IOException
        {
            in.close();
            super.close();
        }

        public long length()
            throws IOException
        {
            return in.length();
        }

        public int read()
            throws IOException
        {
            int j = read(oneByte, 0, 1);
            int i = j;
            if (j == 1)
            {
                i = oneByte[0] & 0xff;
            }
            return i;
        }

        public int read(byte abyte0[])
            throws IOException
        {
            return in.read(abyte0, 0, abyte0.length);
        }

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            return in.read(abyte0, i, j);
        }

        public void seek(long l)
            throws IOException
        {
            if (l < 0L)
            {
                throw new IOException((new StringBuilder()).append("Illegal seek: ").append(l).toString());
            } else
            {
                in.seek(l);
                return;
            }
        }

        public long skip(long l)
            throws IOException
        {
            long l1 = in.tell();
            long l2 = in.length() - l1;
            if (l2 > l)
            {
                in.seek(l);
                return in.tell() - l1;
            } else
            {
                in.seek(l2);
                return in.tell() - l1;
            }
        }

        public long tell()
            throws IOException
        {
            return in.tell();
        }

        SeekableInputStream(SeekableInput seekableinput)
            throws IOException
        {
            in = seekableinput;
        }
    }


    private long blockStart;
    private SeekableInputStream sin;

    public DataFileReader(SeekableInput seekableinput, DatumReader datumreader)
        throws IOException
    {
        super(datumreader);
        sin = new SeekableInputStream(seekableinput);
        initialize(sin);
        blockFinished();
    }

    protected DataFileReader(SeekableInput seekableinput, DatumReader datumreader, DataFileStream.Header header)
        throws IOException
    {
        super(datumreader);
        sin = new SeekableInputStream(seekableinput);
        initialize(sin, header);
    }

    public DataFileReader(File file, DatumReader datumreader)
        throws IOException
    {
        this(((SeekableInput) (new SeekableFileInput(file))), datumreader);
    }

    public static DataFileReader openReader(SeekableInput seekableinput, DatumReader datumreader, DataFileStream.Header header, boolean flag)
        throws IOException
    {
        datumreader = new DataFileReader(seekableinput, datumreader, header);
        if (flag)
        {
            datumreader.sync(seekableinput.tell());
            return datumreader;
        } else
        {
            datumreader.seek(seekableinput.tell());
            return datumreader;
        }
    }

    public static FileReader openReader(SeekableInput seekableinput, DatumReader datumreader)
        throws IOException
    {
        if (seekableinput.length() < (long)DataFileConstants.MAGIC.length)
        {
            throw new IOException("Not an Avro data file");
        }
        byte abyte0[] = new byte[DataFileConstants.MAGIC.length];
        seekableinput.seek(0L);
        for (int i = 0; i < abyte0.length; i = seekableinput.read(abyte0, i, abyte0.length - i)) { }
        seekableinput.seek(0L);
        if (Arrays.equals(DataFileConstants.MAGIC, abyte0))
        {
            return new DataFileReader(seekableinput, datumreader);
        }
        if (Arrays.equals(DataFileReader12.MAGIC, abyte0))
        {
            return new DataFileReader12(seekableinput, datumreader);
        } else
        {
            throw new IOException("Not an Avro data file");
        }
    }

    public static FileReader openReader(File file, DatumReader datumreader)
        throws IOException
    {
        return openReader(((SeekableInput) (new SeekableFileInput(file))), datumreader);
    }

    protected void blockFinished()
        throws IOException
    {
        blockStart = sin.tell() - (long)vin.inputStream().available();
    }

    public boolean pastSync(long l)
        throws IOException
    {
        return blockStart >= 16L + l || blockStart >= sin.length();
    }

    public long previousSync()
    {
        return blockStart;
    }

    public void seek(long l)
        throws IOException
    {
        sin.seek(l);
        vin = DecoderFactory.get().binaryDecoder(sin, vin);
        datumIn = null;
        blockRemaining = 0L;
        blockStart = l;
    }

    public void sync(long l)
        throws IOException
    {
        int i;
        seek(l);
        if (l == 0L && getMeta("avro.sync") != null)
        {
            initialize(sin);
            return;
        }
        i = 0;
        Object obj;
        obj = vin.inputStream();
        vin.readFixed(syncBuffer);
          goto _L1
_L10:
        int j;
        if (j >= 16) goto _L3; else goto _L2
_L2:
        if (getHeader().sync[j] == syncBuffer[(i + j) % 16]) goto _L4; else goto _L3
_L3:
        if (j != 16) goto _L6; else goto _L5
_L5:
        try
        {
            blockStart = (long)i + l + 16L;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L8:
        blockStart = sin.tell();
        return;
_L4:
        j++;
        continue; /* Loop/switch isn't completed */
_L6:
        byte abyte0[];
        j = ((InputStream) (obj)).read();
        abyte0 = syncBuffer;
        abyte0[i % 16] = (byte)j;
        if (j == -1) goto _L8; else goto _L7
_L7:
        i++;
_L1:
        j = 0;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public long tell()
        throws IOException
    {
        return sin.tell();
    }
}
