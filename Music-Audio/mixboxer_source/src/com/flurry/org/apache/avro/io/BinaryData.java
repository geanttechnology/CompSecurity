// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericDatumReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Decoder, BinaryDecoder

public class BinaryData
{
    private static class Decoders
    {

        private final BinaryDecoder.BufferAccessor b1;
        private final BinaryDecoder.BufferAccessor b2;
        private final BinaryDecoder d1 = new BinaryDecoder(new byte[0], 0, 0);
        private final BinaryDecoder d2 = new BinaryDecoder(new byte[0], 0, 0);

        public void set(byte abyte0[], int i, int j, byte abyte1[], int k, int l)
        {
            d1.configure(abyte0, i, j);
            d2.configure(abyte1, k, l);
        }





        public Decoders()
        {
            b1 = d1.getBufferAccessor();
            b2 = d2.getBufferAccessor();
        }
    }

    private static class HashData
    {

        private final BinaryDecoder.BufferAccessor bytes;
        private final BinaryDecoder decoder = new BinaryDecoder(new byte[0], 0, 0);

        public void set(byte abyte0[], int i, int j)
        {
            decoder.configure(abyte0, i, j);
        }



        public HashData()
        {
            bytes = decoder.getBufferAccessor();
        }
    }


    private static final ThreadLocal DECODERS = new ThreadLocal() {

        protected Decoders initialValue()
        {
            return new Decoders();
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };
    private static final ThreadLocal HASH_DATA = new ThreadLocal() {

        protected HashData initialValue()
        {
            return new HashData();
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };

    private BinaryData()
    {
    }

    private static int compare(Decoders decoders, Schema schema)
        throws IOException
    {
        BinaryDecoder binarydecoder;
        BinaryDecoder binarydecoder1;
        binarydecoder = decoders.d1;
        binarydecoder1 = decoders.d2;
        static class _cls3
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[com.flurry.org.apache.avro.Schema.Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.RECORD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ENUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.LONG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.MAP.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.UNION.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FIXED.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.STRING.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BYTES.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FLOAT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.DOUBLE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BOOLEAN.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.NULL.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 92
    //                   1 102
    //                   2 206
    //                   3 206
    //                   4 240
    //                   5 276
    //                   6 509
    //                   7 519
    //                   8 565
    //                   9 629
    //                   10 629
    //                   11 701
    //                   12 737
    //                   13 770
    //                   14 798;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L9 _L10 _L11 _L12 _L13
_L1:
        throw new AvroRuntimeException("Unexpected schema to compare!");
_L2:
        for (schema = schema.getFields().iterator(); schema.hasNext();)
        {
            com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
            if (field.order() == com.flurry.org.apache.avro.Schema.Field.Order.IGNORE)
            {
                GenericDatumReader.skip(field.schema(), binarydecoder);
                GenericDatumReader.skip(field.schema(), binarydecoder1);
            } else
            {
                int i = compare(decoders, field.schema());
                if (i != 0)
                {
                    if (field.order() == com.flurry.org.apache.avro.Schema.Field.Order.DESCENDING)
                    {
                        i = -i;
                    }
                    return i;
                }
            }
        }

        return 0;
_L3:
        int j = binarydecoder.readInt();
        int k1 = binarydecoder1.readInt();
        if (j == k1)
        {
            return 0;
        }
        return j <= k1 ? -1 : 1;
_L4:
        long l2 = binarydecoder.readLong();
        long l4 = binarydecoder1.readLong();
        if (l2 == l4)
        {
            return 0;
        }
        return l2 <= l4 ? -1 : 1;
_L5:
        long l3;
        long l6;
        long l8;
        long l9;
        long l11;
        l9 = 0L;
        l6 = 0L;
        l3 = 0L;
        l11 = 0L;
        l8 = 0L;
_L15:
        long l5;
        long l7;
        long l10;
        long l12;
        long l13;
        long l14;
        l10 = l11;
        l5 = l6;
        if (l6 == 0L)
        {
            l6 = binarydecoder.readLong();
            l5 = l6;
            if (l6 < 0L)
            {
                l5 = -l6;
                binarydecoder.readLong();
            }
            l10 = l11 + l5;
        }
        l12 = l8;
        l7 = l3;
        if (l3 == 0L)
        {
            l3 = binarydecoder1.readLong();
            l7 = l3;
            if (l3 < 0L)
            {
                l7 = -l3;
                binarydecoder1.readLong();
            }
            l12 = l8 + l7;
        }
        if (l5 == 0L || l7 == 0L)
        {
            if (l10 == l12)
            {
                return 0;
            }
            return l10 <= l12 ? -1 : 1;
        }
        l14 = Math.min(l10, l12);
        l13 = l9;
_L16:
        l9 = l13;
        l11 = l10;
        l8 = l12;
        l6 = l5;
        l3 = l7;
        if (l13 >= l14) goto _L15; else goto _L14
_L14:
        int k = compare(decoders, schema.getElementType());
        if (k != 0)
        {
            return k;
        }
        l13++;
        l5--;
        l7--;
          goto _L16
          goto _L15
_L6:
        throw new AvroRuntimeException("Can't compare maps!");
_L7:
        int l = binarydecoder.readInt();
        int l1 = binarydecoder1.readInt();
        if (l == l1)
        {
            return compare(decoders, (Schema)schema.getTypes().get(l));
        } else
        {
            return l - l1;
        }
_L8:
        int i1 = schema.getFixedSize();
        int i2 = compareBytes(decoders.b1.getBuf(), decoders.b1.getPos(), i1, decoders.b2.getBuf(), decoders.b2.getPos(), i1);
        decoders.d1.skipFixed(i1);
        decoders.d2.skipFixed(i1);
        return i2;
_L9:
        int j1 = binarydecoder.readInt();
        int j2 = binarydecoder1.readInt();
        int k2 = compareBytes(decoders.b1.getBuf(), decoders.b1.getPos(), j1, decoders.b2.getBuf(), decoders.b2.getPos(), j2);
        decoders.d1.skipFixed(j1);
        decoders.d2.skipFixed(j2);
        return k2;
_L10:
        float f = binarydecoder.readFloat();
        float f1 = binarydecoder1.readFloat();
        if (f == f1)
        {
            return 0;
        }
        return f <= f1 ? -1 : 1;
_L11:
        double d = binarydecoder.readDouble();
        double d1 = binarydecoder1.readDouble();
        if (d == d1)
        {
            return 0;
        }
        return d <= d1 ? -1 : 1;
_L12:
        boolean flag = binarydecoder.readBoolean();
        if (flag == binarydecoder1.readBoolean())
        {
            return 0;
        }
        return !flag ? -1 : 1;
_L13:
        return 0;
    }

    public static int compare(byte abyte0[], int i, int j, byte abyte1[], int k, int l, Schema schema)
    {
        Decoders decoders = (Decoders)DECODERS.get();
        decoders.set(abyte0, i, j, abyte1, k, l);
        try
        {
            i = compare(decoders, schema);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AvroRuntimeException(abyte0);
        }
        return i;
    }

    public static int compare(byte abyte0[], int i, byte abyte1[], int j, Schema schema)
    {
        return compare(abyte0, i, abyte0.length - i, abyte1, j, abyte1.length - j, schema);
    }

    public static int compareBytes(byte abyte0[], int i, int j, byte abyte1[], int k, int l)
    {
        int j1 = i;
        for (int i1 = k; j1 < i + j && i1 < k + l; i1++)
        {
            int k1 = abyte0[j1] & 0xff;
            int l1 = abyte1[i1] & 0xff;
            if (k1 != l1)
            {
                return k1 - l1;
            }
            j1++;
        }

        return j - l;
    }

    public static int encodeBoolean(boolean flag, byte abyte0[], int i)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        abyte0[i] = byte0;
        return 1;
    }

    public static int encodeDouble(double d, byte abyte0[], int i)
    {
        long l = Double.doubleToRawLongBits(d);
        int j = (int)(l & -1L);
        int k = (int)(l >>> 32 & -1L);
        abyte0[i] = (byte)(j & 0xff);
        abyte0[i + 4] = (byte)(k & 0xff);
        abyte0[i + 5] = (byte)(k >>> 8 & 0xff);
        abyte0[i + 1] = (byte)(j >>> 8 & 0xff);
        abyte0[i + 2] = (byte)(j >>> 16 & 0xff);
        abyte0[i + 6] = (byte)(k >>> 16 & 0xff);
        abyte0[i + 7] = (byte)(k >>> 24 & 0xff);
        abyte0[i + 3] = (byte)(j >>> 24 & 0xff);
        return 8;
    }

    public static int encodeFloat(float f, byte abyte0[], int i)
    {
        int j = Float.floatToRawIntBits(f);
        abyte0[i] = (byte)(j & 0xff);
        abyte0[i + 1] = (byte)(j >>> 8 & 0xff);
        abyte0[i + 2] = (byte)(j >>> 16 & 0xff);
        abyte0[i + 3] = (byte)(j >>> 24 & 0xff);
        return 4;
    }

    public static int encodeInt(int i, byte abyte0[], int j)
    {
        int l = i << 1 ^ i >> 31;
        int k = l;
        i = j;
        if ((l & 0xffffff80) != 0)
        {
            int j1 = j + 1;
            abyte0[j] = (byte)((l | 0x80) & 0xff);
            int l1 = l >>> 7;
            i = j1;
            k = l1;
            if (l1 > 127)
            {
                int i1 = j1 + 1;
                abyte0[j1] = (byte)((l1 | 0x80) & 0xff);
                l1 >>>= 7;
                k = l1;
                i = i1;
                if (l1 > 127)
                {
                    int k1 = i1 + 1;
                    abyte0[i1] = (byte)((l1 | 0x80) & 0xff);
                    i1 = l1 >>> 7;
                    i = k1;
                    k = i1;
                    if (i1 > 127)
                    {
                        i = k1 + 1;
                        abyte0[k1] = (byte)((i1 | 0x80) & 0xff);
                        k = i1 >>> 7;
                    }
                }
            }
        }
        abyte0[i] = (byte)k;
        return (i + 1) - j;
    }

    public static int encodeLong(long l, byte abyte0[], int i)
    {
        long l2 = l << 1 ^ l >> 63;
        l = l2;
        int j = i;
        if ((-128L & l2) != 0L)
        {
            int l1 = i + 1;
            abyte0[i] = (byte)(int)((128L | l2) & 255L);
            l2 >>>= 7;
            j = l1;
            l = l2;
            if (l2 > 127L)
            {
                int k = l1 + 1;
                abyte0[l1] = (byte)(int)((128L | l2) & 255L);
                l2 >>>= 7;
                l = l2;
                j = k;
                if (l2 > 127L)
                {
                    int i2 = k + 1;
                    abyte0[k] = (byte)(int)((128L | l2) & 255L);
                    l2 >>>= 7;
                    j = i2;
                    l = l2;
                    if (l2 > 127L)
                    {
                        int i1 = i2 + 1;
                        abyte0[i2] = (byte)(int)((128L | l2) & 255L);
                        l2 >>>= 7;
                        l = l2;
                        j = i1;
                        if (l2 > 127L)
                        {
                            int j2 = i1 + 1;
                            abyte0[i1] = (byte)(int)((128L | l2) & 255L);
                            l2 >>>= 7;
                            j = j2;
                            l = l2;
                            if (l2 > 127L)
                            {
                                int j1 = j2 + 1;
                                abyte0[j2] = (byte)(int)((128L | l2) & 255L);
                                l2 >>>= 7;
                                l = l2;
                                j = j1;
                                if (l2 > 127L)
                                {
                                    int k2 = j1 + 1;
                                    abyte0[j1] = (byte)(int)((128L | l2) & 255L);
                                    l2 >>>= 7;
                                    j = k2;
                                    l = l2;
                                    if (l2 > 127L)
                                    {
                                        int k1 = k2 + 1;
                                        abyte0[k2] = (byte)(int)((128L | l2) & 255L);
                                        l2 >>>= 7;
                                        l = l2;
                                        j = k1;
                                        if (l2 > 127L)
                                        {
                                            abyte0[k1] = (byte)(int)((128L | l2) & 255L);
                                            l = l2 >>> 7;
                                            j = k1 + 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        abyte0[j] = (byte)(int)l;
        return (j + 1) - i;
    }

    private static int hashBytes(int i, HashData hashdata, int j, boolean flag)
        throws IOException
    {
        byte abyte0[] = hashdata.bytes.getBuf();
        int j1 = hashdata.bytes.getPos();
        int k1 = j1 + j;
        int k;
        if (flag)
        {
            int l = k1 - 1;
            do
            {
                k = i;
                if (l < j1)
                {
                    break;
                }
                i = i * 31 + abyte0[l];
                l--;
            } while (true);
        } else
        {
            int i1 = j1;
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                i = i * 31 + abyte0[i1];
                i1++;
            } while (true);
        }
        hashdata.decoder.skipFixed(j);
        return k;
    }

    private static int hashCode(HashData hashdata, Schema schema)
        throws IOException
    {
        BinaryDecoder binarydecoder;
        int i;
        i = 0;
        binarydecoder = hashdata.decoder;
        _cls3..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 88
    //                   1 98
    //                   2 174
    //                   3 174
    //                   4 191
    //                   5 226
    //                   6 293
    //                   7 304
    //                   8 325
    //                   9 336
    //                   10 347
    //                   11 183
    //                   12 207
    //                   13 358
    //                   14 180;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L7:
        break MISSING_BLOCK_LABEL_304;
_L8:
        break MISSING_BLOCK_LABEL_325;
_L9:
        break MISSING_BLOCK_LABEL_336;
_L10:
        break MISSING_BLOCK_LABEL_347;
_L13:
        break MISSING_BLOCK_LABEL_358;
_L14:
        break; /* Loop/switch isn't completed */
_L1:
        throw new AvroRuntimeException("Unexpected schema to hashCode!");
_L2:
        int j = 1;
        schema = schema.getFields().iterator();
        do
        {
            i = j;
            if (!schema.hasNext())
            {
                break;
            }
            com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
            if (field.order() == com.flurry.org.apache.avro.Schema.Field.Order.IGNORE)
            {
                GenericDatumReader.skip(field.schema(), binarydecoder);
            } else
            {
                j = j * 31 + hashCode(hashdata, field.schema());
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L3:
        i = binarydecoder.readInt();
_L15:
        return i;
_L11:
        return Float.floatToIntBits(binarydecoder.readFloat());
_L4:
        long l = binarydecoder.readLong();
        return (int)(l >>> 32 ^ l);
_L12:
        long l1 = Double.doubleToLongBits(binarydecoder.readDouble());
        return (int)(l1 >>> 32 ^ l1);
_L5:
        schema = schema.getElementType();
        int k = 1;
        long l2 = binarydecoder.readArrayStart();
        do
        {
            i = k;
            if (l2 == 0L)
            {
                break;
            }
            for (long l3 = 0L; l3 < l2; l3++)
            {
                k = k * 31 + hashCode(hashdata, schema);
            }

            l2 = binarydecoder.arrayNext();
        } while (true);
        if (true) goto _L15; else goto _L6
_L6:
        throw new AvroRuntimeException("Can't hashCode maps!");
        return hashCode(hashdata, (Schema)schema.getTypes().get(binarydecoder.readInt()));
        return hashBytes(1, hashdata, schema.getFixedSize(), false);
        return hashBytes(0, hashdata, binarydecoder.readInt(), false);
        return hashBytes(1, hashdata, binarydecoder.readInt(), true);
        char c;
        if (binarydecoder.readBoolean())
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return c;
    }

    public static int hashCode(byte abyte0[], int i, int j, Schema schema)
    {
        HashData hashdata = (HashData)HASH_DATA.get();
        hashdata.set(abyte0, i, j);
        try
        {
            i = hashCode(hashdata, schema);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AvroRuntimeException(abyte0);
        }
        return i;
    }

    public static int skipLong(byte abyte0[], int i)
    {
        int j = i + 1;
        byte byte1 = abyte0[i];
        i = j;
        for (byte byte0 = byte1; (byte0 & 0x80) != 0;)
        {
            byte0 = abyte0[i];
            i++;
        }

        return i;
    }

}
