// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBufferObserver

public final class DataBufferObserverSet
    implements DataBufferObserver, DataBufferObserver.Observable
{

    private HashSet zzadk;

    public DataBufferObserverSet()
    {
        zzadk = new HashSet();
    }

    public final void addObserver(DataBufferObserver databufferobserver)
    {
        zzadk.add(databufferobserver);
    }

    public final void clear()
    {
        zzadk.clear();
    }

    public final boolean hasObservers()
    {
        return !zzadk.isEmpty();
    }

    public final void onDataChanged()
    {
        for (Iterator iterator = zzadk.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataChanged()) { }
    }

    public final void onDataRangeChanged(int i, int j)
    {
        for (Iterator iterator = zzadk.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeChanged(i, j)) { }
    }

    public final void onDataRangeInserted(int i, int j)
    {
        for (Iterator iterator = zzadk.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeInserted(i, j)) { }
    }

    public final void onDataRangeMoved(int i, int j, int k)
    {
        for (Iterator iterator = zzadk.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeMoved(i, j, k)) { }
    }

    public final void onDataRangeRemoved(int i, int j)
    {
        for (Iterator iterator = zzadk.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeRemoved(i, j)) { }
    }

    public final void removeObserver(DataBufferObserver databufferobserver)
    {
        zzadk.remove(databufferobserver);
    }
}
