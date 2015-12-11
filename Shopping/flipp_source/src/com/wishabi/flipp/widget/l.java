// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.wishabi.flipp.widget:
//            CollectionView, o, j, s

final class l
    implements android.view.View.OnLongClickListener
{

    static final boolean a;
    final j b;

    l(j j1)
    {
        b = j1;
        super();
    }

    public final boolean onLongClick(View view)
    {
        Object obj;
        int i;
        obj = (o)view.getLayoutParams();
        if (!a && obj == null)
        {
            throw new AssertionError();
        }
        i = ((o) (obj)).d;
        if (j.b(b) != null && i >= 0)
        {
            j.b(b).getItemId(i);
        }
        obj = b.h;
        if (((CollectionView) (obj)).b != 3)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (((CollectionView) (obj)).c != null || ((CollectionView) (obj)).startActionMode(((CollectionView) (obj)).d) == null) goto _L2; else goto _L1
_L1:
        ((CollectionView) (obj)).a(i, true);
        ((CollectionView) (obj)).performHapticFeedback(0);
_L4:
        return true;
_L2:
        if (((CollectionView) (obj)).c == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (!((CollectionView) (obj)).e.get(i, false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CollectionView) (obj)).a(i, flag);
        return true;
        if (((CollectionView) (obj)).a != null)
        {
            ((CollectionView) (obj)).performHapticFeedback(0);
            if (view != null)
            {
                view.sendAccessibilityEvent(2);
            }
            return ((CollectionView) (obj)).a.a();
        } else
        {
            return false;
        }
    }

    static 
    {
        boolean flag;
        if (!com/wishabi/flipp/widget/CollectionView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
