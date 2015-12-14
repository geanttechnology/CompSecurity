// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;

public class SortActionProvider extends ActionProvider
    implements android.view.MenuItem.OnMenuItemClickListener
{

    private final MenuInflater menuInflater = new MenuInflater(getContext());
    private int menuLayout;
    private OnSortingChangedListener onSortChangedListener;
    private int selectedMenuItem;

    public SortActionProvider(Context context)
    {
        super(context);
    }

    public boolean hasSubMenu()
    {
        return true;
    }

    public View onCreateActionView()
    {
        return null;
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i != selectedMenuItem)
        {
            if (onSortChangedListener != null)
            {
                onSortChangedListener.onSortingChanged(i);
            }
            selectedMenuItem = i;
            menuitem.setChecked(true);
        }
        return true;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
        submenu.clear();
        menuInflater.inflate(menuLayout, submenu);
        MenuItem menuitem = submenu.findItem(selectedMenuItem);
        submenu.setGroupCheckable(menuitem.getGroupId(), true, true);
        menuitem.setChecked(true);
        for (int i = 0; i < submenu.size(); i++)
        {
            submenu.getItem(i).setOnMenuItemClickListener(this);
        }

    }

    public void setOnSortChangedListener(OnSortingChangedListener onsortingchangedlistener)
    {
        onSortChangedListener = onsortingchangedlistener;
    }

    public void setupSort(int i, int j)
    {
        menuLayout = i;
        selectedMenuItem = j;
    }
}
