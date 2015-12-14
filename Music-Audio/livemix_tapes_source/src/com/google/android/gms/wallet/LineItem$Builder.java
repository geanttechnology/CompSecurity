// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            LineItem

public final class <init>
{

    final LineItem zzaWH;

    public LineItem build()
    {
        return zzaWH;
    }

    public zzaWH setCurrencyCode(String s)
    {
        zzaWH.zzaWc = s;
        return this;
    }

    public zzaWH setDescription(String s)
    {
        zzaWH.description = s;
        return this;
    }

    public ion setQuantity(String s)
    {
        zzaWH.zzaWE = s;
        return this;
    }

    public zzaWH setRole(int i)
    {
        zzaWH.zzaWG = i;
        return this;
    }

    public zzaWH setTotalPrice(String s)
    {
        zzaWH.zzaWb = s;
        return this;
    }

    public zzaWH setUnitPrice(String s)
    {
        zzaWH.zzaWF = s;
        return this;
    }

    private (LineItem lineitem)
    {
        zzaWH = lineitem;
        super();
    }

    zzaWH(LineItem lineitem, zzaWH zzawh)
    {
        this(lineitem);
    }
}
