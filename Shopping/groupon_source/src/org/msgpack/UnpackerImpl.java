// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.msgpack.object.ArrayType;
import org.msgpack.object.BooleanType;
import org.msgpack.object.FloatType;
import org.msgpack.object.IntegerType;
import org.msgpack.object.MapType;
import org.msgpack.object.NilType;
import org.msgpack.object.RawType;

// Referenced classes of package org.msgpack:
//            UnpackException, MessagePackObject

public class UnpackerImpl
{

    private ByteBuffer castBuffer;
    private int cs;
    private MessagePackObject data;
    private boolean finished;
    private int stack_count[];
    private int stack_ct[];
    private Object stack_obj[];
    private int top;
    private int top_count;
    private int top_ct;
    private Object top_obj;
    private int trail;

    public UnpackerImpl()
    {
        stack_ct = new int[32];
        stack_count = new int[32];
        stack_obj = new Object[32];
        castBuffer = ByteBuffer.allocate(8);
        finished = false;
        data = null;
        reset();
    }

    public final int execute(byte abyte0[], int i, int j)
        throws UnpackException
    {
        if (i >= j)
        {
            return i;
        }
_L33:
        int k;
        int l;
        l = abyte0[i];
        k = i;
        if (cs != 0) goto _L2; else goto _L1
_L1:
        Object obj;
        if ((l & 0x80) == 0)
        {
            obj = IntegerType.create((byte)l);
        } else
        {
label0:
            {
                if ((l & 0xe0) != 224)
                {
                    break label0;
                }
                obj = IntegerType.create((byte)l);
            }
        }
_L7:
        if (top != -1) goto _L4; else goto _L3
_L3:
        i++;
        data = (MessagePackObject)obj;
        finished = true;
_L9:
        return i;
        if ((l & 0xe0) != 160) goto _L6; else goto _L5
_L5:
label1:
        {
            trail = l & 0x1f;
            if (trail != 0)
            {
                break label1;
            }
            obj = RawType.create(new byte[0]);
        }
          goto _L7
        cs = 32;
        k = i;
_L2:
        i = k;
        if (j - k <= trail) goto _L9; else goto _L8
_L8:
        l = k + 1;
        i = k + trail;
        cs;
        JVM INSTR tableswitch 10 32: default 276
    //                   10 822
    //                   11 858
    //                   12 895
    //                   13 912
    //                   14 951
    //                   15 992
    //                   16 1063
    //                   17 1075
    //                   18 1111
    //                   19 1147
    //                   20 276
    //                   21 276
    //                   22 276
    //                   23 276
    //                   24 276
    //                   25 276
    //                   26 1184
    //                   27 1249
    //                   28 1345
    //                   29 1497
    //                   30 1649
    //                   31 1803
    //                   32 1314;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L10 _L10 _L10 _L10 _L10 _L10 _L21 _L22 _L23 _L24 _L25 _L26 _L27
_L10:
        throw new UnpackException("parse error");
_L6:
        if ((l & 0xf0) != 144) goto _L29; else goto _L28
_L28:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        k = l & 0xf;
        obj = new MessagePackObject[k];
        if (k != 0) goto _L31; else goto _L30
_L30:
        obj = ArrayType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L31:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 0;
        top_count = k;
        k = i;
_L38:
        cs = 0;
        k++;
        i = k;
        if (k < j) goto _L33; else goto _L32
_L32:
        i = k;
          goto _L9
_L29:
        if ((l & 0xf0) != 128) goto _L35; else goto _L34
_L34:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        k = l & 0xf;
        obj = new MessagePackObject[k * 2];
        if (k != 0) goto _L37; else goto _L36
_L36:
        obj = MapType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L37:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 1;
        top_count = k;
        k = i;
          goto _L38
_L35:
        l & 0xff;
        JVM INSTR tableswitch 192 223: default 736
    //                   192 746
    //                   193 736
    //                   194 754
    //                   195 763
    //                   196 736
    //                   197 736
    //                   198 736
    //                   199 736
    //                   200 736
    //                   201 736
    //                   202 772
    //                   203 772
    //                   204 772
    //                   205 772
    //                   206 772
    //                   207 772
    //                   208 772
    //                   209 772
    //                   210 772
    //                   211 772
    //                   212 736
    //                   213 736
    //                   214 736
    //                   215 736
    //                   216 736
    //                   217 736
    //                   218 797
    //                   219 797
    //                   220 797
    //                   221 797
    //                   222 797
    //                   223 797;
           goto _L39 _L40 _L39 _L41 _L42 _L39 _L39 _L39 _L39 _L39 _L39 _L43 _L43 _L43 _L43 _L43 _L43 _L43 _L43 _L43 _L43 _L39 _L39 _L39 _L39 _L39 _L39 _L44 _L44 _L44 _L44 _L44 _L44
_L39:
        throw new UnpackException("parse error");
_L40:
        obj = NilType.create();
          goto _L7
_L41:
        obj = BooleanType.create(false);
          goto _L7
_L42:
        obj = BooleanType.create(true);
          goto _L7
_L43:
        trail = 1 << (l & 3);
        cs = l & 0x1f;
        k = i;
          goto _L2
_L44:
        trail = 2 << (l & 1);
        cs = l & 0x1f;
        k = i;
          goto _L2
_L11:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        obj = FloatType.create(castBuffer.getFloat(0));
          goto _L7
_L12:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 8);
        obj = FloatType.create(castBuffer.getDouble(0));
          goto _L7
_L13:
        obj = IntegerType.create((short)(abyte0[l] & 0xff));
          goto _L7
_L14:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 2);
        obj = IntegerType.create(castBuffer.getShort(0) & 0xffff);
          goto _L7
