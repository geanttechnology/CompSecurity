// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package jumiomobile:
//            ee

class eg
    implements android.view.ActionMode.Callback
{

    final ee a;

    eg(ee ee)
    {
        a = ee;
        super();
    }

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        return false;
    }

    public void onDestroyActionMode(ActionMode actionmode)
    {
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return false;
    }
}
