// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.comcast.cim.android.view.common.Searchable;
import com.comcast.cim.android.view.common.SearchableFragment;

public abstract class MultiDeleteActionFragment extends SearchableFragment
{

    protected ActionMode actionMode;
    protected android.view.ActionMode.Callback actionModeCallback;
    protected TextView counterField;
    protected boolean isEditMode;

    public MultiDeleteActionFragment()
    {
        actionModeCallback = new android.view.ActionMode.Callback() {

            final MultiDeleteActionFragment this$0;

            public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
            {
                if (menuitem.getItemId() == com.xfinity.playerlib.R.id.delete)
                {
                    deleteItems();
                    actionmode.finish();
                    return true;
                } else
                {
                    return false;
                }
            }

            public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
            {
                setEditMode(true);
                View view = LayoutInflater.from(getActivity().getActionBar().getThemedContext()).inflate(com.xfinity.playerlib.R.layout.action_mode_custom, null);
                actionmode.setCustomView(view);
                counterField = (TextView)view.findViewById(com.xfinity.playerlib.R.id.counter);
                actionmode.getMenuInflater().inflate(com.xfinity.playerlib.R.menu.context_menu, menu);
                showSelectedCountOnActionMenu();
                return true;
            }

            public void onDestroyActionMode(ActionMode actionmode)
            {
                if (actionmode == actionMode)
                {
                    setEditMode(false);
                }
            }

            public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
            {
                return false;
            }

            
            {
                this$0 = MultiDeleteActionFragment.this;
                super();
            }
        };
    }

    protected abstract void deleteItems();

    protected abstract int getCheckedItemsCount();

    protected abstract int getTotalItemsCount();

    protected abstract int getViewLayoutId();

    protected abstract boolean isEditEnabled();

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        if (searchable == null || !searchable.isSearching())
        {
            menu = menu.findItem(com.xfinity.playerlib.R.id.menu_item_edit);
            menu.setVisible(true);
            menu.setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final MultiDeleteActionFragment this$0;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    startActionMode();
                    return false;
                }

            
            {
                this$0 = MultiDeleteActionFragment.this;
                super();
            }
            });
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (bundle != null)
        {
            isEditMode = bundle.getBoolean("isEditMode", false);
        }
        layoutinflater = (ViewGroup)layoutinflater.inflate(getViewLayoutId(), viewgroup, false);
        if (isEditEnabled())
        {
            setHasOptionsMenu(true);
        }
        return layoutinflater;
    }

    protected void onEditModeChanged(boolean flag)
    {
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        if (isEditMode)
        {
            startActionMode();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isEditMode", isEditMode);
    }

    protected void setEditMode(boolean flag)
    {
        if (isEditMode != flag)
        {
            isEditMode = flag;
            onEditModeChanged(isEditMode);
        }
    }

    protected void showSelectedCountOnActionMenu()
    {
        int i = getCheckedItemsCount();
        StringBuffer stringbuffer = new StringBuffer();
        if (i == 0)
        {
            stringbuffer.append(getActivity().getResources().getString(com.xfinity.playerlib.R.string.none));
        } else
        if (i < getTotalItemsCount())
        {
            stringbuffer.append(i);
        } else
        {
            stringbuffer.append(getActivity().getResources().getString(com.xfinity.playerlib.R.string.all));
        }
        stringbuffer.append(" ").append(getActivity().getResources().getString(com.xfinity.playerlib.R.string.selected));
        counterField.setText(stringbuffer.toString());
    }

    protected void startActionMode()
    {
        actionMode = getActivity().startActionMode(actionModeCallback);
    }
}
