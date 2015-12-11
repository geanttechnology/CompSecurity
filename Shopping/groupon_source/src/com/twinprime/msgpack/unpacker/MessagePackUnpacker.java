// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.io.BufferReferer;
import com.twinprime.msgpack.io.StreamInput;
import com.twinprime.msgpack.packer.Unconverter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            AbstractUnpacker, UnpackerStack, IntAccept, LongAccept, 
//            BigIntegerAccept, MapAccept, ValueAccept, SkipAccept, 
//            Accept, SizeLimitException

public class MessagePackUnpacker extends AbstractUnpacker
{

    private final BigIntegerAccept bigIntegerAccept;
    private byte headByte;
    protected final StreamInput in;
    private final IntAccept intAccept;
    private final LongAccept longAccept;
    private final MapAccept mapAccept;
    private byte raw[];
    private int rawFilled;
    private final SkipAccept skipAccept;
    private final UnpackerStack stack;
    private final ValueAccept valueAccept;

    protected MessagePackUnpacker(MessagePack messagepack, StreamInput streaminput)
    {
        super(messagepack);
        stack = new UnpackerStack();
        headByte = -63;
        intAccept = new IntAccept();
        longAccept = new LongAccept();
        bigIntegerAccept = new BigIntegerAccept();
        mapAccept = new MapAccept();
        valueAccept = new ValueAccept();
        skipAccept = new SkipAccept();
        in = streaminput;
    }

    public MessagePackUnpacker(MessagePack messagepack, InputStream inputstream)
    {
        this(messagepack, new StreamInput(inputstream));
    }

    private byte getHeadByte()
        throws IOException
    {
        byte byte1 = headByte;
        byte byte0 = byte1;
        if (byte1 == -63)
        {
            byte0 = in.readByte();
            headByte = byte0;
        }
        return byte0;
    }

    private boolean readOneWithoutStackLarge(Accept accept, int i)
        throws IOException
    {
        switch (i & 0xff)
        {
        case 193: 
        case 199: 
        case 200: 
        case 201: 
        case 212: 
        case 213: 
        case 214: 
        case 215: 
        case 216: 
        default:
            headByte = -63;
            throw new IOException((new StringBuilder()).append("Invalid byte: ").append(i).toString());

        case 192: 
            accept.acceptNil();
            headByte = -63;
            return true;

        case 194: 
            accept.acceptBoolean(false);
            headByte = -63;
            return true;

        case 195: 
            accept.acceptBoolean(true);
            headByte = -63;
            return true;

        case 202: 
            accept.acceptFloat(in.getFloat());
            in.advance();
            headByte = -63;
            return true;

        case 203: 
            accept.acceptDouble(in.getDouble());
            in.advance();
            headByte = -63;
            return true;

        case 204: 
            accept.acceptUnsignedInteger(in.getByte());
            in.advance();
            headByte = -63;
            return true;

        case 205: 
            accept.acceptUnsignedInteger(in.getShort());
            in.advance();
            headByte = -63;
            return true;

        case 206: 
            accept.acceptUnsignedInteger(in.getInt());
            in.advance();
            headByte = -63;
            return true;

        case 207: 
            accept.acceptUnsignedInteger(in.getLong());
            in.advance();
            headByte = -63;
            return true;

        case 208: 
            accept.acceptInteger(in.getByte());
            in.advance();
            headByte = -63;
            return true;

        case 209: 
            accept.acceptInteger(in.getShort());
            in.advance();
            headByte = -63;
            return true;

        case 210: 
            accept.acceptInteger(in.getInt());
            in.advance();
            headByte = -63;
            return true;

        case 211: 
            accept.acceptInteger(in.getLong());
            in.advance();
            headByte = -63;
            return true;

        case 196: 
        case 217: 
            i = in.getByte();
            if (i == 0)
            {
                accept.acceptEmptyRaw();
                in.advance();
                headByte = -63;
                return true;
            }
            if (i >= rawSizeLimit)
            {
                throw new SizeLimitException(String.format("Size of raw (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(rawSizeLimit)
                }));
            }
            in.advance();
            if (!tryReferRawBody(accept, i))
            {
                readRawBody(i);
                accept.acceptRaw(raw);
                raw = null;
            }
            headByte = -63;
            return true;

        case 197: 
        case 218: 
            i = in.getShort() & 0xffff;
            if (i == 0)
            {
                accept.acceptEmptyRaw();
                in.advance();
                headByte = -63;
                return true;
            }
            if (i >= rawSizeLimit)
            {
                throw new SizeLimitException(String.format("Size of raw (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(rawSizeLimit)
                }));
            }
            in.advance();
            if (!tryReferRawBody(accept, i))
            {
                readRawBody(i);
                accept.acceptRaw(raw);
                raw = null;
            }
            headByte = -63;
            return true;

