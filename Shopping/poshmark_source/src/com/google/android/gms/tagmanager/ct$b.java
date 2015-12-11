// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            ct, by

private static class Wt
{

    private by WY;
    private com.google.android.gms.internal.b.WY Wt;

    public int getSize()
    {
        int j = ((com.google.android.gms.internal.b)WY.getObject()).W();
        int i;
        if (Wt == null)
        {
            i = 0;
        } else
        {
            i = Wt.W();
        }
        return i + j;
    }

    public com.google.android.gms.internal.b jG()
    {
        return Wt;
    }

    public by ka()
    {
        return WY;
    }

    public (by by1, com.google.android.gms.internal.b b1)
    {
        WY = by1;
        Wt = b1;
    }
}
