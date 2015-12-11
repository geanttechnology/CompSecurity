// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.packer.Packer;
import com.twinprime.msgpack.type.ArrayValue;
import com.twinprime.msgpack.type.FloatValue;
import com.twinprime.msgpack.type.IntegerValue;
import com.twinprime.msgpack.type.MapValue;
import com.twinprime.msgpack.type.RawValue;
import com.twinprime.msgpack.type.Value;
import com.twinprime.msgpack.type.ValueType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog

class JNILibrary
{

    private static final MessagePack msgpack = new MessagePack();

    static byte[] encodeMessage(Hashtable hashtable, int i, boolean flag)
    {
        Object obj = null;
        ByteArrayOutputStream bytearrayoutputstream;
        ByteArrayOutputStream bytearrayoutputstream1;
        Packer packer;
        Iterator iterator;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream1 = new ByteArrayOutputStream();
        packer = msgpack.createPacker(bytearrayoutputstream1);
        packer.writeMapBegin(hashtable.size());
        iterator = hashtable.keySet().iterator();
        int j = 0;
_L2:
        if (j >= hashtable.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Number number = (Number)iterator.next();
        packer.write(number);
        packer.write(hashtable.get(number));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        packer.writeMapEnd();
        if (TPLog.LOG13.isLoggable("JNILibrary"))
        {
            Log.d("JNILibrary", (new StringBuilder()).append("body byte[] len: ").append(bytearrayoutputstream1.toByteArray().length).toString());
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        bytearrayoutputstream.write(getHeader(i, bytearrayoutputstream1.toByteArray().length));
        bytearrayoutputstream.write(bytearrayoutputstream1.toByteArray());
        hashtable = bytearrayoutputstream.toByteArray();
_L4:
        return hashtable;
        Object obj1;
        obj1;
        hashtable = obj;
        if (TPLog.LOG10.isLoggable("JNILibrary"))
        {
            Log.e("JNILibrary", "Exception while getting msgpack: IOException");
            ((IOException) (obj1)).printStackTrace();
            return null;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        hashtable = obj;
        if (TPLog.LOG10.isLoggable("JNILibrary"))
        {
            Log.e("JNILibrary", "Exception while getting msgpack: NumberFormatException");
            ((NumberFormatException) (obj1)).printStackTrace();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static byte[] encodeMessage(byte abyte0[], int i, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (TPLog.LOG10.isLoggable("JNILibrary"))
            {
                Log.e("JNILibrary", "Exception while getting msgpack: IOException");
                abyte0.printStackTrace();
            }
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        bytearrayoutputstream.write(getHeader(i, abyte0.length));
        bytearrayoutputstream.write(abyte0);
        abyte0 = bytearrayoutputstream.toByteArray();
        return abyte0;
    }

    static byte[] encodeMessage(long al[], int i)
    {
        Object obj = null;
        ByteArrayOutputStream bytearrayoutputstream;
        ByteArrayOutputStream bytearrayoutputstream1;
        Packer packer;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream1 = new ByteArrayOutputStream();
        packer = msgpack.createPacker(bytearrayoutputstream1);
        packer.writeMapBegin(1);
        packer.write(0L);
        packer.writeArrayBegin(i);
        int j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        packer.writeMapBegin(4);
        packer.write(2L);
        packer.write((int)al[j * 4 + 2]);
        packer.write(0L);
        packer.write(al[j * 4 + 0]);
        packer.write(3L);
        packer.write(al[j * 4 + 3]);
        packer.write(1L);
        packer.write(al[j * 4 + 1]);
        packer.writeMapEnd();
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        packer.writeArrayEnd();
        packer.writeMapEnd();
        if (TPLog.LOG13.isLoggable("JNILibrary"))
        {
            Log.d("JNILibrary", (new StringBuilder()).append("body byte[] len: ").append(bytearrayoutputstream1.toByteArray().length).toString());
        }
        bytearrayoutputstream.write(getHeader(12, bytearrayoutputstream1.toByteArray().length));
        bytearrayoutputstream.write(bytearrayoutputstream1.toByteArray());
        al = bytearrayoutputstream.toByteArray();
_L4:
        return al;
        Object obj1;
        obj1;
        al = obj;
        if (TPLog.LOG10.isLoggable("JNILibrary"))
        {
            Log.e("JNILibrary", "Exception while getting msgpack: IOException");
            ((IOException) (obj1)).printStackTrace();
            return null;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        al = obj;
        if (TPLog.LOG10.isLoggable("JNILibrary"))
        {
            Log.e("JNILibrary", "Exception while getting msgpack: NumberFormatException");
            ((NumberFormatException) (obj1)).printStackTrace();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static byte[] getHeader(int i, int j)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(bytearrayoutputstream);
        packer.write(i);
        packer.write(j);
        if (TPLog.LOG13.isLoggable("JNILibrary"))
        {
            Log.d("JNILibrary", (new StringBuilder()).append("header byte[] len: ").append(bytearrayoutputstream.toByteArray().length).toString());
        }
        return bytearrayoutputstream.toByteArray();
    }

    static List listForArrayValue(ArrayValue arrayvalue)
    {
        ArrayList arraylist = new ArrayList();
        arrayvalue = arrayvalue.iterator();
        do
        {
            if (!arrayvalue.hasNext())
            {
                break;
            }
            Object obj = objectForValue((Value)arrayvalue.next());
            if (obj != null)
            {
                arraylist.add(obj);
            }
        } while (true);
        return arraylist;
    }

    static Hashtable mapForMapValue(MapValue mapvalue)
    {
        Hashtable hashtable = new Hashtable();
        Iterator iterator = mapvalue.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (Value)iterator.next();
            Object obj = objectForValue(((Value) (obj1)));
            if (obj != null)
            {
                obj1 = objectForValue((Value)mapvalue.get(obj1));
                if (obj1 != null)
                {
                    hashtable.put(obj, obj1);
                }
            }
        } while (true);
        return hashtable;
    }

    static Object objectForValue(Value value)
    {
        Object obj1 = null;
        if (value.getType() != ValueType.INTEGER) goto _L2; else goto _L1
_L1:
        Object obj = Long.valueOf(((IntegerValue)value.getValue()).getLong());
_L4:
        if (TPLog.LOG13.isLoggable("JNILibrary"))
        {
            Log.d("JNILibrary", (new StringBuilder()).append("Type: ").append(value.getType()).append(" Value: ").append(obj).toString());
        }
        return obj;
_L2:
        if (value.getType() == ValueType.FLOAT)
        {
            obj = Double.valueOf(((FloatValue)value.getValue()).getDouble());
        } else
        if (value.getType() == ValueType.RAW)
        {
            obj = ((RawValue)value.getValue()).getString();
        } else
        if (value.getType() == ValueType.MAP)
        {
            obj = mapForMapValue((MapValue)value.getValue());
        } else
        if (value.getType() == ValueType.ARRAY)
        {
            obj = listForArrayValue((ArrayValue)value.getValue());
        } else
        {
            obj = obj1;
            if (TPLog.LOG11.isLoggable("JNILibrary"))
            {
                Log.e("JNILibrary", (new StringBuilder()).append("Unknown value_type ").append(value.getType()).toString());
                obj = obj1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
