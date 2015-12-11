// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            bc, ay, ah

static class a
    implements bc
{

    ay a;

    public void onAnimationCancel(View view)
    {
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof bc)
        {
            obj = (bc)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((bc) (obj)).onAnimationCancel(view);
        }
    }

    public void onAnimationEnd(View view)
    {
        if (ay.c(a) >= 0)
        {
            ah.a(view, ay.c(a), null);
            ay.a(a, -1);
        }
        if (ay.b(a) != null)
        {
            ay.b(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof bc)
        {
            obj = (bc)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((bc) (obj)).onAnimationEnd(view);
        }
    }

    public void onAnimationStart(View view)
    {
        if (ay.c(a) >= 0)
        {
            ah.a(view, 2, null);
        }
        if (ay.a(a) != null)
        {
            ay.a(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof bc)
        {
            obj = (bc)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((bc) (obj)).onAnimationStart(view);
        }
    }

    (ay ay1)
    {
        a = ay1;
    }
}
