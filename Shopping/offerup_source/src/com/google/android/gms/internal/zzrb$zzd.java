// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzdf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzae

public class <init>
{

    private String zzYk;
    private final List zzbao;
    private final Map zzbap;
    private int zzbaq;

    public <init> zzEf()
    {
        return new <init>(zzbao, zzbap, zzYk, zzbaq, null);
    }

    public zzbaq zzb(zzbaq zzbaq1)
    {
        zzbao.add(zzbaq1);
        return this;
    }

    public zzbao zzc(zzbao zzbao1)
    {
        String s = zzdf.zzg((g)zzbao1.zzEa().get(zzae.zzfu.toString()));
        List list = (List)zzbap.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzbap.put(s, obj);
        }
        ((List) (obj)).add(zzbao1);
        return this;
    }

    public zzbap zzfo(String s)
    {
        zzYk = s;
        return this;
    }

    public zzYk zzjC(int i)
    {
        zzbaq = i;
        return this;
    }

    private ()
    {
        zzbao = new ArrayList();
        zzbap = new HashMap();
        zzYk = "";
        zzbaq = 0;
    }

    zzbaq(zzbaq zzbaq1)
    {
        this();
    }
}
