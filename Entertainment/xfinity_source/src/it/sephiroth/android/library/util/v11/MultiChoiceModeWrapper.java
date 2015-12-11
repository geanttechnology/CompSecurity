// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util.v11;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

// Referenced classes of package it.sephiroth.android.library.util.v11:
//            MultiChoiceModeListener

public class MultiChoiceModeWrapper
    implements MultiChoiceModeListener
{

    private AbsHListView mView;
    private MultiChoiceModeListener mWrapped;

    public MultiChoiceModeWrapper(AbsHListView abshlistview)
    {
        mView = abshlistview;
    }

    public boolean hasWrappedCallback()
    {
        return mWrapped != null;
    }

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return mWrapped.onActionItemClicked(actionmode, menuitem);
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        boolean flag = false;
        if (mWrapped.onCreateActionMode(actionmode, menu))
        {
            mView.setLongClickable(false);
            flag = true;
        }
        return flag;
    }

    public void onDestroyActionMode(ActionMode actionmode)
    {
        mWrapped.onDestroyActionMode(actionmode);
        mView.mChoiceActionMode = null;
        mView.clearChoices();
        mView.mDataChanged = true;
        mView.rememberSyncState();
        mView.requestLayout();
        mView.setLongClickable(true);
    }

    public void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag)
    {
        mWrapped.onItemCheckedStateChanged(actionmode, i, l, flag);
        if (mView.getCheckedItemCount() == 0)
        {
            actionmode.finish();
        }
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return mWrapped.onPrepareActionMode(actionmode, menu);
    }

    public void setWrapped(MultiChoiceModeListener multichoicemodelistener)
    {
        mWrapped = multichoicemodelistener;
    }
}
