// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuPresenter, MenuView, MenuBuilder, j, 
//            v

public abstract class d
    implements MenuPresenter
{

    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public d(Context context, int i, int k)
    {
        mSystemContext = context;
        mSystemInflater = LayoutInflater.from(context);
        mMenuLayoutRes = i;
        mItemLayoutRes = k;
    }

    protected void addItemView(View view, int i)
    {
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(view);
        }
        ((ViewGroup)mMenuView).addView(view, i);
    }

    public abstract void bindItemView(j j1, MenuView.ItemView itemview);

    public boolean collapseItemActionView(MenuBuilder menubuilder, j j1)
    {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewgroup)
    {
        return (MenuView.ItemView)mSystemInflater.inflate(mItemLayoutRes, viewgroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, j j1)
    {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup viewgroup, int i)
    {
        viewgroup.removeViewAt(i);
        return true;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public MenuPresenter.Callback getCallback()
    {
        return mCallback;
    }

    public int getId()
    {
        return mId;
    }

    public View getItemView(j j1, View view, ViewGroup viewgroup)
    {
        if (view instanceof MenuView.ItemView)
        {
            view = (MenuView.ItemView)view;
        } else
        {
            view = createItemView(viewgroup);
        }
        bindItemView(j1, view);
        return (View)view;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        if (mMenuView == null)
        {
            mMenuView = (MenuView)mSystemInflater.inflate(mMenuLayoutRes, viewgroup, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        }
        return mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mMenu = menubuilder;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if (mCallback != null)
        {
            mCallback.onCloseMenu(menubuilder, flag);
        }
    }

    public boolean onSubMenuSelected(v v)
    {
        if (mCallback != null)
        {
            return mCallback.onOpenSubMenu(v);
        } else
        {
            return false;
        }
    }

    public void setCallback(MenuPresenter.Callback callback)
    {
        mCallback = callback;
    }

    public void setId(int i)
    {
        mId = i;
    }

    public boolean shouldIncludeItem(int i, j j1)
    {
        return true;
    }

    public void updateMenuView(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)mMenuView;
        if (viewgroup != null)
        {
            int k;
            if (mMenu != null)
            {
                mMenu.j();
                ArrayList arraylist = mMenu.i();
                int i1 = arraylist.size();
                int l = 0;
                int i = 0;
                do
                {
                    k = i;
                    if (l >= i1)
                    {
                        break;
                    }
                    j j2 = (j)arraylist.get(l);
                    if (shouldIncludeItem(i, j2))
                    {
                        View view = viewgroup.getChildAt(i);
                        j j1;
                        View view1;
                        if (view instanceof MenuView.ItemView)
                        {
                            j1 = ((MenuView.ItemView)view).getItemData();
                        } else
                        {
                            j1 = null;
                        }
                        view1 = getItemView(j2, view, viewgroup);
                        if (j2 != j1)
                        {
                            view1.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(view1);
                        }
                        if (view1 != view)
                        {
                            addItemView(view1, i);
                        }
                        i++;
                    }
                    l++;
                } while (true);
            } else
            {
                k = 0;
            }
            while (k < viewgroup.getChildCount()) 
            {
                if (!filterLeftoverView(viewgroup, k))
                {
                    k++;
                }
            }
        }
    }
}
