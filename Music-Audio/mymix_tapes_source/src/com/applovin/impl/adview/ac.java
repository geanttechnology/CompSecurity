// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.view.View;

// Referenced classes of package com.applovin.impl.adview:
//            x

class ac
    implements android.view.View.OnClickListener
{

    final x a;

    ac(x x1)
    {
        a = x1;
        super();
    }

    public void onClick(View view)
    {
        a.dismiss();
    }
}
