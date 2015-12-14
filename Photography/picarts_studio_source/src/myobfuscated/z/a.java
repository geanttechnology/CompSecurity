// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.z;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.ad;
import myobfuscated.f.m;

public abstract class a
    implements ad
{

    public final Drawable a;

    public a(Drawable drawable)
    {
        a = (Drawable)m.a(drawable, "Argument must not be null");
    }

    public final Object b()
    {
        return a.getConstantState().newDrawable();
    }
}
