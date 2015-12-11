// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package com.google.android.gms.internal:
//            zzfe

class zzAt
    implements android.content.nterface.OnClickListener
{

    final String zzAs;
    final String zzAt;
    final zzfe zzAu;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (DownloadManager)zzfe.zza(zzAu).getSystemService("download");
        try
        {
            dialoginterface.enqueue(zzAu.zzg(zzAs, zzAt));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            zzAu.zzak("Could not store picture.");
        }
    }

    Listener(zzfe zzfe1, String s, String s1)
    {
        zzAu = zzfe1;
        zzAs = s;
        zzAt = s1;
        super();
    }
}
