// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class UdpDataSource
    implements UriDataSource
{
    public static final class UdpDataSourceException extends IOException
    {

        public UdpDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }

        public UdpDataSourceException(String s)
        {
            super(s);
        }
    }


    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    private InetAddress address;
    private DataSpec dataSpec;
    private final TransferListener listener;
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private byte packetBuffer[];
    private int packetRemaining;
    private DatagramSocket socket;
    private InetSocketAddress socketAddress;

    public UdpDataSource(TransferListener transferlistener)
    {
        this(transferlistener, 2000);
    }

    public UdpDataSource(TransferListener transferlistener, int i)
    {
        listener = transferlistener;
        packetBuffer = new byte[i];
        packet = new DatagramPacket(packetBuffer, 0, i);
    }

    public void close()
    {
        if (multicastSocket != null)
        {
            try
            {
                multicastSocket.leaveGroup(address);
            }
            catch (IOException ioexception) { }
            multicastSocket = null;
        }
        if (socket != null)
        {
            socket.close();
            socket = null;
        }
        address = null;
        socketAddress = null;
        packetRemaining = 0;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
    }

    public String getUri()
    {
        if (dataSpec == null)
        {
            return null;
        } else
        {
            return dataSpec.uri.toString();
        }
    }

    public long open(DataSpec dataspec)
        throws UdpDataSourceException
    {
        String s;
        int i;
        dataSpec = dataspec;
        dataspec = dataspec.uri.toString();
        s = dataspec.substring(0, dataspec.indexOf(':'));
        i = Integer.parseInt(dataspec.substring(dataspec.indexOf(':') + 1));
        address = InetAddress.getByName(s);
        socketAddress = new InetSocketAddress(address, i);
        if (!address.isMulticastAddress()) goto _L2; else goto _L1
_L1:
        multicastSocket = new MulticastSocket(socketAddress);
        multicastSocket.joinGroup(address);
        socket = multicastSocket;
_L4:
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return -1L;
_L2:
        try
        {
            socket = new DatagramSocket(socketAddress);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new UdpDataSourceException(dataspec);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int read(byte abyte0[], int i, int j)
        throws UdpDataSourceException
    {
        if (packetRemaining == 0)
        {
            int k;
            int l;
            try
            {
                socket.receive(packet);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new UdpDataSourceException(abyte0);
            }
            packetRemaining = packet.getLength();
            if (listener != null)
            {
                listener.onBytesTransferred(packetRemaining);
            }
        }
        k = packet.getLength();
        l = packetRemaining;
        j = Math.min(packetRemaining, j);
        System.arraycopy(packetBuffer, k - l, abyte0, i, j);
        packetRemaining = packetRemaining - j;
        return j;
    }
}
