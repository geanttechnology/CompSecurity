// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class fr
    implements RealTimeSocket
{

    private ParcelFileDescriptor om;
    private final LocalSocket uM;
    private final String up;

    fr(LocalSocket localsocket, String s)
    {
        uM = localsocket;
        up = s;
    }

    public void close()
        throws IOException
    {
        uM.close();
    }

    public InputStream getInputStream()
        throws IOException
    {
        return uM.getInputStream();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return uM.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
        throws IOException
    {
        if (om == null && !isClosed())
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeFileDescriptor(uM.getFileDescriptor());
            parcel.setDataPosition(0);
            om = parcel.readFileDescriptor();
        }
        return om;
    }

    public boolean isClosed()
    {
        return !uM.isConnected() && !uM.isBound();
    }
}
