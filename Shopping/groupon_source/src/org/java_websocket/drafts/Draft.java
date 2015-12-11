// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft
{
    public static final class CloseHandshakeType extends Enum
    {

        private static final CloseHandshakeType $VALUES[];
        public static final CloseHandshakeType NONE;
        public static final CloseHandshakeType ONEWAY;
        public static final CloseHandshakeType TWOWAY;

        public static CloseHandshakeType valueOf(String s)
        {
            return (CloseHandshakeType)Enum.valueOf(org/java_websocket/drafts/Draft$CloseHandshakeType, s);
        }

        public static CloseHandshakeType[] values()
        {
            return (CloseHandshakeType[])$VALUES.clone();
        }

        static 
        {
            NONE = new CloseHandshakeType("NONE", 0);
            ONEWAY = new CloseHandshakeType("ONEWAY", 1);
            TWOWAY = new CloseHandshakeType("TWOWAY", 2);
            $VALUES = (new CloseHandshakeType[] {
                NONE, ONEWAY, TWOWAY
            });
        }

        private CloseHandshakeType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class HandshakeState extends Enum
    {

        private static final HandshakeState $VALUES[];
        public static final HandshakeState MATCHED;
        public static final HandshakeState NOT_MATCHED;

        public static HandshakeState valueOf(String s)
        {
            return (HandshakeState)Enum.valueOf(org/java_websocket/drafts/Draft$HandshakeState, s);
        }

        public static HandshakeState[] values()
        {
            return (HandshakeState[])$VALUES.clone();
        }

        static 
        {
            MATCHED = new HandshakeState("MATCHED", 0);
            NOT_MATCHED = new HandshakeState("NOT_MATCHED", 1);
            $VALUES = (new HandshakeState[] {
                MATCHED, NOT_MATCHED
            });
        }

        private HandshakeState(String s, int i)
        {
            super(s, i);
        }
    }


    public static final byte FLASH_POLICY_REQUEST[] = Charsetfunctions.utf8Bytes("<policy-file-request/>\0");
    public static int INITIAL_FAMESIZE = 64;
    public static int MAX_FAME_SIZE = 1000;
    protected org.java_websocket.framing.Framedata.Opcode continuousFrameType;
    protected org.java_websocket.WebSocket.Role role;

    public Draft()
    {
        role = null;
        continuousFrameType = null;
    }

    public static ByteBuffer readLine(ByteBuffer bytebuffer)
    {
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(bytebuffer.remaining());
        byte byte1 = 48;
        do
        {
            byte byte2 = byte1;
            if (bytebuffer.hasRemaining())
            {
                byte byte0 = bytebuffer.get();
                bytebuffer1.put(byte0);
                byte1 = byte0;
                if (byte2 == 13)
                {
                    byte1 = byte0;
                    if (byte0 == 10)
                    {
                        bytebuffer1.limit(bytebuffer1.position() - 2);
                        bytebuffer1.position(0);
                        return bytebuffer1;
                    }
                }
            } else
            {
                bytebuffer.position(bytebuffer.position() - bytebuffer1.position());
                return null;
            }
        } while (true);
    }

    public static String readStringLine(ByteBuffer bytebuffer)
    {
        bytebuffer = readLine(bytebuffer);
        if (bytebuffer == null)
        {
            return null;
        } else
        {
            return Charsetfunctions.stringAscii(bytebuffer.array(), 0, bytebuffer.limit());
        }
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer bytebuffer, org.java_websocket.WebSocket.Role role1)
        throws InvalidHandshakeException, IncompleteHandshakeException
    {
        Object obj = readStringLine(bytebuffer);
        if (obj == null)
        {
            throw new IncompleteHandshakeException(bytebuffer.capacity() + 128);
        }
        obj = ((String) (obj)).split(" ", 3);
        if (obj.length != 3)
        {
            throw new InvalidHandshakeException();
        }
        if (role1 == org.java_websocket.WebSocket.Role.CLIENT)
        {
            role1 = new HandshakeImpl1Server();
            ServerHandshakeBuilder serverhandshakebuilder = (ServerHandshakeBuilder)role1;
            serverhandshakebuilder.setHttpStatus(Short.parseShort(obj[1]));
            serverhandshakebuilder.setHttpStatusMessage(obj[2]);
        } else
        {
            role1 = new HandshakeImpl1Client();
            role1.setResourceDescriptor(obj[1]);
        }
        for (obj = readStringLine(bytebuffer); obj != null && ((String) (obj)).length() > 0; obj = readStringLine(bytebuffer))
        {
            obj = ((String) (obj)).split(":", 2);
            if (obj.length != 2)
            {
                throw new InvalidHandshakeException("not an http header");
            }
            role1.put(obj[0], obj[1].replaceFirst("^ +", ""));
        }

        if (obj == null)
        {
            throw new IncompleteHandshakeException();
        } else
        {
            return role1;
        }
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clienthandshake, ServerHandshake serverhandshake)
        throws InvalidHandshakeException;

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clienthandshake)
        throws InvalidHandshakeException;

    protected boolean basicAccept(Handshakedata handshakedata)
    {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int checkAlloc(int i)
        throws LimitExedeedException, InvalidDataException
    {
        if (i < 0)
        {
            throw new InvalidDataException(1002, "Negative count");
        } else
        {
            return i;
        }
    }

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List createFrames(String s, boolean flag);

    public List createHandshake(Handshakedata handshakedata, org.java_websocket.WebSocket.Role role1)
    {
        return createHandshake(handshakedata, role1, true);
    }

    public List createHandshake(Handshakedata handshakedata, org.java_websocket.WebSocket.Role role1, boolean flag)
    {
        role1 = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake)
        {
            role1.append("GET ");
            role1.append(((ClientHandshake)handshakedata).getResourceDescriptor());
            role1.append(" HTTP/1.1");
        } else
        if (handshakedata instanceof ServerHandshake)
        {
            role1.append((new StringBuilder()).append("HTTP/1.1 101 ").append(((ServerHandshake)handshakedata).getHttpStatusMessage()).toString());
        } else
        {
            throw new RuntimeException("unknow role");
        }
        role1.append("\r\n");
        for (Iterator iterator = handshakedata.iterateHttpFields(); iterator.hasNext(); role1.append("\r\n"))
        {
            String s = (String)iterator.next();
            String s1 = handshakedata.getFieldValue(s);
            role1.append(s);
            role1.append(": ");
            role1.append(s1);
        }

        role1.append("\r\n");
        role1 = Charsetfunctions.asciiBytes(role1.toString());
        ByteBuffer bytebuffer;
        int i;
        if (flag)
        {
            handshakedata = handshakedata.getContent();
        } else
        {
            handshakedata = null;
        }
        if (handshakedata == null)
        {
            i = 0;
        } else
        {
            i = handshakedata.length;
        }
        bytebuffer = ByteBuffer.allocate(i + role1.length);
        bytebuffer.put(role1);
        if (handshakedata != null)
        {
            bytebuffer.put(handshakedata);
        }
        bytebuffer.flip();
        return Collections.singletonList(bytebuffer);
    }

    public abstract CloseHandshakeType getCloseHandshakeType();

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clienthandshakebuilder)
        throws InvalidHandshakeException;

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clienthandshake, ServerHandshakeBuilder serverhandshakebuilder)
        throws InvalidHandshakeException;

    public abstract void reset();

    public void setParseMode(org.java_websocket.WebSocket.Role role1)
    {
        role = role1;
    }

    public abstract List translateFrame(ByteBuffer bytebuffer)
        throws InvalidDataException;

    public Handshakedata translateHandshake(ByteBuffer bytebuffer)
        throws InvalidHandshakeException
    {
        return translateHandshakeHttp(bytebuffer, role);
    }

}
