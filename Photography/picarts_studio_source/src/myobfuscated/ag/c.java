// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import myobfuscated.ah.e;
import myobfuscated.ah.f;

// Referenced classes of package myobfuscated.ag:
//            i

public abstract class c extends i
    implements f
{

    private Animatable b;

    public c(ImageView imageview)
    {
        super(imageview);
    }

    public final Drawable a()
    {
        return ((ImageView)a).getDrawable();
    }

    public final void a(Drawable drawable)
    {
        ((ImageView)a).setImageDrawable(drawable);
    }

    public abstract void a(Object obj);

    public void a(Object obj, e e1)
    {
        if (e1 == null || !e1.a(obj, this))
        {
            a(obj);
        }
        if (obj instanceof Animatable)
        {
            b = (Animatable)obj;
            b.start();
        }
    }

    public final void b(Drawable drawable)
    {
        super.b(drawable);
        a(null);
        a(drawable);
    }

    public final void c(Drawable drawable)
    {
        super.c(drawable);
        a(null);
        a(drawable);
    }

    public final void d()
    {
        if (b != null)
        {
            b.start();
        }
    }

    public final void d(Drawable drawable)
    {
        super.d(drawable);
        a(null);
        a(drawable);
    }

    public final void e()
    {
        if (b != null)
        {
            b.stop();
        }
    }
}
