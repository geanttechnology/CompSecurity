// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bumptech.glide.request.b;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.ag:
//            h, j, g, k

public abstract class i extends h
{

    protected final View a;
    private final j b;

    public i(View view)
    {
        a = (View)m.a(view, "Argument must not be null");
        b = new j(view);
    }

    public final void a(b b1)
    {
        a.setTag(b1);
    }

    public final void a(g g1)
    {
        j j1 = b;
        int l = j1.c();
        int i1 = j1.b();
        if (j.a(l) && j.a(i1))
        {
            g1.a(l, i1);
        } else
        {
            if (!j1.b.contains(g1))
            {
                j1.b.add(g1);
            }
            if (j1.c == null)
            {
                g1 = j1.a.getViewTreeObserver();
                j1.c = new k(j1);
                g1.addOnPreDrawListener(j1.c);
                return;
            }
        }
    }

    public final b b()
    {
        Object obj = a.getTag();
        if (obj != null)
        {
            if (obj instanceof b)
            {
                return (b)obj;
            } else
            {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
        } else
        {
            return null;
        }
    }

    public final View c()
    {
        return a;
    }

    public void d(Drawable drawable)
    {
        super.d(drawable);
        b.a();
    }

    public String toString()
    {
        return (new StringBuilder("Target for: ")).append(a).toString();
    }
}
