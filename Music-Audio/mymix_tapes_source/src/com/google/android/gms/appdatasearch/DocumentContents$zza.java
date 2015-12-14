// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            DocumentContents, DocumentSection

public static class 
{

    private List zzOV;
    private String zzOW;
    private boolean zzOX;
    private Account zzOY;

    public  zzK(boolean flag)
    {
        zzOX = flag;
        return this;
    }

    public zzOX zza(Account account)
    {
        zzOY = account;
        return this;
    }

    public zzOY zza(DocumentSection documentsection)
    {
        if (zzOV == null)
        {
            zzOV = new ArrayList();
        }
        zzOV.add(documentsection);
        return this;
    }

    public zzOV zzbv(String s)
    {
        zzOW = s;
        return this;
    }

    public DocumentContents zzkY()
    {
        String s = zzOW;
        boolean flag = zzOX;
        Account account = zzOY;
        DocumentSection adocumentsection[];
        if (zzOV != null)
        {
            adocumentsection = (DocumentSection[])zzOV.toArray(new DocumentSection[zzOV.size()]);
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
