// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzby, zzbu, zziz

final class 
    implements zzdk
{

    public final void zza(zziz zziz1, Map map)
    {
        if (!((Boolean)zzby.zzvs.get()).booleanValue())
        {
            return;
        }
        boolean flag;
        if (!Boolean.parseBoolean((String)map.get("disabled")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zziz1.zzE(flag);
    }

    ()
    {
    }
}
