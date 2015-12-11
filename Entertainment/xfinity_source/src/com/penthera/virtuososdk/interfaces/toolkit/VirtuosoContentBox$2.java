// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.os.RemoteException;
import com.penthera.virtuososdk.client.IEngineObserver;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoContentBox

class <init> extends com.penthera.virtuososdk.interfaces.ck.Stub
{

    final VirtuosoContentBox this$0;

    public void collectionsChanged(IVirtuosoIdentifier aivirtuosoidentifier[])
        throws RemoteException
    {
    }

    public void collectionsDeleted(String as[])
        throws RemoteException
    {
    }

    public void downloadEngineStatusDidChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
        throws RemoteException
    {
        Iterator iterator = VirtuosoContentBox.access$2(VirtuosoContentBox.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((IEngineObserver)iterator.next()).downloadEngineStatusDidChange(ivirtuosodownloadenginestatus);
        } while (true);
    }

    public void engineContentInList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
        throws RemoteException
    {
    }

    public void engineListChanged()
        throws RemoteException
    {
    }

    public void itemUpdated(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException
    {
    }

    public void settingChanged(int i)
        throws RemoteException
    {
        Iterator iterator = VirtuosoContentBox.access$2(VirtuosoContentBox.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((IEngineObserver)iterator.next()).settingChanged(i);
        } while (true);
    }

    ()
    {
        this$0 = VirtuosoContentBox.this;
        super();
    }
}
