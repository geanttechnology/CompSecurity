// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.g.c:
//            y, e

final class h
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final y a;
    final WeakReference b;
    e c;

    h(y y1, ImageView imageview, e e)
    {
        a = y1;
        b = new WeakReference(imageview);
        c = e;
        imageview.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final boolean onPreDraw()
    {
        ImageView imageview = (ImageView)b.get();
        Object obj;
        if (imageview != null)
        {
            if (((ViewTreeObserver) (obj = imageview.getViewTreeObserver())).isAlive())
            {
                int i = imageview.getWidth();
                int j = imageview.getHeight();
                if (i > 0 && j > 0)
                {
                    ((ViewTreeObserver) (obj)).removeOnPreDrawListener(this);
                    obj = a;
                    obj.c = false;
                    ((y) (obj)).a(i, j).a(imageview, c);
                    return true;
                }
            }
        }
        return true;
    }
}
