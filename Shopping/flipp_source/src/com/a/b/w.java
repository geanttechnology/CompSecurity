// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.a.b:
//            a, j, ad, am, 
//            ao, aj

final class w extends a
{

    j j;

    w(ad ad1, ImageView imageview, ao ao, boolean flag, boolean flag1, int i, Drawable drawable, 
            String s, j j1)
    {
        super(ad1, imageview, ao, flag, flag1, i, drawable, s);
        j = j1;
    }

    public final void a()
    {
        ImageView imageview = (ImageView)c.get();
        if (imageview != null)
        {
            if (f != 0)
            {
                imageview.setImageResource(f);
            } else
            if (g != null)
            {
                imageview.setImageDrawable(g);
            }
            if (j != null)
            {
                j.b();
                return;
            }
        }
    }

    public final void a(Bitmap bitmap, aj aj)
    {
        if (bitmap == null)
        {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] {
                this
            }));
        }
        ImageView imageview = (ImageView)c.get();
        if (imageview != null)
        {
            android.content.Context context = a.c;
            boolean flag = a.j;
            am.a(imageview, context, bitmap, aj, e, flag);
            if (j != null)
            {
                j.a();
                return;
            }
        }
    }

    final void b()
    {
        super.b();
        if (j != null)
        {
            j = null;
        }
    }
}
