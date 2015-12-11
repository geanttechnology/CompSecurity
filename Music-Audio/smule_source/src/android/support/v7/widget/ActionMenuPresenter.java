// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.d;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.r;
import android.support.v7.internal.view.menu.v;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView

public class ActionMenuPresenter extends d
    implements android.support.v4.view.ActionProvider.SubUiVisibilityListener
{

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
        super(context, android.support.v7.appcompat.R.layout.abc_action_menu_layout, android.support.v7.appcompat.R.layout.abc_action_menu_item_layout);
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
        int k;
        k = viewgroup.getChildCount();
        i = 0;
_L7:
        if (i >= k) goto _L4; else goto _L3
_L3:
        View view1;
        view1 = viewgroup.getChildAt(i);
        if (!(view1 instanceof android.support.v7.internal.view.menu.MenuView.ItemView))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = view1;
        if (((android.support.v7.internal.view.menu.MenuView.ItemView)view1).getItemData() == menuitem) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    public void bindItemView(j j1, android.support.v7.internal.view.menu.MenuView.ItemView itemview)
    {
        itemview.initialize(j1, 0);
        j1 = (ActionMenuView)mMenuView;
        itemview = (ActionMenuItemView)itemview;
        itemview.setItemInvoker(j1);
        if (mPopupCallback == null)
        {
            mPopupCallback = new ActionMenuPopupCallback();
        }
        itemview.setPopupCallback(mPopupCallback);
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
            return super.filterLeftoverView(viewgroup, i);
        }
    }

    public boolean flagActionItems()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int l;
        int i1;
        int l3;
        int l4;
        int i5;
