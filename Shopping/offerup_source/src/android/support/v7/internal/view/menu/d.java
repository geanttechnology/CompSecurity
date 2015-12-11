// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.bi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            x, aa, z, y, 
//            i, m, ac

public abstract class d
    implements x
{

    private y mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected i mMenu;
    private int mMenuLayoutRes;
    protected z mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public d(Context context, int j, int k)
    {
        mSystemContext = context;
        mSystemInflater = LayoutInflater.from(context);
        mMenuLayoutRes = j;
        mItemLayoutRes = k;
    }

    protected void addItemView(View view, int j)
    {
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(view);
        }
        ((ViewGroup)mMenuView).addView(view, j);
    }

    public abstract void bindItemView(m m1, aa aa1);

    public boolean collapseItemActionView(i j, m m1)
    {
        return false;
    }

    public aa createItemView(ViewGroup viewgroup)
    {
        return (aa)mSystemInflater.inflate(mItemLayoutRes, viewgroup, false);
    }

    public boolean expandItemActionView(i j, m m1)
    {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup viewgroup, int j)
    {
        viewgroup.removeViewAt(j);
        return true;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public y getCallback()
    {
        return mCallback;
    }

    public int getId()
    {
        return mId;
    }

    public View getItemView(m m1, View view, ViewGroup viewgroup)
    {
        if (view instanceof aa)
        {
            view = (aa)view;
        } else
        {
            view = createItemView(viewgroup);
        }
        bindItemView(m1, view);
        return (View)view;
    }

    public z getMenuView(ViewGroup viewgroup)
    {
        if (mMenuView == null)
        {
            mMenuView = (z)mSystemInflater.inflate(mMenuLayoutRes, viewgroup, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        }
        return mMenuView;
    }

    public void initForMenu(Context context, i j)
    {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mMenu = j;
    }

    public void onCloseMenu(i j, boolean flag)
    {
        if (mCallback != null)
        {
            mCallback.onCloseMenu(j, flag);
        }
    }

    public boolean onSubMenuSelected(ac ac)
    {
        if (mCallback != null)
        {
            return mCallback.onOpenSubMenu(ac);
        } else
        {
            return false;
        }
    }

    public void setCallback(y y1)
    {
        mCallback = y1;
    }

    public void setId(int j)
    {
        mId = j;
    }

    public boolean shouldIncludeItem(int j, m m1)
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
                mMenu.k();
                ArrayList arraylist = mMenu.j();
                int i1 = arraylist.size();
                int l = 0;
                int j = 0;
                do
                {
                    k = j;
                    if (l >= i1)
                    {
                        break;
                    }
                    m m2 = (m)arraylist.get(l);
                    if (shouldIncludeItem(j, m2))
                    {
                        View view = viewgroup.getChildAt(j);
                        m m1;
                        View view1;
                        if (view instanceof aa)
                        {
                            m1 = ((aa)view).getItemData();
                        } else
                        {
                            m1 = null;
                        }
                        view1 = getItemView(m2, view, viewgroup);
                        if (m2 != m1)
                        {
                            view1.setPressed(false);
                            bi.w(view1);
                        }
                        if (view1 != view)
                        {
                            addItemView(view1, j);
                        }
                        j++;
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
