// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.a.b:
//            aq, ap, j

final class m
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final aq a;
    final WeakReference b;
    j c;

    m(aq aq1, ImageView imageview, j j)
    {
        a = aq1;
        b = new WeakReference(imageview);
        c = j;
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
                int i = imageview.getMeasuredWidth();
                int j = imageview.getMeasuredHeight();
                if (i > 0 && j > 0)
                {
                    ((ViewTreeObserver) (obj)).removeOnPreDrawListener(this);
                    obj = a;
                    obj.d = false;
                    ((aq) (obj)).b.a(i, j);
                    ((aq) (obj)).a(imageview, c);
                    return true;
                }
            }
        }
        return true;
    }
}
