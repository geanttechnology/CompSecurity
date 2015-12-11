// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPProxyDaemon, TPControlChannelStateMachine, TPVTPManager, TPLog, 
//            TPVTP

static class vtp
{

    protected WeakReference localSelectionKeyRef;
    fer localWriteBuffer;
    protected WeakReference remoteSelectionKeyRef;
    fer remoteWriteBuffer;
    protected TPVTP vtp;

    public static String interestBits(int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if ((i & 0x10) == 16)
        {
            s = "ACCEPT ";
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        if ((i & 8) == 8)
        {
            s = "CONNECT ";
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        if ((i & 1) == 1)
        {
            s = "READ ";
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        if ((i & 4) == 4)
        {
            s = "WRITE ";
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    public void close(SelectionKey selectionkey, SelectionKey selectionkey1)
    {
        if (selectionkey != null)
        {
            try
            {
                selectionkey1.cancel();
                selectionkey1.channel().close();
            }
            catch (IOException ioexception) { }
        }
        if (selectionkey1 != null)
        {
            try
            {
                selectionkey.cancel();
                selectionkey.channel().close();
            }
            // Misplaced declaration of an exception variable
            catch (SelectionKey selectionkey) { }
        }
        try
        {
            if (vtp != null)
            {
                TPControlChannelStateMachine.getInstance().tpVtpManager.releaseVtp(vtp);
            }
        }
        // Misplaced declaration of an exception variable
        catch (SelectionKey selectionkey) { }
        vtp = null;
    }

    protected SelectionKey getOtherKey(SelectionKey selectionkey)
    {
        SelectionKey selectionkey1 = (SelectionKey)localSelectionKeyRef.get();
        SelectionKey selectionkey2 = (SelectionKey)remoteSelectionKeyRef.get();
        if (selectionkey1 == selectionkey)
        {
            return selectionkey2;
        } else
        {
            return selectionkey1;
        }
    }

    public boolean isDone()
    {
        SelectionKey selectionkey = (SelectionKey)localSelectionKeyRef.get();
        SelectionKey selectionkey1 = (SelectionKey)remoteSelectionKeyRef.get();
        if (selectionkey != null && selectionkey1 != null && selectionkey.interestOps() == 0 && selectionkey1.interestOps() == 0)
        {
            close(selectionkey, selectionkey1);
            return true;
        } else
        {
            return false;
        }
    }

    public void read(SelectionKey selectionkey)
    {
        fer fer;
        SelectionKey selectionkey1;
        SelectionKey selectionkey2;
        selectionkey2 = (SelectionKey)localSelectionKeyRef.get();
        selectionkey1 = (SelectionKey)remoteSelectionKeyRef.get();
        fer = null;
        if (selectionkey2 != selectionkey) goto _L2; else goto _L1
_L1:
        fer = remoteWriteBuffer;
_L4:
        if (fer != null)
        {
            readChannel(selectionkey, fer);
            if (!fer.isEmpty() || fer.closeWriteBuffer)
            {
                selectionkey = getOtherKey(selectionkey);
                if (selectionkey != null)
                {
                    selectionkey.interestOps(selectionkey.interestOps() | 4);
                }
            }
        }
        return;
_L2:
        if (selectionkey1 == selectionkey)
        {
            fer = localWriteBuffer;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void readChannel(SelectionKey selectionkey, fer fer)
    {
        SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
_L2:
        ByteBuffer bytebuffer = ByteBuffer.allocate(4096);
        int i;
        try
        {
            i = socketchannel.read(bytebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                ((IOException) (obj)).printStackTrace();
            }
            fer.closeWriteBuffer = true;
            i = -1;
        }
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            StringBuilder stringbuilder1 = (new StringBuilder()).append("Read ").append(i).append("B from ");
            Object obj;
            if (selectionkey == localSelectionKeyRef.get())
            {
                obj = "Local ";
            } else
            {
                obj = "Remote ";
            }
            Log.d("TPLocalProxy", stringbuilder1.append(((String) (obj))).append(selectionkey).toString());
        }
        if (i > 0)
        {
            bytebuffer.flip();
            fer.add(bytebuffer);
            continue; /* Loop/switch isn't completed */
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("Closing read  ");
            String s;
            if (selectionkey == localSelectionKeyRef.get())
            {
                s = "Local ";
            } else
            {
                s = "Remote ";
            }
            Log.d("TPLocalProxy", stringbuilder.append(s).append(selectionkey).toString());
        }
        selectionkey.interestOps(selectionkey.interestOps() & -2);
        fer.closeWriteBuffer = true;
        if (socketchannel.socket().isInputShutdown())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        socketchannel.socket().shutdownInput();
        return;
        selectionkey;
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String selectionKeyToString(SelectionKey selectionkey)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("Key:").append(selectionkey).toString());
        if (selectionkey != null)
        {
            stringbuilder.append((new StringBuilder()).append(" interest:").append(interestBits(selectionkey.interestOps())).toString());
        }
        return stringbuilder.toString();
    }

    public void setRemoteKey(SelectionKey selectionkey)
    {
        remoteSelectionKeyRef = new WeakReference(selectionkey);
        if (!remoteWriteBuffer.isEmpty())
        {
            selectionkey.interestOps(selectionkey.interestOps() | 4);
        }
    }

    protected void setVtp(TPVTP tpvtp)
    {
        vtp = tpvtp;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("ProxyChannel");
        stringbuilder.append((new StringBuilder()).append("\n\t[Local] ").append(selectionKeyToString((SelectionKey)localSelectionKeyRef.get())).toString());
        stringbuilder.append((new StringBuilder()).append("\n\t[Remote] ").append(selectionKeyToString((SelectionKey)remoteSelectionKeyRef.get())).toString());
        return stringbuilder.toString();
    }

    public void write(SelectionKey selectionkey)
    {
        fer fer;
        SelectionKey selectionkey1;
        SelectionKey selectionkey2;
        selectionkey1 = (SelectionKey)localSelectionKeyRef.get();
        selectionkey2 = (SelectionKey)remoteSelectionKeyRef.get();
        fer = null;
        if (selectionkey2 != selectionkey) goto _L2; else goto _L1
_L1:
        fer = remoteWriteBuffer;
_L7:
        if (fer == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        writeChannel(selectionkey, fer);
_L4:
        return;
_L2:
        if (selectionkey1 == selectionkey)
        {
            fer = localWriteBuffer;
        }
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            ioexception.printStackTrace();
        }
        writeChannelClose(selectionkey);
        selectionkey = getOtherKey(selectionkey);
        if (selectionkey == null) goto _L4; else goto _L3
_L3:
        selectionkey.interestOps(selectionkey.interestOps() & -2);
        selectionkey = (SocketChannel)selectionkey.channel();
        if (selectionkey.socket().isInputShutdown()) goto _L4; else goto _L5
_L5:
        try
        {
            selectionkey.socket().shutdownInput();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SelectionKey selectionkey)
        {
            return;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void writeChannel(SelectionKey selectionkey, fer fer)
        throws IOException
    {
        SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
        do
        {
            ByteBuffer bytebuffer = fer.peek();
            if (bytebuffer == null)
            {
                break;
            }
            int i = socketchannel.write(bytebuffer);
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                StringBuilder stringbuilder1 = (new StringBuilder()).append("Wrote ").append(i).append("B to ");
                String s;
                if (selectionkey == localSelectionKeyRef.get())
                {
                    s = "Local ";
                } else
                {
                    s = "Remote ";
                }
                Log.d("TPLocalProxy", stringbuilder1.append(s).append(selectionkey).toString());
            }
            if (bytebuffer.hasRemaining())
            {
                break;
            }
            fer.remove();
        } while (true);
        if (!fer.isEmpty())
        {
            break MISSING_BLOCK_LABEL_292;
        }
        selectionkey.interestOps(selectionkey.interestOps() & -5);
        if (!fer.closeWriteBuffer || socketchannel.socket().isOutputShutdown())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        try
        {
            socketchannel.socket().shutdownOutput();
        }
        catch (IOException ioexception) { }
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("Closing write ");
            String s1;
            if (selectionkey == localSelectionKeyRef.get())
            {
                s1 = "Local ";
            } else
            {
                s1 = "Remote ";
            }
            Log.d("TPLocalProxy", stringbuilder.append(s1).append(selectionkey).toString());
        }
        if (selectionkey != localSelectionKeyRef.get())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        selectionkey.interestOps(selectionkey.interestOps() & -2);
        fer.closeWriteBuffer = true;
        if (socketchannel.socket().isInputShutdown())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        socketchannel.socket().shutdownInput();
_L2:
        return;
        selectionkey;
        if (!TPLog.LOG13.isLoggable("TPLocalProxy")) goto _L2; else goto _L1
_L1:
        selectionkey.printStackTrace();
        return;
        selectionkey.interestOps(selectionkey.interestOps() | 4);
        return;
    }

    public void writeChannelClose(SelectionKey selectionkey)
    {
        selectionkey.interestOps(selectionkey.interestOps() & -5);
        SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
        if (!socketchannel.socket().isOutputShutdown())
        {
            try
            {
                socketchannel.socket().shutdownOutput();
            }
            catch (IOException ioexception) { }
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                StringBuilder stringbuilder = (new StringBuilder()).append("Closing write ");
                String s;
                if (selectionkey == localSelectionKeyRef.get())
                {
                    s = "Local ";
                } else
                {
                    s = "Remote ";
                }
                Log.d("TPLocalProxy", stringbuilder.append(s).append(selectionkey).toString());
            }
        }
    }

    fer(SelectionKey selectionkey, SelectionKey selectionkey1, TPVTP tpvtp)
    {
        localSelectionKeyRef = new WeakReference(selectionkey);
        remoteSelectionKeyRef = new WeakReference(selectionkey1);
        localWriteBuffer = new fer();
        remoteWriteBuffer = new fer();
        vtp = tpvtp;
    }
}
