// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.packer.Unconverter;
import com.twinprime.msgpack.type.Value;
import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Unpacker, UnpackerIterator

public abstract class AbstractUnpacker
    implements Unpacker
{

    protected int arraySizeLimit;
    protected int mapSizeLimit;
    protected MessagePack msgpack;
    protected int rawSizeLimit;

    protected AbstractUnpacker(MessagePack messagepack)
    {
        rawSizeLimit = 0x8000000;
        arraySizeLimit = 0x400000;
        mapSizeLimit = 0x200000;
        msgpack = messagepack;
    }

    public UnpackerIterator iterator()
    {
        return new UnpackerIterator(this);
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public Value readValue()
        throws IOException
    {
        Unconverter unconverter = new Unconverter(msgpack);
        readValue(unconverter);
        return unconverter.getResult();
    }

    protected abstract void readValue(Unconverter unconverter)
        throws IOException;
}
