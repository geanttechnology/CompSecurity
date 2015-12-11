// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.Map;

// Referenced classes of package com.a.b:
//            ap, ad, am, m, 
//            ba, aj, j, w

public final class aq
{

    public final ad a;
    public final ap b;
    public boolean c;
    public boolean d;
    public int e;
    private boolean f;
    private Drawable g;
    private int h;
    private Drawable i;

    aq()
    {
        a = null;
        b = new ap(null);
    }

    aq(ad ad1, Uri uri)
    {
        if (ad1.k)
        {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        } else
        {
            a = ad1;
            b = new ap(uri);
            return;
        }
    }

    public final void a(ImageView imageview, j j1)
    {
        if (imageview == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (b.a()) goto _L2; else goto _L1
_L1:
        a.a(imageview);
        am.a(imageview, e, g);
_L4:
        return;
_L2:
        ao ao;
        String s;
        if (d)
        {
            boolean flag;
            if (b.a != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int k = imageview.getMeasuredWidth();
            int l = imageview.getMeasuredHeight();
            if (k == 0 || l == 0)
            {
                am.a(imageview, e, g);
                ad ad1 = a;
                j1 = new m(this, imageview, j1);
                ad1.h.put(imageview, j1);
                return;
            }
            b.a(k, l);
        }
        ao = a.a(b.b());
        s = ba.a(ao);
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        android.graphics.Bitmap bitmap = a.b(s);
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        a.a(imageview);
        am.a(imageview, a.c, bitmap, aj.a, f, a.j);
        if (j1 != null)
        {
            j1.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        am.a(imageview, e, g);
        imageview = new w(a, imageview, ao, c, f, h, i, s, j1);
        a.a(imageview);
        return;
    }
}
