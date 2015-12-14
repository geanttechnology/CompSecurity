// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.PointF;
import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCArcMenu, ArcLayout

class a
    implements android.view.tChangeListener
{

    final BCArcMenu a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (BCArcMenu.a(a) != null)
        {
            j = BCArcMenu.a(a).getWidth();
            i = BCArcMenu.a(a).getHeight();
            BCArcMenu.a(a).setLeft((int)BCArcMenu.b(a).x - j / 2);
            BCArcMenu.a(a).setTop((int)BCArcMenu.b(a).y - i / 2);
            view = BCArcMenu.a(a);
            k = (int)BCArcMenu.b(a).x;
            view.setRight(j / 2 + k);
            view = BCArcMenu.a(a);
            j = (int)BCArcMenu.b(a).y;
            view.setBottom(i / 2 + j);
        }
    }

    (BCArcMenu bcarcmenu)
    {
        a = bcarcmenu;
        super();
    }
}