_L15:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        obj = IntegerType.create((long)castBuffer.getInt(0) & 0xffffffffL);
          goto _L7
_L16:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 8);
        long l1 = castBuffer.getLong(0);
        if (l1 < 0L)
        {
            obj = IntegerType.create(new BigInteger(1, castBuffer.array()));
        } else
        {
            obj = IntegerType.create(l1);
        }
          goto _L7
_L17:
        obj = IntegerType.create(abyte0[l]);
          goto _L7
_L18:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 2);
        obj = IntegerType.create(castBuffer.getShort(0));
          goto _L7
_L19:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        obj = IntegerType.create(castBuffer.getInt(0));
          goto _L7
_L20:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 8);
        obj = IntegerType.create(castBuffer.getLong(0));
          goto _L7
_L21:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 2);
        trail = castBuffer.getShort(0) & 0xffff;
        if (trail != 0) goto _L46; else goto _L45
_L45:
        obj = RawType.create(new byte[0]);
          goto _L7
_L46:
        cs = 32;
        k = i;
          goto _L2
_L22:
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        trail = castBuffer.getInt(0) & 0x7fffffff;
        if (trail != 0) goto _L48; else goto _L47
_L47:
        obj = RawType.create(new byte[0]);
          goto _L7
_L48:
        cs = 32;
        k = i;
          goto _L2
_L27:
        obj = new byte[trail];
        System.arraycopy(abyte0, l, obj, 0, trail);
        obj = RawType.create(((byte []) (obj)));
          goto _L7
_L23:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 2);
        k = castBuffer.getShort(0) & 0xffff;
        obj = new MessagePackObject[k];
        if (k != 0) goto _L50; else goto _L49
_L49:
        obj = ArrayType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L50:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 0;
        top_count = k;
        k = i;
          goto _L38
_L24:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        k = castBuffer.getInt(0) & 0x7fffffff;
        obj = new MessagePackObject[k];
        if (k != 0) goto _L52; else goto _L51
_L51:
        obj = ArrayType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L52:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 0;
        top_count = k;
        k = i;
          goto _L38
_L25:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 2);
        k = castBuffer.getShort(0) & 0xffff;
        obj = new MessagePackObject[k * 2];
        if (k != 0) goto _L54; else goto _L53
_L53:
        obj = MapType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L54:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 1;
        top_count = k;
        k = i;
          goto _L38
_L26:
        if (top >= 32)
        {
            throw new UnpackException("parse error");
        }
        castBuffer.rewind();
        castBuffer.put(abyte0, l, 4);
        k = castBuffer.getInt(0) & 0x7fffffff;
        obj = new MessagePackObject[k * 2];
        if (k != 0) goto _L56; else goto _L55
_L55:
        obj = MapType.create((MessagePackObject[])(MessagePackObject[])obj);
          goto _L7
_L56:
        top = top + 1;
        stack_obj[top] = top_obj;
        stack_ct[top] = top_ct;
        stack_count[top] = top_count;
        top_obj = obj;
        top_ct = 1;
        top_count = k;
        k = i;
          goto _L38
_L4:
        top_ct;
        JVM INSTR tableswitch 0 2: default 1988
    //                   0 1998
    //                   1 2120
    //                   2 2158;
           goto _L57 _L58 _L59 _L60
_L57:
        throw new UnpackException("parse error");
_L58:
        Object aobj[];
        aobj = (Object[])(Object[])top_obj;
        aobj[aobj.length - top_count] = obj;
        l = top_count - 1;
        top_count = l;
        k = i;
        if (l != 0) goto _L38; else goto _L61
_L61:
        top_obj = stack_obj[top];
        top_ct = stack_ct[top];
        top_count = stack_count[top];
        obj = ArrayType.create((MessagePackObject[])(MessagePackObject[])aobj);
        stack_obj[top] = null;
        top = top - 1;
          goto _L7
_L59:
        aobj = (Object[])(Object[])top_obj;
        aobj[aobj.length - top_count * 2] = obj;
        top_ct = 2;
        k = i;
          goto _L38
_L60:
        aobj = (Object[])(Object[])top_obj;
        aobj[(aobj.length - top_count * 2) + 1] = obj;
        k = top_count - 1;
        top_count = k;
        if (k != 0) goto _L63; else goto _L62
_L62:
        top_obj = stack_obj[top];
        top_ct = stack_ct[top];
        top_count = stack_count[top];
        obj = MapType.create((MessagePackObject[])(MessagePackObject[])aobj);
        stack_obj[top] = null;
        top = top - 1;
          goto _L7
_L63:
        top_ct = 1;
        k = i;
          goto _L38
    }

    public final MessagePackObject getData()
    {
        return data;
    }

    public final boolean isFinished()
    {
        return finished;
    }

    public final void reset()
    {
        resetState();
        finished = false;
        data = null;
    }

    public final void resetState()
    {
        cs = 0;
        top = -1;
        top_ct = 0;
        top_count = 0;
        top_obj = null;
    }
}
