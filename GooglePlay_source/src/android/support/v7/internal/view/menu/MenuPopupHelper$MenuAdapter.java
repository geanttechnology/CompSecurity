// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuPopupHelper, MenuBuilder, MenuItemImpl, ListMenuItemView

private final class findExpandedIndex extends BaseAdapter
{

    private MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    final MenuPopupHelper this$0;

    private void findExpandedIndex()
    {
        MenuItemImpl menuitemimpl = MenuPopupHelper.access$300(MenuPopupHelper.this).mExpandedItem;
        if (menuitemimpl != null)
        {
            ArrayList arraylist = MenuPopupHelper.access$300(MenuPopupHelper.this).getNonActionItems();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((MenuItemImpl)arraylist.get(i) == menuitemimpl)
                {
                    mExpandedIndex = i;
                    return;
                }
            }

        }
        mExpandedIndex = -1;
    }

    public final int getCount()
    {
        ArrayList arraylist;
        if (MenuPopupHelper.access$100(MenuPopupHelper.this))
        {
            arraylist = mAdapterMenu.getNonActionItems();
        } else
        {
            arraylist = mAdapterMenu.getVisibleItems();
        }
        if (mExpandedIndex < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
        }
    }

    public final MenuItemImpl getItem(int i)
    {
        ArrayList arraylist;
        int j;
        if (MenuPopupHelper.access$100(MenuPopupHelper.this))
        {
            arraylist = mAdapterMenu.getNonActionItems();
        } else
        {
            arraylist = mAdapterMenu.getVisibleItems();
        }
        j = i;
        if (mExpandedIndex >= 0)
        {
            j = i;
            if (i >= mExpandedIndex)
            {
                j = i + 1;
            }
        }
        return (MenuItemImpl)arraylist.get(j);
    }

    public final volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = MenuPopupHelper.access$200(MenuPopupHelper.this).inflate(0x7f040010, viewgroup, false);
        }
        view = (this._cls0)view1;
        if (mForceShowIcon)
        {
            viewgroup = (ListMenuItemView)view1;
            viewgroup.mForceShowIcon = true;
            viewgroup.mPreserveIconSpacing = true;
        }
        view._mth6b732f7b(getItem(i));
        return view1;
    }

    public final void notifyDataSetChanged()
    {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }


    public (MenuBuilder menubuilder)
    {
        this$0 = MenuPopupHelper.this;
        super();
        mExpandedIndex = -1;
        mAdapterMenu = menubuilder;
        findExpandedIndex();
    }
}
