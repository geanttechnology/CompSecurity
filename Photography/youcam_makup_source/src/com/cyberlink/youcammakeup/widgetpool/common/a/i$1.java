// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.graphics.Bitmap;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            i, h

class a
    implements android.view..OnLayoutChangeListener
{

    final h a;
    final i b;

    public void onLayoutChange(View view, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2)
    {
        if (i.a(b) == null)
        {
            return;
        }
        if (i.b(b) != view.getWidth())
        {
            i.a(b, Bitmap.createScaledBitmap(i.a(b), view.getWidth(), view.getHeight(), true));
            i.a(b, view.getWidth());
        }
        a.setImage(i.a(b));
    }

    (i j, h h1)
    {
        b = j;
        a = h1;
        super();
    }
}
