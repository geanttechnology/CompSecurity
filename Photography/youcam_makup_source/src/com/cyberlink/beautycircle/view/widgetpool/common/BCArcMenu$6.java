// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCArcMenu, b

class a
    implements android.view.Listener
{

    final BCArcMenu a;

    public void onClick(View view)
    {
        if (BCArcMenu.f(a) != null)
        {
            BCArcMenu.f(a).d();
        }
    }

    (BCArcMenu bcarcmenu)
    {
        a = bcarcmenu;
        super();
    }
}
