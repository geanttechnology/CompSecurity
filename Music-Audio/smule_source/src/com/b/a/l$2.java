// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import junit.framework.Assert;

// Referenced classes of package com.b.a:
//            l, m, o, c, 
//            k

final class ject
    implements Runnable
{

    final m a;
    final String b;
    final Drawable c;
    final k d;
    final ImageView e;
    final ArrayList f;

    public void run()
    {
        Assert.assertEquals(Looper.myLooper(), Looper.getMainLooper());
        Object obj = a.f;
        Iterator iterator;
        int i;
        if (obj != null)
        {
            obj = new o(b, l.a, ((android.graphics.Bitmap) (obj)));
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            l.a((new StringBuilder()).append("No usable result, defaulting ").append(b).toString(), new Object[0]);
            obj = c;
            l.a().a(b, obj);
        }
        l.b().remove(b);
        if (d != null && e == null)
        {
            d.a(null, a.f, b, false);
        }
        iterator = f.iterator();
        i = 0;
        while (iterator.hasNext()) 
        {
            ImageView imageview = (ImageView)iterator.next();
            String s = (String)l.c().get(imageview);
            if (!b.equals(s))
            {
                l.a((new StringBuilder()).append("Ignoring out of date request to update view for ").append(b).append(" ").append(s).append(" ").append(imageview).toString(), new Object[0]);
            } else
            {
                l.c().remove(imageview);
                if (obj != null)
                {
                    imageview.setImageDrawable(((Drawable) (obj)));
                }
                if (d != null && imageview == e)
                {
                    d.a(imageview, a.f, b, false);
                }
                i++;
            }
        }
        l.a((new StringBuilder()).append("Populated: ").append(i).toString(), new Object[0]);
    }

    rayList(m m1, String s, Drawable drawable, k k1, ImageView imageview, ArrayList arraylist)
    {
        a = m1;
        b = s;
        c = drawable;
        d = k1;
        e = imageview;
        f = arraylist;
        super();
    }
}
