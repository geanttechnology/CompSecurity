// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            dk, cx, bi

final class db
    implements dk
{

    private cx a;

    db(cx cx1)
    {
        a = cx1;
    }

    public final void onAnimationCancel(View view)
    {
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof dk)
        {
            obj = (dk)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((dk) (obj)).onAnimationCancel(view);
        }
    }

    public final void onAnimationEnd(View view)
    {
        if (cx.c(a) >= 0)
        {
            bi.a(view, cx.c(a), null);
            cx.a(a, -1);
        }
        if (cx.b(a) != null)
        {
            cx.b(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof dk)
        {
            obj = (dk)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((dk) (obj)).onAnimationEnd(view);
        }
    }

    public final void onAnimationStart(View view)
    {
        if (cx.c(a) >= 0)
        {
            bi.a(view, 2, null);
        }
        if (cx.a(a) != null)
        {
            cx.a(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof dk)
        {
            obj = (dk)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((dk) (obj)).onAnimationStart(view);
        }
    }
}
