// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.graphics.Bitmap;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            ai, al

final class a
    implements com.appnexus.opensdk.b.
{

    final al a;
    final a b;

    public final void a()
    {
        com.appnexus.opensdk.b.b.e(b.f, (new StringBuilder("Image downloading failed for url ")).append(a.b()).toString());
    }

    public final void a(Bitmap bitmap)
    {
        a.b(bitmap);
    }

    ( , al al1)
    {
        b = ;
        a = al1;
        super();
    }
}
