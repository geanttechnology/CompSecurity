// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            i, ao

abstract class ai
{

    static final int b[] = {
        0x10100a7, 0x101009e
    };
    static final int c[] = {
        0x101009c, 0x101009e
    };
    static final int d[] = new int[0];
    final View e;
    final ao f;

    ai(View view, ao ao)
    {
        e = view;
        f = ao;
    }

    final Drawable a(int j, ColorStateList colorstatelist)
    {
        Resources resources = e.getResources();
        i k = d();
        k.a(resources.getColor(0x7f0e009f), resources.getColor(0x7f0e009e), resources.getColor(0x7f0e009c), resources.getColor(0x7f0e009d));
        k.a(j);
        k.a(colorstatelist.getDefaultColor());
        return k;
    }

    abstract void a();

    abstract void a(float f1);

    abstract void a(int j);

    abstract void a(ColorStateList colorstatelist);

    abstract void a(android.graphics.PorterDuff.Mode mode);

    abstract void a(Drawable drawable, ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode, int j, int k);

    abstract void a(int ai1[]);

    abstract void b();

    abstract void b(float f1);

    abstract void c();

    i d()
    {
        return new i();
    }

}
