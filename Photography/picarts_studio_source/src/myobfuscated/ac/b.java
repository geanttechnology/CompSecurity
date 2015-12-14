// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ac;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.resource.bitmap.w;
import myobfuscated.f.m;
import myobfuscated.s.g;

// Referenced classes of package myobfuscated.ac:
//            d

public final class b
    implements d
{

    private final Resources a;
    private final g b;

    public b(Resources resources, g g1)
    {
        a = (Resources)m.a(resources, "Argument must not be null");
        b = (g)m.a(g1, "Argument must not be null");
    }

    public final ad a(ad ad1)
    {
        return w.a(a, b, (Bitmap)ad1.b());
    }
}
