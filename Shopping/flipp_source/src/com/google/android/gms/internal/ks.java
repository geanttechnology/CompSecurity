// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.widget.ViewSwitcher;

// Referenced classes of package com.google.android.gms.internal:
//            x, jg, cu, ie, 
//            c, ee, eb, l

final class ks
{

    public final ViewSwitcher a;
    public final String b;
    public final Context c;
    public final jg d;
    public final cu e;
    public c f;
    public ee g;
    public x h;
    public eb i;
    public l j;

    public ks(Context context, x x1, String s, cu cu1)
    {
        if (x1.e)
        {
            a = null;
        } else
        {
            a = new ViewSwitcher(context);
            a.setMinimumWidth(x1.g);
            a.setMinimumHeight(x1.d);
            a.setVisibility(4);
        }
        h = x1;
        b = s;
        c = context;
        d = new jg(ie.a(cu1.b, context));
        e = cu1;
    }
}
