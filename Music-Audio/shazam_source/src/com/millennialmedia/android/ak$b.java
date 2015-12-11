// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            ab, ak, al, ao, 
//            aa

class nit> extends ab
{

    final ak p;

    public final void a(ao ao)
    {
        p.removeView(ao);
    }

    public final void a(ao ao, android.widget.iveLayout.LayoutParams layoutparams)
    {
        (new StringBuilder("MMLayout adding view (")).append(ao).append(") to ").append(this);
        al.d();
        p.addView(ao, layoutparams);
    }

    public final void a(boolean flag)
    {
        p.setClickable(flag);
    }

    final volatile aa d()
    {
        return p;
    }

    final int f()
    {
        return p.getId();
    }

    public outParams(ak ak1, Context context)
    {
        p = ak1;
        super(context);
    }
}
