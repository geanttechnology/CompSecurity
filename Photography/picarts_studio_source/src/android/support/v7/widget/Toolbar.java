// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.x;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.RtlSpacingHelper;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.internal.widget.ViewUtils;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView, ActionMenuPresenter

public class Toolbar extends ViewGroup
{

    private static final String TAG = "Toolbar";
    private x mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private j mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int mTempMargins[];
    private final ArrayList mTempViews;
    private final TintManager mTintManager;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public Toolbar(Context context)
    {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.appcompat.R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        mContentInsets = new RtlSpacingHelper();
        mGravity = 0x800013;
        mTempViews = new ArrayList();
        mTempMargins = new int[2];
        mMenuViewItemClickListener = new _cls1();
        mShowOverflowMenuRunnable = new _cls2();
        context = TintTypedArray.obtainStyledAttributes(getContext(), attributeset, android.support.v7.appcompat.R.styleable.Toolbar, j, 0);
        mTitleTextAppearance = context.getResourceId(android.support.v7.appcompat.R.styleable.Toolbar_titleTextAppearance, 0);
        mSubtitleTextAppearance = context.getResourceId(android.support.v7.appcompat.R.styleable.Toolbar_subtitleTextAppearance, 0);
        mGravity = context.getInteger(android.support.v7.appcompat.R.styleable.Toolbar_android_gravity, mGravity);
        mButtonGravity = 48;
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_titleMargins, 0);
        mTitleMarginBottom = j;
        mTitleMarginTop = j;
        mTitleMarginEnd = j;
        mTitleMarginStart = j;
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_titleMarginStart, -1);
        if (j >= 0)
        {
            mTitleMarginStart = j;
        }
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_titleMarginEnd, -1);
        if (j >= 0)
        {
            mTitleMarginEnd = j;
        }
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_titleMarginTop, -1);
        if (j >= 0)
        {
            mTitleMarginTop = j;
        }
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_titleMarginBottom, -1);
        if (j >= 0)
        {
            mTitleMarginBottom = j;
        }
        mMaxButtonHeight = context.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.Toolbar_maxButtonHeight, -1);
        j = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_contentInsetStart, 0x80000000);
        int k = context.getDimensionPixelOffset(android.support.v7.appcompat.R.styleable.Toolbar_contentInsetEnd, 0x80000000);
        int l = context.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.Toolbar_contentInsetLeft, 0);
        int i1 = context.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.Toolbar_contentInsetRight, 0);
        mContentInsets.setAbsolute(l, i1);
        if (j != 0x80000000 || k != 0x80000000)
        {
            mContentInsets.setRelative(j, k);
        }
        mCollapseIcon = context.getDrawable(android.support.v7.appcompat.R.styleable.Toolbar_collapseIcon);
        mCollapseDescription = context.getText(android.support.v7.appcompat.R.styleable.Toolbar_collapseContentDescription);
        attributeset = context.getText(android.support.v7.appcompat.R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(attributeset))
        {
            setTitle(attributeset);
        }
        attributeset = context.getText(android.support.v7.appcompat.R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(attributeset))
        {
            setSubtitle(attributeset);
        }
        mPopupContext = getContext();
        setPopupTheme(context.getResourceId(android.support.v7.appcompat.R.styleable.Toolbar_popupTheme, 0));
        attributeset = context.getDrawable(android.support.v7.appcompat.R.styleable.Toolbar_navigationIcon);
        if (attributeset != null)
        {
            setNavigationIcon(attributeset);
        }
        attributeset = context.getText(android.support.v7.appcompat.R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(attributeset))
        {
            setNavigationContentDescription(attributeset);
        }
        context.recycle();
        mTintManager = context.getTintManager();
    }

    private void addCustomViewsWithGravity(List list, int j)
    {
        boolean flag = true;
        boolean flag1 = false;
        int k;
        int l;
        if (ViewCompat.getLayoutDirection(this) != 1)
        {
            flag = false;
        }
        l = getChildCount();
        k = GravityCompat.getAbsoluteGravity(j, ViewCompat.getLayoutDirection(this));
        list.clear();
        j = ((flag1) ? 1 : 0);
        if (flag)
        {
            for (j = l - 1; j >= 0; j--)
            {
                View view = getChildAt(j);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (layoutparams.mViewType == 0 && shouldLayout(view) && getChildHorizontalGravity(layoutparams.gravity) == k)
                {
                    list.add(view);
                }
            }

        } else
        {
            for (; j < l; j++)
            {
                View view1 = getChildAt(j);
                LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                if (layoutparams1.mViewType == 0 && shouldLayout(view1) && getChildHorizontalGravity(layoutparams1.gravity) == k)
                {
                    list.add(view1);
                }
            }

        }
    }

    private void addSystemView(View view)
    {
        Object obj = view.getLayoutParams();
        if (obj == null)
        {
            obj = generateDefaultLayoutParams();
        } else
        if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
        {
            obj = generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        {
            obj = (LayoutParams)obj;
        }
        obj.mViewType = 1;
        addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    private void ensureCollapseButtonView()
    {
        if (mCollapseButtonView == null)
        {
            mCollapseButtonView = new ImageButton(getContext(), null, android.support.v7.appcompat.R.attr.toolbarNavigationButtonStyle);
            mCollapseButtonView.setImageDrawable(mCollapseIcon);
            mCollapseButtonView.setContentDescription(mCollapseDescription);
            LayoutParams layoutparams = generateDefaultLayoutParams();
            layoutparams.gravity = 0x800003 | mButtonGravity & 0x70;
            layoutparams.mViewType = 2;
            mCollapseButtonView.setLayoutParams(layoutparams);
            mCollapseButtonView.setOnClickListener(new _cls3());
        }
    }

    private void ensureLogoView()
    {
        if (mLogoView == null)
        {
            mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu()
    {
        ensureMenuView();
        if (mMenuView.peekMenu() == null)
        {
            i j = (i)mMenuView.getMenu();
            if (mExpandedMenuPresenter == null)
            {
                mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
            }
            mMenuView.setExpandedActionViewsExclusive(true);
            j.a(mExpandedMenuPresenter, mPopupContext);
        }
    }

    private void ensureMenuView()
    {
        if (mMenuView == null)
        {
            mMenuView = new ActionMenuView(getContext());
            mMenuView.setPopupTheme(mPopupTheme);
            mMenuView.setOnMenuItemClickListener(mMenuViewItemClickListener);
            mMenuView.setMenuCallbacks(mActionMenuPresenterCallback, mMenuBuilderCallback);
            LayoutParams layoutparams = generateDefaultLayoutParams();
            layoutparams.gravity = 0x800005 | mButtonGravity & 0x70;
            mMenuView.setLayoutParams(layoutparams);
            addSystemView(mMenuView);
        }
    }

    private void ensureNavButtonView()
    {
        if (mNavButtonView == null)
        {
            mNavButtonView = new ImageButton(getContext(), null, android.support.v7.appcompat.R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutparams = generateDefaultLayoutParams();
            layoutparams.gravity = 0x800003 | mButtonGravity & 0x70;
            mNavButtonView.setLayoutParams(layoutparams);
        }
    }

    private int getChildHorizontalGravity(int j)
    {
label0:
        {
            int l = ViewCompat.getLayoutDirection(this);
            int k = GravityCompat.getAbsoluteGravity(j, l) & 7;
            j = k;
            switch (k)
            {
            case 2: // '\002'
            case 4: // '\004'
            default:
                if (l != 1)
                {
                    break label0;
                }
                j = 5;
                break;

            case 1: // '\001'
            case 3: // '\003'
            case 5: // '\005'
                break;
            }
            return j;
        }
        return 3;
    }

    private int getChildTop(View view, int j)
    {
        LayoutParams layoutparams;
        int k;
        int l;
        int i1;
        int j1;
        layoutparams = (LayoutParams)view.getLayoutParams();
        l = view.getMeasuredHeight();
        if (j > 0)
        {
            j = (l - j) / 2;
        } else
        {
            j = 0;
        }
        getChildVerticalGravity(layoutparams.gravity);
        JVM INSTR lookupswitch 2: default 60
    //                   48: 115
    //                   80: 122;
           goto _L1 _L2 _L3
_L1:
        k = getPaddingTop();
        i1 = getPaddingBottom();
        j1 = getHeight();
        j = (j1 - k - i1 - l) / 2;
        if (j >= layoutparams.topMargin) goto _L5; else goto _L4
_L4:
        j = layoutparams.topMargin;
_L7:
        return j + k;
_L2:
        return getPaddingTop() - j;
_L3:
        return getHeight() - getPaddingBottom() - l - layoutparams.bottomMargin - j;
_L5:
        l = j1 - i1 - l - j - k;
        if (l < layoutparams.bottomMargin)
        {
            j = Math.max(0, j - (layoutparams.bottomMargin - l));
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private int getChildVerticalGravity(int j)
    {
        int k = j & 0x70;
        j = k;
        switch (k)
        {
        default:
            j = mGravity & 0x70;
            // fall through

        case 16: // '\020'
        case 48: // '0'
        case 80: // 'P'
            return j;
        }
    }

    private int getHorizontalMargins(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int j = MarginLayoutParamsCompat.getMarginStart(view);
        return MarginLayoutParamsCompat.getMarginEnd(view) + j;
    }

    private MenuInflater getMenuInflater()
    {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int j = ((android.view.ViewGroup.MarginLayoutParams) (view)).topMargin;
        return ((android.view.ViewGroup.MarginLayoutParams) (view)).bottomMargin + j;
    }

    private int getViewListMeasuredWidth(List list, int ai[])
    {
        int i1 = ai[0];
        int l = ai[1];
        int j1 = list.size();
        int k = 0;
        int j;
        int k1;
        int l1;
        int i2;
        for (j = 0; k < j1; j += i2 + k1 + l1)
        {
            ai = (View)list.get(k);
            LayoutParams layoutparams = (LayoutParams)ai.getLayoutParams();
            i1 = layoutparams.leftMargin - i1;
            l = layoutparams.rightMargin - l;
            k1 = Math.max(0, i1);
            l1 = Math.max(0, l);
            i1 = Math.max(0, -i1);
            l = Math.max(0, -l);
            i2 = ai.getMeasuredWidth();
            k++;
        }

        return j;
    }

    private static boolean isCustomView(View view)
    {
        return ((LayoutParams)view.getLayoutParams()).mViewType == 0;
    }

    private int layoutChildLeft(View view, int j, int ai[], int k)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int l = layoutparams.leftMargin - ai[0];
        j = Math.max(0, l) + j;
        ai[0] = Math.max(0, -l);
        k = getChildTop(view, k);
        l = view.getMeasuredWidth();
        view.layout(j, k, j + l, view.getMeasuredHeight() + k);
        return layoutparams.rightMargin + l + j;
    }

    private int layoutChildRight(View view, int j, int ai[], int k)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int l = layoutparams.rightMargin - ai[1];
        j -= Math.max(0, l);
        ai[1] = Math.max(0, -l);
        k = getChildTop(view, k);
        l = view.getMeasuredWidth();
        view.layout(j - l, k, j, view.getMeasuredHeight() + k);
        return j - (layoutparams.leftMargin + l);
    }

    private int measureChildCollapseMargins(View view, int j, int k, int l, int i1, int ai[])
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int j1 = marginlayoutparams.leftMargin - ai[0];
        int k1 = marginlayoutparams.rightMargin - ai[1];
        int l1 = Math.max(0, j1) + Math.max(0, k1);
        ai[0] = Math.max(0, -j1);
        ai[1] = Math.max(0, -k1);
        view.measure(getChildMeasureSpec(j, getPaddingLeft() + getPaddingRight() + l1 + k, marginlayoutparams.width), getChildMeasureSpec(l, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin + i1, marginlayoutparams.height));
        return view.getMeasuredWidth() + l1;
    }

    private void measureChildConstrained(View view, int j, int k, int l, int i1, int j1)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int k1 = getChildMeasureSpec(j, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin + k, marginlayoutparams.width);
        k = getChildMeasureSpec(l, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin + i1, marginlayoutparams.height);
        l = android.view.View.MeasureSpec.getMode(k);
        j = k;
        if (l != 0x40000000)
        {
            j = k;
            if (j1 >= 0)
            {
                j = j1;
                if (l != 0)
                {
                    j = Math.min(android.view.View.MeasureSpec.getSize(k), j1);
                }
                j = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            }
        }
        view.measure(k1, j);
    }

    private void postShowOverflowMenu()
    {
        removeCallbacks(mShowOverflowMenuRunnable);
        post(mShowOverflowMenuRunnable);
    }

    private void setChildVisibilityForExpandedActionView(boolean flag)
    {
        int k = getChildCount();
        int j = 0;
        while (j < k) 
        {
            View view = getChildAt(j);
            if (((LayoutParams)view.getLayoutParams()).mViewType != 2 && view != mMenuView)
            {
                byte byte0;
                if (flag)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                view.setVisibility(byte0);
            }
            j++;
        }
    }

    private boolean shouldCollapse()
    {
        if (mCollapsible) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int k = getChildCount();
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                View view = getChildAt(j);
                if (shouldLayout(view) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private boolean shouldLayout(View view)
    {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }

    private void updateChildVisibilityForExpandedActionView(View view)
    {
        if (((LayoutParams)view.getLayoutParams()).mViewType != 2 && view != mMenuView)
        {
            byte byte0;
            if (mExpandedActionView != null)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
    }

    public boolean canShowOverflowMenu()
    {
        return getVisibility() == 0 && mMenuView != null && mMenuView.isOverflowReserved();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return super.checkLayoutParams(layoutparams) && (layoutparams instanceof LayoutParams);
    }

    public void collapseActionView()
    {
        m m1;
        if (mExpandedMenuPresenter == null)
        {
            m1 = null;
        } else
        {
            m1 = mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (m1 != null)
        {
            m1.collapseActionView();
        }
    }

    public void dismissPopupMenus()
    {
        if (mMenuView != null)
        {
            mMenuView.dismissPopupMenus();
        }
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-2, -2);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof LayoutParams)
        {
            return new LayoutParams((LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.support.v7.app.ActionBar.LayoutParams)
        {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new LayoutParams(layoutparams);
        }
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public int getContentInsetEnd()
    {
        return mContentInsets.getEnd();
    }

    public int getContentInsetLeft()
    {
        return mContentInsets.getLeft();
    }

    public int getContentInsetRight()
    {
        return mContentInsets.getRight();
    }

    public int getContentInsetStart()
    {
        return mContentInsets.getStart();
    }

    public Drawable getLogo()
    {
        if (mLogoView != null)
        {
            return mLogoView.getDrawable();
        } else
        {
            return null;
        }
    }

    public CharSequence getLogoDescription()
    {
        if (mLogoView != null)
        {
            return mLogoView.getContentDescription();
        } else
        {
            return null;
        }
    }

    public Menu getMenu()
    {
        ensureMenu();
        return mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription()
    {
        if (mNavButtonView != null)
        {
            return mNavButtonView.getContentDescription();
        } else
        {
            return null;
        }
    }

    public Drawable getNavigationIcon()
    {
        if (mNavButtonView != null)
        {
            return mNavButtonView.getDrawable();
        } else
        {
            return null;
        }
    }

    public int getPopupTheme()
    {
        return mPopupTheme;
    }

    public CharSequence getSubtitle()
    {
        return mSubtitleText;
    }

    public CharSequence getTitle()
    {
        return mTitleText;
    }

    public DecorToolbar getWrapper()
    {
        if (mWrapper == null)
        {
            mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return mWrapper;
    }

    public boolean hasExpandedActionView()
    {
        return mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    public boolean hideOverflowMenu()
    {
        return mMenuView != null && mMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int j)
    {
        getMenuInflater().inflate(j, getMenu());
    }

    public boolean isOverflowMenuShowPending()
    {
        return mMenuView != null && mMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing()
    {
        return mMenuView != null && mMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated()
    {
        if (mTitleTextView != null) goto _L2; else goto _L1
_L1:
        Layout layout;
        return false;
_L2:
        if ((layout = mTitleTextView.getLayout()) != null)
        {
            int k = layout.getLineCount();
            int j = 0;
            while (j < k) 
            {
                if (layout.getEllipsisCount(j) > 0)
                {
                    return true;
                }
                j++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(mShowOverflowMenuRunnable);
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        int j = MotionEventCompat.getActionMasked(motionevent);
        if (j == 9)
        {
            mEatingHover = false;
        }
        if (!mEatingHover)
        {
            boolean flag = super.onHoverEvent(motionevent);
            if (j == 9 && !flag)
            {
                mEatingHover = true;
            }
        }
        if (j == 10 || j == 3)
        {
            mEatingHover = false;
        }
        return true;
    }

    protected void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        Object obj;
        Object obj1;
        int ai[];
        int j1;
        boolean flag1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        boolean flag2;
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        k2 = getWidth();
        j3 = getHeight();
        j1 = getPaddingLeft();
        l2 = getPaddingRight();
        i3 = getPaddingTop();
        k3 = getPaddingBottom();
        i1 = k2 - l2;
        ai = mTempMargins;
        ai[1] = 0;
        ai[0] = 0;
        j2 = ViewCompat.getMinimumHeight(this);
        if (shouldLayout(mNavButtonView))
        {
            if (l1 != 0)
            {
                i1 = layoutChildRight(mNavButtonView, i1, ai, j2);
                j = j1;
            } else
            {
                j = layoutChildLeft(mNavButtonView, j1, ai, j2);
            }
        } else
        {
            j = j1;
        }
        k = i1;
        l = j;
        if (shouldLayout(mCollapseButtonView))
        {
            if (l1 != 0)
            {
                k = layoutChildRight(mCollapseButtonView, i1, ai, j2);
                l = j;
            } else
            {
                l = layoutChildLeft(mCollapseButtonView, j, ai, j2);
                k = i1;
            }
        }
        j = k;
        i1 = l;
        if (shouldLayout(mMenuView))
        {
            if (l1 != 0)
            {
                i1 = layoutChildLeft(mMenuView, l, ai, j2);
                j = k;
            } else
            {
                j = layoutChildRight(mMenuView, k, ai, j2);
                i1 = l;
            }
        }
        ai[0] = Math.max(0, getContentInsetLeft() - i1);
        ai[1] = Math.max(0, getContentInsetRight() - (k2 - l2 - j));
        l = Math.max(i1, getContentInsetLeft());
        i1 = Math.min(j, k2 - l2 - getContentInsetRight());
        k = i1;
        j = l;
        if (shouldLayout(mExpandedActionView))
        {
            if (l1 != 0)
            {
                k = layoutChildRight(mExpandedActionView, i1, ai, j2);
                j = l;
            } else
            {
                j = layoutChildLeft(mExpandedActionView, l, ai, j2);
                k = i1;
            }
        }
        if (shouldLayout(mLogoView))
        {
            if (l1 != 0)
            {
                k = layoutChildRight(mLogoView, k, ai, j2);
                l = j;
            } else
            {
                l = layoutChildLeft(mLogoView, j, ai, j2);
            }
        } else
        {
            l = j;
        }
        flag = shouldLayout(mTitleTextView);
        flag2 = shouldLayout(mSubtitleTextView);
        j = 0;
        if (flag)
        {
            LayoutParams layoutparams = (LayoutParams)mTitleTextView.getLayoutParams();
            j = layoutparams.topMargin;
            i1 = mTitleTextView.getMeasuredHeight();
            j = layoutparams.bottomMargin + (j + i1) + 0;
        }
        if (flag2)
        {
            LayoutParams layoutparams1 = (LayoutParams)mSubtitleTextView.getLayoutParams();
            i1 = layoutparams1.topMargin;
            int k1 = mSubtitleTextView.getMeasuredHeight();
            i2 = layoutparams1.bottomMargin + (i1 + k1) + j;
        } else
        {
            i2 = j;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        i1 = k;
        j = l;
        if (!flag2) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            obj = mTitleTextView;
        } else
        {
            obj = mSubtitleTextView;
        }
        if (flag2)
        {
            obj1 = mSubtitleTextView;
        } else
        {
            obj1 = mTitleTextView;
        }
        obj = (LayoutParams)((View) (obj)).getLayoutParams();
        obj1 = (LayoutParams)((View) (obj1)).getLayoutParams();
        if (flag && mTitleTextView.getMeasuredWidth() > 0 || flag2 && mSubtitleTextView.getMeasuredWidth() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mGravity & 0x70;
        JVM INSTR lookupswitch 2: default 560
    //                   48: 999
    //                   80: 1073;
           goto _L4 _L5 _L6
_L4:
        j = (j3 - i3 - k3 - i2) / 2;
        if (j < ((LayoutParams) (obj)).topMargin + mTitleMarginTop)
        {
            j = ((LayoutParams) (obj)).topMargin + mTitleMarginTop;
        } else
        {
            i1 = j3 - k3 - i2 - j - i3;
            if (i1 < ((LayoutParams) (obj)).bottomMargin + mTitleMarginBottom)
            {
                j = Math.max(0, j - ((((LayoutParams) (obj1)).bottomMargin + mTitleMarginBottom) - i1));
            }
        }
        j = i3 + j;
_L8:
        if (l1 != 0)
        {
            if (flag1)
            {
                i1 = mTitleMarginStart;
            } else
            {
                i1 = 0;
            }
            i1 -= ai[1];
            k -= Math.max(0, i1);
            ai[1] = Math.max(0, -i1);
            if (flag)
            {
                obj = (LayoutParams)mTitleTextView.getLayoutParams();
                i1 = k - mTitleTextView.getMeasuredWidth();
                l1 = mTitleTextView.getMeasuredHeight() + j;
                mTitleTextView.layout(i1, j, k, l1);
                i2 = mTitleMarginEnd;
                j = l1 + ((LayoutParams) (obj)).bottomMargin;
                i1 -= i2;
            } else
            {
                i1 = k;
            }
            if (flag2)
            {
                obj = (LayoutParams)mSubtitleTextView.getLayoutParams();
                j = ((LayoutParams) (obj)).topMargin + j;
                l1 = mSubtitleTextView.getMeasuredWidth();
                i2 = mSubtitleTextView.getMeasuredHeight();
                mSubtitleTextView.layout(k - l1, j, k, i2 + j);
                j = mTitleMarginEnd;
                l1 = ((LayoutParams) (obj)).bottomMargin;
                j = k - j;
            } else
            {
                j = k;
            }
            if (flag1)
            {
                j = Math.min(i1, j);
            } else
            {
                j = k;
            }
            i1 = j;
            j = l;
        } else
        {
            if (flag1)
            {
                i1 = mTitleMarginStart;
            } else
            {
                i1 = 0;
            }
            i1 -= ai[0];
            l += Math.max(0, i1);
            ai[0] = Math.max(0, -i1);
            if (flag)
            {
                obj = (LayoutParams)mTitleTextView.getLayoutParams();
                l1 = mTitleTextView.getMeasuredWidth() + l;
                i1 = mTitleTextView.getMeasuredHeight() + j;
                mTitleTextView.layout(l, j, l1, i1);
                i2 = mTitleMarginEnd;
                j = ((LayoutParams) (obj)).bottomMargin;
                l1 += i2;
                j += i1;
            } else
            {
                l1 = l;
            }
            if (flag2)
            {
                obj = (LayoutParams)mSubtitleTextView.getLayoutParams();
                i1 = j + ((LayoutParams) (obj)).topMargin;
                j = mSubtitleTextView.getMeasuredWidth() + l;
                i2 = mSubtitleTextView.getMeasuredHeight();
                mSubtitleTextView.layout(l, i1, j, i2 + i1);
                i1 = mTitleMarginEnd;
                i2 = ((LayoutParams) (obj)).bottomMargin;
                i2 = i1 + j;
            } else
            {
                i2 = l;
            }
            i1 = k;
            j = l;
            if (flag1)
            {
                j = Math.max(l1, i2);
                i1 = k;
            }
        }
_L3:
        addCustomViewsWithGravity(mTempViews, 3);
        l = mTempViews.size();
        for (k = 0; k < l; k++)
        {
            j = layoutChildLeft((View)mTempViews.get(k), j, ai, j2);
        }

        addCustomViewsWithGravity(mTempViews, 5);
        l = mTempViews.size();
        for (k = 0; k < l; k++)
        {
            i1 = layoutChildRight((View)mTempViews.get(k), i1, ai, j2);
        }

        addCustomViewsWithGravity(mTempViews, 1);
        l = getViewListMeasuredWidth(mTempViews, ai);
        k = ((k2 - j1 - l2) / 2 + j1) - l / 2;
        l += k;
          goto _L7
_L5:
        j = getPaddingTop();
        j = ((LayoutParams) (obj)).topMargin + j + mTitleMarginTop;
        break MISSING_BLOCK_LABEL_604;
_L6:
        j = j3 - k3 - ((LayoutParams) (obj1)).bottomMargin - mTitleMarginBottom - i2;
          goto _L8
_L7:
        if (k >= j) goto _L10; else goto _L9
_L9:
        i1 = mTempViews.size();
        l = 0;
        k = j;
        for (j = l; j < i1; j++)
        {
            k = layoutChildLeft((View)mTempViews.get(j), k, ai, j2);
        }

        break; /* Loop/switch isn't completed */
_L10:
        j = k;
        if (l > i1)
        {
            j = k - (l - i1);
        }
        if (true) goto _L9; else goto _L11
_L11:
        mTempViews.clear();
        return;
          goto _L8
    }

    protected void onMeasure(int j, int k)
    {
        int ai[] = mTempMargins;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int l2;
        if (ViewUtils.isLayoutRtl(this))
        {
            l1 = 0;
            i2 = 1;
        } else
        {
            l1 = 1;
            i2 = 0;
        }
        l = 0;
        if (shouldLayout(mNavButtonView))
        {
            measureChildConstrained(mNavButtonView, j, 0, k, 0, mMaxButtonHeight);
            l = mNavButtonView.getMeasuredWidth() + getHorizontalMargins(mNavButtonView);
            k1 = Math.max(0, mNavButtonView.getMeasuredHeight() + getVerticalMargins(mNavButtonView));
            j1 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(mNavButtonView));
        } else
        {
            j1 = 0;
            k1 = 0;
        }
        j2 = l;
        l = j1;
        i1 = k1;
        if (shouldLayout(mCollapseButtonView))
        {
            measureChildConstrained(mCollapseButtonView, j, 0, k, 0, mMaxButtonHeight);
            j2 = mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(mCollapseButtonView);
            i1 = Math.max(k1, mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(mCollapseButtonView));
            l = ViewUtils.combineMeasuredStates(j1, ViewCompat.getMeasuredState(mCollapseButtonView));
        }
        j1 = getContentInsetStart();
        l2 = Math.max(j1, j2) + 0;
        ai[i2] = Math.max(0, j1 - j2);
        i2 = 0;
        j1 = l;
        k1 = i1;
        if (shouldLayout(mMenuView))
        {
            measureChildConstrained(mMenuView, j, l2, k, 0, mMaxButtonHeight);
            i2 = mMenuView.getMeasuredWidth() + getHorizontalMargins(mMenuView);
            k1 = Math.max(i1, mMenuView.getMeasuredHeight() + getVerticalMargins(mMenuView));
            j1 = ViewUtils.combineMeasuredStates(l, ViewCompat.getMeasuredState(mMenuView));
        }
        l = getContentInsetEnd();
        j2 = l2 + Math.max(l, i2);
        ai[l1] = Math.max(0, l - i2);
        i2 = j2;
        l = j1;
        i1 = k1;
        if (shouldLayout(mExpandedActionView))
        {
            i2 = j2 + measureChildCollapseMargins(mExpandedActionView, j, j2, k, 0, ai);
            i1 = Math.max(k1, mExpandedActionView.getMeasuredHeight() + getVerticalMargins(mExpandedActionView));
            l = ViewUtils.combineMeasuredStates(j1, ViewCompat.getMeasuredState(mExpandedActionView));
        }
        j1 = i2;
        k1 = l;
        l1 = i1;
        if (shouldLayout(mLogoView))
        {
            j1 = i2 + measureChildCollapseMargins(mLogoView, j, i2, k, 0, ai);
            l1 = Math.max(i1, mLogoView.getMeasuredHeight() + getVerticalMargins(mLogoView));
            k1 = ViewUtils.combineMeasuredStates(l, ViewCompat.getMeasuredState(mLogoView));
        }
        j2 = getChildCount();
        i2 = 0;
        i1 = l1;
        l = k1;
        k1 = i2;
        i2 = j1;
        while (k1 < j2) 
        {
            View view = getChildAt(k1);
            int k2;
            int i3;
            int j3;
            int k3;
            if (((LayoutParams)view.getLayoutParams()).mViewType == 0 && shouldLayout(view))
            {
                i2 += measureChildCollapseMargins(view, j, i2, k, 0, ai);
                j1 = Math.max(i1, view.getMeasuredHeight() + getVerticalMargins(view));
                i1 = ViewUtils.combineMeasuredStates(l, ViewCompat.getMeasuredState(view));
                l = j1;
            } else
            {
                j1 = i1;
                i1 = l;
                l = j1;
            }
            k1++;
            j1 = l;
            l = i1;
            i1 = j1;
        }
        l1 = 0;
        k1 = 0;
        j3 = mTitleMarginTop + mTitleMarginBottom;
        k3 = mTitleMarginStart + mTitleMarginEnd;
        j1 = l;
        if (shouldLayout(mTitleTextView))
        {
            measureChildCollapseMargins(mTitleTextView, j, i2 + k3, k, j3, ai);
            j1 = mTitleTextView.getMeasuredWidth();
            l1 = getHorizontalMargins(mTitleTextView) + j1;
            k1 = mTitleTextView.getMeasuredHeight() + getVerticalMargins(mTitleTextView);
            j1 = ViewUtils.combineMeasuredStates(l, ViewCompat.getMeasuredState(mTitleTextView));
        }
        i3 = k1;
        k2 = l1;
        l = j1;
        if (shouldLayout(mSubtitleTextView))
        {
            k2 = Math.max(l1, measureChildCollapseMargins(mSubtitleTextView, j, i2 + k3, k, j3 + k1, ai));
            i3 = k1 + (mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(mSubtitleTextView));
            l = ViewUtils.combineMeasuredStates(j1, ViewCompat.getMeasuredState(mSubtitleTextView));
        }
        i1 = Math.max(i1, i3);
        l1 = getPaddingLeft();
        i3 = getPaddingRight();
        j1 = getPaddingTop();
        k1 = getPaddingBottom();
        l1 = ViewCompat.resolveSizeAndState(Math.max(k2 + i2 + (l1 + i3), getSuggestedMinimumWidth()), j, 0xff000000 & l);
        j = ViewCompat.resolveSizeAndState(Math.max(i1 + (j1 + k1), getSuggestedMinimumHeight()), k, l << 16);
        if (shouldCollapse())
        {
            j = 0;
        }
        setMeasuredDimension(l1, j);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (mMenuView != null)
        {
            parcelable = mMenuView.peekMenu();
        } else
        {
            parcelable = null;
        }
        if (savedstate.expandedMenuItemId != 0 && mExpandedMenuPresenter != null && parcelable != null)
        {
            parcelable = parcelable.findItem(savedstate.expandedMenuItemId);
            if (parcelable != null)
            {
                MenuItemCompat.expandActionView(parcelable);
            }
        }
        if (savedstate.isOverflowOpen)
        {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int j)
    {
        boolean flag = true;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            super.onRtlPropertiesChanged(j);
        }
        RtlSpacingHelper rtlspacinghelper = mContentInsets;
        if (j != 1)
        {
            flag = false;
        }
        rtlspacinghelper.setDirection(flag);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null)
        {
            savedstate.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedstate.isOverflowOpen = isOverflowMenuShowing();
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int j = MotionEventCompat.getActionMasked(motionevent);
        if (j == 0)
        {
            mEatingTouch = false;
        }
        if (!mEatingTouch)
        {
            boolean flag = super.onTouchEvent(motionevent);
            if (j == 0 && !flag)
            {
                mEatingTouch = true;
            }
        }
        if (j == 1 || j == 3)
        {
            mEatingTouch = false;
        }
        return true;
    }

    public void setCollapsible(boolean flag)
    {
        mCollapsible = flag;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int j, int k)
    {
        mContentInsets.setAbsolute(j, k);
    }

    public void setContentInsetsRelative(int j, int k)
    {
        mContentInsets.setRelative(j, k);
    }

    public void setLogo(int j)
    {
        setLogo(mTintManager.getDrawable(j));
    }

    public void setLogo(Drawable drawable)
    {
        if (drawable == null) goto _L2; else goto _L1
_L1:
        ensureLogoView();
        if (mLogoView.getParent() == null)
        {
            addSystemView(mLogoView);
            updateChildVisibilityForExpandedActionView(mLogoView);
        }
_L4:
        if (mLogoView != null)
        {
            mLogoView.setImageDrawable(drawable);
        }
        return;
_L2:
        if (mLogoView != null && mLogoView.getParent() != null)
        {
            removeView(mLogoView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setLogoDescription(int j)
    {
        setLogoDescription(getContext().getText(j));
    }

    public void setLogoDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            ensureLogoView();
        }
        if (mLogoView != null)
        {
            mLogoView.setContentDescription(charsequence);
        }
    }

    public void setMenu(i j, ActionMenuPresenter actionmenupresenter)
    {
        if (j != null || mMenuView != null)
        {
            ensureMenuView();
            i k = mMenuView.peekMenu();
            if (k != j)
            {
                if (k != null)
                {
                    k.b(mOuterActionMenuPresenter);
                    k.b(mExpandedMenuPresenter);
                }
                if (mExpandedMenuPresenter == null)
                {
                    mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
                }
                actionmenupresenter.setExpandedActionViewsExclusive(true);
                if (j != null)
                {
                    j.a(actionmenupresenter, mPopupContext);
                    j.a(mExpandedMenuPresenter, mPopupContext);
                } else
                {
                    actionmenupresenter.initForMenu(mPopupContext, null);
                    mExpandedMenuPresenter.initForMenu(mPopupContext, null);
                    actionmenupresenter.updateMenuView(true);
                    mExpandedMenuPresenter.updateMenuView(true);
                }
                mMenuView.setPopupTheme(mPopupTheme);
                mMenuView.setPresenter(actionmenupresenter);
                mOuterActionMenuPresenter = actionmenupresenter;
                return;
            }
        }
    }

    public void setMenuCallbacks(x x, j j)
    {
        mActionMenuPresenterCallback = x;
        mMenuBuilderCallback = j;
    }

    public void setNavigationContentDescription(int j)
    {
        CharSequence charsequence;
        if (j != 0)
        {
            charsequence = getContext().getText(j);
        } else
        {
            charsequence = null;
        }
        setNavigationContentDescription(charsequence);
    }

    public void setNavigationContentDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            ensureNavButtonView();
        }
        if (mNavButtonView != null)
        {
            mNavButtonView.setContentDescription(charsequence);
        }
    }

    public void setNavigationIcon(int j)
    {
        setNavigationIcon(mTintManager.getDrawable(j));
    }

    public void setNavigationIcon(Drawable drawable)
    {
        if (drawable == null) goto _L2; else goto _L1
_L1:
        ensureNavButtonView();
        if (mNavButtonView.getParent() == null)
        {
            addSystemView(mNavButtonView);
            updateChildVisibilityForExpandedActionView(mNavButtonView);
        }
_L4:
        if (mNavButtonView != null)
        {
            mNavButtonView.setImageDrawable(drawable);
        }
        return;
_L2:
        if (mNavButtonView != null && mNavButtonView.getParent() != null)
        {
            removeView(mNavButtonView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        ensureNavButtonView();
        mNavButtonView.setOnClickListener(onclicklistener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onmenuitemclicklistener)
    {
        mOnMenuItemClickListener = onmenuitemclicklistener;
    }

    public void setPopupTheme(int j)
    {
label0:
        {
            if (mPopupTheme != j)
            {
                mPopupTheme = j;
                if (j != 0)
                {
                    break label0;
                }
                mPopupContext = getContext();
            }
            return;
        }
        mPopupContext = new ContextThemeWrapper(getContext(), j);
    }

    public void setSubtitle(int j)
    {
        setSubtitle(getContext().getText(j));
    }

    public void setSubtitle(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        if (mSubtitleTextView == null)
        {
            Context context = getContext();
            mSubtitleTextView = new TextView(context);
            mSubtitleTextView.setSingleLine();
            mSubtitleTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            if (mSubtitleTextAppearance != 0)
            {
                mSubtitleTextView.setTextAppearance(context, mSubtitleTextAppearance);
            }
            if (mSubtitleTextColor != 0)
            {
                mSubtitleTextView.setTextColor(mSubtitleTextColor);
            }
        }
        if (mSubtitleTextView.getParent() == null)
        {
            addSystemView(mSubtitleTextView);
            updateChildVisibilityForExpandedActionView(mSubtitleTextView);
        }
_L4:
        if (mSubtitleTextView != null)
        {
            mSubtitleTextView.setText(charsequence);
        }
        mSubtitleText = charsequence;
        return;
_L2:
        if (mSubtitleTextView != null && mSubtitleTextView.getParent() != null)
        {
            removeView(mSubtitleTextView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSubtitleTextAppearance(Context context, int j)
    {
        mSubtitleTextAppearance = j;
        if (mSubtitleTextView != null)
        {
            mSubtitleTextView.setTextAppearance(context, j);
        }
    }

    public void setSubtitleTextColor(int j)
    {
        mSubtitleTextColor = j;
        if (mSubtitleTextView != null)
        {
            mSubtitleTextView.setTextColor(j);
        }
    }

    public void setTitle(int j)
    {
        setTitle(getContext().getText(j));
    }

    public void setTitle(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        if (mTitleTextView == null)
        {
            Context context = getContext();
            mTitleTextView = new TextView(context);
            mTitleTextView.setSingleLine();
            mTitleTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            if (mTitleTextAppearance != 0)
            {
                mTitleTextView.setTextAppearance(context, mTitleTextAppearance);
            }
            if (mTitleTextColor != 0)
            {
                mTitleTextView.setTextColor(mTitleTextColor);
            }
        }
        if (mTitleTextView.getParent() == null)
        {
            addSystemView(mTitleTextView);
            updateChildVisibilityForExpandedActionView(mTitleTextView);
        }
_L4:
        if (mTitleTextView != null)
        {
            mTitleTextView.setText(charsequence);
        }
        mTitleText = charsequence;
        return;
_L2:
        if (mTitleTextView != null && mTitleTextView.getParent() != null)
        {
            removeView(mTitleTextView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setTitleTextAppearance(Context context, int j)
    {
        mTitleTextAppearance = j;
        if (mTitleTextView != null)
        {
            mTitleTextView.setTextAppearance(context, j);
        }
    }

    public void setTitleTextColor(int j)
    {
        mTitleTextColor = j;
        if (mTitleTextView != null)
        {
            mTitleTextView.setTextColor(j);
        }
    }

    public boolean showOverflowMenu()
    {
        return mMenuView != null && mMenuView.showOverflowMenu();
    }






    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class LayoutParams {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class ExpandedActionViewMenuPresenter {}


    /* member class not found */
    class SavedState {}

}
