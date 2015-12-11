// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import io.presage.utils.e;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

final class b
    implements a.b
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void a(String s)
    {
        e.b(new String[] {
            io/presage/formats/multiwebviews/a.getSimpleName(), "onOrientationChanged", s
        });
        io.presage.formats.multiwebviews.a.a(a, "android", s);
    }
}
