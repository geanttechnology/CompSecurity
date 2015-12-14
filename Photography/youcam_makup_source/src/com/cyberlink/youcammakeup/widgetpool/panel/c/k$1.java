// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.graphics.Bitmap;
import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.a.f;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            k

class a
    implements android.view..OnLayoutChangeListener
{

    final f a;
    final k b;

    public void onLayoutChange(View view, int i, int j, int l, int i1, int j1, int k1, 
            int l1, int i2)
    {
        if (k.a(b) == null)
        {
            return;
        }
        if (k.b(b) != view.getWidth())
        {
            k.a(b, Bitmap.createScaledBitmap(k.a(b), view.getWidth(), view.getHeight(), true));
            k.a(b, view.getWidth());
        }
        a.setImage(k.a(b));
    }

    (k k1, f f1)
    {
        b = k1;
        a = f1;
        super();
    }
}