label0:
        {
            arraylist = mMenu.i();
            l4 = arraylist.size();
            int i = mMaxItems;
            l3 = mActionItemWidthLimit;
            i5 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)mMenuView;
            i1 = 0;
            int k1 = 0;
            boolean flag = false;
            l = 0;
            while (l < l4) 
            {
                j j1 = (j)arraylist.get(l);
                if (j1.k())
                {
                    i1++;
                } else
                if (j1.j())
                {
                    k1++;
                } else
                {
                    flag = true;
                }
                if (mExpandedActionViewsExclusive && j1.isActionViewExpanded())
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
                if (i1 + k1 <= i)
                {
                    break label0;
                }
            }
            l = i - 1;
        }
        l -= i1;
        SparseBooleanArray sparsebooleanarray = mActionButtonGroups;
        sparsebooleanarray.clear();
        int k = 0;
        int i2;
        boolean flag1;
        int i3;
        int k3;
        if (mStrictWidthLimit)
        {
            k = l3 / mMinCellSize;
            i1 = mMinCellSize;
            int l1 = mMinCellSize;
            i3 = (l3 % i1) / k + l1;
        } else
        {
            i3 = 0;
        }
        k3 = 0;
        flag1 = false;
        i1 = k;
        k = l;
        i2 = l3;
        l = ((flag1) ? 1 : 0);
        while (k3 < l4) 
        {
            j j2 = (j)arraylist.get(k3);
            int k2;
            if (j2.k())
            {
                View view = getItemView(j2, mScrapActionButtonView, viewgroup);
                if (mScrapActionButtonView == null)
                {
                    mScrapActionButtonView = view;
                }
                int i4;
                if (mStrictWidthLimit)
                {
                    k2 = i1 - ActionMenuView.measureChildForCells(view, i3, i1, i5, 0);
                } else
                {
                    view.measure(i5, i5);
                    k2 = i1;
                }
                i1 = view.getMeasuredWidth();
                if (l == 0)
                {
                    l = i1;
                }
                i4 = j2.getGroupId();
                if (i4 != 0)
                {
                    sparsebooleanarray.put(i4, true);
                }
                j2.d(true);
                i2 -= i1;
                i1 = k;
                k = i2;
            } else
            if (j2.j())
            {
                int j5 = j2.getGroupId();
                boolean flag3 = sparsebooleanarray.get(j5);
                boolean flag2;
                if ((k > 0 || flag3) && i2 > 0 && (!mStrictWidthLimit || i1 > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    View view1 = getItemView(j2, mScrapActionButtonView, viewgroup);
                    if (mScrapActionButtonView == null)
                    {
                        mScrapActionButtonView = view1;
                    }
                    int j4;
                    if (mStrictWidthLimit)
                    {
                        k2 = ActionMenuView.measureChildForCells(view1, i3, i1, i5, 0);
                        if (k2 == 0)
                        {
                            flag2 = false;
                        }
                        i1 -= k2;
                    } else
                    {
                        view1.measure(i5, i5);
                    }
                    k2 = view1.getMeasuredWidth();
                    j4 = i2 - k2;
                    i2 = l;
                    if (l == 0)
                    {
                        i2 = k2;
                    }
                    if (mStrictWidthLimit)
                    {
                        if (j4 >= 0)
                        {
                            l = 1;
                        } else
                        {
                            l = 0;
                        }
                        flag2 &= l;
                        l = i2;
                        k2 = i1;
                        i2 = j4;
                        i1 = l;
                        l = k2;
                    } else
                    {
                        if (j4 + i2 > 0)
                        {
                            l = 1;
                        } else
                        {
                            l = 0;
                        }
                        flag2 &= l;
                        l = i1;
                        i1 = i2;
                        i2 = j4;
                    }
                } else
                {
                    int l2 = l;
                    l = i1;
                    i1 = l2;
                }
                if (flag2 && j5 != 0)
                {
                    sparsebooleanarray.put(j5, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(j5, false);
                    int k4 = 0;
                    while (k4 < k3) 
                    {
                        j j3 = (j)arraylist.get(k4);
                        k2 = k;
                        if (j3.getGroupId() == j5)
                        {
                            k2 = k;
                            if (j3.i())
                            {
                                k2 = k + 1;
                            }
                            j3.d(false);
                        }
                        k4++;
                        k = k2;
                    }
                }
                k2 = k;
                if (flag2)
                {
                    k2 = k - 1;
                }
                j2.d(flag2);
                k = i2;
                i2 = k2;
                k2 = l;
                l = i1;
                i1 = i2;
            } else
            {
                j2.d(false);
                k2 = i2;
                i2 = k;
                k = k2;
                k2 = i1;
                i1 = i2;
            }
            i4 = k3 + 1;
            k3 = i1;
            i1 = k2;
            i2 = k;
            k = k3;
            k3 = i4;
        }
        return true;
    }

    public View getItemView(j j1, View view, ViewGroup viewgroup)
    {
        View view1 = j1.getActionView();
        if (view1 == null || j1.m())
        {
            view1 = super.getItemView(j1, view, viewgroup);
        }
        byte byte0;
        if (j1.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        j1 = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!j1.checkLayoutParams(view))
        {
            view1.setLayoutParams(j1.generateLayoutParams(view));
        }
        return view1;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        viewgroup = super.getMenuView(viewgroup);
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

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
        initForMenu(context, menubuilder);
        menubuilder = context.getResources();
        context = ActionBarPolicy.get(context);
        if (!mReserveOverflowSet)
        {
            mReserveOverflow = context.showsOverflowMenuButton();
        }
        if (!mWidthLimitSet)
        {
            mWidthLimit = context.getEmbeddedMenuWidthLimit();
        }
        if (!mMaxItemsSet)
        {
            mMaxItems = context.getMaxActionButtons();
        }
        int i = mWidthLimit;
        if (mReserveOverflow)
        {
            if (mOverflowButton == null)
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(k, k);
            }
            i -= mOverflowButton.getMeasuredWidth();
        } else
        {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = i;
        mMinCellSize = (int)(56F * menubuilder.getDisplayMetrics().density);
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

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        dismissPopupMenus();
        onCloseMenu(menubuilder, flag);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (!mMaxItemsSet)
        {
            mMaxItems = mContext.getResources().getInteger(android.support.v7.appcompat.R.integer.abc_max_action_buttons);
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
                onSubMenuSelected((v)parcelable.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState();
        savedstate.openSubMenuId = mOpenSubMenuId;
        return savedstate;
    }

    public boolean onSubMenuSelected(v v1)
    {
        if (!v1.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = v1; ((v) (obj)).s() != mMenu; obj = (v)((v) (obj)).s()) { }
        View view = findViewForItem(((v) (obj)).getItem());
        obj = view;
        if (view == null)
        {
            if (mOverflowButton == null)
            {
                return false;
            }
            obj = mOverflowButton;
        }
        mOpenSubMenuId = v1.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, v1);
        mActionButtonPopup.setAnchorView(((View) (obj)));
        mActionButtonPopup.show();
        onSubMenuSelected(v1);
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

    public boolean shouldIncludeItem(int i, j j1)
    {
        return j1.i();
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
            ActionBarTransition.beginDelayedTransition(((ViewGroup) (obj)));
        }
        updateMenuView(flag);
        ((View)mMenuView).requestLayout();
        if (mMenu != null)
        {
            obj = mMenu.k();
            int l = ((ArrayList) (obj)).size();
            for (int i = 0; i < l; i++)
            {
                ActionProvider actionprovider = ((j)((ArrayList) (obj)).get(i)).getSupportActionProvider();
                if (actionprovider != null)
                {
                    actionprovider.setSubUiVisibilityListener(this);
                }
            }

        }
        int k;
        if (mMenu != null)
        {
            obj = mMenu.l();
        } else
        {
            obj = null;
        }
        k = ((flag2) ? 1 : 0);
        if (mReserveOverflow)
        {
            k = ((flag2) ? 1 : 0);
            if (obj != null)
            {
                k = ((ArrayList) (obj)).size();
                if (k == 1)
                {
                    if (!((j)((ArrayList) (obj)).get(0)).isActionViewExpanded())
                    {
                        k = 1;
                    } else
                    {
                        k = 0;
                    }
                } else
                if (k > 0)
                {
                    k = ((flag1) ? 1 : 0);
                } else
                {
                    k = 0;
                }
            }
        }
        if (k == 0) goto _L2; else goto _L1
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



    private class PopupPresenterCallback
        implements android.support.v7.internal.view.menu.MenuPresenter.Callback
    {

        final ActionMenuPresenter this$0;

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
        {
            if (menubuilder instanceof v)
            {
                ((v)menubuilder).p().a(false);
            }
            android.support.v7.internal.view.menu.MenuPresenter.Callback callback = getCallback();
            if (callback != null)
            {
                callback.onCloseMenu(menubuilder, flag);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menubuilder)
        {
            if (menubuilder == null)
            {
                return false;
            }
            mOpenSubMenuId = ((v)menubuilder).getItem().getItemId();
            android.support.v7.internal.view.menu.MenuPresenter.Callback callback = getCallback();
            boolean flag;
            if (callback != null)
            {
                flag = callback.onOpenSubMenu(menubuilder);
            } else
            {
                flag = false;
            }
            return flag;
        }

        private PopupPresenterCallback()
        {
            this$0 = ActionMenuPresenter.this;
            super();
        }

    }


    private class ActionMenuPopupCallback extends c
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
            super();
        }

    }


    /* member class not found */
    class ActionButtonSubmenu {}


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

        protected boolean setFrame(int i, int k, int l, int i1)
        {
            boolean flag = setFrame(i, k, l, i1);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable drawable1 = getBackground();
            if (drawable != null && drawable1 != null)
            {
                int j1 = getWidth();
                k = getHeight();
                i = Math.max(j1, k) / 2;
                int k1 = getPaddingLeft();
                int l1 = getPaddingRight();
                l = getPaddingTop();
                i1 = getPaddingBottom();
                j1 = (j1 + (k1 - l1)) / 2;
                k = (k + (l - i1)) / 2;
                DrawableCompat.setHotspotBounds(drawable1, j1 - i, k - i, j1 + i, k + i);
            }
            return flag;
        }

        public OverflowMenuButton(Context context)
        {
            this$0 = ActionMenuPresenter.this;
            TintImageView(context, null, android.support.v7.appcompat.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ListPopupWindow.ForwardingListener(ActionMenuPresenter.this) {

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
                    this$1 = OverflowMenuButton.this;
                    this$0 = actionmenupresenter;
                    ForwardingListener(final_view);
                }

            });
        }
    }


    private class SavedState
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


}
