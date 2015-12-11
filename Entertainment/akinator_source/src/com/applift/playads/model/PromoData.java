// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.model;

import java.io.Serializable;

// Referenced classes of package com.applift.playads.model:
//            Promo

public final class PromoData
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public final String html;
    public final Promo promos[];

    public PromoData(Promo apromo[], String s)
    {
        promos = apromo;
        html = s;
    }
}
