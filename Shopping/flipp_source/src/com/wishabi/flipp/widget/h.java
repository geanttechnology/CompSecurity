// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Rect;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.widget:
//            eh, CollectionView, g, aw

public final class h extends eh
{

    private final Context a;
    private final CollectionView b;

    public h(Context context, CollectionView collectionview)
    {
        a = context;
        b = collectionview;
    }

    public final int a()
    {
        g g1 = (g)b.getAdapter();
        if (g1 == null)
        {
            return 0;
        } else
        {
            return g1.b();
        }
    }

    public final int a(int j)
    {
        g g1 = (g)b.getAdapter();
        if (g1 == null)
        {
            return 0;
        } else
        {
            return g1.e.b(j).a();
        }
    }

    public final int a(int j, int k)
    {
        Object obj;
        obj = (g)b.getAdapter();
        if (obj == null || a == null)
        {
            return 0;
        }
        ((g) (obj)).b(j);
        JVM INSTR tableswitch 0 1: default 56
    //                   0 66
    //                   1 392;
           goto _L1 _L2 _L3
_L1:
        throw new InvalidParameterException("Bad section requested");
_L2:
        float f1;
        float f2;
        int i1;
        int j1;
        int k1 = i.a(10);
        i1 = i.a(15);
        j1 = i.a(50);
        f1 = Math.min(((g) (obj)).f[k], 1.1F);
        f2 = c(j) - k1;
        ((g) (obj)).b(j);
        JVM INSTR tableswitch 0 1: default 140
    //                   0 150
    //                   1 271;
           goto _L4 _L5 _L6
_L4:
        throw new IllegalStateException("Invalid section height");
_L5:
        boolean flag;
        if (((g) (obj)).c == null || ((g) (obj)).a == null)
        {
            flag = false;
        } else
        {
            if (!((g) (obj)).a.moveToPosition(k))
            {
                throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(k).toString());
            }
            flag = aw.a((ArrayList)((g) (obj)).c.get(Long.valueOf(((g) (obj)).a.getLong(((g) (obj)).h))));
        }
_L7:
        if (flag)
        {
            j = i.a(55);
        } else
        {
            j = 0;
        }
        return Math.max((int)(f2 * f1), j1) + i1 + j;
_L6:
        if (((g) (obj)).d == null || ((g) (obj)).b == null)
        {
            flag = false;
        } else
        {
            if (!((g) (obj)).b.moveToPosition(k))
            {
                throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(k).toString());
            }
            obj = (ArrayList)((g) (obj)).d.get(Integer.valueOf(((g) (obj)).b.getInt(((g) (obj)).i)));
            if (obj == null || ((ArrayList) (obj)).isEmpty())
            {
                flag = false;
            } else
            {
                flag = true;
            }
        }
          goto _L7
_L3:
        return i.a(260);
    }

    public final void a(int j, Rect rect)
    {
        g g1 = (g)b.getAdapter();
        if (a == null || g1 == null)
        {
            rect.set(0, 0, 0, 0);
            return;
        }
        switch (g1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
        case 1: // '\001'
            j = i.a(5);
            break;
        }
        rect.set(j, 0, j, j);
    }

    public final int b(int j)
    {
        g g1 = (g)b.getAdapter();
        if (a == null || g1 == null)
        {
            return 0;
        }
        int k = Math.max(i.a() / 180, 2);
        switch (g1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
            return k;

        case 1: // '\001'
            return k;
        }
    }

    public final int b(int j, int k)
    {
        g g1 = (g)b.getAdapter();
        if (g1 == null)
        {
            return -1;
        } else
        {
            return g1.a(j, k);
        }
    }

    public final int c(int j)
    {
        if (a == null)
        {
            return 0;
        } else
        {
            int k = i.a(5);
            j = b(j);
            return (b.getMeasuredWidth() - k * 2) / j;
        }
    }

    public final int d(int j)
    {
        g g1 = (g)b.getAdapter();
        if (a == null || g1 == null)
        {
            return 0;
        }
        switch (g1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
        case 1: // '\001'
            return i.a(26);
        }
    }

    public final int e(int j)
    {
        g g1 = (g)b.getAdapter();
        if (a == null || g1 == null)
        {
            return 0;
        }
        switch (g1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
        case 1: // '\001'
            return i.a(5);
        }
    }

    public final int f(int j)
    {
        g g1 = (g)b.getAdapter();
        if (g1 == null)
        {
            return -1;
        } else
        {
            return g1.e.c() + j;
        }
    }
}
