// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            akf, akj, aky, akz, 
//            alb

class akq extends akf
{

    akj m;

    akq(aky aky1, ImageView imageview, alb alb, int i, int j, int k, Drawable drawable, 
            String s, Object obj, akj akj1, boolean flag)
    {
        super(aky1, imageview, alb, i, j, k, drawable, s, obj, flag);
        m = akj1;
    }

    public void a()
    {
        ImageView imageview = (ImageView)c.get();
        if (imageview != null)
        {
            if (g != 0)
            {
                imageview.setImageResource(g);
            } else
            if (h != null)
            {
                imageview.setImageDrawable(h);
            }
            if (m != null)
            {
                m.b();
                return;
            }
        }
    }

    public void a(Bitmap bitmap, aky.d d)
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
            boolean flag = a.k;
            akz.a(imageview, context, bitmap, d, this.d, flag);
            if (m != null)
            {
                m.a();
                return;
            }
        }
    }

    void b()
    {
        super.b();
        if (m != null)
        {
            m = null;
        }
    }
}
