// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ad, ae

class a
    implements android.view.OnClickListener
{

    final ad a;

    public void onClick(View view)
    {
        if (ad.a(a) != null && ad.a(a).size() > 0)
        {
            for (view = ad.a(a).iterator(); view.hasNext(); ((ae)view.next()).a(a)) { }
        }
    }

    (ad ad1)
    {
        a = ad1;
        super();
    }
}