        case 198: 
        case 219: 
            i = in.getInt();
            if (i == 0)
            {
                accept.acceptEmptyRaw();
                in.advance();
                headByte = -63;
                return true;
            }
            if (i < 0 || i >= rawSizeLimit)
            {
                throw new SizeLimitException(String.format("Size of raw (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(rawSizeLimit)
                }));
            }
            in.advance();
            if (!tryReferRawBody(accept, i))
            {
                readRawBody(i);
                accept.acceptRaw(raw);
                raw = null;
            }
            headByte = -63;
            return true;

        case 220: 
            i = in.getShort() & 0xffff;
            if (i >= arraySizeLimit)
            {
                throw new SizeLimitException(String.format("Size of array (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(arraySizeLimit)
                }));
            } else
            {
                accept.acceptArray(i);
                stack.reduceCount();
                stack.pushArray(i);
                in.advance();
                headByte = -63;
                return false;
            }

        case 221: 
            i = in.getInt();
            if (i < 0 || i >= arraySizeLimit)
            {
                throw new SizeLimitException(String.format("Size of array (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(arraySizeLimit)
                }));
            } else
            {
                accept.acceptArray(i);
                stack.reduceCount();
                stack.pushArray(i);
                in.advance();
                headByte = -63;
                return false;
            }

        case 222: 
            i = in.getShort() & 0xffff;
            if (i >= mapSizeLimit)
            {
                throw new SizeLimitException(String.format("Size of map (%d) over limit at %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(mapSizeLimit)
                }));
            } else
            {
                accept.acceptMap(i);
                stack.reduceCount();
                stack.pushMap(i);
                in.advance();
                headByte = -63;
                return false;
            }

        case 223: 
            i = in.getInt();
            break;
        }
        if (i < 0 || i >= mapSizeLimit)
        {
            throw new SizeLimitException(String.format("Size of map (%d) over limit at %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(mapSizeLimit)
            }));
        } else
        {
            accept.acceptMap(i);
            stack.reduceCount();
            stack.pushMap(i);
            in.advance();
            headByte = -63;
            return false;
        }
    }

    private void readRawBody(int i)
        throws IOException
    {
        raw = new byte[i];
        rawFilled = 0;
        readRawBodyCont();
    }

    private void readRawBodyCont()
        throws IOException
    {
        int i = in.read(raw, rawFilled, raw.length - rawFilled);
        rawFilled = rawFilled + i;
        if (rawFilled < raw.length)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    private boolean tryReferRawBody(BufferReferer bufferreferer, int i)
        throws IOException
    {
        return in.tryRefer(bufferreferer, i);
    }

    public void close()
        throws IOException
    {
        in.close();
    }

    final void readOne(Accept accept)
        throws IOException
    {
        stack.checkCount();
        if (readOneWithoutStack(accept))
        {
            stack.reduceCount();
        }
    }

    final boolean readOneWithoutStack(Accept accept)
        throws IOException
    {
        if (raw != null)
        {
            readRawBodyCont();
            accept.acceptRaw(raw);
            raw = null;
            headByte = -63;
            return true;
        }
        int i = getHeadByte();
        if ((i & 0x80) == 0)
        {
            accept.acceptInteger(i);
            headByte = -63;
            return true;
        }
        if ((i & 0xe0) == 224)
        {
            accept.acceptInteger(i);
            headByte = -63;
            return true;
        }
        if ((i & 0xe0) == 160)
        {
            i &= 0x1f;
            if (i == 0)
            {
                accept.acceptEmptyRaw();
                headByte = -63;
                return true;
            }
            if (!tryReferRawBody(accept, i))
            {
                readRawBody(i);
                accept.acceptRaw(raw);
                raw = null;
            }
            headByte = -63;
            return true;
        }
        if ((i & 0xf0) == 144)
        {
            i &= 0xf;
            accept.acceptArray(i);
            stack.reduceCount();
            stack.pushArray(i);
            headByte = -63;
            return false;
        }
        if ((i & 0xf0) == 128)
        {
            i &= 0xf;
            accept.acceptMap(i);
            stack.reduceCount();
            stack.pushMap(i);
            headByte = -63;
            return false;
        } else
        {
            return readOneWithoutStackLarge(accept, i);
        }
    }

    protected void readValue(Unconverter unconverter)
        throws IOException
    {
        if (unconverter.getResult() != null)
        {
            unconverter.resetResult();
        }
        valueAccept.setUnconverter(unconverter);
        stack.checkCount();
        if (readOneWithoutStack(valueAccept))
        {
            stack.reduceCount();
            if (unconverter.getResult() != null)
            {
                return;
            }
        }
        do
        {
            while (stack.getTopCount() != 0) 
            {
                readOne(valueAccept);
            }
            if (stack.topIsArray())
            {
                unconverter.writeArrayEnd(true);
                stack.pop();
            } else
            if (stack.topIsMap())
            {
                unconverter.writeMapEnd(true);
                stack.pop();
            } else
            {
                throw new RuntimeException("invalid stack");
            }
        } while (unconverter.getResult() == null);
    }
}
