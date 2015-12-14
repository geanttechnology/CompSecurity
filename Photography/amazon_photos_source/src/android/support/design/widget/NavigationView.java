// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class NavigationView extends ScrimInsetsFrameLayout
{
    public static interface OnNavigationItemSelectedListener
    {

        public abstract boolean onNavigationItemSelected(MenuItem menuitem);
    }

    public static class SavedState extends android.view.View.BaseSavedState
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
        public Bundle menuState;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(menuState);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            menuState = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final int CHECKED_STATE_SET[] = {
        0x10100a0
    };
    private static final int DISABLED_STATE_SET[] = {
        0xfefeff62
    };
    private OnNavigationItemSelectedListener mListener;
    private int mMaxWidth;
    private final MenuBuilder mMenu;
    private MenuInflater mMenuInflater;
    private final NavigationMenuPresenter mPresenter;

    public NavigationView(Context context)
    {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NavigationView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMenu = new MenuBuilder(context);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.design.R.styleable.NavigationView, i, android.support.design.R.style.Widget_Design_NavigationView);
        setBackgroundDrawable(typedarray.getDrawable(android.support.design.R.styleable.NavigationView_android_background));
        if (typedarray.hasValue(android.support.design.R.styleable.NavigationView_elevation))
        {
            ViewCompat.setElevation(this, typedarray.getDimensionPixelSize(android.support.design.R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, typedarray.getBoolean(android.support.design.R.styleable.NavigationView_android_fitsSystemWindows, false));
        mMaxWidth = typedarray.getDimensionPixelSize(android.support.design.R.styleable.NavigationView_android_maxWidth, 0);
        ColorStateList colorstatelist;
        Drawable drawable;
        if (typedarray.hasValue(android.support.design.R.styleable.NavigationView_itemIconTint))
        {
            attributeset = typedarray.getColorStateList(android.support.design.R.styleable.NavigationView_itemIconTint);
        } else
        {
            attributeset = createDefaultColorStateList(0x1010038);
        }
        if (typedarray.hasValue(android.support.design.R.styleable.NavigationView_itemTextColor))
        {
            colorstatelist = typedarray.getColorStateList(android.support.design.R.styleable.NavigationView_itemTextColor);
        } else
        {
            colorstatelist = createDefaultColorStateList(0x1010036);
        }
        drawable = typedarray.getDrawable(android.support.design.R.styleable.NavigationView_itemBackground);
        if (typedarray.hasValue(android.support.design.R.styleable.NavigationView_menu))
        {
            inflateMenu(typedarray.getResourceId(android.support.design.R.styleable.NavigationView_menu, 0));
        }
        mMenu.setCallback(new android.support.v7.internal.view.menu.MenuBuilder.Callback() {

            final NavigationView this$0;

            public boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem)
            {
                return mListener != null && mListener.onNavigationItemSelected(menuitem);
            }

            public void onMenuModeChange(MenuBuilder menubuilder)
            {
            }

            
            {
                this$0 = NavigationView.this;
                super();
            }
        });
        mPresenter = new NavigationMenuPresenter();
        mPresenter.setId(1);
        mPresenter.initForMenu(context, mMenu);
        mPresenter.setItemIconTintList(attributeset);
        mPresenter.setItemTextColor(colorstatelist);
        mPresenter.setItemBackground(drawable);
        mMenu.addMenuPresenter(mPresenter);
        addView((View)mPresenter.getMenuView(this));
        if (typedarray.hasValue(android.support.design.R.styleable.NavigationView_headerLayout))
        {
            inflateHeaderView(typedarray.getResourceId(android.support.design.R.styleable.NavigationView_headerLayout, 0));
        }
        typedarray.recycle();
    }

    private ColorStateList createDefaultColorStateList(int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedvalue, true))
        {
            ColorStateList colorstatelist = getResources().getColorStateList(typedvalue.resourceId);
            if (getContext().getTheme().resolveAttribute(android.support.design.R.attr.colorPrimary, typedvalue, true))
            {
                i = typedvalue.data;
                int j = colorstatelist.getDefaultColor();
                int ai[] = DISABLED_STATE_SET;
                int ai1[] = CHECKED_STATE_SET;
                int ai2[] = EMPTY_STATE_SET;
                int k = colorstatelist.getColorForState(DISABLED_STATE_SET, j);
                return new ColorStateList(new int[][] {
                    ai, ai1, ai2
                }, new int[] {
                    k, i, j
                });
            }
        }
        return null;
    }

    private MenuInflater getMenuInflater()
    {
        if (mMenuInflater == null)
        {
            mMenuInflater = new SupportMenuInflater(getContext());
        }
        return mMenuInflater;
    }

    public Drawable getItemBackground()
    {
        return mPresenter.getItemBackground();
    }

    public ColorStateList getItemIconTintList()
    {
        return mPresenter.getItemTintList();
    }

    public ColorStateList getItemTextColor()
    {
        return mPresenter.getItemTextColor();
    }

    public Menu getMenu()
    {
        return mMenu;
    }

    public View inflateHeaderView(int i)
    {
        return mPresenter.inflateHeaderView(i);
    }

    public void inflateMenu(int i)
    {
        if (mPresenter != null)
        {
            mPresenter.setUpdateSuspended(true);
        }
        getMenuInflater().inflate(i, mMenu);
        if (mPresenter != null)
        {
            mPresenter.setUpdateSuspended(false);
            mPresenter.updateMenuView(false);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = i;
        android.view.View.MeasureSpec.getMode(i);
        JVM INSTR lookupswitch 3: default 40
    //                   -2147483648: 49
    //                   0: 70
    //                   1073741824: 42;
           goto _L1 _L2 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        k = i;
_L6:
        super.onMeasure(k, j);
        return;
_L2:
        k = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(android.view.View.MeasureSpec.getSize(i), mMaxWidth), 0x40000000);
        continue; /* Loop/switch isn't completed */
_L3:
        k = android.view.View.MeasureSpec.makeMeasureSpec(mMaxWidth, 0x40000000);
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        mMenu.restorePresenterStates(((SavedState) (parcelable)).menuState);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.menuState = new Bundle();
        mMenu.savePresenterStates(savedstate.menuState);
        return savedstate;
    }

    public void setItemBackground(Drawable drawable)
    {
        mPresenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i)
    {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemIconTintList(ColorStateList colorstatelist)
    {
        mPresenter.setItemIconTintList(colorstatelist);
    }

    public void setItemTextColor(ColorStateList colorstatelist)
    {
        mPresenter.setItemTextColor(colorstatelist);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onnavigationitemselectedlistener)
    {
        mListener = onnavigationitemselectedlistener;
    }


}
