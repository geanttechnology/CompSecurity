// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            MeTabScrollView

class a
    implements android.view.er
{

    final MeTabScrollView a;

    public void onClick(View view)
    {
        while (MeTabScrollView.a(a) != null && MeTabScrollView.a(a).equals(view) || MeTabScrollView.g(a) == null) 
        {
            return;
        }
        MeTabScrollView.g(a).onClick(view);
    }

    I(MeTabScrollView metabscrollview)
    {
        a = metabscrollview;
        super();
    }
}
