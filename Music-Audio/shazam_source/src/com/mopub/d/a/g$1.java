// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import android.graphics.Bitmap;
import java.util.HashMap;

// Referenced classes of package com.mopub.d.a:
//            g

final class init>
    implements com.mopub.d.
{

    final String a;
    final g b;

    public final void a(Object obj)
    {
        obj = (Bitmap)obj;
        g g1 = b;
        String s = a;
        g1.a.a(s, ((Bitmap) (obj)));
        itmap itmap = (itmap)g1.b.remove(s);
        if (itmap != null)
        {
            itmap.a = ((Bitmap) (obj));
            g1.a(s, itmap);
        }
    }

    itmap(g g1, String s)
    {
        b = g1;
        a = s;
        super();
    }
}
