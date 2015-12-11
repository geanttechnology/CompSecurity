// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import io.presage.utils.e;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

final class d
    implements io.presage.try.h.a
{

    final a a;

    d(a a1)
    {
        a = a1;
        super();
    }

    public final void a()
    {
        e.b(new String[] {
            io/presage/formats/multiwebviews/a.getSimpleName(), "Back button pressed."
        });
        io.presage.formats.multiwebviews.a.a(a, "android", "back");
    }
}
