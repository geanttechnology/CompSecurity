// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;


// Referenced classes of package com.abtnprojects.ambatana:
//            h, d

class a
    implements Runnable
{

    final d a;
    final h b;

    public void run()
    {
        Object obj1 = null;
        h h1 = b;
        Object obj;
        if (a == null)
        {
            obj = null;
        } else
        {
            obj = a.a;
        }
        h.a(h1, ((android.graphics.Bitmap) (obj)));
        if (a == null)
        {
            obj = obj1;
        } else
        {
            obj = a.b;
        }
        if (h.a(b) != null && obj != null)
        {
            b.a(((android.net.Uri) (obj)));
            return;
        } else
        {
            h.a(b, 0x7f0900a0);
            return;
        }
    }

    (h h1, d d1)
    {
        b = h1;
        a = d1;
        super();
    }
}
