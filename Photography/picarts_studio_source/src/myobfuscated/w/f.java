// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.w;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.e;
import myobfuscated.ai.b;
import myobfuscated.f.m;
import myobfuscated.r.c;
import myobfuscated.v.ae;
import myobfuscated.v.af;

public final class f
    implements ae
{

    private Context a;

    public f(Context context)
    {
        a = context.getApplicationContext();
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = (Uri)obj;
        if (m.a(i, j))
        {
            return new af(new b(obj), myobfuscated.r.b.a(a, ((Uri) (obj)), new c()));
        } else
        {
            return null;
        }
    }

    public final boolean handles(Object obj)
    {
        obj = (Uri)obj;
        return m.a(((Uri) (obj))) && !m.b(((Uri) (obj)));
    }
}
