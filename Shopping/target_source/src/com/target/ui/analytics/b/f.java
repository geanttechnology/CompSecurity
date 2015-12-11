// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.target.ui.fragment.cardstream.e;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class f extends a
{

    public final int cardColumn;
    public final int cardRow;
    public final e tappedCard;

    private f(e e, int i, int j)
    {
        tappedCard = e;
        cardRow = i;
        cardColumn = j;
    }

    public static f a(e e, int i)
    {
        return new f(e, i, 0);
    }
}
