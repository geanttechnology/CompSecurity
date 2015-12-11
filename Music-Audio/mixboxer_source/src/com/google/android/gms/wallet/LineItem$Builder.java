// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            LineItem

public final class <init>
{

    final LineItem Gz;

    public LineItem build()
    {
        return Gz;
    }

    public Gz setCurrencyCode(String s)
    {
        Gz.Gk = s;
        return this;
    }

    public Gz setDescription(String s)
    {
        Gz.description = s;
        return this;
    }

    public ion setQuantity(String s)
    {
        Gz.Gw = s;
        return this;
    }

    public Gz setRole(int i)
    {
        Gz.Gy = i;
        return this;
    }

    public Gz setTotalPrice(String s)
    {
        Gz.Gj = s;
        return this;
    }

    public Gz setUnitPrice(String s)
    {
        Gz.Gx = s;
        return this;
    }

    private (LineItem lineitem)
    {
        Gz = lineitem;
        super();
    }

    Gz(LineItem lineitem, Gz gz)
    {
        this(lineitem);
    }
}
