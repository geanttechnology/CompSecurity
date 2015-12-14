// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer, DataHolder, zzb, zzg

public abstract class AbstractDataBuffer
    implements DataBuffer
{

    public final DataHolder zzabq;

    public AbstractDataBuffer(DataHolder dataholder)
    {
        zzabq = dataholder;
        if (zzabq != null)
        {
            zzabq.zzr(this);
        }
    }

    public final void close()
    {
        release();
    }

    public abstract Object get(int i);

    public int getCount()
    {
        if (zzabq == null)
        {
            return 0;
        } else
        {
            return zzabq.getCount();
        }
    }

    public boolean isClosed()
    {
        return zzabq == null || zzabq.isClosed();
    }

    public Iterator iterator()
    {
        return new zzb(this);
    }

    public void release()
    {
        if (zzabq != null)
        {
            zzabq.close();
        }
    }

    public Iterator singleRefIterator()
    {
        return new zzg(this);
    }

    public Bundle zzor()
    {
        return zzabq.zzor();
    }
}
