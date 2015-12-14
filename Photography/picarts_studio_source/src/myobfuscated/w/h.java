// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.w;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.resource.bitmap.aa;
import myobfuscated.ai.b;
import myobfuscated.f.m;
import myobfuscated.r.d;
import myobfuscated.v.ae;
import myobfuscated.v.af;

public final class h
    implements ae
{

    private final Context a;

    h(Context context)
    {
        a = context.getApplicationContext();
    }

    public final af buildLoadData(Object obj, int i, int j, e e1)
    {
        obj = (Uri)obj;
        if (m.a(i, j))
        {
            e1 = (Long)e1.a(aa.a);
            if (e1 != null && e1.longValue() == -1L)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                return new af(new b(obj), myobfuscated.r.b.a(a, ((Uri) (obj)), new d()));
            }
        }
        return null;
    }

    public final boolean handles(Object obj)
    {
        obj = (Uri)obj;
        return m.a(((Uri) (obj))) && m.b(((Uri) (obj)));
    }
}
