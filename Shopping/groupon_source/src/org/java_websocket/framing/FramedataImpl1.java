// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.framing;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.util.Charsetfunctions;

// Referenced classes of package org.java_websocket.framing:
//            FrameBuilder, Framedata

public class FramedataImpl1
    implements FrameBuilder
{

    protected static byte emptyarray[] = new byte[0];
    protected boolean fin;
    protected Framedata.Opcode optcode;
    protected boolean transferemasked;
    private ByteBuffer unmaskedpayload;

    public FramedataImpl1()
    {
    }

    public FramedataImpl1(Framedata.Opcode opcode)
    {
        optcode = opcode;
        unmaskedpayload = ByteBuffer.wrap(emptyarray);
    }

    public FramedataImpl1(Framedata framedata)
    {
        fin = framedata.isFin();
        optcode = framedata.getOpcode();
        unmaskedpayload = framedata.getPayloadData();
        transferemasked = framedata.getTransfereMasked();
    }

    public Framedata.Opcode getOpcode()
    {
        return optcode;
    }

    public ByteBuffer getPayloadData()
    {
        return unmaskedpayload;
    }

    public boolean getTransfereMasked()
    {
        return transferemasked;
    }

    public boolean isFin()
    {
        return fin;
    }

    public void setFin(boolean flag)
    {
        fin = flag;
    }

    public void setOptcode(Framedata.Opcode opcode)
    {
        optcode = opcode;
    }

    public void setPayload(ByteBuffer bytebuffer)
        throws InvalidDataException
    {
        unmaskedpayload = bytebuffer;
    }

    public void setTransferemasked(boolean flag)
    {
        transferemasked = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Framedata{ optcode:").append(getOpcode()).append(", fin:").append(isFin()).append(", payloadlength:[pos:").append(unmaskedpayload.position()).append(", len:").append(unmaskedpayload.remaining()).append("], payload:").append(Arrays.toString(Charsetfunctions.utf8Bytes(new String(unmaskedpayload.array())))).append("}").toString();
    }

}
