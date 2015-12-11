// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package com.wishabi.flipp.widget:
//            p, CollectionView

final class q
    implements p
{

    p a;
    final CollectionView b;

    private q(CollectionView collectionview)
    {
        b = collectionview;
        super();
    }

    q(CollectionView collectionview, byte byte0)
    {
        this(collectionview);
    }

    public final void a(ActionMode actionmode, int i, long l, boolean flag)
    {
        a.a(actionmode, i, l, flag);
        if (b.getActivatedItemCount() == 0)
        {
            actionmode.finish();
        }
    }

    public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return a.onActionItemClicked(actionmode, menuitem);
    }

    public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        boolean flag = false;
        if (a.onCreateActionMode(actionmode, menu))
        {
            b.setLongClickable(false);
            flag = true;
        }
        return flag;
    }

    public final void onDestroyActionMode(ActionMode actionmode)
    {
        a.onDestroyActionMode(actionmode);
        CollectionView.a(b);
        CollectionView.b(b).clear();
        b.requestLayout();
        b.setLongClickable(true);
    }

    public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return a.onPrepareActionMode(actionmode, menu);
    }
}
