// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_75;
import org.java_websocket.drafts.Draft_76;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.util.Charsetfunctions;

// Referenced classes of package org.java_websocket:
//            WebSocket, WebSocketListener

public class WebSocketImpl
    implements WebSocket
{

    static final boolean $assertionsDisabled;
    public static boolean DEBUG = false;
    public static int RCVBUF = 16384;
    public static final List defaultdraftlist;
    public ByteChannel channel;
    private Integer closecode;
    private Boolean closedremotely;
    private String closemessage;
    private org.java_websocket.framing.Framedata.Opcode current_continuous_frame_opcode;
    private Draft draft;
    private volatile boolean flushandclosestate;
    private ClientHandshake handshakerequest;
    public final BlockingQueue inQueue = new LinkedBlockingQueue();
    public SelectionKey key;
    private List knownDrafts;
    public final BlockingQueue outQueue = new LinkedBlockingQueue();
    private WebSocket.READYSTATE readystate;
    private String resourceDescriptor;
    private WebSocket.Role role;
    private ByteBuffer tmpHandshakeBytes;
    private final WebSocketListener wsl;

    public WebSocketImpl(WebSocketListener websocketlistener, Draft draft1)
    {
        flushandclosestate = false;
        readystate = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        draft = null;
        current_continuous_frame_opcode = null;
        tmpHandshakeBytes = ByteBuffer.allocate(0);
        handshakerequest = null;
        closemessage = null;
        closecode = null;
        closedremotely = null;
        resourceDescriptor = null;
        if (websocketlistener == null || draft1 == null && role == WebSocket.Role.SERVER)
        {
            throw new IllegalArgumentException("parameters must not be null");
        }
        wsl = websocketlistener;
        role = WebSocket.Role.CLIENT;
        if (draft1 != null)
        {
            draft = draft1.copyInstance();
        }
    }

    private void close(int i, String s, boolean flag)
    {
label0:
        {
            if (readystate != WebSocket.READYSTATE.CLOSING && readystate != WebSocket.READYSTATE.CLOSED)
            {
                if (readystate != WebSocket.READYSTATE.OPEN)
                {
                    break MISSING_BLOCK_LABEL_190;
                }
                if (i != 1006)
                {
                    break label0;
                }
                if (!$assertionsDisabled && flag)
                {
                    throw new AssertionError();
                }
                readystate = WebSocket.READYSTATE.CLOSING;
                flushAndClose(i, s, false);
            }
            return;
        }
        if (draft.getCloseHandshakeType() == org.java_websocket.drafts.Draft.CloseHandshakeType.NONE) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        wsl.onWebsocketCloseInitiated(this, i, s);
_L3:
        sendFrame(new CloseFrameBuilder(i, s));
_L2:
        flushAndClose(i, s, flag);
_L4:
        if (i == 1002)
        {
            flushAndClose(i, s, flag);
        }
        readystate = WebSocket.READYSTATE.CLOSING;
        tmpHandshakeBytes = null;
        return;
        Object obj;
        obj;
        wsl.onWebsocketError(this, ((Exception) (obj)));
          goto _L3
        obj;
        wsl.onWebsocketError(this, ((Exception) (obj)));
        flushAndClose(1006, "generated frame is invalid", false);
          goto _L2
        if (i == -3)
        {
            if (!$assertionsDisabled && !flag)
            {
                throw new AssertionError();
            }
            flushAndClose(-3, s, true);
        } else
        {
            flushAndClose(-1, s, false);
        }
          goto _L4
    }

    private void decodeFrames(ByteBuffer bytebuffer)
    {
        Iterator iterator = draft.translateFrame(bytebuffer).iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Framedata framedata;
        boolean flag;
        framedata = (Framedata)iterator.next();
        if (DEBUG)
        {
            System.out.println((new StringBuilder()).append("matched frame: ").append(framedata).toString());
        }
        bytebuffer = framedata.getOpcode();
        flag = framedata.isFin();
        if (bytebuffer != org.java_websocket.framing.Framedata.Opcode.CLOSING) goto _L4; else goto _L3
_L3:
        int i;
        i = 1005;
        bytebuffer = "";
        if (framedata instanceof CloseFrame)
        {
            bytebuffer = (CloseFrame)framedata;
            i = bytebuffer.getCloseCode();
            bytebuffer = bytebuffer.getMessage();
        }
        if (readystate != WebSocket.READYSTATE.CLOSING) goto _L6; else goto _L5
_L5:
        closeConnection(i, bytebuffer, true);
          goto _L7
        bytebuffer;
        wsl.onWebsocketError(this, bytebuffer);
        close(bytebuffer);
_L2:
        return;
_L6:
label0:
        {
            if (draft.getCloseHandshakeType() != org.java_websocket.drafts.Draft.CloseHandshakeType.TWOWAY)
            {
                break label0;
            }
            close(i, bytebuffer, true);
        }
          goto _L7
        flushAndClose(i, bytebuffer, false);
          goto _L7
_L4:
label1:
        {
            if (bytebuffer != org.java_websocket.framing.Framedata.Opcode.PING)
            {
                break label1;
            }
            wsl.onWebsocketPing(this, framedata);
        }
          goto _L7
label2:
        {
            if (bytebuffer != org.java_websocket.framing.Framedata.Opcode.PONG)
            {
                break label2;
            }
            wsl.onWebsocketPong(this, framedata);
        }
          goto _L7
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        if (bytebuffer != org.java_websocket.framing.Framedata.Opcode.CONTINUOUS)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        if (bytebuffer == org.java_websocket.framing.Framedata.Opcode.CONTINUOUS) goto _L9; else goto _L8
_L8:
        if (current_continuous_frame_opcode != null)
        {
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        }
        current_continuous_frame_opcode = bytebuffer;
_L10:
        wsl.onWebsocketMessageFragment(this, framedata);
          goto _L7
        bytebuffer;
        wsl.onWebsocketError(this, bytebuffer);
          goto _L7
_L9:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (current_continuous_frame_opcode == null)
        {
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        current_continuous_frame_opcode = null;
          goto _L10
        if (current_continuous_frame_opcode != null) goto _L10; else goto _L11
_L11:
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        org.java_websocket.framing.Framedata.Opcode opcode;
        if (current_continuous_frame_opcode != null)
        {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        }
        opcode = org.java_websocket.framing.Framedata.Opcode.TEXT;
        if (bytebuffer != opcode)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        wsl.onWebsocketMessage(this, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
          goto _L7
        bytebuffer;
        wsl.onWebsocketError(this, bytebuffer);
          goto _L7
        opcode = org.java_websocket.framing.Framedata.Opcode.BINARY;
        if (bytebuffer != opcode)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        wsl.onWebsocketMessage(this, framedata.getPayloadData());
          goto _L7
        bytebuffer;
        wsl.onWebsocketError(this, bytebuffer);
          goto _L7
        throw new InvalidDataException(1002, "non control or continious frame expected");
    }

    private boolean decodeHandshake(ByteBuffer bytebuffer)
    {
        ByteBuffer bytebuffer1;
        org.java_websocket.drafts.Draft.HandshakeState handshakestate;
        org.java_websocket.drafts.Draft.HandshakeState handshakestate1;
        if (tmpHandshakeBytes.capacity() == 0)
        {
            bytebuffer1 = bytebuffer;
        } else
        {
            if (tmpHandshakeBytes.remaining() < bytebuffer.remaining())
            {
                bytebuffer1 = ByteBuffer.allocate(tmpHandshakeBytes.capacity() + bytebuffer.remaining());
                tmpHandshakeBytes.flip();
                bytebuffer1.put(tmpHandshakeBytes);
                tmpHandshakeBytes = bytebuffer1;
            }
            tmpHandshakeBytes.put(bytebuffer);
            tmpHandshakeBytes.flip();
            bytebuffer1 = tmpHandshakeBytes;
        }
        bytebuffer1.mark();
        if (draft != null) goto _L2; else goto _L1
_L1:
        handshakestate = isFlashEdgeCase(bytebuffer1);
        handshakestate1 = org.java_websocket.drafts.Draft.HandshakeState.MATCHED;
        if (handshakestate != handshakestate1) goto _L2; else goto _L3
_L3:
        write(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(wsl.getFlashPolicy(this))));
        close(-3, "");
_L5:
        return false;
        InvalidDataException invaliddataexception;
        invaliddataexception;
        close(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
        if (true) goto _L5; else goto _L4
_L4:
        Object obj;
        obj;
        if (tmpHandshakeBytes.capacity() != 0) goto _L7; else goto _L6
_L6:
        int j;
        bytebuffer1.reset();
        j = ((IncompleteHandshakeException) (obj)).getPreferedSize();
        if (j != 0) goto _L9; else goto _L8
_L8:
        int i = bytebuffer1.capacity() + 16;
_L23:
        tmpHandshakeBytes = ByteBuffer.allocate(i);
        tmpHandshakeBytes.put(bytebuffer);
_L21:
        return false;
_L2:
        if (role != WebSocket.Role.SERVER) goto _L11; else goto _L10
_L10:
        if (draft != null) goto _L13; else goto _L12
_L12:
        obj = knownDrafts.iterator();
_L19:
        if (!((Iterator) (obj)).hasNext()) goto _L15; else goto _L14
_L14:
        Object obj1 = ((Draft)((Iterator) (obj)).next()).copyInstance();
        Object obj3;
        ((Draft) (obj1)).setParseMode(role);
        bytebuffer1.reset();
        obj3 = ((Draft) (obj1)).translateHandshake(bytebuffer1);
        if (obj3 instanceof ClientHandshake) goto _L17; else goto _L16
_L16:
        flushAndClose(1002, "wrong http function", false);
        return false;
_L17:
        obj3 = (ClientHandshake)obj3;
        if (((Draft) (obj1)).acceptHandshakeAsServer(((ClientHandshake) (obj3))) != org.java_websocket.drafts.Draft.HandshakeState.MATCHED) goto _L19; else goto _L18
_L18:
        resourceDescriptor = ((ClientHandshake) (obj3)).getResourceDescriptor();
        org.java_websocket.handshake.ServerHandshakeBuilder serverhandshakebuilder = wsl.onWebsocketHandshakeReceivedAsServer(this, ((Draft) (obj1)), ((ClientHandshake) (obj3)));
        write(((Draft) (obj1)).createHandshake(((Draft) (obj1)).postProcessHandshakeResponseAsServer(((ClientHandshake) (obj3)), serverhandshakebuilder), role));
        draft = ((Draft) (obj1));
        open(((Handshakedata) (obj3)));
        return true;
        Object obj2;
        obj2;
        flushAndClose(((InvalidDataException) (obj2)).getCloseCode(), ((InvalidDataException) (obj2)).getMessage(), false);
        return false;
        obj2;
        wsl.onWebsocketError(this, ((Exception) (obj2)));
        flushAndClose(-1, ((RuntimeException) (obj2)).getMessage(), false);
        return false;
_L15:
        if (draft == null)
        {
            close(1002, "no draft matches");
        }
        break MISSING_BLOCK_LABEL_791;
_L13:
        obj = draft.translateHandshake(bytebuffer1);
        if (obj instanceof ClientHandshake)
        {
            break MISSING_BLOCK_LABEL_491;
        }
        flushAndClose(1002, "wrong http function", false);
        return false;
        obj = (ClientHandshake)obj;
        if (draft.acceptHandshakeAsServer(((ClientHandshake) (obj))) != org.java_websocket.drafts.Draft.HandshakeState.MATCHED)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        open(((Handshakedata) (obj)));
        return true;
        close(1002, "the handshake did finaly not match");
        return false;
_L11:
        if (role != WebSocket.Role.CLIENT) goto _L21; else goto _L20
_L20:
        draft.setParseMode(role);
        obj = draft.translateHandshake(bytebuffer1);
        if (obj instanceof ServerHandshake)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        flushAndClose(1002, "wrong http function", false);
        return false;
        obj = (ServerHandshake)obj;
        obj2 = draft.acceptHandshakeAsClient(handshakerequest, ((ServerHandshake) (obj)));
        obj3 = org.java_websocket.drafts.Draft.HandshakeState.MATCHED;
        if (obj2 != obj3)
        {
            break MISSING_BLOCK_LABEL_672;
        }
        wsl.onWebsocketHandshakeReceivedAsClient(this, handshakerequest, ((ServerHandshake) (obj)));
        open(((Handshakedata) (obj)));
        return true;
        obj;
        flushAndClose(((InvalidDataException) (obj)).getCloseCode(), ((InvalidDataException) (obj)).getMessage(), false);
        return false;
        obj;
        wsl.onWebsocketError(this, ((Exception) (obj)));
        flushAndClose(-1, ((RuntimeException) (obj)).getMessage(), false);
        return false;
        close(1002, (new StringBuilder()).append("draft ").append(draft).append(" refuses handshake").toString());
          goto _L21
        obj;
        close(((InvalidDataException) (obj)));
          goto _L21
_L9:
        i = j;
        if ($assertionsDisabled) goto _L23; else goto _L22
_L22:
        i = j;
        if (((IncompleteHandshakeException) (obj)).getPreferedSize() >= bytebuffer1.remaining()) goto _L23; else goto _L24
_L24:
        throw new AssertionError();
_L7:
        tmpHandshakeBytes.position(tmpHandshakeBytes.limit());
        tmpHandshakeBytes.limit(tmpHandshakeBytes.capacity());
          goto _L21
        obj2;
          goto _L19
        return false;
          goto _L21
    }

    private org.java_websocket.drafts.Draft.HandshakeState isFlashEdgeCase(ByteBuffer bytebuffer)
        throws IncompleteHandshakeException
    {
        bytebuffer.mark();
        if (bytebuffer.limit() > Draft.FLASH_POLICY_REQUEST.length)
        {
            return org.java_websocket.drafts.Draft.HandshakeState.NOT_MATCHED;
        }
        if (bytebuffer.limit() < Draft.FLASH_POLICY_REQUEST.length)
        {
            throw new IncompleteHandshakeException(Draft.FLASH_POLICY_REQUEST.length);
        }
        for (int i = 0; bytebuffer.hasRemaining(); i++)
        {
            if (Draft.FLASH_POLICY_REQUEST[i] != bytebuffer.get())
            {
                bytebuffer.reset();
                return org.java_websocket.drafts.Draft.HandshakeState.NOT_MATCHED;
            }
        }

        return org.java_websocket.drafts.Draft.HandshakeState.MATCHED;
    }

    private void open(Handshakedata handshakedata)
    {
        if (DEBUG)
        {
            System.out.println((new StringBuilder()).append("open using draft: ").append(draft.getClass().getSimpleName()).toString());
        }
        readystate = WebSocket.READYSTATE.OPEN;
        try
        {
            wsl.onWebsocketOpen(this, handshakedata);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Handshakedata handshakedata)
        {
            wsl.onWebsocketError(this, handshakedata);
        }
    }

    private void send(Collection collection)
    {
        if (!isOpen())
        {
            throw new WebsocketNotConnectedException();
        }
        for (collection = collection.iterator(); collection.hasNext(); sendFrame((Framedata)collection.next())) { }
    }

    private void write(ByteBuffer bytebuffer)
    {
        if (DEBUG)
        {
            PrintStream printstream = System.out;
            StringBuilder stringbuilder = (new StringBuilder()).append("write(").append(bytebuffer.remaining()).append("): {");
            String s;
            if (bytebuffer.remaining() > 1000)
            {
                s = "too big to display";
            } else
            {
                s = new String(bytebuffer.array());
            }
            printstream.println(stringbuilder.append(s).append("}").toString());
        }
        outQueue.add(bytebuffer);
        wsl.onWriteDemand(this);
    }

    private void write(List list)
    {
        for (list = list.iterator(); list.hasNext(); write((ByteBuffer)list.next())) { }
    }

    public void close(int i)
    {
        close(i, "", false);
    }

    public void close(int i, String s)
    {
        close(i, s, false);
    }

    public void close(InvalidDataException invaliddataexception)
    {
        close(invaliddataexception.getCloseCode(), invaliddataexception.getMessage(), false);
    }

    public void closeConnection(int i, String s)
    {
        closeConnection(i, s, false);
    }

    protected void closeConnection(int i, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        WebSocket.READYSTATE readystate1;
        obj = readystate;
        readystate1 = WebSocket.READYSTATE.CLOSED;
        if (obj != readystate1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (key != null)
        {
            key.cancel();
        }
        obj = channel;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        channel.close();
_L3:
        wsl.onWebsocketClose(this, i, s, flag);
_L4:
        if (draft != null)
        {
            draft.reset();
        }
        handshakerequest = null;
        readystate = WebSocket.READYSTATE.CLOSED;
        outQueue.clear();
          goto _L1
        s;
        throw s;
        IOException ioexception;
        ioexception;
        wsl.onWebsocketError(this, ioexception);
          goto _L3
        s;
        wsl.onWebsocketError(this, s);
          goto _L4
    }

    protected void closeConnection(int i, boolean flag)
    {
        closeConnection(i, "", flag);
    }

    public void decode(ByteBuffer bytebuffer)
    {
        if (!$assertionsDisabled && !bytebuffer.hasRemaining())
        {
            throw new AssertionError();
        }
        if (DEBUG)
        {
            PrintStream printstream = System.out;
            StringBuilder stringbuilder = (new StringBuilder()).append("process(").append(bytebuffer.remaining()).append("): {");
            String s;
            if (bytebuffer.remaining() > 1000)
            {
                s = "too big to display";
            } else
            {
                s = new String(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
            }
            printstream.println(stringbuilder.append(s).append("}").toString());
        }
        if (readystate != WebSocket.READYSTATE.NOT_YET_CONNECTED)
        {
            decodeFrames(bytebuffer);
        } else
        if (decodeHandshake(bytebuffer))
        {
            if (!$assertionsDisabled && tmpHandshakeBytes.hasRemaining() == bytebuffer.hasRemaining() && bytebuffer.hasRemaining())
            {
                throw new AssertionError();
            }
            if (bytebuffer.hasRemaining())
            {
                decodeFrames(bytebuffer);
            } else
            if (tmpHandshakeBytes.hasRemaining())
            {
                decodeFrames(tmpHandshakeBytes);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && bytebuffer.hasRemaining())
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public void eot()
    {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED)
        {
            closeConnection(-1, true);
            return;
        }
        if (flushandclosestate)
        {
            closeConnection(closecode.intValue(), closemessage, closedremotely.booleanValue());
            return;
        }
        if (draft.getCloseHandshakeType() == org.java_websocket.drafts.Draft.CloseHandshakeType.NONE)
        {
            closeConnection(1000, true);
            return;
        }
        if (draft.getCloseHandshakeType() == org.java_websocket.drafts.Draft.CloseHandshakeType.ONEWAY)
        {
            if (role == WebSocket.Role.SERVER)
            {
                closeConnection(1006, true);
                return;
            } else
            {
                closeConnection(1000, true);
                return;
            }
        } else
        {
            closeConnection(1006, true);
            return;
        }
    }

    protected void flushAndClose(int i, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = flushandclosestate;
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        closecode = Integer.valueOf(i);
        closemessage = s;
        closedremotely = Boolean.valueOf(flag);
        flushandclosestate = true;
        wsl.onWriteDemand(this);
        wsl.onWebsocketClosing(this, i, s, flag);
_L4:
        if (draft != null)
        {
            draft.reset();
        }
        handshakerequest = null;
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
        s;
        wsl.onWebsocketError(this, s);
          goto _L4
    }

    public InetSocketAddress getLocalSocketAddress()
    {
        return wsl.getLocalSocketAddress(this);
    }

    public WebSocket.READYSTATE getReadyState()
    {
        return readystate;
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean isClosed()
    {
        return readystate == WebSocket.READYSTATE.CLOSED;
    }

    public boolean isClosing()
    {
        return readystate == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose()
    {
        return flushandclosestate;
    }

    public boolean isOpen()
    {
        if ($assertionsDisabled || readystate != WebSocket.READYSTATE.OPEN || !flushandclosestate)
        {
            return readystate == WebSocket.READYSTATE.OPEN;
        } else
        {
            throw new AssertionError();
        }
    }

    public void send(String s)
        throws WebsocketNotConnectedException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        Draft draft1 = draft;
        boolean flag;
        if (role == WebSocket.Role.CLIENT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        send(((Collection) (draft1.createFrames(s, flag))));
    }

    public void sendFrame(Framedata framedata)
    {
        if (DEBUG)
        {
            System.out.println((new StringBuilder()).append("send frame: ").append(framedata).toString());
        }
        write(draft.createBinaryFrame(framedata));
    }

    public void startHandshake(ClientHandshakeBuilder clienthandshakebuilder)
        throws InvalidHandshakeException
    {
        if (!$assertionsDisabled && readystate == WebSocket.READYSTATE.CONNECTING)
        {
            throw new AssertionError("shall only be called once");
        }
        handshakerequest = draft.postProcessHandshakeRequestAsClient(clienthandshakebuilder);
        resourceDescriptor = clienthandshakebuilder.getResourceDescriptor();
        if (!$assertionsDisabled && resourceDescriptor == null)
        {
            throw new AssertionError();
        }
        try
        {
            wsl.onWebsocketHandshakeSentAsClient(this, handshakerequest);
        }
        // Misplaced declaration of an exception variable
        catch (ClientHandshakeBuilder clienthandshakebuilder)
        {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
        // Misplaced declaration of an exception variable
        catch (ClientHandshakeBuilder clienthandshakebuilder)
        {
            wsl.onWebsocketError(this, clienthandshakebuilder);
            throw new InvalidHandshakeException((new StringBuilder()).append("rejected because of").append(clienthandshakebuilder).toString());
        }
        write(draft.createHandshake(handshakerequest, role));
    }

    public String toString()
    {
        return super.toString();
    }

    static 
    {
        boolean flag;
        if (!org/java_websocket/WebSocketImpl.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        defaultdraftlist = new ArrayList(4);
        defaultdraftlist.add(new Draft_17());
        defaultdraftlist.add(new Draft_10());
        defaultdraftlist.add(new Draft_76());
        defaultdraftlist.add(new Draft_75());
    }
}
