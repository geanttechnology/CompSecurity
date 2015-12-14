// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.nearby.messages.MessageListener;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzg, MessageWrapper

private static class <init> extends <init>
{

    private final MessageListener zzaJV;

    public void zza(MessageWrapper messagewrapper)
        throws RemoteException
    {
        zzaJV.onFound(messagewrapper.zzaJS);
    }

    public void zzb(MessageWrapper messagewrapper)
        throws RemoteException
    {
        zzaJV.onLost(messagewrapper.zzaJS);
    }

    private rapper(MessageListener messagelistener)
    {
        zzaJV = messagelistener;
    }

    zzaJV(MessageListener messagelistener, zzaJV zzajv)
    {
        this(messagelistener);
    }
}
