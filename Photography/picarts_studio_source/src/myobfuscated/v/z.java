// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.e;
import myobfuscated.ai.b;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.v:
//            ae, af, ab

public final class z
    implements ae
{

    private final Context a;

    z(Context context)
    {
        a = context;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = (Uri)obj;
        return new af(new b(obj), new ab(a, ((Uri) (obj))));
    }

    public final boolean handles(Object obj)
    {
        return m.a((Uri)obj);
    }
}
