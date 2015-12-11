// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

// Referenced classes of package org.java_websocket.drafts:
//            Draft

public class Draft_75 extends Draft
{

    protected ByteBuffer currentFrame;
    protected boolean readingState;
    protected List readyframes;
    private final Random reuseableRandom = new Random();

    public Draft_75()
    {
        readingState = false;
        readyframes = new LinkedList();
    }

    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clienthandshake, ServerHandshake serverhandshake)
    {
        if (clienthandshake.getFieldValue("WebSocket-Origin").equals(serverhandshake.getFieldValue("Origin")) && basicAccept(serverhandshake))
        {
            return Draft.HandshakeState.MATCHED;
        } else
        {
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clienthandshake)
    {
        if (clienthandshake.hasFieldValue("Origin") && basicAccept(clienthandshake))
        {
            return Draft.HandshakeState.MATCHED;
        } else
        {
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public Draft copyInstance()
    {
        return new Draft_75();
    }

    public ByteBuffer createBinaryFrame(Framedata framedata)
    {
        if (framedata.getOpcode() != org.java_websocket.framing.Framedata.Opcode.TEXT)
        {
            throw new RuntimeException("only text frames supported");
        } else
        {
            framedata = framedata.getPayloadData();
            ByteBuffer bytebuffer = ByteBuffer.allocate(framedata.remaining() + 2);
            bytebuffer.put((byte)0);
            framedata.mark();
            bytebuffer.put(framedata);
            framedata.reset();
            bytebuffer.put((byte)-1);
            bytebuffer.flip();
            return bytebuffer;
        }
    }

    public ByteBuffer createBuffer()
    {
        return ByteBuffer.allocate(INITIAL_FAMESIZE);
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
        return Draft.CloseHandshakeType.NONE;
    }

    public ByteBuffer increaseBuffer(ByteBuffer bytebuffer)
        throws LimitExedeedException, InvalidDataException
    {
        bytebuffer.flip();
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(checkAlloc(bytebuffer.capacity() * 2));
        bytebuffer1.put(bytebuffer);
        return bytebuffer1;
    }

    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clienthandshakebuilder)
        throws InvalidHandshakeException
    {
        clienthandshakebuilder.put("Upgrade", "WebSocket");
        clienthandshakebuilder.put("Connection", "Upgrade");
        if (!clienthandshakebuilder.hasFieldValue("Origin"))
        {
            clienthandshakebuilder.put("Origin", (new StringBuilder()).append("random").append(reuseableRandom.nextInt()).toString());
        }
        return clienthandshakebuilder;
    }

    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clienthandshake, ServerHandshakeBuilder serverhandshakebuilder)
        throws InvalidHandshakeException
    {
        serverhandshakebuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverhandshakebuilder.put("Upgrade", "WebSocket");
        serverhandshakebuilder.put("Connection", clienthandshake.getFieldValue("Connection"));
        serverhandshakebuilder.put("WebSocket-Origin", clienthandshake.getFieldValue("Origin"));
        serverhandshakebuilder.put("WebSocket-Location", (new StringBuilder()).append("ws://").append(clienthandshake.getFieldValue("Host")).append(clienthandshake.getResourceDescriptor()).toString());
        return serverhandshakebuilder;
    }

    public void reset()
    {
        readingState = false;
        currentFrame = null;
    }

    public List translateFrame(ByteBuffer bytebuffer)
        throws InvalidDataException
    {
        bytebuffer = translateRegularFrame(bytebuffer);
        if (bytebuffer == null)
        {
            throw new InvalidDataException(1002);
        } else
        {
            return bytebuffer;
        }
    }

    protected List translateRegularFrame(ByteBuffer bytebuffer)
        throws InvalidDataException
    {
        List list;
label0:
        {
            Object obj = null;
            while (bytebuffer.hasRemaining()) 
            {
                byte byte0 = bytebuffer.get();
                if (byte0 == 0)
                {
                    if (readingState)
                    {
                        throw new InvalidFrameException("unexpected START_OF_FRAME");
                    }
                    readingState = true;
                } else
                if (byte0 == -1)
                {
                    if (!readingState)
                    {
                        throw new InvalidFrameException("unexpected END_OF_FRAME");
                    }
                    if (currentFrame != null)
                    {
                        currentFrame.flip();
                        FramedataImpl1 framedataimpl1 = new FramedataImpl1();
                        framedataimpl1.setPayload(currentFrame);
                        framedataimpl1.setFin(true);
                        framedataimpl1.setOptcode(org.java_websocket.framing.Framedata.Opcode.TEXT);
                        readyframes.add(framedataimpl1);
                        currentFrame = null;
                        bytebuffer.mark();
                    }
                    readingState = false;
                } else
                {
                    list = obj;
                    if (!readingState)
                    {
                        break label0;
                    }
                    if (currentFrame == null)
                    {
                        currentFrame = createBuffer();
                    } else
                    if (!currentFrame.hasRemaining())
                    {
                        currentFrame = increaseBuffer(currentFrame);
                    }
                    currentFrame.put(byte0);
                }
            }
            list = readyframes;
            readyframes = new LinkedList();
        }
        return list;
    }
}
