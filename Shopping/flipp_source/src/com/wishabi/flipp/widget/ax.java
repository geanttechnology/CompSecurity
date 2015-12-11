// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.wishabi.flipp.app.FlippApplication;
import com.wishabi.flipp.util.i;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.widget:
//            eh, CollectionView, bw, by, 
//            ay, da

public final class ax extends eh
{

    private final Context a;
    private final CollectionView b;

    public ax(Context context, CollectionView collectionview)
    {
        a = context;
        b = collectionview;
    }

    public final int a()
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return 0;
        } else
        {
            return bw1.b();
        }
    }

    public final int a(int j)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return 0;
        } else
        {
            return ((by)bw1.c.get(j)).b;
        }
    }

    public final int a(int j, int k)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return 0;
        }
        j = bw1.b(j);
        switch (ay.a[j - 1])
        {
        default:
            return i.a(180);

        case 2: // '\002'
            return i.a(210);
        }
    }

    public final void a(int j, Rect rect)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return;
        }
        j = bw1.b(j);
        ay.a[j - 1];
        JVM INSTR tableswitch 1 1: default 48
    //                   1 75;
           goto _L1 _L2
_L1:
        j = (int)TypedValue.applyDimension(1, 5F, a.getResources().getDisplayMetrics());
_L4:
        rect.set(j, 0, j, j);
        return;
_L2:
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int b(int j)
    {
        boolean flag = false;
        int k = -1;
        Object obj = (bw)b.getAdapter();
        ((bw) (obj)).b(j);
        switch (ay.a[((bw) (obj)).b(j) - 1])
        {
        default:
            return 0;

        case 1: // '\001'
            return 3;

        case 2: // '\002'
            j = i.a(300);
            k = i.a(5);
            return Math.max((int)Math.floor(((double)b.getMeasuredWidth() - (double)k * 2D) / (double)j), 1);

        case 3: // '\003'
            j = i.a(123);
            break;
        }
        int l = i.a(5);
        l = (int)Math.ceil(((double)b.getMeasuredWidth() - (double)l * 2D) / (double)j);
        obj = FlippApplication.b();
        if (obj == null)
        {
            j = -1;
        } else
        {
            j = ((Context) (obj)).getResources().getDisplayMetrics().heightPixels;
        }
        obj = FlippApplication.b();
        if (obj != null)
        {
            k = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
        }
        if (j >= k)
        {
            flag = true;
        }
        if (flag)
        {
            j = 5;
        } else
        {
            j = 9;
        }
        return Math.min(l, j);
    }

    public final int b(int j, int k)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return -1;
        } else
        {
            return bw1.a(j, k);
        }
    }

    public final int c(int j)
    {
        int k = (int)TypedValue.applyDimension(1, 5F, a.getResources().getDisplayMetrics());
        int l = (int)TypedValue.applyDimension(1, 10F, a.getResources().getDisplayMetrics());
        j = b(j);
        return (b.getMeasuredWidth() - k * 2 - l * (j - 1)) / j;
    }

    public final int d(int j)
    {
        bw bw1;
        int k;
        bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return 0;
        }
        k = bw1.b(j);
        ay.a[k - 1];
        JVM INSTR tableswitch 1 1: default 48
    //                   1 85;
           goto _L1 _L2
_L1:
        if (bw1.b && j == 1 || j == 0)
        {
            j = 26;
        } else
        {
            j = 0;
        }
_L4:
        return (int)TypedValue.applyDimension(1, j, a.getResources().getDisplayMetrics());
_L2:
        j = 48;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int e(int j)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return 0;
        }
        j = bw1.b(j);
        ay.a[j - 1];
        JVM INSTR tableswitch 1 1: default 48
    //                   1 68;
           goto _L1 _L2
_L1:
        j = 5;
_L4:
        return (int)TypedValue.applyDimension(1, j, a.getResources().getDisplayMetrics());
_L2:
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int f(int j)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return -1;
        } else
        {
            return ((da) (bw1)).j + j;
        }
    }

    public final boolean g(int j)
    {
        bw bw1 = (bw)b.getAdapter();
        if (bw1 == null)
        {
            return true;
        }
        bw1.b(j);
        return !bw1.b || j != 0;
    }
}
