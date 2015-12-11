// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.rio.j2me.common.rsc.BadRscHeaderException;
import com.amazon.rio.j2me.common.rsc.RscRequestHeader;
import com.amazon.rio.j2me.common.rsc.RscResponseHeader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class RscResponseHeaderReader
{

    public RscResponseHeaderReader()
    {
    }

    public static RscResponseHeader readHeader(DataInputStream datainputstream)
        throws EOFException, IOException
    {
        byte byte0 = datainputstream.readByte();
        if (byte0 != 0)
        {
            throw new BadRscHeaderException((new StringBuilder()).append("unsupported RSC response header version: rscVersion=").append(byte0).toString());
        }
        if (datainputstream.readByte() != 0)
        {
            return new RscResponseHeader(datainputstream.readUTF());
        } else
        {
            return new RscResponseHeader(RscRequestHeader.readByteArray(datainputstream), RscRequestHeader.readByteArray(datainputstream));
        }
    }
}
