// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.view.View;

// Referenced classes of package com.applovin.impl.adview:
//            u, x

class ad
    implements android.view.View.OnClickListener
{

    final u a;
    final x b;

    ad(x x, u u1)
    {
        b = x;
        a = u1;
        super();
    }

    public void onClick(View view)
    {
        a.performClick();
    }
}
