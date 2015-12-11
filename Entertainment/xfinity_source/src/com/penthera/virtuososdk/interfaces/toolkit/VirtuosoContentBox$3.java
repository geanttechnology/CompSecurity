// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.os.RemoteException;
import com.penthera.virtuososdk.client.IDownloadedObserver;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoContentBox

class tub extends com.penthera.virtuososdk.interfaces.llback.Stub
{

    final VirtuosoContentBox this$0;

    public void engineContentInDownloadedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
        throws RemoteException
    {
    }

    public void engineDownloadedListChanged()
        throws RemoteException
    {
        Iterator iterator = VirtuosoContentBox.access$3(VirtuosoContentBox.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((IDownloadedObserver)iterator.next()).engineDownloadedListChanged();
        } while (true);
    }

    tub()
    {
        this$0 = VirtuosoContentBox.this;
        super();
    }
}
