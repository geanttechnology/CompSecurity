// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder, c

public abstract class DataBuffer
    implements Releasable, Iterable
{

    protected final DataHolder DG;

    protected DataBuffer(DataHolder dataholder)
    {
        DG = dataholder;
        if (DG != null)
        {
            DG.b(this);
        }
    }

    public abstract Object get(int i);

    public int getCount()
    {
        if (DG == null)
        {
            return 0;
        } else
        {
            return DG.getCount();
        }
    }

    public Iterator iterator()
    {
        return new c(this);
    }

    public void release()
    {
        if (DG != null)
        {
            DG.close();
        }
    }
}
