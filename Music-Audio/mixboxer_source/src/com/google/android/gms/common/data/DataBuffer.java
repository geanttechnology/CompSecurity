// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder, a

public abstract class DataBuffer
    implements Iterable
{

    protected final DataHolder nE;

    protected DataBuffer(DataHolder dataholder)
    {
        nE = dataholder;
        if (nE != null)
        {
            nE.c(this);
        }
    }

    public void close()
    {
        if (nE != null)
        {
            nE.close();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public abstract Object get(int i);

    public int getCount()
    {
        if (nE == null)
        {
            return 0;
        } else
        {
            return nE.getCount();
        }
    }

    public Bundle getMetadata()
    {
        return nE.getMetadata();
    }

    public boolean isClosed()
    {
        if (nE == null)
        {
            return true;
        } else
        {
            return nE.isClosed();
        }
    }

    public Iterator iterator()
    {
        return new a(this);
    }
}
