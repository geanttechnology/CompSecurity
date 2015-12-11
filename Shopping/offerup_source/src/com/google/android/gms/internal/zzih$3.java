// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzab, zzih

class  extends zzab
{

    final zzih zzJc;
    final Map zzJd;

    public Map getHeaders()
    {
        if (zzJd == null)
        {
            return super.getHeaders();
        } else
        {
            return zzJd;
        }
    }

    (zzih zzih, String s,  ,  1, Map map)
    {
        zzJc = zzih;
        zzJd = map;
        super(s, , 1);
    }
}
