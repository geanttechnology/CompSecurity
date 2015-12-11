// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io.protocol;

import com.google.userfeedback.android.api.common.io.IoUtil;
import com.google.userfeedback.android.api.common.io.MarkedOutputStream;
import com.google.userfeedback.android.api.common.util.IntMap;
import com.google.userfeedback.android.api.common.util.Primitives;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

// Referenced classes of package com.google.userfeedback.android.api.common.io.protocol:
//            ProtoBufType

public class ProtoBuf
{

    public static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    public static final Boolean FALSE = new Boolean(false);
    private static final int MARKER_HOLDER = -1;
    private static final String MSG_EOF = "Unexp.EOF";
    private static final String MSG_MISMATCH = "Type mismatch";
    private static final String MSG_UNSUPPORTED = "Unsupp.Type";
    private static final SimpleCounter NULL_COUNTER = new SimpleCounter(null);
    public static final Boolean TRUE = new Boolean(true);
    private static final int VARINT_MAX_BYTES = 10;
    static final int WIRETYPE_END_GROUP = 4;
    static final int WIRETYPE_FIXED32 = 5;
    static final int WIRETYPE_FIXED64 = 1;
    static final int WIRETYPE_LENGTH_DELIMITED = 2;
    static final int WIRETYPE_START_GROUP = 3;
    static final int WIRETYPE_VARINT = 0;
    private int cachedSize;
    private ProtoBufType msgType;
    private final IntMap values = new IntMap();
    private IntMap wireTypes;

    public ProtoBuf(ProtoBufType protobuftype)
    {
        cachedSize = 0x80000000;
        msgType = protobuftype;
    }

    private void addObject(int i, Object obj)
    {
        insertObject(i, 0, obj, true);
    }

    private void assertTypeMatch(int i, Object obj)
    {
    }

    private static void checkTag(int i)
    {
    }

    private Object convert(Object obj, int i, int j)
    {
        i;
        JVM INSTR tableswitch 16 36: default 100
    //                   16 117
    //                   17 100
    //                   18 100
    //                   19 166
    //                   20 100
    //                   21 166
    //                   22 166
    //                   23 166
    //                   24 110
    //                   25 198
    //                   26 280
    //                   27 280
    //                   28 259
    //                   29 100
    //                   30 100
    //                   31 166
    //                   32 166
    //                   33 166
    //                   34 166
    //                   35 198
    //                   36 259;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L3 _L3 _L3 _L4 _L5 _L6 _L6 _L7 _L1 _L1 _L3 _L3 _L3 _L3 _L5 _L7
_L1:
        throw new RuntimeException("Unsupp.Type");
_L4:
        if (!(obj instanceof Boolean)) goto _L8; else goto _L2
_L2:
        return obj;
_L8:
        switch ((int)((Long)obj).longValue())
        {
        default:
            throw new IllegalArgumentException("Type mismatch");

        case 0: // '\0'
            return FALSE;

        case 1: // '\001'
            return TRUE;
        }
_L3:
        if (!(obj instanceof Boolean)) goto _L2; else goto _L9
_L9:
        long l;
        if (((Boolean)obj).booleanValue())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        return Primitives.toLong(l);
_L5:
        if (obj instanceof String)
        {
            return IoUtil.encodeUtf8((String)obj);
        }
        if (!(obj instanceof ProtoBuf)) goto _L2; else goto _L10
_L10:
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            ((ProtoBuf)obj).outputTo(bytearrayoutputstream);
            obj = bytearrayoutputstream.toByteArray();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((IOException) (obj)).toString());
        }
        return obj;
_L7:
        if (!(obj instanceof byte[])) goto _L2; else goto _L11
_L11:
        obj = (byte[])obj;
        return IoUtil.decodeUtf8(((byte []) (obj)), 0, obj.length, true);
_L6:
        if (!(obj instanceof byte[])) goto _L2; else goto _L12
_L12:
        if (j <= 0) goto _L14; else goto _L13
_L13:
        if (msgType == null) goto _L14; else goto _L15
_L15:
        ProtoBuf protobuf = new ProtoBuf((ProtoBufType)msgType.getData(j));
