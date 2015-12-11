// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;

// Referenced classes of package com.google.android.gms.internal:
//            zzfe

class zzAu
    implements android.content.nterface.OnClickListener
{

    final zzfe zzAu;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        zzAu.zzak("User canceled the download.");
    }

    Listener(zzfe zzfe1)
    {
        zzAu = zzfe1;
        super();
    }
}
