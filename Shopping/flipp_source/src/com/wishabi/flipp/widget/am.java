// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Rect;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import java.security.InvalidParameterException;

// Referenced classes of package com.wishabi.flipp.widget:
//            eh, CollectionView, al

public final class am extends eh
{

    private final Context a;
    private final CollectionView b;

    public am(Context context, CollectionView collectionview)
    {
        a = context;
        b = collectionview;
    }

    public final int a()
    {
        al al1 = (al)b.getAdapter();
        if (al1 == null)
        {
            return 0;
        } else
        {
            return al1.b();
        }
    }

    public final int a(int j)
    {
        al al1 = (al)b.getAdapter();
        if (al1 == null)
        {
            return 0;
        } else
        {
            return al1.a.b(j).a();
        }
    }

    public final int a(int j, int k)
    {
        al al1 = (al)b.getAdapter();
        if (al1 == null || a == null)
        {
            return 0;
        }
        switch (al1.c(j))
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            throw new InvalidParameterException("Bad section requested");

        case 5: // '\005'
            return b.getMeasuredHeight() - i.a(48);

        case 1: // '\001'
        case 2: // '\002'
            return i.a(260);
        }
    }

    public final void a(int j, Rect rect)
    {
        al al1 = (al)b.getAdapter();
        if (a == null || al1 == null)
        {
            rect.set(0, 0, 0, 0);
            return;
        }
        switch (al1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
            rect.set(0, 0, 0, 0);
            return;

        case 1: // '\001'
        case 2: // '\002'
            j = i.a(5);
            break;
        }
        rect.set(j, 0, j, j);
    }

    public final int b(int j)
    {
        al al1 = (al)b.getAdapter();
        if (a == null || al1 == null)
        {
            return 0;
        }
        switch (al1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
            return 1;

        case 1: // '\001'
        case 2: // '\002'
            return Math.max(b.getMeasuredWidth() / i.a(180), 2);
        }
    }

    public final int b(int j, int k)
    {
        al al1 = (al)b.getAdapter();
        if (al1 == null)
        {
            return -1;
        } else
        {
            return al1.a(j, k);
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
        al al1 = (al)b.getAdapter();
        if (a == null || al1 == null)
        {
            return 0;
        }
        switch (al1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
            return i.a(48);

        case 1: // '\001'
        case 2: // '\002'
            return i.a(26);
        }
    }

    public final int e(int j)
    {
        al al1 = (al)b.getAdapter();
        if (a == null || al1 == null)
        {
            return 0;
        }
        switch (al1.b(j))
        {
        default:
            throw new InvalidParameterException("Bad section requested");

        case 0: // '\0'
            return i.a(0);

        case 1: // '\001'
        case 2: // '\002'
            return i.a(5);
        }
    }

    public final int f(int j)
    {
        al al1 = (al)b.getAdapter();
        if (al1 == null)
        {
            return -1;
        } else
        {
            return al1.a.c() + j;
        }
    }
}
