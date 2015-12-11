// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public final class <init>
{

    private final Object zzJm;
    private final List zzago;

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder(100)).append(zzJm.getClass().getSimpleName()).append('{');
        int j = zzago.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((String)zzago.get(i));
            if (i < j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.append('}').toString();
    }

    public final zzago zzg(String s, Object obj)
    {
        zzago.add((new StringBuilder()).append((String)zzx.zzw(s)).append("=").append(String.valueOf(obj)).toString());
        return this;
    }

    private (Object obj)
    {
        zzJm = zzx.zzw(obj);
        zzago = new ArrayList();
    }

    zzago(Object obj, zzago zzago1)
    {
        this(obj);
    }
}
