// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.g;
import java.io.File;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            e

public final class b
    implements g
{

    private final myobfuscated.s.g a;
    private final g b;

    public b(myobfuscated.s.g g1, g g2)
    {
        a = g1;
        b = g2;
    }

    public final EncodeStrategy a(e e1)
    {
        return b.a(e1);
    }

    public final boolean a(Object obj, File file, e e1)
    {
        obj = (ad)obj;
        return b.a(new com.bumptech.glide.load.resource.bitmap.e(((BitmapDrawable)((ad) (obj)).b()).getBitmap(), a), file, e1);
    }
}
