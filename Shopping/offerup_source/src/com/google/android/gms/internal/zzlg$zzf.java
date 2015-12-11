// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzlg, zzli

class zzabX extends zzabX
{

    final zzlg zzabL;
    private final ArrayList zzabX;

    public void zznO()
    {
        Set set = zzlg.zzd(zzabL).zzaci;
        if (set.isEmpty())
        {
            set = zzlg.zzh(zzabL);
        }
        for (Iterator iterator = zzabX.iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.abX)iterator.next()).za(zzlg.zzg(zzabL), set)) { }
    }

    public (zzlg zzlg1, ArrayList arraylist)
    {
        zzabL = zzlg1;
        super(zzlg1, null);
        zzabX = arraylist;
    }
}
