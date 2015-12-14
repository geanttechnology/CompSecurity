// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.ad;

// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            a

final class a
    implements ad
{

    private a a;

    public final void a(float f)
    {
        com.socialin.android.photo.imgop.blending.a.b(a).set(com.socialin.android.photo.imgop.blending.a.a(a).f);
        com.socialin.android.photo.imgop.blending.a.b(a).mapRect(com.socialin.android.photo.imgop.blending.a.c(a), com.socialin.android.photo.imgop.blending.a.d(a));
        com.socialin.android.photo.imgop.blending.a.e(a).postScale(f, f);
    }

    public final void a(float f, float f1, float f2, float f3)
    {
        if (com.socialin.android.photo.imgop.blending.a.c(a).contains(com.socialin.android.photo.imgop.blending.a.a(f, f2), com.socialin.android.photo.imgop.blending.a.a(f1, f3)))
        {
            com.socialin.android.photo.imgop.blending.a.a(a).b = true;
            com.socialin.android.photo.imgop.blending.a.a(a).a = true;
            com.socialin.android.photo.imgop.blending.a.a(a).c = true;
            return;
        }
        if (android.os.d.VERSION.SDK_INT >= 11)
        {
            com.socialin.android.photo.imgop.blending.a.a(a).b = false;
        }
        com.socialin.android.photo.imgop.blending.a.a(a).a = false;
        com.socialin.android.photo.imgop.blending.a.a(a).c = false;
    }

    public final void b()
    {
        com.socialin.android.photo.imgop.blending.a.b(a).set(com.socialin.android.photo.imgop.blending.a.a(a).f);
        com.socialin.android.photo.imgop.blending.a.b(a).mapRect(com.socialin.android.photo.imgop.blending.a.c(a), com.socialin.android.photo.imgop.blending.a.d(a));
        com.socialin.android.photo.imgop.blending.a.f(a);
    }

    public final void c()
    {
        com.socialin.android.photo.imgop.blending.a.b(a).set(com.socialin.android.photo.imgop.blending.a.a(a).f);
        com.socialin.android.photo.imgop.blending.a.b(a).mapRect(com.socialin.android.photo.imgop.blending.a.c(a), com.socialin.android.photo.imgop.blending.a.d(a));
    }

    tector(a a1)
    {
        a = a1;
        super();
    }
}
