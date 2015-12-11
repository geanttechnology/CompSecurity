// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import io.presage.ads.NewAd;
import io.presage.utils.e;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

final class c
    implements a.a
{

    final a a;

    c(a a1)
    {
        a = a1;
        super();
    }

    public final void a()
    {
        e.b(new String[] {
            io/presage/formats/multiwebviews/a.getSimpleName(), "Soft key pressed (home or recent apps)."
        });
        io.presage.formats.multiwebviews.a.a(a).onFormatEvent("close_system_dialog");
        io.presage.formats.multiwebviews.a.a(a, "android", "close_system_dialog");
    }
}
