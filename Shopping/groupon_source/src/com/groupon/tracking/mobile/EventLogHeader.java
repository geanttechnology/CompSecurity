// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.msgpack.Packer;

public class EventLogHeader
{

    public long timestamp;
    public int version;

    public EventLogHeader()
    {
    }

    public void pack(Packer packer)
        throws IOException
    {
        packer.packArray(2);
        packer.pack(version);
        packer.pack(timestamp);
    }

    public final byte[] pack()
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        pack(new Packer(bytearrayoutputstream));
        return bytearrayoutputstream.toByteArray();
    }
}
