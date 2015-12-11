// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;

// Referenced classes of package com.google.android.gms.internal:
//            zzbk

class zzsg
    implements Runnable
{

    final View zzsg;
    final zzbk zzsh;

    public void run()
    {
        zzsh.zzg(zzsg);
    }

    (zzbk zzbk1, View view)
    {
        zzsh = zzbk1;
        zzsg = view;
        super();
    }
}
