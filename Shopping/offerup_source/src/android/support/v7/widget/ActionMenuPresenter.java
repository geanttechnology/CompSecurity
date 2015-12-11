// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.aa;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.d;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.v;
import android.support.v7.internal.view.menu.z;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView

public class ActionMenuPresenter extends d
    implements l
{

    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private OverflowMenuButton mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(null);
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
        int j;
        int i1;
        i1 = viewgroup.getChildCount();
        j = 0;
_L7:
        if (j >= i1) goto _L4; else goto _L3
_L3:
        View view1;
        view1 = viewgroup.getChildAt(j);
        if (!(view1 instanceof aa))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = view1;
        if (((aa)view1).getItemData() == menuitem) goto _L6; else goto _L5
_L5:
        j++;
          goto _L7
_L4:
        return null;
    }

    public void bindItemView(m m1, aa aa1)
    {
        aa1.a(m1, 0);
        m1 = (ActionMenuView)mMenuView;
        aa1 = (ActionMenuItemView)aa1;
        aa1.setItemInvoker(m1);
        if (mPopupCallback == null)
        {
            mPopupCallback = new ActionMenuPopupCallback(null);
        }
        aa1.setPopupCallback(mPopupCallback);
    }

    public boolean dismissPopupMenus()
    {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewgroup, int j)
    {
        if (viewgroup.getChildAt(j) == mOverflowButton)
        {
            return false;
        } else
        {
            return super.filterLeftoverView(viewgroup, j);
        }
    }

    public boolean flagActionItems()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int j1;
        int k1;
        int k4;
        int i6;
        int j6;
