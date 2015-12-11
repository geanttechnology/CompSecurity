// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.da;
import com.wishabi.flipp.widget.g;
import com.wishabi.flipp.widget.p;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.app:
//            ClippingsFragment

final class f
    implements p
{

    final ClippingsFragment a;

    f(ClippingsFragment clippingsfragment)
    {
        a = clippingsfragment;
        super();
    }

    public final void a(ActionMode actionmode, int j, long l, boolean flag)
    {
        actionmode.setTitle(a.getResources().getQuantityString(0x7f0d0006, ClippingsFragment.a(a).getActivatedItemCount(), new Object[] {
            Integer.valueOf(ClippingsFragment.a(a).getActivatedItemCount())
        }));
    }

    public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        Object obj;
        ArrayList arraylist;
        g g1;
        ArrayList arraylist1;
        int j;
        int l;
        int j1;
        int k1;
        obj = a.getActivity();
        g1 = (g)ClippingsFragment.a(a).getAdapter();
        if (g1 == null || obj == null)
        {
            return true;
        }
        obj = ((Activity) (obj)).getContentResolver();
        arraylist1 = new ArrayList();
        arraylist = new ArrayList();
        if (menuitem.getItemId() != 0x7f0b015a)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        menuitem = ClippingsFragment.a(a).getActivatedItemPositions();
        if (menuitem.size() == 0)
        {
            ClippingsFragment.a(a).a();
            return true;
        }
        if (ClippingsFragment.b(a) == null || ClippingsFragment.c(a) == null)
        {
            return true;
        }
        l = ClippingsFragment.b(a).getColumnIndexOrThrow("_id");
        j1 = ClippingsFragment.c(a).getColumnIndexOrThrow("_id");
        k1 = menuitem.size();
        j = 0;
_L2:
        int l1;
        if (j >= k1)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        l1 = menuitem.keyAt(j);
        switch (g1.getItemViewType(l1))
        {
        default:
            throw new IllegalStateException("Clipping adapter is reporting tap for untappable item");

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            arraylist1.add(Long.valueOf(((Cursor)g1.a(l1)).getLong(j1)));
            break;
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        arraylist.add(Integer.valueOf(((Cursor)g1.a(l1)).getInt(l)));
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        if (menuitem.getItemId() == 0x7f0b0159)
        {
            int i1 = ((da) (g1)).j;
            for (int k = 0; k < i1; k++)
            {
                ClippingsFragment.a(a).a(k, true);
            }

            return true;
        }
        if (arraylist1.isEmpty() && arraylist.isEmpty())
        {
            return true;
        }
        if (!arraylist1.isEmpty())
        {
            menuitem = q.a(arraylist1);
            ((ContentResolver) (obj)).delete(i.g, com.wishabi.flipp.util.f.a("_id", menuitem), menuitem);
        }
        if (!arraylist.isEmpty())
        {
            menuitem = new ContentValues();
            menuitem.put("clipped", Integer.valueOf(0));
            String as[] = q.a(arraylist);
            ((ContentResolver) (obj)).update(i.t, menuitem, com.wishabi.flipp.util.f.a("_id", as), as);
        }
        actionmode.finish();
        return true;
    }

    public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        actionmode = actionmode.getMenuInflater();
        if (actionmode == null)
        {
            return false;
        } else
        {
            actionmode.inflate(0x7f100003, menu);
            return true;
        }
    }

    public final void onDestroyActionMode(ActionMode actionmode)
    {
        ClippingsFragment.a(a, false);
    }

    public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        actionmode.setTitle(a.getResources().getQuantityString(0x7f0d0006, ClippingsFragment.a(a).getActivatedItemCount(), new Object[] {
            Integer.valueOf(ClippingsFragment.a(a).getActivatedItemCount())
        }));
        ClippingsFragment.a(a, true);
        return false;
    }
}
