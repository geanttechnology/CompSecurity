// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.sticker:
//            h, c, f, StickerFragment

class a
    implements h
{

    final long a;
    final c b;

    public void a(List list)
    {
        c.a(b);
        if (list != null)
        {
            list = new f(b.a, list, false, a);
            StickerFragment.f(b.a).put(String.valueOf(a), list);
        }
        if (StickerFragment.j(b.a) && c.b(b) >= c.c(b))
        {
            StickerFragment.a(b.a, false);
            c.d(b);
        }
    }

    kerFragment(c c1, long l)
    {
        b = c1;
        a = l;
        super();
    }
}
