// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ah;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

// Referenced classes of package myobfuscated.ah:
//            e, f

public final class b
    implements e
{

    private final e a;
    private final int b;

    public b(e e1, int i)
    {
        a = e1;
        b = i;
    }

    public final boolean a(Object obj, f f1)
    {
        obj = (Drawable)obj;
        Drawable drawable = f1.a();
        if (drawable != null)
        {
            obj = new TransitionDrawable(new Drawable[] {
                drawable, obj
            });
            ((TransitionDrawable) (obj)).setCrossFadeEnabled(true);
            ((TransitionDrawable) (obj)).startTransition(b);
            f1.a(((Drawable) (obj)));
            return true;
        } else
        {
            a.a(obj, f1);
            return false;
        }
    }
}