_L17:
        return protobuf.parse((byte[])obj);
_L14:
        protobuf = new ProtoBuf(null);
        if (true) goto _L17; else goto _L16
_L16:
        obj;
        throw new RuntimeException(((IOException) (obj)).toString());
    }

    private int getCachedDataSize(int i, int j, boolean flag)
    {
        int k = getVarIntSize(i << 3);
        switch (getWireType(i))
        {
        case 2: // '\002'
        case 4: // '\004'
        default:
            Object obj = getObject(i, j, 16);
            long l;
            long l1;
            if (obj instanceof byte[])
            {
                i = ((byte[])obj).length;
            } else
            if (obj instanceof String)
            {
                i = IoUtil.encodeUtf8((String)obj, null, 0);
            } else
            {
                i = ((ProtoBuf)obj).getCachedDataSize(flag);
            }
            return i + (getVarIntSize(i) + k);

        case 5: // '\005'
            return k + 4;

        case 1: // '\001'
            return k + 8;

        case 0: // '\0'
            l1 = getLong(i, j);
            l = l1;
            if (isZigZagEncodedType(i))
            {
                l = zigZagEncode(l1);
            }
            return getVarIntSize(l) + k;

        case 3: // '\003'
            return getProtoBuf(i, j).getCachedDataSize(flag) + k + k;
        }
    }

    private int getCachedDataSize(boolean flag)
    {
        int j;
        if (cachedSize != 0x80000000 && flag)
        {
            return cachedSize;
        }
        com.google.userfeedback.android.api.common.util.IntMap.KeyIterator keyiterator = values.keys();
        j = 0;
        do
        {
label0:
            {
                if (!keyiterator.hasNext())
                {
                    break label0;
                }
                int l = keyiterator.next();
                int i1 = getCount(l);
                int k = 0;
                int i = j;
                do
                {
                    j = i;
                    if (k >= i1)
                    {
                        break;
                    }
                    j = getCachedDataSize(l, k, flag);
                    k++;
                    i = j + i;
                } while (true);
            }
        } while (true);
        cachedSize = j;
        return cachedSize;
    }

    private static int getCount(Object obj)
    {
        if (obj == null)
        {
            return 0;
        }
        if (obj instanceof Vector)
        {
            return ((Vector)obj).size();
        } else
        {
            return 1;
        }
    }

    private Object getDefault(int i)
    {
        switch (getType(i))
        {
        default:
            return msgType.getData(i);

        case 16: // '\020'
        case 26: // '\032'
        case 27: // '\033'
            return null;
        }
    }

    private static int getNumBytesUsed(Object obj)
    {
        if (obj != null)
        {
            if (obj instanceof String)
            {
                return ((String)obj).length();
            }
            if (obj instanceof Vector)
            {
                int i = 0;
                int j = 0;
                for (; i < ((Vector)obj).size(); i++)
                {
                    j += getNumBytesUsed(((Vector)obj).elementAt(i));
                }

                return j;
            }
            if (obj instanceof ProtoBuf)
            {
                return ((ProtoBuf)obj).getNumBytesUsed();
            }
            if (obj instanceof byte[])
            {
                return ((byte[])obj).length;
            }
            if (obj instanceof Long)
            {
                return 8;
            }
            if (obj instanceof Boolean)
            {
                return 1;
            }
        }
        return 0;
    }

    private Object getObject(int i, int j)
    {
        checkTag(i);
        Object obj = values.get(i);
        int k = getCount(obj);
        if (k == 0)
        {
            return getDefault(i);
        }
        if (k > 1)
        {
            throw new IllegalArgumentException();
        } else
        {
            return getObjectWithoutArgChecking(i, 0, j, obj);
        }
    }

    private Object getObject(int i, int j, int k)
    {
        checkTag(i);
        Object obj = values.get(i);
        if (j >= getCount(obj))
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return getObjectWithoutArgChecking(i, j, k, obj);
        }
    }

    private Object getObjectWithoutArgChecking(int i, int j, int k, Object obj)
    {
label0:
        {
            Vector vector;
            Object obj1;
            if (obj instanceof Vector)
            {
                vector = (Vector)obj;
                obj = vector.elementAt(j);
            } else
            {
                vector = null;
            }
            obj1 = convert(obj, k, i);
            if (obj1 != obj && obj != null)
            {
                if (vector != null)
                {
                    break label0;
                }
                setObject(i, obj1);
            }
            return obj1;
        }
        vector.setElementAt(obj1, j);
        return obj1;
    }

    private static int getVarIntSize(long l)
    {
        if (l >= 0L) goto _L2; else goto _L1
_L1:
        int j = 10;
_L4:
        return j;
_L2:
        int i = 1;
        do
        {
            j = i;
            if (l < 128L)
            {
                continue;
            }
            i++;
            l >>= 7;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private final int getWireType(int i)
    {
        int k = getType(i);
        int j = k;
        switch (k)
        {
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            String s = String.valueOf("Unsupp.Type:");
            String s1 = String.valueOf(msgType);
            throw new RuntimeException((new StringBuilder(String.valueOf(s).length() + 24 + String.valueOf(s1).length())).append(s).append(s1).append("/").append(i).append("/").append(k).toString());

        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 24: // '\030'
        case 29: // '\035'
        case 30: // '\036'
        case 33: // '!'
        case 34: // '"'
            j = 0;
            // fall through

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 16: // '\020'
            return j;

        case 25: // '\031'
        case 27: // '\033'
        case 28: // '\034'
        case 35: // '#'
        case 36: // '$'
            return 2;

        case 17: // '\021'
        case 22: // '\026'
        case 32: // ' '
            return 1;

        case 18: // '\022'
        case 23: // '\027'
        case 31: // '\037'
            return 5;

        case 26: // '\032'
            return 3;
        }
    }

    private void insertObject(int i, int j, Object obj)
    {
        insertObject(i, j, obj, false);
    }

    private void insertObject(int i, int j, Object obj, boolean flag)
    {
        checkTag(i);
        Object obj1 = values.get(i);
        Vector vector = null;
        if (obj1 instanceof Vector)
        {
            vector = (Vector)obj1;
        }
        if (obj1 == null || vector != null && vector.size() == 0)
        {
            setObject(i, obj);
            return;
        }
        assertTypeMatch(i, obj);
        Vector vector1 = vector;
        if (vector == null)
        {
            vector1 = new Vector();
            vector1.addElement(obj1);
            values.put(i, vector1);
        }
        if (flag)
        {
            vector1.addElement(obj);
            return;
        } else
        {
            vector1.insertElementAt(obj, j);
            return;
        }
    }

    private boolean isZigZagEncodedType(int i)
    {
        i = getType(i);
        return i == 33 || i == 34;
    }

    private int outputField(int i, MarkedOutputStream markedoutputstream)
    {
        int l;
        int i1;
        int j1;
        int k1;
        j1 = getCount(i);
        k1 = getWireType(i);
        i1 = 0;
        l = 0;
_L7:
        int j;
        int l1;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        j = l + writeVarInt(markedoutputstream, i << 3 | k1);
        l1 = markedoutputstream.availableContent();
        k1;
        JVM INSTR tableswitch 0 5: default 88
    //                   0 199
    //                   1 96
    //                   2 248
    //                   3 367
    //                   4 88
    //                   5 96;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L3
_L5:
        break MISSING_BLOCK_LABEL_367;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException();
_L3:
        int k;
        long l2 = ((Long)getObject(i, i1, 19)).longValue();
        if (k1 == 5)
        {
            k = 4;
        } else
        {
            k = 8;
        }
        for (l = 0; l < k; l++)
        {
            markedoutputstream.write((int)(255L & l2));
            l2 >>= 8;
        }

        k = 0;
_L8:
        l = j;
        if (k == 0)
        {
            l = j + (markedoutputstream.availableContent() - l1);
        }
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
        long l4 = ((Long)getObject(i, i1, 19)).longValue();
        long l3 = l4;
        if (isZigZagEncodedType(i))
        {
            l3 = zigZagEncode(l4);
        }
        writeVarInt(markedoutputstream, l3);
        k = 0;
          goto _L8
_L4:
        byte abyte0[];
        if (getType(i) == 27)
        {
            k = 16;
        } else
        {
            k = 25;
        }
        abyte0 = ((byte []) (getObject(i, i1, k)));
        if (abyte0 instanceof byte[])
        {
            abyte0 = (byte[])abyte0;
            writeVarInt(markedoutputstream, abyte0.length);
            markedoutputstream.write(abyte0);
            k = 0;
        } else
        {
            markedoutputstream.addMarker(markedoutputstream.availableContent());
            k = markedoutputstream.numMarkers();
            markedoutputstream.addMarker(-1);
            l = ((ProtoBuf)abyte0).outputToInternal(markedoutputstream);
            markedoutputstream.setMarker(k, l);
            j += l + getVarIntSize(l);
            k = 1;
        }
          goto _L8
        k = ((ProtoBuf)getObject(i, i1, 26)).outputToInternal(markedoutputstream);
        j = writeVarInt(markedoutputstream, i << 3 | 4) + (k + j);
        k = 1;
          goto _L8
        return l;
    }

    private void outputTo(OutputStream outputstream, boolean flag)
    {
        int k = 0;
        MarkedOutputStream markedoutputstream = new MarkedOutputStream();
        int i = outputToInternal(markedoutputstream);
        if (flag)
        {
            ((DataOutput)outputstream).writeInt(i);
        }
        int i1 = markedoutputstream.numMarkers();
        for (int j = 0; j < i1;)
        {
            int l = markedoutputstream.getMarker(j);
            markedoutputstream.writeContentsTo(outputstream, k, l - k);
            writeVarInt(outputstream, markedoutputstream.getMarker(j + 1));
            j += 2;
            k = l;
        }

        if (k < markedoutputstream.availableContent())
        {
            markedoutputstream.writeContentsTo(outputstream, k, markedoutputstream.availableContent() - k);
        }
    }

    private int outputToInternal(MarkedOutputStream markedoutputstream)
    {
        com.google.userfeedback.android.api.common.util.IntMap.KeyIterator keyiterator = values.keys();
        int i;
        for (i = 0; keyiterator.hasNext(); i += outputField(keyiterator.next(), markedoutputstream)) { }
        return i;
    }

    private int parseInternal(InputStream inputstream, int i, boolean flag, SimpleCounter simplecounter)
    {
        if (flag)
        {
            clear();
        }
_L7:
        int j;
        int j1;
        j = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        long l1 = readVarInt(inputstream, true, simplecounter);
        j = i;
        if (l1 == -1L)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        j = i - simplecounter.count;
        i = (int)l1 & 7;
        if (i == 4)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        j1 = (int)(l1 >>> 3);
        if (getType(j1) == 16)
        {
            if (wireTypes == null)
            {
                wireTypes = new IntMap();
            }
            wireTypes.put(j1, Primitives.toInteger(i));
        }
        i;
        JVM INSTR tableswitch 0 5: default 144
    //                   0 180
    //                   1 238
    //                   2 311
    //                   3 407
    //                   4 144
    //                   5 238;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IOException((new StringBuilder(52)).append("Unknown wire type ").append(i).append(", reading garbage data?").toString());
_L2:
        Object obj;
        long l4 = readVarInt(inputstream, false, simplecounter);
        i = simplecounter.count;
        long l2 = l4;
        if (isZigZagEncodedType(j1))
        {
            l2 = zigZagDecode(l4);
        }
        obj = Primitives.toLong(l2);
        i = j - i;
_L8:
        addObject(j1, obj);
        if (true) goto _L7; else goto _L6
_L6:
        long l3 = 0L;
        boolean flag1 = false;
        int l;
        if (i == 5)
        {
            i = 4;
        } else
        {
            i = 8;
        }
        l = j - i;
        j = ((flag1) ? 1 : 0);
        for (; i > 0; i--)
        {
            l3 |= (long)inputstream.read() << j;
            j += 8;
        }

        obj = Primitives.toLong(l3);
        i = l;
          goto _L8
_L4:
        int i1 = (int)readVarInt(inputstream, false, simplecounter);
        int k = j - simplecounter.count - i1;
        byte abyte0[];
        if (i1 == 0)
        {
            abyte0 = EMPTY_BYTE_ARRAY;
        } else
        {
            abyte0 = new byte[i1];
        }
        j = 0;
        obj = abyte0;
        i = k;
        if (j >= i1) goto _L8; else goto _L9
_L9:
        i = inputstream.read(abyte0, j, i1 - j);
        if (i <= 0)
        {
            throw new IOException("Unexp.EOF");
        }
        j += i;
        break MISSING_BLOCK_LABEL_347;
_L5:
        if (msgType == null)
        {
            obj = null;
        } else
        {
            obj = (ProtoBufType)msgType.getData(j1);
        }
        obj = new ProtoBuf(((ProtoBufType) (obj)));
        i = ((ProtoBuf) (obj)).parseInternal(inputstream, j, false, simplecounter);
          goto _L8
        if (j < 0)
        {
            throw new IOException();
        }
        return j;
          goto _L8
    }

    static long readVarInt(InputStream inputstream, boolean flag)
    {
        return readVarInt(inputstream, flag, NULL_COUNTER);
    }

    private static long readVarInt(InputStream inputstream, boolean flag, SimpleCounter simplecounter)
    {
        simplecounter.count = 0;
        long l = 0L;
        int i = 0;
        int j = 0;
        long l1;
        do
        {
            l1 = l;
            if (i >= 10)
            {
                break;
            }
            int k = inputstream.read();
            if (k == -1)
            {
                if (i == 0 && flag)
                {
                    return -1L;
                } else
                {
                    throw new IOException("EOF");
                }
            }
            l |= (long)(k & 0x7f) << j;
            l1 = l;
            if ((k & 0x80) == 0)
            {
                break;
            }
            j += 7;
            i++;
        } while (true);
        simplecounter.count = i + 1;
        return l1;
    }

    private void setObject(int i, int j, Object obj)
    {
        if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (obj != null)
        {
            assertTypeMatch(i, obj);
        }
        if (j < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj1 = values.get(i);
        if (obj1 instanceof Vector)
        {
            obj1 = (Vector)obj1;
            if (j == ((Vector) (obj1)).size())
            {
                ((Vector) (obj1)).addElement(obj);
                return;
            } else
            {
                ((Vector) (obj1)).setElementAt(obj, j);
                return;
            }
        }
        if (obj1 == null)
        {
            if (j > 0)
            {
                throw new ArrayIndexOutOfBoundsException();
            } else
            {
                setObject(i, obj);
                return;
            }
        }
        Vector vector;
        switch (j)
        {
        default:
            throw new ArrayIndexOutOfBoundsException();

        case 0: // '\0'
            setObject(i, obj);
            return;

        case 1: // '\001'
            vector = new Vector();
            break;
        }
        vector.addElement(obj1);
        vector.addElement(obj);
        values.put(i, vector);
    }

    private void setObject(int i, Object obj)
    {
        if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (obj != null)
        {
            assertTypeMatch(i, obj);
        }
        values.put(i, obj);
    }

    static int writeVarInt(OutputStream outputstream, long l)
    {
        int i = 0;
        do
        {
            int j;
label0:
            {
                j = i;
                if (i < 10)
                {
                    j = (int)(127L & l);
                    l >>>= 7;
                    if (l != 0L)
                    {
                        break label0;
                    }
                    outputstream.write(j);
                    j = i + 1;
                }
                return j;
            }
            outputstream.write(j | 0x80);
            i++;
        } while (true);
    }

    private static long zigZagDecode(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    private static long zigZagEncode(long l)
    {
        return l << 1 ^ -(l >>> 63);
    }

    public void addBool(int i, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = TRUE;
        } else
        {
            boolean1 = FALSE;
        }
        addObject(i, boolean1);
    }

    public void addBytes(int i, byte abyte0[])
    {
        addObject(i, abyte0);
    }

    public void addDouble(int i, double d)
    {
        setLong(i, Double.doubleToLongBits(d));
    }

    public void addFloat(int i, float f)
    {
        setInt(i, Float.floatToIntBits(f));
    }

    public void addInt(int i, int j)
    {
        addLong(i, j);
    }

    public void addLong(int i, long l)
    {
        addObject(i, Primitives.toLong(l));
    }

    public void addProtoBuf(int i, ProtoBuf protobuf)
    {
        addObject(i, protobuf);
    }

    public void addString(int i, String s)
    {
        addObject(i, s);
    }

    public void clear()
    {
        values.clear();
        wireTypes = null;
    }

    public ProtoBuf createGroup(int i)
    {
        return new ProtoBuf((ProtoBufType)getType().getData(i));
    }

    public boolean getBool(int i)
    {
        return ((Boolean)getObject(i, 24)).booleanValue();
    }

    public boolean getBool(int i, int j)
    {
        return ((Boolean)getObject(i, j, 24)).booleanValue();
    }

    public byte[] getBytes(int i)
    {
        return (byte[])getObject(i, 25);
    }

    public byte[] getBytes(int i, int j)
    {
        return (byte[])getObject(i, j, 25);
    }

    public int getCount(int i)
    {
        return getCount(values.get(i));
    }

    public int getDataSize()
    {
        return getCachedDataSize(false);
    }

    public double getDouble(int i)
    {
        return Double.longBitsToDouble(getLong(i));
    }

    public double getDouble(int i, int j)
    {
        return Double.longBitsToDouble(getLong(i, j));
    }

    public float getFloat(int i)
    {
        return Float.intBitsToFloat(getInt(i));
    }

    public float getFloat(int i, int j)
    {
        return Float.intBitsToFloat(getInt(i, j));
    }

    public int getInt(int i)
    {
        return (int)((Long)getObject(i, 21)).longValue();
    }

    public int getInt(int i, int j)
    {
        return (int)((Long)getObject(i, j, 21)).longValue();
    }

    public long getLong(int i)
    {
        return ((Long)getObject(i, 19)).longValue();
    }

    public long getLong(int i, int j)
    {
        return ((Long)getObject(i, j, 19)).longValue();
    }

    public int getNumBytesUsed()
    {
        int i = values.getNumBytesOverhead();
        for (com.google.userfeedback.android.api.common.util.IntMap.KeyIterator keyiterator = values.keys(); keyiterator.hasNext();)
        {
            int j = keyiterator.next();
            i += getNumBytesUsed(values.get(j));
        }

        return i;
    }

    public ProtoBuf getProtoBuf(int i)
    {
        return (ProtoBuf)getObject(i, 26);
    }

    public ProtoBuf getProtoBuf(int i, int j)
    {
        return (ProtoBuf)getObject(i, j, 26);
    }

    public String getString(int i)
    {
        return (String)getObject(i, 28);
    }

    public String getString(int i, int j)
    {
        return (String)getObject(i, j, 28);
    }

    public int getType(int i)
    {
label0:
        {
            int j;
            if (msgType != null)
            {
                j = msgType.getType(i);
            } else
            {
                j = 16;
            }
            if (j == 16)
            {
                Object obj;
                int k;
                if (wireTypes != null)
                {
                    obj = (Integer)wireTypes.get(i);
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    j = ((Integer) (obj)).intValue();
                }
            }
            k = j;
            if (j == 16)
            {
                k = j;
                if (getCount(i) > 0)
                {
                    obj = getObject(i, 0, 16);
                    if (!(obj instanceof Long) && !(obj instanceof Boolean))
                    {
                        break label0;
                    }
                    k = 0;
                }
            }
            return k;
        }
        return 2;
    }

    public ProtoBufType getType()
    {
        return msgType;
    }

    public boolean has(int i)
    {
        return getCount(i) > 0 || getDefault(i) != null;
    }

    public void insertBool(int i, int j, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = TRUE;
        } else
        {
            boolean1 = FALSE;
        }
        insertObject(i, j, boolean1);
    }

    public void insertBytes(int i, int j, byte abyte0[])
    {
        insertObject(i, j, abyte0);
    }

    public void insertDouble(int i, int j, double d)
    {
        insertLong(i, j, Double.doubleToLongBits(d));
    }

    public void insertFloat(int i, int j, float f)
    {
        insertInt(i, j, Float.floatToIntBits(f));
    }

    public void insertInt(int i, int j, int k)
    {
        insertLong(i, j, k);
    }

    public void insertLong(int i, int j, long l)
    {
        insertObject(i, j, Primitives.toLong(l));
    }

    public void insertProtoBuf(int i, int j, ProtoBuf protobuf)
    {
        insertObject(i, j, protobuf);
    }

    public void insertString(int i, int j, String s)
    {
        insertObject(i, j, s);
    }

    public boolean isValid()
    {
        return msgType == null || msgType.isValidProto(this);
    }

    public int maxTag()
    {
        return values.maxKey();
    }

    public void outputTo(OutputStream outputstream)
    {
        outputTo(outputstream, false);
    }

    public void outputWithSizeTo(OutputStream outputstream)
    {
        outputTo(outputstream, true);
    }

    public int parse(InputStream inputstream, int i)
    {
        return parseInternal(inputstream, i, true, new SimpleCounter(null));
    }

    public ProtoBuf parse(InputStream inputstream)
    {
        parse(inputstream, 0x7fffffff);
        return this;
    }

    public ProtoBuf parse(byte abyte0[])
    {
        parse(((InputStream) (new ByteArrayInputStream(abyte0))), abyte0.length);
        return this;
    }

    public void remove(int i, int j)
    {
        int k = getCount(i);
        if (j >= k)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (k == 1)
        {
            values.remove(i);
            return;
        } else
        {
            ((Vector)values.get(i)).removeElementAt(j);
            return;
        }
    }

    public void setBool(int i, int j, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = TRUE;
        } else
        {
            boolean1 = FALSE;
        }
        setObject(i, j, boolean1);
    }

    public void setBool(int i, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = TRUE;
        } else
        {
            boolean1 = FALSE;
        }
        setObject(i, boolean1);
    }

    public void setBytes(int i, int j, byte abyte0[])
    {
        setObject(i, j, abyte0);
    }

    public void setBytes(int i, byte abyte0[])
    {
        setObject(i, abyte0);
    }

    public void setDouble(int i, double d)
    {
        setLong(i, Double.doubleToLongBits(d));
    }

    public void setDouble(int i, int j, double d)
    {
        setLong(i, j, Double.doubleToLongBits(d));
    }

    public void setFloat(int i, float f)
    {
        setInt(i, Float.floatToIntBits(f));
    }

    public void setFloat(int i, int j, float f)
    {
        setInt(i, j, Float.floatToIntBits(f));
    }

    public void setInt(int i, int j)
    {
        setLong(i, j);
    }

    public void setInt(int i, int j, int k)
    {
        setLong(i, j, k);
    }

    public void setLong(int i, int j, long l)
    {
        setObject(i, j, Primitives.toLong(l));
    }

    public void setLong(int i, long l)
    {
        setObject(i, Primitives.toLong(l));
    }

    public void setProtoBuf(int i, int j, ProtoBuf protobuf)
    {
        setObject(i, j, protobuf);
    }

    public void setProtoBuf(int i, ProtoBuf protobuf)
    {
        setObject(i, protobuf);
    }

    public void setString(int i, int j, String s)
    {
        setObject(i, j, s);
    }

    public void setString(int i, String s)
    {
        setObject(i, s);
    }

    void setType(ProtoBufType protobuftype)
    {
        if (!values.isEmpty() || msgType != null && protobuftype != null && protobuftype != msgType)
        {
            throw new IllegalArgumentException();
        } else
        {
            msgType = protobuftype;
            wireTypes = null;
            return;
        }
    }

    public byte[] toByteArray()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        outputTo(bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }


    private class SimpleCounter
    {

        public int count;

        private SimpleCounter()
        {
            count = 0;
        }

        SimpleCounter(_cls1 _pcls1)
        {
            this();
        }
    }

}
