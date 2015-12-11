// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.d;
import android.support.v7.bz;
import android.support.v7.ca;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.p;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.u;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView, ListPopupWindow

public class ActionMenuPresenter extends b
    implements android.support.v4.view.d.a
{
    /* member class not found */
    class ActionButtonSubmenu {}

    private class ActionMenuPopupCallback extends android.support.v7.internal.view.menu.ActionMenuItemView.b
    {

        final ActionMenuPresenter this$0;

        public ListPopupWindow getPopup()
        {
            if (mActionButtonPopup != null)
            {
                return mActionButtonPopup.getPopup();
            } else
            {
                return null;
            }
        }

        private ActionMenuPopupCallback()
        {
            this$0 = ActionMenuPresenter.this;
            b();
        }

    }

    private class OverflowMenuButton extends TintImageView
        implements ActionMenuView.ActionMenuChildView
    {

        private final float mTempPts[] = new float[2];
        final ActionMenuPresenter this$0;

        public boolean needsDividerAfter()
        {
            return false;
        }

        public boolean needsDividerBefore()
        {
            return false;
        }

        public boolean performClick()
        {
            if (performClick())
            {
                return true;
            } else
            {
                playSoundEffect(0);
                showOverflowMenu();
                return true;
            }
        }

        protected boolean setFrame(int i, int j, int l, int i1)
        {
            boolean flag = setFrame(i, j, l, i1);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable drawable1 = getBackground();
            if (drawable != null && drawable1 != null)
            {
                int j1 = getWidth();
                j = getHeight();
                i = Math.max(j1, j) / 2;
                int k1 = getPaddingLeft();
                int l1 = getPaddingRight();
                l = getPaddingTop();
                i1 = getPaddingBottom();
                j1 = (j1 + (k1 - l1)) / 2;
                j = (j + (l - i1)) / 2;
                u.a(drawable1, j1 - i, j - i, j1 + i, j + i);
            }
            return flag;
        }

        public OverflowMenuButton(Context context)
        {
            this$0 = ActionMenuPresenter.this;
            TintImageView(context, null, android.support.v7.br.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new _cls1(ActionMenuPresenter.this));
        }
    }

    private class PopupPresenterCallback
        implements android.support.v7.internal.view.menu.l.a
    {

        final ActionMenuPresenter this$0;

        public void onCloseMenu(f f1, boolean flag)
        {
            if (f1 instanceof p)
            {
                ((p)f1).p().a(false);
            }
            android.support.v7.internal.view.menu.l.a a = getCallback();
            if (a != null)
            {
                a.onCloseMenu(f1, flag);
            }
        }

        public boolean onOpenSubMenu(f f1)
        {
            if (f1 == null)
            {
                return false;
            }
            mOpenSubMenuId = ((p)f1).getItem().getItemId();
            android.support.v7.internal.view.menu.l.a a = getCallback();
            boolean flag;
            if (a != null)
            {
                flag = a.onOpenSubMenu(f1);
            } else
            {
                flag = false;
            }
            return flag;
        }

        private PopupPresenterCallback()
        {
            this$0 = ActionMenuPresenter.this;
            Object();
        }

    }

    private static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int openSubMenuId;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(openSubMenuId);
        }


        SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            openSubMenuId = parcel.readInt();
        }
    }


    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context context)
    {
        b(context, android.support.v7.br.h.abc_action_menu_layout, android.support.v7.br.h.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuitem)
    {
        ViewGroup viewgroup = (ViewGroup)mMenuView;
        if (viewgroup != null) goto _L2; else goto _L1
_L1:
        View view = null;
_L6:
        return view;
_L2:
        int i;
        int j;
        j = viewgroup.getChildCount();
        i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        View view1;
        view1 = viewgroup.getChildAt(i);
        if (!(view1 instanceof android.support.v7.internal.view.menu.m.a))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = view1;
        if (((android.support.v7.internal.view.menu.m.a)view1).getItemData() == menuitem) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    public void bindItemView(h h1, android.support.v7.internal.view.menu.m.a a)
    {
        a.a(h1, 0);
        h1 = (ActionMenuView)mMenuView;
        a = (ActionMenuItemView)a;
        a.setItemInvoker(h1);
        if (mPopupCallback == null)
        {
            mPopupCallback = new ActionMenuPopupCallback();
        }
        a.setPopupCallback(mPopupCallback);
    }

    public boolean dismissPopupMenus()
    {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewgroup, int i)
    {
        if (viewgroup.getChildAt(i) == mOverflowButton)
        {
            return false;
        } else
        {
            return filterLeftoverView(viewgroup, i);
        }
    }

    public boolean flagActionItems()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int l;
        int i1;
        int i3;
        int i4;
        int j4;
label0:
        {
            arraylist = mMenu.i();
            i4 = arraylist.size();
            int i = mMaxItems;
            i3 = mActionItemWidthLimit;
            j4 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)mMenuView;
            i1 = 0;
            int j1 = 0;
            boolean flag = false;
            l = 0;
            while (l < i4) 
            {
                h h1 = (h)arraylist.get(l);
                if (h1.l())
                {
                    i1++;
                } else
                if (h1.k())
                {
                    j1++;
                } else
                {
                    flag = true;
                }
                if (mExpandedActionViewsExclusive && h1.isActionViewExpanded())
                {
                    i = 0;
                }
                l++;
            }
            l = i;
            if (!mReserveOverflow)
            {
                break label0;
            }
            if (!flag)
            {
                l = i;
                if (i1 + j1 <= i)
                {
                    break label0;
                }
            }
            l = i - 1;
        }
        l -= i1;
        SparseBooleanArray sparsebooleanarray = mActionButtonGroups;
        sparsebooleanarray.clear();
        int j = 0;
        int l1;
        boolean flag1;
        int k2;
        int l2;
        if (mStrictWidthLimit)
        {
            j = i3 / mMinCellSize;
            i1 = mMinCellSize;
            int k1 = mMinCellSize;
            k2 = (i3 % i1) / j + k1;
        } else
        {
            k2 = 0;
        }
        l2 = 0;
        flag1 = false;
        i1 = j;
        j = l;
        l1 = i3;
        l = ((flag1) ? 1 : 0);
        while (l2 < i4) 
        {
            h h2 = (h)arraylist.get(l2);
            int i2;
            if (h2.l())
            {
                View view = getItemView(h2, mScrapActionButtonView, viewgroup);
                if (mScrapActionButtonView == null)
                {
                    mScrapActionButtonView = view;
                }
                int j3;
                if (mStrictWidthLimit)
                {
                    i2 = i1 - ActionMenuView.measureChildForCells(view, k2, i1, j4, 0);
                } else
                {
                    view.measure(j4, j4);
                    i2 = i1;
                }
                i1 = view.getMeasuredWidth();
                if (l == 0)
                {
                    l = i1;
                }
                j3 = h2.getGroupId();
                if (j3 != 0)
                {
                    sparsebooleanarray.put(j3, true);
                }
                h2.d(true);
                l1 -= i1;
                i1 = j;
                j = l1;
            } else
            if (h2.k())
            {
                int k4 = h2.getGroupId();
                boolean flag3 = sparsebooleanarray.get(k4);
                boolean flag2;
                if ((j > 0 || flag3) && l1 > 0 && (!mStrictWidthLimit || i1 > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    View view1 = getItemView(h2, mScrapActionButtonView, viewgroup);
                    if (mScrapActionButtonView == null)
                    {
                        mScrapActionButtonView = view1;
                    }
                    int k3;
                    if (mStrictWidthLimit)
                    {
                        i2 = ActionMenuView.measureChildForCells(view1, k2, i1, j4, 0);
                        if (i2 == 0)
                        {
                            flag2 = false;
                        }
                        i1 -= i2;
                    } else
                    {
                        view1.measure(j4, j4);
                    }
                    i2 = view1.getMeasuredWidth();
                    k3 = l1 - i2;
                    l1 = l;
                    if (l == 0)
                    {
                        l1 = i2;
                    }
                    if (mStrictWidthLimit)
                    {
                        if (k3 >= 0)
                        {
                            l = 1;
                        } else
                        {
                            l = 0;
                        }
                        flag2 &= l;
                        l = l1;
                        i2 = i1;
                        l1 = k3;
                        i1 = l;
                        l = i2;
                    } else
                    {
                        if (k3 + l1 > 0)
                        {
                            l = 1;
                        } else
                        {
                            l = 0;
                        }
                        flag2 &= l;
                        l = i1;
                        i1 = l1;
                        l1 = k3;
                    }
                } else
                {
                    int j2 = l;
                    l = i1;
                    i1 = j2;
                }
                if (flag2 && k4 != 0)
                {
                    sparsebooleanarray.put(k4, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(k4, false);
                    int l3 = 0;
                    while (l3 < l2) 
                    {
                        h h3 = (h)arraylist.get(l3);
                        i2 = j;
                        if (h3.getGroupId() == k4)
                        {
                            i2 = j;
                            if (h3.j())
                            {
                                i2 = j + 1;
                            }
                            h3.d(false);
                        }
                        l3++;
                        j = i2;
                    }
                }
                i2 = j;
                if (flag2)
                {
                    i2 = j - 1;
                }
                h2.d(flag2);
                j = l1;
                l1 = i2;
                i2 = l;
                l = i1;
                i1 = l1;
            } else
            {
                h2.d(false);
                i2 = l1;
                l1 = j;
                j = i2;
                i2 = i1;
                i1 = l1;
            }
            j3 = l2 + 1;
            l2 = i1;
            i1 = i2;
            l1 = j;
            j = l2;
            l2 = j3;
        }
        return true;
    }

    public View getItemView(h h1, View view, ViewGroup viewgroup)
    {
        View view1 = h1.getActionView();
        if (view1 == null || h1.n())
        {
            view1 = getItemView(h1, view, viewgroup);
        }
        byte byte0;
        if (h1.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        h1 = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!h1.checkLayoutParams(view))
        {
            view1.setLayoutParams(h1.generateLayoutParams(view));
        }
        return view1;
    }

    public m getMenuView(ViewGroup viewgroup)
    {
        viewgroup = getMenuView(viewgroup);
        ((ActionMenuView)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public boolean hideOverflowMenu()
    {
        if (mPostedOpenRunnable != null && mMenuView != null)
        {
            ((View)mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowpopup = mOverflowPopup;
        if (overflowpopup != null)
        {
            overflowpopup.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean hideSubMenus()
    {
        if (mActionButtonPopup != null)
        {
            mActionButtonPopup.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public void initForMenu(Context context, f f1)
    {
        initForMenu(context, f1);
        f1 = context.getResources();
        context = ca.a(context);
        if (!mReserveOverflowSet)
        {
            mReserveOverflow = context.b();
        }
        if (!mWidthLimitSet)
        {
            mWidthLimit = context.c();
        }
        if (!mMaxItemsSet)
        {
            mMaxItems = context.a();
        }
        int i = mWidthLimit;
        if (mReserveOverflow)
        {
            if (mOverflowButton == null)
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(j, j);
            }
            i -= mOverflowButton.getMeasuredWidth();
        } else
        {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = i;
        mMinCellSize = (int)(56F * f1.getDisplayMetrics().density);
        mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending()
    {
        return mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing()
    {
        return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    public boolean isOverflowReserved()
    {
        return mReserveOverflow;
    }

    public void onCloseMenu(f f1, boolean flag)
    {
        dismissPopupMenus();
        onCloseMenu(f1, flag);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (!mMaxItemsSet)
        {
            mMaxItems = mContext.getResources().getInteger(android.support.v7.br.g.abc_max_action_buttons);
        }
        if (mMenu != null)
        {
            mMenu.b(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        if (((SavedState) (parcelable)).openSubMenuId > 0)
        {
            parcelable = mMenu.findItem(((SavedState) (parcelable)).openSubMenuId);
            if (parcelable != null)
            {
                onSubMenuSelected((p)parcelable.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState();
        savedstate.openSubMenuId = mOpenSubMenuId;
        return savedstate;
    }

    public boolean onSubMenuSelected(p p1)
    {
        if (!p1.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = p1; ((p) (obj)).s() != mMenu; obj = (p)((p) (obj)).s()) { }
        View view = findViewForItem(((p) (obj)).getItem());
        obj = view;
        if (view == null)
        {
            if (mOverflowButton == null)
            {
                return false;
            }
            obj = mOverflowButton;
        }
        mOpenSubMenuId = p1.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, p1);
        mActionButtonPopup.setAnchorView(((View) (obj)));
        mActionButtonPopup.show();
        onSubMenuSelected(p1);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean flag)
    {
        if (flag)
        {
            onSubMenuSelected(null);
            return;
        } else
        {
            mMenu.a(false);
            return;
        }
    }

    public void setExpandedActionViewsExclusive(boolean flag)
    {
        mExpandedActionViewsExclusive = flag;
    }

    public void setItemLimit(int i)
    {
        mMaxItems = i;
        mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionmenuview)
    {
        mMenuView = actionmenuview;
        actionmenuview.initialize(mMenu);
    }

    public void setReserveOverflow(boolean flag)
    {
        mReserveOverflow = flag;
        mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean flag)
    {
        mWidthLimit = i;
        mStrictWidthLimit = flag;
        mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, h h1)
    {
        return h1.j();
    }

    public boolean showOverflowMenu()
    {
        if (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null && mPostedOpenRunnable == null && !mMenu.l().isEmpty())
        {
            mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(mContext, mMenu, mOverflowButton, true));
            ((View)mMenuView).post(mPostedOpenRunnable);
            onSubMenuSelected(null);
            return true;
        } else
        {
            return false;
        }
    }

    public void updateMenuView(boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = false;
        Object obj = (ViewGroup)((View)mMenuView).getParent();
        if (obj != null)
        {
            bz.a(((ViewGroup) (obj)));
        }
        updateMenuView(flag);
        ((View)mMenuView).requestLayout();
        if (mMenu != null)
        {
            obj = mMenu.k();
            int l = ((ArrayList) (obj)).size();
            for (int i = 0; i < l; i++)
            {
                d d1 = ((h)((ArrayList) (obj)).get(i)).a();
                if (d1 != null)
                {
                    d1.setSubUiVisibilityListener(this);
                }
            }

        }
        int j;
        if (mMenu != null)
        {
            obj = mMenu.l();
        } else
        {
            obj = null;
        }
        j = ((flag2) ? 1 : 0);
        if (mReserveOverflow)
        {
            j = ((flag2) ? 1 : 0);
            if (obj != null)
            {
                j = ((ArrayList) (obj)).size();
                if (j == 1)
                {
                    if (!((h)((ArrayList) (obj)).get(0)).isActionViewExpanded())
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                } else
                if (j > 0)
                {
                    j = ((flag1) ? 1 : 0);
                } else
                {
                    j = 0;
                }
            }
        }
        if (j == 0) goto _L2; else goto _L1
_L1:
        if (mOverflowButton == null)
        {
            mOverflowButton = new OverflowMenuButton(mSystemContext);
        }
        obj = (ViewGroup)mOverflowButton.getParent();
        if (obj != mMenuView)
        {
            if (obj != null)
            {
                ((ViewGroup) (obj)).removeView(mOverflowButton);
            }
            obj = (ActionMenuView)mMenuView;
            ((ActionMenuView) (obj)).addView(mOverflowButton, ((ActionMenuView) (obj)).generateOverflowButtonLayoutParams());
        }
_L4:
        ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
        return;
_L2:
        if (mOverflowButton != null && mOverflowButton.getParent() == mMenuView)
        {
            ((ViewGroup)mMenuView).removeView(mOverflowButton);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



/*
    static OverflowPopup access$202(ActionMenuPresenter actionmenupresenter, OverflowPopup overflowpopup)
    {
        actionmenupresenter.mOverflowPopup = overflowpopup;
        return overflowpopup;
    }

*/



/*
    static OpenOverflowRunnable access$302(ActionMenuPresenter actionmenupresenter, OpenOverflowRunnable openoverflowrunnable)
    {
        actionmenupresenter.mPostedOpenRunnable = openoverflowrunnable;
        return openoverflowrunnable;
    }

*/






/*
    static ActionButtonSubmenu access$702(ActionMenuPresenter actionmenupresenter, ActionButtonSubmenu actionbuttonsubmenu)
    {
        actionmenupresenter.mActionButtonPopup = actionbuttonsubmenu;
        return actionbuttonsubmenu;
    }

*/



    // Unreferenced inner class android/support/v7/widget/ActionMenuPresenter$OverflowMenuButton$1

/* anonymous class */
    class OverflowMenuButton._cls1 extends ListPopupWindow.ForwardingListener
    {

        final OverflowMenuButton this$1;
        final ActionMenuPresenter val$this$0;

        public ListPopupWindow getPopup()
        {
            if (mOverflowPopup == null)
            {
                return null;
            } else
            {
                return mOverflowPopup.getPopup();
            }
        }

        public boolean onForwardingStarted()
        {
            showOverflowMenu();
            return true;
        }

        public boolean onForwardingStopped()
        {
            if (mPostedOpenRunnable != null)
            {
                return false;
            } else
            {
                hideOverflowMenu();
                return true;
            }
        }

            
            {
                this$1 = final_overflowmenubutton;
                this$0 = actionmenupresenter;
                ForwardingListener(View.this);
            }
    }

}
