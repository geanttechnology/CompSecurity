// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.gms.common.data:
//            zzb, DataBuffer, zzc

public class zzg extends zzb
{

    private Object zzadF;

    public zzg(DataBuffer databuffer)
    {
        super(databuffer);
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder("Cannot advance the iterator beyond ")).append(zzadj).toString());
        }
        zzadj = zzadj + 1;
        if (zzadj == 0)
        {
            zzadF = zzadi.get(0);
            if (!(zzadF instanceof zzc))
            {
                throw new IllegalStateException((new StringBuilder("DataBuffer reference of type ")).append(zzadF.getClass()).append(" is not movable").toString());
            }
        } else
        {
            ((zzc)zzadF).zzbr(zzadj);
        }
        return zzadF;
    }
}