label0:
        {
            arraylist = mMenu.j();
            i6 = arraylist.size();
            int j = mMaxItems;
            k4 = mActionItemWidthLimit;
            j6 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)mMenuView;
            k1 = 0;
            int l1 = 0;
            boolean flag = false;
            j1 = 0;
            while (j1 < i6) 
            {
                m m1 = (m)arraylist.get(j1);
                if (m1.k())
                {
                    k1++;
                } else
                if (m1.j())
                {
                    l1++;
                } else
                {
                    flag = true;
                }
                if (mExpandedActionViewsExclusive && m1.isActionViewExpanded())
                {
                    j = 0;
                }
                j1++;
            }
            j1 = j;
            if (!mReserveOverflow)
            {
                break label0;
            }
            if (!flag)
            {
                j1 = j;
                if (k1 + l1 <= j)
                {
                    break label0;
                }
            }
            j1 = j - 1;
        }
        j1 -= k1;
        SparseBooleanArray sparsebooleanarray = mActionButtonGroups;
        sparsebooleanarray.clear();
        int i1;
        int j2;
        boolean flag1;
        int i4;
        int j4;
        if (mStrictWidthLimit)
        {
            i1 = k4 / mMinCellSize;
            k1 = mMinCellSize;
            int i2 = mMinCellSize;
            i4 = (k4 % k1) / i1 + i2;
        } else
        {
            i4 = 0;
            i1 = 0;
        }
        flag1 = false;
        j4 = 0;
        k1 = i1;
        i1 = j1;
        j2 = k4;
        j1 = ((flag1) ? 1 : 0);
        while (j4 < i6) 
        {
            m m2 = (m)arraylist.get(j4);
            if (m2.k())
            {
                View view = getItemView(m2, mScrapActionButtonView, viewgroup);
                if (mScrapActionButtonView == null)
                {
                    mScrapActionButtonView = view;
                }
                int k2;
                int l4;
                if (mStrictWidthLimit)
                {
                    k2 = k1 - ActionMenuView.measureChildForCells(view, i4, k1, j6, 0);
                } else
                {
                    view.measure(j6, j6);
                    k2 = k1;
                }
                k1 = view.getMeasuredWidth();
                if (j1 == 0)
                {
                    j1 = k1;
                }
                l4 = m2.getGroupId();
                if (l4 != 0)
                {
                    sparsebooleanarray.put(l4, true);
                }
                m2.d(true);
                k1 = j2 - k1;
                j2 = i1;
                i1 = k2;
            } else
            if (m2.j())
            {
                int k6 = m2.getGroupId();
                boolean flag3 = sparsebooleanarray.get(k6);
                boolean flag2;
                if ((i1 > 0 || flag3) && j2 > 0 && (!mStrictWidthLimit || k1 > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                int k3;
                if (flag2)
                {
                    View view1 = getItemView(m2, mScrapActionButtonView, viewgroup);
                    if (mScrapActionButtonView == null)
                    {
                        mScrapActionButtonView = view1;
                    }
                    int i3;
                    int j5;
                    if (mStrictWidthLimit)
                    {
                        int i5 = ActionMenuView.measureChildForCells(view1, i4, k1, j6, 0);
                        int l2 = k1 - i5;
                        k1 = l2;
                        if (i5 == 0)
                        {
                            flag2 = false;
                            k1 = l2;
                        }
                    } else
                    {
                        view1.measure(j6, j6);
                    }
                    j5 = view1.getMeasuredWidth();
                    j2 -= j5;
                    i3 = j1;
                    if (j1 == 0)
                    {
                        i3 = j5;
                    }
                    if (mStrictWidthLimit)
                    {
                        int k5;
                        if (j2 >= 0)
                        {
                            j1 = 1;
                        } else
                        {
                            j1 = 0;
                        }
                        flag2 &= j1;
                        j1 = k1;
                        k1 = i3;
                    } else
                    {
                        if (j2 + i3 > 0)
                        {
                            j1 = 1;
                        } else
                        {
                            j1 = 0;
                        }
                        flag2 &= j1;
                        j1 = k1;
                        k1 = i3;
                    }
                } else
                {
                    int l3 = k1;
                    k1 = j1;
                    j1 = l3;
                }
                if (flag2 && k6 != 0)
                {
                    sparsebooleanarray.put(k6, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(k6, false);
                    int l5 = 0;
                    while (l5 < j4) 
                    {
                        m m3 = (m)arraylist.get(l5);
                        int j3 = i1;
                        if (m3.getGroupId() == k6)
                        {
                            j3 = i1;
                            if (m3.i())
                            {
                                j3 = i1 + 1;
                            }
                            m3.d(false);
                        }
                        l5++;
                        i1 = j3;
                    }
                }
                i3 = i1;
                if (flag2)
                {
                    i3 = i1 - 1;
                }
                m2.d(flag2);
                k5 = k1;
                k1 = j2;
                j2 = i3;
                i1 = j1;
                j1 = k5;
            } else
            {
                m2.d(false);
                k3 = i1;
                i1 = k1;
                k1 = j2;
                j2 = k3;
            }
            l4 = j4 + 1;
            k2 = k1;
            j4 = j2;
            k1 = i1;
            j2 = k2;
            i1 = j4;
            j4 = l4;
        }
        return true;
    }

    public View getItemView(m m1, View view, ViewGroup viewgroup)
    {
        View view1 = m1.getActionView();
        if (view1 == null || m1.m())
        {
            view1 = super.getItemView(m1, view, viewgroup);
        }
        byte byte0;
        if (m1.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        m1 = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!m1.checkLayoutParams(view))
        {
            view1.setLayoutParams(m1.generateLayoutParams(view));
        }
        return view1;
    }

    public z getMenuView(ViewGroup viewgroup)
    {
        viewgroup = super.getMenuView(viewgroup);
        ((ActionMenuView)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public Drawable getOverflowIcon()
    {
        if (mOverflowButton != null)
        {
            return mOverflowButton.getDrawable();
        }
        if (mPendingOverflowIconSet)
        {
            return mPendingOverflowIcon;
        } else
        {
            return null;
        }
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

    public void initForMenu(Context context, i j)
    {
        initForMenu(context, j);
        j = context.getResources();
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
        int i1 = mWidthLimit;
        if (mReserveOverflow)
        {
            if (mOverflowButton == null)
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                if (mPendingOverflowIconSet)
                {
                    mOverflowButton.setImageDrawable(mPendingOverflowIcon);
                    mPendingOverflowIcon = null;
                    mPendingOverflowIconSet = false;
                }
                int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(j1, j1);
            }
            i1 -= mOverflowButton.getMeasuredWidth();
        } else
        {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = i1;
        mMinCellSize = (int)(56F * j.getDisplayMetrics().density);
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

    public void onCloseMenu(i j, boolean flag)
    {
        dismissPopupMenus();
        onCloseMenu(j, flag);
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
                onSubMenuSelected((ac)parcelable.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState();
        savedstate.openSubMenuId = mOpenSubMenuId;
        return savedstate;
    }

    public boolean onSubMenuSelected(ac ac1)
    {
        if (!ac1.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = ac1; ((ac) (obj)).p() != mMenu; obj = (ac)((ac) (obj)).p()) { }
        View view = findViewForItem(((ac) (obj)).getItem());
        obj = view;
        if (view == null)
        {
            if (mOverflowButton == null)
            {
                return false;
            }
            obj = mOverflowButton;
        }
        mOpenSubMenuId = ac1.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, ac1);
        mActionButtonPopup.setAnchorView(((View) (obj)));
        mActionButtonPopup.show();
        onSubMenuSelected(ac1);
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

    public void setMenuView(ActionMenuView actionmenuview)
    {
        mMenuView = actionmenuview;
        actionmenuview.initialize(mMenu);
    }

    public void setOverflowIcon(Drawable drawable)
    {
        if (mOverflowButton != null)
        {
            mOverflowButton.setImageDrawable(drawable);
            return;
        } else
        {
            mPendingOverflowIconSet = true;
            mPendingOverflowIcon = drawable;
            return;
        }
    }

    public void setReserveOverflow(boolean flag)
    {
        mReserveOverflow = flag;
        mReserveOverflowSet = true;
    }

    public boolean shouldIncludeItem(int j, m m1)
    {
        return m1.i();
    }

    public boolean showOverflowMenu()
    {
        if (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null && mPostedOpenRunnable == null && !mMenu.m().isEmpty())
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
            obj = mMenu.l();
            int j1 = ((ArrayList) (obj)).size();
            for (int j = 0; j < j1; j++)
            {
                k k1 = ((m)((ArrayList) (obj)).get(j)).a();
                if (k1 != null)
                {
                    k1.a(this);
                }
            }

        }
        int i1;
        if (mMenu != null)
        {
            obj = mMenu.m();
        } else
        {
            obj = null;
        }
        i1 = ((flag2) ? 1 : 0);
        if (mReserveOverflow)
        {
            i1 = ((flag2) ? 1 : 0);
            if (obj != null)
            {
                i1 = ((ArrayList) (obj)).size();
                if (i1 == 1)
                {
                    if (!((m)((ArrayList) (obj)).get(0)).isActionViewExpanded())
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                } else
                if (i1 > 0)
                {
                    i1 = ((flag1) ? 1 : 0);
                } else
                {
                    i1 = 0;
                }
            }
        }
        if (i1 == 0) goto _L2; else goto _L1
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
        implements y
    {

        final ActionMenuPresenter this$0;

        public void onCloseMenu(i j, boolean flag)
        {
            if (j instanceof ac)
            {
                ((ac)j).n().a(false);
            }
            y y1 = getCallback();
            if (y1 != null)
            {
                y1.onCloseMenu(j, flag);
            }
        }

        public boolean onOpenSubMenu(i j)
        {
            if (j == null)
            {
                return false;
            }
            mOpenSubMenuId = ((ac)j).getItem().getItemId();
            y y1 = getCallback();
            if (y1 != null)
            {
                return y1.onOpenSubMenu(j);
            } else
            {
                return false;
            }
        }

        private PopupPresenterCallback()
        {
            this$0 = ActionMenuPresenter.this;
            super();
        }

        PopupPresenterCallback(_cls1 _pcls1)
        {
            this();
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

        ActionMenuPopupCallback(_cls1 _pcls1)
        {
            this();
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

        protected boolean setFrame(int j, int i1, int j1, int k1)
        {
            boolean flag = setFrame(j, i1, j1, k1);
            Drawable drawable = getDrawable();
            Drawable drawable1 = getBackground();
            if (drawable != null && drawable1 != null)
            {
                int l1 = getWidth();
                i1 = getHeight();
                j = Math.max(l1, i1) / 2;
                int i2 = getPaddingLeft();
                int j2 = getPaddingRight();
                j1 = getPaddingTop();
                k1 = getPaddingBottom();
                l1 = (l1 + (i2 - j2)) / 2;
                i1 = (i1 + (j1 - k1)) / 2;
                a.a(drawable1, l1 - j, i1 - j, l1 + j, i1 + j);
            }
            return flag;
        }

        public OverflowMenuButton(Context context)
        {
            this$0 = ActionMenuPresenter.this;
            super(context, null, android.support.v7.appcompat.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            class _cls1 extends ListPopupWindow.ForwardingListener
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

                _cls1(ActionMenuPresenter actionmenupresenter)
                {
                    this$1 = OverflowMenuButton.this;
                    this$0 = actionmenupresenter;
                    super(final_view);
                }

            }

            setOnTouchListener(new _cls1(ActionMenuPresenter.this));
        }
    }


    /* member class not found */
    class ActionButtonSubmenu {}


    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        public int openSubMenuId;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int j)
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

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final SavedState[] newArray(int j)
            {
                return new SavedState[j];
            }

            public final volatile Object[] newArray(int j)
            {
                return newArray(j);
            }

                _cls1()
                {
                }
        }

    }


}
