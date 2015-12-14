// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ac

class a
    implements android.view.OnClickListener
{

    final com.cyberlink.beautycircle.model.ProductTag a;
    final ac b;

    public void onClick(View view)
    {
        c.a(ac.h(b).getContext(), a.productId);
    }

    Tag(ac ac1, com.cyberlink.beautycircle.model.ProductTag producttag)
    {
        b = ac1;
        a = producttag;
        super();
    }
}
