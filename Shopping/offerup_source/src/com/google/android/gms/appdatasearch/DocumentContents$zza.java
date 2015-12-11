// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            DocumentSection, DocumentContents

public class 
{

    private List zzQa;
    private String zzQb;
    private boolean zzQc;
    private Account zzQd;

    public  zzK(boolean flag)
    {
        zzQc = flag;
        return this;
    }

    public zzQc zza(DocumentSection documentsection)
    {
        if (zzQa == null)
        {
            zzQa = new ArrayList();
        }
        zzQa.add(documentsection);
        return this;
    }

    public zzQa zzb(Account account)
    {
        zzQd = account;
        return this;
    }

    public zzQd zzbx(String s)
    {
        zzQb = s;
        return this;
    }

    public DocumentContents zzlo()
    {
        String s = zzQb;
        boolean flag = zzQc;
        Account account = zzQd;
        DocumentSection adocumentsection[];
        if (zzQa != null)
        {
            adocumentsection = (DocumentSection[])zzQa.toArray(new DocumentSection[zzQa.size()]);
        } else
        {
            adocumentsection = null;
        }
        return new DocumentContents(s, flag, account, adocumentsection);
    }

    public ()
    {
    }
}
