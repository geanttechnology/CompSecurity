// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.rio.j2me.common.rsc.RscRequestHeader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class RscRequestHeaderWriter
{

    public RscRequestHeaderWriter()
    {
    }

    public static int writeHeader(DataOutputStream dataoutputstream, String s, String s1, String s2, byte abyte0[], byte abyte1[])
        throws IOException
    {
        dataoutputstream.writeByte(0);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream1 = new DataOutputStream(bytearrayoutputstream);
        dataoutputstream1.writeByte(0);
        dataoutputstream1.writeLong((new Date()).getTime());
        dataoutputstream1.writeUTF(s);
        dataoutputstream1.writeUTF(s1);
        dataoutputstream1.writeUTF(s2);
        RscRequestHeader.writeByteArray(dataoutputstream1, abyte0);
        RscRequestHeader.writeByteArray(dataoutputstream1, abyte1);
        dataoutputstream1.flush();
        dataoutputstream1.close();
        s = bytearrayoutputstream.toByteArray();
        dataoutputstream.writeShort(s.length);
        dataoutputstream.write(s);
        dataoutputstream.flush();
        return s.length + 3;
    }

    public static int writeHeader(OutputStream outputstream, String s, String s1, String s2, byte abyte0[], byte abyte1[])
        throws IOException
    {
        return writeHeader(new DataOutputStream(outputstream), s, s1, s2, abyte0, abyte1);
    }
}
