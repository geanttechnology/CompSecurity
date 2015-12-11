// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.widget.ViewSwitcher;

// Referenced classes of package com.google.android.gms.internal:
//            r, x, h, cu, 
//            g, ab, cm, cj, 
//            ae

private static final class ej
{

    public final String adUnitId;
    public final ViewSwitcher eg;
    public final Context eh;
    public final h ei;
    public final cu ej;
    public ab ek;
    public cm el;
    public x em;
    public cj en;
    public ae eo;

    public (Context context, x x1, String s, cu cu1)
    {
        if (x1.eG)
        {
            eg = null;
        } else
        {
            eg = new ViewSwitcher(context);
            eg.setMinimumWidth(x1.widthPixels);
            eg.setMinimumHeight(x1.heightPixels);
            eg.setVisibility(4);
        }
        em = x1;
        adUnitId = s;
        eh = context;
        ei = new h(g.a(cu1.iJ, context));
        ej = cu1;
    }
}
