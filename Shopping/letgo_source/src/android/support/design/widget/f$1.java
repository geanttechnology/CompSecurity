// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.support.v4.widget.u;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            f

class t> extends android.support.v4.widget.f._cls1
{

    final f a;
    private int b;

    private boolean a(View view, float f1)
    {
        if (f1 == 0.0F) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (ah.g(view) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f.c(a) != 2) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        if (f.c(a) == 0)
        {
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (f1 >= 0.0F)
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_64;
        if (f1 > 0.0F) goto _L3; else goto _L5
_L5:
        return false;
        if (f.c(a) != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f1 <= 0.0F)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
        if (f1 < 0.0F) goto _L3; else goto _L6
_L6:
        return false;
_L2:
        int i = view.getLeft();
        int j = b;
        int k = Math.round((float)view.getWidth() * f.d(a));
        if (Math.abs(i - j) < k)
        {
            return false;
        }
        if (true) goto _L3; else goto _L7
_L7:
        return false;
    }

    public int a(View view)
    {
        return view.getWidth();
    }

    public int a(View view, int i, int j)
    {
        int k;
        if (ah.g(view) == 1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (f.c(a) == 0)
        {
            if (j != 0)
            {
                k = b - view.getWidth();
                j = b;
            } else
            {
                k = b;
                j = b + view.getWidth();
            }
        } else
        if (f.c(a) == 1)
        {
            if (j != 0)
            {
                k = b;
                j = b + view.getWidth();
            } else
            {
                k = b - view.getWidth();
                j = b;
            }
        } else
        {
            k = b - view.getWidth();
            j = b + view.getWidth();
        }
        return f.a(k, i, j);
    }

    public void a(int i)
    {
        if (f.a(a) != null)
        {
            f.a(a).a(i);
        }
    }

    public void a(View view, float f1, float f2)
    {
        int i = view.getWidth();
        boolean flag = false;
        if (a(view, f1))
        {
            if (view.getLeft() < b)
            {
                i = b - i;
            } else
            {
                i = b + i;
            }
            flag = true;
        } else
        {
            i = b;
        }
        if (f.b(a).a(i, view.getTop()))
        {
            ah.a(view, new <init>(a, view, flag));
        } else
        if (flag && f.a(a) != null)
        {
            f.a(a).a(view);
            return;
        }
    }

    public void a(View view, int i, int j, int k, int l)
    {
        float f1 = (float)view.getWidth() * f.e(a);
        float f2 = (float)view.getWidth() * f.f(a);
        if ((float)i <= f1)
        {
            ah.c(view, 1.0F);
            return;
        }
        if ((float)i >= f2)
        {
            ah.c(view, 0.0F);
            return;
        } else
        {
            ah.c(view, f.b(0.0F, 1.0F - f.a(f1, f2, i), 1.0F));
            return;
        }
    }

    public boolean a(View view, int i)
    {
        b = view.getLeft();
        return true;
    }

    public int b(View view, int i, int j)
    {
        return view.getTop();
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
