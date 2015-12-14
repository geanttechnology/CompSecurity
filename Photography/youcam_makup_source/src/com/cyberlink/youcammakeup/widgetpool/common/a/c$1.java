// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.graphics.Bitmap;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            c, f

class a
    implements android.view..OnLayoutChangeListener
{

    final f a;
    final c b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (b.b == null)
        {
            return;
        }
        if (b.c != view.getWidth())
        {
            b.b = Bitmap.createScaledBitmap(b.b, view.getWidth(), view.getHeight(), true);
            b.c = view.getWidth();
        }
        a.setImage(b.b);
    }

    (c c1, f f1)
    {
        b = c1;
        a = f1;
        super();
    }
}
