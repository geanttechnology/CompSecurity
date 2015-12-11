// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.util.HashSet;

// Referenced classes of package com.b.a:
//            p, l, f, c

class o extends BitmapDrawable
{

    p a;
    String b;

    public o(String s, Resources resources, Bitmap bitmap)
    {
        this(s, resources, bitmap, new p(null));
    }

    private o(String s, Resources resources, Bitmap bitmap, p p1)
    {
        super(resources, bitmap);
        b = s;
        a = p1;
        l.d().add(bitmap);
        l.e().a(s);
        l.a().a(s, this);
        s = a;
        s.a = ((p) (s)).a + 1;
    }

    public o a(Resources resources)
    {
        return new o(b, resources, getBitmap(), a);
    }

    public void a()
    {
        l.a((new StringBuilder()).append("BOOM! Headshot: ").append(b).toString(), new Object[0]);
        a.b = true;
        l.a().b(b);
        l.d().remove(getBitmap());
    }

    protected void finalize()
    {
        super.finalize();
        p p1 = a;
        p1.a = p1.a - 1;
        if (a.a == 0)
        {
            if (!a.b)
            {
                l.e().b(b, getBitmap());
            }
            l.d().remove(getBitmap());
            l.a().b(b);
            l.a((new StringBuilder()).append("Zombie GC event ").append(b).toString(), new Object[0]);
        }
    }
}
