// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.res.Resources;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity

final class a
    implements android.widget.deListener
{

    private DrawingGalleryActivity a;

    public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131755681: 
            DrawingGalleryActivity.f(a);
            break;
        }
        return true;
    }

    public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        actionmode.getMenuInflater().inflate(0x7f110001, menu);
        DrawingGalleryActivity.a(a, actionmode);
        return true;
    }

    public final void onDestroyActionMode(ActionMode actionmode)
    {
        DrawingGalleryActivity.a(a, null);
    }

    public final void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag)
    {
        i = DrawingGalleryActivity.g(a).getCheckedItemCount();
        actionmode.setTitle(a.getResources().getQuantityString(0x7f0a0001, i, new Object[] {
            Integer.valueOf(i)
        }));
        DrawingGalleryActivity.g(a).smoothScrollBy(0, 10);
    }

    public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return false;
    }

    stener(DrawingGalleryActivity drawinggalleryactivity)
    {
        a = drawinggalleryactivity;
        super();
    }
}
