// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;

// Referenced classes of package org.java_websocket.drafts:
//            Draft

public class Draft_10 extends Draft
{
    private class IncompleteException extends Throwable
    {

        private int preferedsize;
        final Draft_10 this$0;

        public int getPreferedSize()
        {
            return preferedsize;
        }

        public IncompleteException(int i)
        {
            this$0 = Draft_10.this;
            super();
            preferedsize = i;
        }
    }


    static final boolean $assertionsDisabled;
    private Framedata fragmentedframe;
    private ByteBuffer incompleteframe;
    private final Random reuseableRandom = new Random();

    public Draft_10()
    {
        fragmentedframe = null;
    }

    private byte fromOpcode(org.java_websocket.framing.Framedata.Opcode opcode)
    {
        if (opcode == org.java_websocket.framing.Framedata.Opcode.CONTINUOUS)
        {
            return 0;
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.TEXT)
        {
            return 1;
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.BINARY)
        {
            return 2;
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.CLOSING)
        {
            return 8;
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.PING)
        {
            return 9;
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.PONG)
        {
            return 10;
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("Don't know how to handle ").append(opcode.toString()).toString());
        }
    }

    private String generateFinalKey(String s)
    {
        s = s.trim();
        s = (new StringBuilder()).append(s).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11").toString();
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return Base64.encodeBytes(messagedigest.digest(s.getBytes()));
    }

    public static int readVersion(Handshakedata handshakedata)
    {
        int i = -1;
        handshakedata = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (handshakedata.length() > 0)
        {
            try
            {
                i = (new Integer(handshakedata.trim())).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Handshakedata handshakedata)
            {
                return -1;
            }
        }
        return i;
    }

    private byte[] toByteArray(long l, int i)
    {
        byte abyte0[] = new byte[i];
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)(int)(l >>> i * 8 - 8 - j * 8);
        }

        return abyte0;
    }

    private org.java_websocket.framing.Framedata.Opcode toOpcode(byte byte0)
        throws InvalidFrameException
    {
        switch (byte0)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            throw new InvalidFrameException((new StringBuilder()).append("unknow optcode ").append((short)byte0).toString());

        case 0: // '\0'
            return org.java_websocket.framing.Framedata.Opcode.CONTINUOUS;

        case 1: // '\001'
            return org.java_websocket.framing.Framedata.Opcode.TEXT;

        case 2: // '\002'
            return org.java_websocket.framing.Framedata.Opcode.BINARY;

        case 8: // '\b'
            return org.java_websocket.framing.Framedata.Opcode.CLOSING;

        case 9: // '\t'
            return org.java_websocket.framing.Framedata.Opcode.PING;

        case 10: // '\n'
            return org.java_websocket.framing.Framedata.Opcode.PONG;
        }
    }

    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clienthandshake, ServerHandshake serverhandshake)
        throws InvalidHandshakeException
    {
        if (!clienthandshake.hasFieldValue("Sec-WebSocket-Key") || !serverhandshake.hasFieldValue("Sec-WebSocket-Accept"))
        {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        serverhandshake = serverhandshake.getFieldValue("Sec-WebSocket-Accept");
        if (generateFinalKey(clienthandshake.getFieldValue("Sec-WebSocket-Key")).equals(serverhandshake))
        {
            return Draft.HandshakeState.MATCHED;
        } else
        {
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clienthandshake)
        throws InvalidHandshakeException
    {
        int i = readVersion(clienthandshake);
        if (i == 7 || i == 8)
        {
            if (basicAccept(clienthandshake))
            {
                return Draft.HandshakeState.MATCHED;
            } else
            {
                return Draft.HandshakeState.NOT_MATCHED;
            }
        } else
        {
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public Draft copyInstance()
    {
        return new Draft_10();
    }

    public ByteBuffer createBinaryFrame(Framedata framedata)
    {
        ByteBuffer bytebuffer = framedata.getPayloadData();
        ByteBuffer bytebuffer1;
        int i;
        boolean flag;
        int j;
        byte byte2;
        if (role == org.java_websocket.WebSocket.Role.CLIENT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (bytebuffer.remaining() <= 125)
        {
            i = 1;
        } else
        if (bytebuffer.remaining() <= 65535)
        {
            i = 2;
        } else
        {
            i = 8;
        }
        if (i > 1)
        {
            j = i + 1;
        } else
        {
            j = i;
        }
        if (flag)
        {
            byte2 = 4;
        } else
        {
            byte2 = 0;
        }
        bytebuffer1 = ByteBuffer.allocate(byte2 + (j + 1) + bytebuffer.remaining());
        byte2 = fromOpcode(framedata.getOpcode());
        if (framedata.isFin())
        {
            j = -128;
        } else
        {
            j = 0;
        }
        bytebuffer1.put((byte)((byte)j | byte2));
        framedata = toByteArray(bytebuffer.remaining(), i);
        if (!$assertionsDisabled && framedata.length != i)
        {
            throw new AssertionError();
        }
        if (i == 1)
        {
            byte byte1 = framedata[0];
            if (flag)
            {
                i = -128;
            } else
            {
                i = 0;
            }
            bytebuffer1.put((byte)(i | byte1));
        } else
        if (i == 2)
        {
            if (flag)
            {
                i = -128;
            } else
            {
                i = 0;
            }
            bytebuffer1.put((byte)(i | 0x7e));
            bytebuffer1.put(framedata);
        } else
        if (i == 8)
        {
            byte byte0;
            if (flag)
            {
                byte0 = -128;
            } else
            {
                byte0 = 0;
            }
            bytebuffer1.put((byte)(byte0 | 0x7f));
            bytebuffer1.put(framedata);
        } else
        {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (flag)
        {
            framedata = ByteBuffer.allocate(4);
            framedata.putInt(reuseableRandom.nextInt());
            bytebuffer1.put(framedata.array());
            for (i = 0; bytebuffer.hasRemaining(); i++)
            {
                bytebuffer1.put((byte)(bytebuffer.get() ^ framedata.get(i % 4)));
            }

        } else
        {
            bytebuffer1.put(bytebuffer);
        }
        if (!$assertionsDisabled && bytebuffer1.remaining() != 0)
        {
            throw new AssertionError(bytebuffer1.remaining());
        } else
        {
            bytebuffer1.flip();
            return bytebuffer1;
        }
    }

    public List createFrames(String s, boolean flag)
    {
        FramedataImpl1 framedataimpl1 = new FramedataImpl1();
        try
        {
            framedataimpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NotSendableException(s);
        }
        framedataimpl1.setFin(true);
        framedataimpl1.setOptcode(org.java_websocket.framing.Framedata.Opcode.TEXT);
        framedataimpl1.setTransferemasked(flag);
        return Collections.singletonList(framedataimpl1);
    }

    public Draft.CloseHandshakeType getCloseHandshakeType()
    {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clienthandshakebuilder)
    {
        clienthandshakebuilder.put("Upgrade", "websocket");
        clienthandshakebuilder.put("Connection", "Upgrade");
        clienthandshakebuilder.put("Sec-WebSocket-Version", "8");
        byte abyte0[] = new byte[16];
        reuseableRandom.nextBytes(abyte0);
        clienthandshakebuilder.put("Sec-WebSocket-Key", Base64.encodeBytes(abyte0));
        return clienthandshakebuilder;
    }

    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clienthandshake, ServerHandshakeBuilder serverhandshakebuilder)
        throws InvalidHandshakeException
    {
        serverhandshakebuilder.put("Upgrade", "websocket");
        serverhandshakebuilder.put("Connection", clienthandshake.getFieldValue("Connection"));
        serverhandshakebuilder.setHttpStatusMessage("Switching Protocols");
        clienthandshake = clienthandshake.getFieldValue("Sec-WebSocket-Key");
        if (clienthandshake == null)
        {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        } else
        {
            serverhandshakebuilder.put("Sec-WebSocket-Accept", generateFinalKey(clienthandshake));
            return serverhandshakebuilder;
        }
    }

    public void reset()
    {
        incompleteframe = null;
    }

    public List translateFrame(ByteBuffer bytebuffer)
        throws LimitExedeedException, InvalidDataException
    {
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        if (incompleteframe == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        int i;
        int j;
        bytebuffer.mark();
        i = bytebuffer.remaining();
        j = incompleteframe.remaining();
        if (j <= i)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        incompleteframe.put(bytebuffer.array(), bytebuffer.position(), i);
        bytebuffer.position(bytebuffer.position() + i);
        return Collections.emptyList();
        incompleteframe.put(bytebuffer.array(), bytebuffer.position(), j);
        bytebuffer.position(bytebuffer.position() + j);
        linkedlist.add(translateSingleFrame((ByteBuffer)incompleteframe.duplicate().position(0)));
        incompleteframe = null;
        Object obj;
        do
        {
            obj = linkedlist;
            if (!bytebuffer.hasRemaining())
            {
                break;
            }
            bytebuffer.mark();
            try
            {
                linkedlist.add(translateSingleFrame(bytebuffer));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                bytebuffer.reset();
                incompleteframe = ByteBuffer.allocate(checkAlloc(((IncompleteException) (obj)).getPreferedSize()));
                incompleteframe.put(bytebuffer);
                return linkedlist;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_274;
        obj;
        incompleteframe.limit();
        obj = ByteBuffer.allocate(checkAlloc(((IncompleteException) (obj)).getPreferedSize()));
        if (!$assertionsDisabled && ((ByteBuffer) (obj)).limit() <= incompleteframe.limit())
        {
            throw new AssertionError();
        }
        incompleteframe.rewind();
        ((ByteBuffer) (obj)).put(incompleteframe);
        incompleteframe = ((ByteBuffer) (obj));
        obj = translateFrame(bytebuffer);
        return ((List) (obj));
    }

    public Framedata translateSingleFrame(ByteBuffer bytebuffer)
        throws IncompleteException, InvalidDataException
    {
        int l = bytebuffer.remaining();
        int j = 2;
        if (l < 2)
        {
            throw new IncompleteException(2);
        }
        byte byte0 = bytebuffer.get();
        int i;
        boolean flag1;
        if (byte0 >> 8 != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = (byte)((byte0 & 0x7f) >> 4);
        if (i != 0)
        {
            throw new InvalidFrameException((new StringBuilder()).append("bad rsv ").append(i).toString());
        }
        i = bytebuffer.get();
        org.java_websocket.framing.Framedata.Opcode opcode;
        boolean flag;
        if ((i & 0xffffff80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = (byte)(i & 0x7f);
        opcode = toOpcode((byte)(byte0 & 0xf));
        if (!flag1 && (opcode == org.java_websocket.framing.Framedata.Opcode.PING || opcode == org.java_websocket.framing.Framedata.Opcode.PONG || opcode == org.java_websocket.framing.Framedata.Opcode.CLOSING))
        {
            throw new InvalidFrameException("control frames may no be fragmented");
        }
        if (i < 0 || i > 125)
        {
            if (opcode == org.java_websocket.framing.Framedata.Opcode.PING || opcode == org.java_websocket.framing.Framedata.Opcode.PONG || opcode == org.java_websocket.framing.Framedata.Opcode.CLOSING)
            {
                throw new InvalidFrameException("more than 125 octets");
            }
            if (i == 126)
            {
                j = 2 + 2;
                if (l < j)
                {
                    throw new IncompleteException(j);
                }
                byte abyte0[] = new byte[3];
                abyte0[1] = bytebuffer.get();
                abyte0[2] = bytebuffer.get();
                i = (new BigInteger(abyte0)).intValue();
            } else
            {
                j = 2 + 8;
                if (l < j)
                {
                    throw new IncompleteException(j);
                }
                byte abyte1[] = new byte[8];
                for (i = 0; i < 8; i++)
                {
                    abyte1[i] = bytebuffer.get();
                }

                long l1 = (new BigInteger(abyte1)).longValue();
                if (l1 > 0x7fffffffL)
                {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
                i = (int)l1;
            }
        }
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        j = j + byte0 + i;
        if (l < j)
        {
            throw new IncompleteException(j);
        }
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(checkAlloc(i));
        if (flag)
        {
            byte abyte2[] = new byte[4];
            bytebuffer.get(abyte2);
            for (int k = 0; k < i; k++)
            {
                bytebuffer1.put((byte)(bytebuffer.get() ^ abyte2[k % 4]));
            }

        } else
        {
            bytebuffer1.put(bytebuffer.array(), bytebuffer.position(), bytebuffer1.limit());
            bytebuffer.position(bytebuffer.position() + bytebuffer1.limit());
        }
        if (opcode == org.java_websocket.framing.Framedata.Opcode.CLOSING)
        {
            bytebuffer = new CloseFrameBuilder();
        } else
        {
            bytebuffer = new FramedataImpl1();
            bytebuffer.setFin(flag1);
            bytebuffer.setOptcode(opcode);
        }
        bytebuffer1.flip();
        bytebuffer.setPayload(bytebuffer1);
        return bytebuffer;
    }

    static 
    {
        boolean flag;
        if (!org/java_websocket/drafts/Draft_10.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
