// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            LineItem

public final class <init>
{

    final LineItem zzbcO;

    public final LineItem build()
    {
        return zzbcO;
    }

    public final zzbcO setCurrencyCode(String s)
    {
        zzbcO.zzbcj = s;
        return this;
    }

    public final zzbcO setDescription(String s)
    {
        zzbcO.description = s;
        return this;
    }

    public final ion setQuantity(String s)
    {
        zzbcO.zzbcL = s;
        return this;
    }

    public final zzbcO setRole(int i)
    {
        zzbcO.zzbcN = i;
        return this;
    }

    public final zzbcO setTotalPrice(String s)
    {
        zzbcO.zzbci = s;
        return this;
    }

    public final zzbcO setUnitPrice(String s)
    {
        zzbcO.zzbcM = s;
        return this;
    }

    private (LineItem lineitem)
    {
        zzbcO = lineitem;
        super();
    }

    zzbcO(LineItem lineitem, zzbcO zzbco)
    {
        this(lineitem);
    }
}
