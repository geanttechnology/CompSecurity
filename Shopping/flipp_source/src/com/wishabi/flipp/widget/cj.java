// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import com.wishabi.flipp.content.ad;
import com.wishabi.flipp.content.ai;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            eh, CollectionView, ci, aw

public final class cj extends eh
{

    private final Context a;
    private final CollectionView b;

    public cj(Context context, CollectionView collectionview)
    {
        a = context;
        b = collectionview;
    }

    public final int a()
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        } else
        {
            return ci1.b();
        }
    }

    public final int a(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        } else
        {
            return ci1.e.b(j).a();
        }
    }

    public final int a(int j, int k)
    {
        ci ci1;
        int i1;
        int j1;
        int k1;
        ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        }
        switch (ci1.c(j))
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            throw new InvalidParameterException("bad section id for search");

        case 6: // '\006'
            return Math.max(b.getMeasuredHeight() - i.a(48), i.a(240));

        case 1: // '\001'
            return (int)TypedValue.applyDimension(1, 180F, a.getResources().getDisplayMetrics());

        case 2: // '\002'
        case 3: // '\003'
            k1 = i.a(10);
            break;
        }
        i1 = i.a(15);
        j1 = i.a(50);
        ci1.e.b(j).b;
        JVM INSTR tableswitch 0 3: default 180
    //                   0 190
    //                   1 190
    //                   2 200
    //                   3 302;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        throw new InvalidParameterException("invalid section index");
_L2:
        throw new IllegalStateException("Search Layout is asking for ratio for a non-item.");
_L3:
        float f1;
        ad ad1 = new ad(ci1.b, ci1.c, k);
        f1 = (float)(ad1.b() - ad1.a()) / (float)(ad1.d() - ad1.c());
_L8:
        float f2;
        f1 = Math.min(f1, 1.1F);
        f2 = c(j) - k1;
        ci1.b(j);
        JVM INSTR tableswitch 2 3: default 292
    //                   2 335
    //                   3 428;
           goto _L5 _L6 _L7
_L5:
        throw new IllegalStateException("Requesting matchup for section that doesn't support matchups");
_L4:
        ai ai1 = (ai)ci1.a(j, k);
        f1 = ai1.e.height() / ai1.e.width();
          goto _L8
_L6:
        boolean flag;
        if (ci1.d == null || ci1.a == null)
        {
            flag = false;
        } else
        {
            ad ad2 = new ad(ci1.b, ci1.c, k);
            flag = aw.a((ArrayList)ci1.d.get(Long.valueOf(ad2.e())));
        }
_L9:
        ai ai2;
        if (flag)
        {
            j = i.a(55);
        } else
        {
            j = 0;
        }
        return Math.max((int)(f2 * f1), j1) + i1 + j;
_L7:
        if (ci1.d == null || ci1.a == null)
        {
            flag = false;
        } else
        {
            ai2 = (ai)ci1.a.get(k);
            flag = aw.a((ArrayList)ci1.d.get(Long.valueOf(ai2.a)));
        }
          goto _L9
    }

    public final void a(int j, Rect rect)
    {
        ci ci1 = (ci)b.getAdapter();
        if (a == null || ci1 == null)
        {
            rect.set(0, 0, 0, 0);
            return;
        }
        switch (ci1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section id for search");

        case 0: // '\0'
            rect.set(0, 0, 0, 0);
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            j = i.a(5);
            break;
        }
        rect.set(j, 0, j, j);
    }

    public final int b(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        }
        Rect rect = new Rect();
        a(j, rect);
        switch (ci1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section id for search");

        case 0: // '\0'
            return 1;

        case 1: // '\001'
            j = i.a(123);
            return (int)Math.ceil(((double)b.getMeasuredWidth() - 2D * (double)rect.left) / (double)j);

        case 2: // '\002'
        case 3: // '\003'
            j = i.a(180);
            break;
        }
        return Math.max(b.getMeasuredWidth() / j, 2);
    }

    public final int b(int j, int k)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        } else
        {
            return ci1.b(j, k);
        }
    }

    public final int c(int j)
    {
        Rect rect = new Rect();
        a(j, rect);
        j = b(j);
        return (b.getMeasuredWidth() - rect.left * 2) / j;
    }

    public final int d(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        }
        switch (ci1.b(j))
        {
        default:
            throw new IllegalStateException("Invalid section id for search");

        case 0: // '\0'
            return i.a(48);

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return i.a(26);
        }
    }

    public final int e(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        }
        switch (ci1.b(j))
        {
        default:
            throw new IllegalStateException("Invalid section id for search");

        case 0: // '\0'
            return i.a(0);

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return i.a(5);
        }
    }

    public final int f(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return 0;
        } else
        {
            return ci1.e.c() + j;
        }
    }

    public final boolean g(int j)
    {
        ci ci1 = (ci)b.getAdapter();
        if (ci1 == null)
        {
            return true;
        }
        switch (ci1.b(j))
        {
        default:
            throw new IllegalStateException("Invalid section id for search");

        case 0: // '\0'
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return true;
        }
    }
}
