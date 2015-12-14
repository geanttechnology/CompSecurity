// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.util.Log;
import android.widget.AbsListView;

// Referenced classes of package com.cyberlink.you.activity:
//            u

class a
    implements android.widget.istView.OnScrollListener
{

    final u a;
    private int b;
    private int c;
    private int d;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        b = i;
        c = j;
        d = k;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0 || i == 1 || i != 2);
        if (i == 0 && b + c == d)
        {
            Log.d("StickerShopAcitvity", "isBottom");
        }
        if (i == 0 && b == 0)
        {
            Log.d("StickerShopAcitvity", "isTop");
        }
    }

    rollListener(u u1)
    {
        a = u1;
        super();
    }
}
