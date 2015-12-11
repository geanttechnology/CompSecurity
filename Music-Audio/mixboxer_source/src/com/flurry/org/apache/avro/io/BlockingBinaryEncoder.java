// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BufferedBinaryEncoder, BinaryData

public class BlockingBinaryEncoder extends BufferedBinaryEncoder
{
    private static class BlockedValue
    {

        static final boolean $assertionsDisabled;
        public int items;
        public long itemsLeftToWrite;
        public int lastFullItem;
        public int start;
        public State state;
        public com.flurry.org.apache.avro.Schema.Type type;

        public boolean check(BlockedValue blockedvalue, int i)
        {
            if (!$assertionsDisabled && state == State.ROOT && type != null)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && state != State.ROOT && type != com.flurry.org.apache.avro.Schema.Type.ARRAY && type != com.flurry.org.apache.avro.Schema.Type.MAP)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && items < 0)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && items == 0 && start != i)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && 1 >= items && start != lastFullItem)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && items > 1 && start > lastFullItem)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && lastFullItem > i)
            {
                throw new AssertionError();
            }
            static class _cls1
            {

                static final int $SwitchMap$org$apache$avro$io$BlockingBinaryEncoder$BlockedValue$State[];

                static 
                {
                    $SwitchMap$org$apache$avro$io$BlockingBinaryEncoder$BlockedValue$State = new int[BlockedValue.State.values().length];
                    try
                    {
                        $SwitchMap$org$apache$avro$io$BlockingBinaryEncoder$BlockedValue$State[BlockedValue.State.ROOT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$org$apache$avro$io$BlockingBinaryEncoder$BlockedValue$State[BlockedValue.State.REGULAR.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$org$apache$avro$io$BlockingBinaryEncoder$BlockedValue$State[BlockedValue.State.OVERFLOW.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.org.apache.avro.io.BlockingBinaryEncoder.BlockedValue.State[state.ordinal()];
            JVM INSTR tableswitch 1 3: default 252
        //                       1 254
        //                       2 293
        //                       3 361;
               goto _L1 _L2 _L3 _L4
_L1:
            return false;
_L2:
            if (!$assertionsDisabled && start != 0)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && blockedvalue != null)
            {
                throw new AssertionError();
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (!$assertionsDisabled && start < 0)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && blockedvalue.lastFullItem > start)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && 1 > blockedvalue.items)
            {
                throw new AssertionError();
            }
            if (true) goto _L1; else goto _L4
_L4:
            if (!$assertionsDisabled && start != 0)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && items != 1)
            {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && blockedvalue.state != State.ROOT && blockedvalue.state != State.OVERFLOW)
            {
                throw new AssertionError();
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        static 
        {
            boolean flag;
            if (!com/flurry/org/apache/avro/io/BlockingBinaryEncoder.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        public BlockedValue()
        {
            type = null;
            state = State.ROOT;
            lastFullItem = 0;
            start = 0;
            items = 1;
        }
    }

    public static final class BlockedValue.State extends Enum
    {

        private static final BlockedValue.State $VALUES[];
        public static final BlockedValue.State OVERFLOW;
        public static final BlockedValue.State REGULAR;
        public static final BlockedValue.State ROOT;

        public static BlockedValue.State valueOf(String s)
        {
            return (BlockedValue.State)Enum.valueOf(com/flurry/org/apache/avro/io/BlockingBinaryEncoder$BlockedValue$State, s);
        }

        public static BlockedValue.State[] values()
        {
            return (BlockedValue.State[])$VALUES.clone();
        }

        static 
        {
            ROOT = new BlockedValue.State("ROOT", 0);
            REGULAR = new BlockedValue.State("REGULAR", 1);
            OVERFLOW = new BlockedValue.State("OVERFLOW", 2);
            $VALUES = (new BlockedValue.State[] {
                ROOT, REGULAR, OVERFLOW
            });
        }

        private BlockedValue.State(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean $assertionsDisabled;
    private static final int STACK_STEP = 10;
    private BlockedValue blockStack[];
    private byte buf[];
    private byte headerBuffer[];
    private int pos;
    private int stackTop;

    BlockingBinaryEncoder(OutputStream outputstream, int i, int j)
    {
        super(outputstream, j);
        stackTop = -1;
        headerBuffer = new byte[12];
        buf = new byte[i];
        pos = 0;
        blockStack = new BlockedValue[0];
        expandStack();
        outputstream = blockStack;
        i = stackTop + 1;
        stackTop = i;
        outputstream = outputstream[i];
        outputstream.type = null;
        outputstream.state = BlockedValue.State.ROOT;
        outputstream.lastFullItem = 0;
        outputstream.start = 0;
        outputstream.items = 1;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    private boolean check()
    {
        if (!$assertionsDisabled && buf == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && pos < 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && pos > buf.length)
        {
            throw new AssertionError((new StringBuilder()).append(pos).append(" ").append(buf.length).toString());
        }
        if (!$assertionsDisabled && blockStack == null)
        {
            throw new AssertionError();
        }
        BlockedValue blockedvalue = null;
        for (int i = 0; i <= stackTop; i++)
        {
            BlockedValue blockedvalue1 = blockStack[i];
            blockedvalue1.check(blockedvalue, pos);
            blockedvalue = blockedvalue1;
        }

        return true;
    }

    private void compact()
        throws IOException
    {
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        }
        BlockedValue blockedvalue = null;
        int j = 1;
label0:
        do
        {
label1:
            {
                if (j <= stackTop)
                {
                    blockedvalue = blockStack[j];
                    if (blockedvalue.state != BlockedValue.State.REGULAR)
                    {
                        break label1;
                    }
                }
                if (!$assertionsDisabled && blockedvalue == null)
                {
                    throw new AssertionError();
                }
                break label0;
            }
            j++;
        } while (true);
        super.writeFixed(buf, 0, blockedvalue.start);
        if (1 < blockedvalue.items)
        {
            super.writeInt(-(blockedvalue.items - 1));
            super.writeInt(blockedvalue.lastFullItem - blockedvalue.start);
            super.writeFixed(buf, blockedvalue.start, blockedvalue.lastFullItem - blockedvalue.start);
            blockedvalue.start = blockedvalue.lastFullItem;
            blockedvalue.items = 1;
        }
        super.writeInt(1);
        BlockedValue blockedvalue1;
        int i;
        if (j + 1 <= stackTop)
        {
            blockedvalue1 = blockStack[j + 1];
        } else
        {
            blockedvalue1 = null;
        }
        if (blockedvalue1 == null)
        {
            i = pos;
        } else
        {
            i = blockedvalue1.start;
        }
        super.writeFixed(buf, blockedvalue.lastFullItem, i - blockedvalue.lastFullItem);
        System.arraycopy(buf, i, buf, 0, pos - i);
        for (j++; j <= stackTop; j++)
        {
            blockedvalue1 = blockStack[j];
            blockedvalue1.start = blockedvalue1.start - i;
            blockedvalue1.lastFullItem = blockedvalue1.lastFullItem - i;
        }

        pos = pos - i;
        if (!$assertionsDisabled && blockedvalue.items != 1)
        {
            throw new AssertionError();
        }
        blockedvalue.lastFullItem = 0;
        blockedvalue.start = 0;
        blockedvalue.state = BlockedValue.State.OVERFLOW;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    private void doWriteBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j < buf.length)
        {
            ensureBounds(j);
            System.arraycopy(abyte0, i, buf, pos, j);
            pos = pos + j;
            return;
        }
        ensureBounds(buf.length);
        if (!$assertionsDisabled && blockStack[stackTop].state != BlockedValue.State.ROOT && blockStack[stackTop].state != BlockedValue.State.OVERFLOW)
        {
            throw new AssertionError();
        } else
        {
            write(abyte0, i, j);
            return;
        }
    }

    private void endBlockedValue()
        throws IOException
    {
_L7:
        Object obj;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        }
        obj = blockStack[stackTop];
        if (!$assertionsDisabled && ((BlockedValue) (obj)).state == BlockedValue.State.ROOT)
        {
            throw new AssertionError();
        }
        if (((BlockedValue) (obj)).state == BlockedValue.State.OVERFLOW)
        {
            finishOverflow();
        }
        if (!$assertionsDisabled && ((BlockedValue) (obj)).state != BlockedValue.State.REGULAR)
        {
            throw new AssertionError();
        }
        if (((BlockedValue) (obj)).items <= 0) goto _L2; else goto _L1
_L1:
        int i = pos - ((BlockedValue) (obj)).start;
        if (((BlockedValue) (obj)).start != 0 || blockStack[stackTop - 1].state == BlockedValue.State.REGULAR) goto _L4; else goto _L3
_L3:
        super.writeInt(-((BlockedValue) (obj)).items);
        super.writeInt(i);
_L2:
        stackTop = stackTop - 1;
        ensureBounds(1);
        obj = buf;
        i = pos;
        pos = i + 1;
        obj[i] = 0;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L4:
        int j = 0 + BinaryData.encodeInt(-((BlockedValue) (obj)).items, headerBuffer, 0);
        j += BinaryData.encodeInt(i, headerBuffer, j);
        if (buf.length < pos + j)
        {
            break; /* Loop/switch isn't completed */
        }
        pos = pos + j;
        int k = ((BlockedValue) (obj)).start;
        System.arraycopy(buf, k, buf, k + j, i);
        System.arraycopy(headerBuffer, 0, buf, k, j);
        if (true) goto _L2; else goto _L5
_L5:
        compact();
        if (true) goto _L7; else goto _L6
_L6:
        if (blockStack[stackTop].state == BlockedValue.State.ROOT)
        {
            flush();
        }
        return;
    }

    private void ensureBounds(int i)
        throws IOException
    {
        while (buf.length < pos + i) 
        {
            if (blockStack[stackTop].state == BlockedValue.State.REGULAR)
            {
                compact();
            } else
            {
                super.writeFixed(buf, 0, pos);
                pos = 0;
            }
        }
    }

    private void expandStack()
    {
        int i = blockStack.length;
        for (blockStack = (BlockedValue[])Arrays.copyOf(blockStack, blockStack.length + 10); i < blockStack.length; i++)
        {
            blockStack[i] = new BlockedValue();
        }

    }

    private void finishOverflow()
        throws IOException
    {
        BlockedValue blockedvalue = blockStack[stackTop];
        if (blockedvalue.state != BlockedValue.State.OVERFLOW)
        {
            throw new IllegalStateException("Not an overflow block");
        }
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        }
        super.writeFixed(buf, 0, pos);
        pos = 0;
        blockedvalue.state = BlockedValue.State.REGULAR;
        blockedvalue.lastFullItem = 0;
        blockedvalue.start = 0;
        blockedvalue.items = 0;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    private void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (blockStack[stackTop].state == BlockedValue.State.ROOT)
        {
            super.writeFixed(abyte0, i, j);
        } else
        {
            int k = j;
            if (!$assertionsDisabled)
            {
                k = j;
                if (!check())
                {
                    throw new AssertionError();
                }
            }
            do
            {
                if (buf.length >= pos + k)
                {
                    break;
                }
                if (blockStack[stackTop].state == BlockedValue.State.REGULAR)
                {
                    compact();
                } else
                {
                    super.writeFixed(buf, 0, pos);
                    pos = 0;
                    if (buf.length <= k)
                    {
                        super.writeFixed(abyte0, i, k);
                        k = 0;
                    }
                }
            } while (true);
            System.arraycopy(abyte0, i, buf, pos, k);
            pos = pos + k;
        }
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public int bytesBuffered()
    {
        return pos + super.bytesBuffered();
    }

    BlockingBinaryEncoder configure(OutputStream outputstream, int i, int j)
    {
        super.configure(outputstream, j);
        pos = 0;
        stackTop = 0;
        if (buf == null || buf.length != i)
        {
            buf = new byte[i];
        }
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return this;
        }
    }

    public void flush()
        throws IOException
    {
        BlockedValue blockedvalue = blockStack[stackTop];
        if (blockedvalue.state == BlockedValue.State.ROOT)
        {
            super.writeFixed(buf, 0, pos);
            pos = 0;
        } else
        {
            while (blockedvalue.state != BlockedValue.State.OVERFLOW) 
            {
                compact();
            }
        }
        super.flush();
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void setItemCount(long l)
        throws IOException
    {
        BlockedValue blockedvalue = blockStack[stackTop];
        if (!$assertionsDisabled && blockedvalue.type != com.flurry.org.apache.avro.Schema.Type.ARRAY && blockedvalue.type != com.flurry.org.apache.avro.Schema.Type.MAP)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && blockedvalue.itemsLeftToWrite != 0L)
        {
            throw new AssertionError();
        }
        blockedvalue.itemsLeftToWrite = l;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void startItem()
        throws IOException
    {
        if (blockStack[stackTop].state == BlockedValue.State.OVERFLOW)
        {
            finishOverflow();
        }
        BlockedValue blockedvalue = blockStack[stackTop];
        blockedvalue.items = blockedvalue.items + 1;
        blockedvalue.lastFullItem = pos;
        blockedvalue.itemsLeftToWrite = blockedvalue.itemsLeftToWrite - 1L;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void writeArrayEnd()
        throws IOException
    {
        BlockedValue blockedvalue = blockStack[stackTop];
        if (blockedvalue.type != com.flurry.org.apache.avro.Schema.Type.ARRAY)
        {
            throw new AvroTypeException("Called writeArrayEnd outside of an array.");
        }
        if (blockedvalue.itemsLeftToWrite != 0L)
        {
            throw new AvroTypeException("Failed to write expected number of array elements.");
        }
        endBlockedValue();
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void writeArrayStart()
        throws IOException
    {
        if (stackTop + 1 == blockStack.length)
        {
            expandStack();
        }
        BlockedValue ablockedvalue[] = blockStack;
        int i = stackTop + 1;
        stackTop = i;
        BlockedValue blockedvalue = ablockedvalue[i];
        blockedvalue.type = com.flurry.org.apache.avro.Schema.Type.ARRAY;
        blockedvalue.state = BlockedValue.State.REGULAR;
        i = pos;
        blockedvalue.lastFullItem = i;
        blockedvalue.start = i;
        blockedvalue.items = 0;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void writeBoolean(boolean flag)
        throws IOException
    {
        ensureBounds(1);
        pos = pos + BinaryData.encodeBoolean(flag, buf, pos);
    }

    public void writeDouble(double d)
        throws IOException
    {
        ensureBounds(8);
        pos = pos + BinaryData.encodeDouble(d, buf, pos);
    }

    public void writeFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        doWriteBytes(abyte0, i, j);
    }

    public void writeFloat(float f)
        throws IOException
    {
        ensureBounds(4);
        pos = pos + BinaryData.encodeFloat(f, buf, pos);
    }

    public void writeIndex(int i)
        throws IOException
    {
        ensureBounds(5);
        pos = pos + BinaryData.encodeInt(i, buf, pos);
    }

    public void writeInt(int i)
        throws IOException
    {
        ensureBounds(5);
        pos = pos + BinaryData.encodeInt(i, buf, pos);
    }

    public void writeLong(long l)
        throws IOException
    {
        ensureBounds(10);
        pos = pos + BinaryData.encodeLong(l, buf, pos);
    }

    public void writeMapEnd()
        throws IOException
    {
        BlockedValue blockedvalue = blockStack[stackTop];
        if (blockedvalue.type != com.flurry.org.apache.avro.Schema.Type.MAP)
        {
            throw new AvroTypeException("Called writeMapEnd outside of a map.");
        }
        if (blockedvalue.itemsLeftToWrite != 0L)
        {
            throw new AvroTypeException("Failed to read write expected number of array elements.");
        }
        endBlockedValue();
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void writeMapStart()
        throws IOException
    {
        if (stackTop + 1 == blockStack.length)
        {
            expandStack();
        }
        BlockedValue ablockedvalue[] = blockStack;
        int i = stackTop + 1;
        stackTop = i;
        BlockedValue blockedvalue = ablockedvalue[i];
        blockedvalue.type = com.flurry.org.apache.avro.Schema.Type.MAP;
        blockedvalue.state = BlockedValue.State.REGULAR;
        i = pos;
        blockedvalue.lastFullItem = i;
        blockedvalue.start = i;
        blockedvalue.items = 0;
        if (!$assertionsDisabled && !check())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    protected void writeZero()
        throws IOException
    {
        ensureBounds(1);
        byte abyte0[] = buf;
        int i = pos;
        pos = i + 1;
        abyte0[i] = 0;
    }

    static 
    {
        boolean flag;
        if (!com/flurry/org/apache/avro/io/BlockingBinaryEncoder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
