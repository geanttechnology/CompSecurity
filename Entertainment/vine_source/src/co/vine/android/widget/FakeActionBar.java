// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.util.ViewUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class FakeActionBar
    implements android.view.View.OnClickListener
{
    public static class MenuItemPack
    {

        MenuItem item;
        public View view;

        public MenuItemPack()
        {
        }
    }

    public static final class Theme extends Enum
    {

        private static final Theme $VALUES[];
        public static final Theme DARK;
        public static final Theme LIGHT;

        public static Theme valueOf(String s)
        {
            return (Theme)Enum.valueOf(co/vine/android/widget/FakeActionBar$Theme, s);
        }

        public static Theme[] values()
        {
            return (Theme[])$VALUES.clone();
        }

        static 
        {
            DARK = new Theme("DARK", 0);
            LIGHT = new Theme("LIGHT", 1);
            $VALUES = (new Theme[] {
                DARK, LIGHT
            });
        }

        private Theme(String s, int i)
        {
            super(s, i);
        }
    }


    private RelativeLayout mActionBar;
    private RelativeLayout mActionBarContainer;
    private RelativeLayout mActionBarLeft;
    private LinearLayout mActionBarRight;
    private final ActionBarActivity mActivity;
    private ImageView mBackIcon;
    private View mContentView;
    private boolean mDisplayHomeAsUp;
    private Boolean mDisplayShowTitle;
    private View mDistanceMarker;
    private boolean mHomeButtonEnabled;
    private ImageView mHomeIcon;
    private Menu mMenu;
    private final ArrayList mMenuItemPacks = new ArrayList();
    public Theme mTheme;
    private String mTitle;
    private TextView mTitleView;

    public FakeActionBar(ActionBarActivity actionbaractivity)
    {
        mActivity = actionbaractivity;
        mTheme = Theme.LIGHT;
    }

    public RelativeLayout getActionBar()
    {
        return mActionBar;
    }

    public RelativeLayout getActionBarLeft()
    {
        return mActionBarLeft;
    }

    public LinearLayout getActionBarRight()
    {
        return mActionBarRight;
    }

    public ImageView getBackIcon()
    {
        return mBackIcon;
    }

    public View getDistanceMaker()
    {
        return mDistanceMarker;
    }

    public ImageView getHomeIcon()
    {
        return mHomeIcon;
    }

    public MenuItemPack getMenuItemPack(int i)
    {
        for (Iterator iterator = mMenuItemPacks.iterator(); iterator.hasNext();)
        {
            MenuItemPack menuitempack = (MenuItemPack)iterator.next();
            if (menuitempack.item.getItemId() == i)
            {
                return menuitempack;
            }
        }

        return null;
    }

    public RelativeLayout getRoot()
    {
        return mActionBarContainer;
    }

    public TextView getTitleView()
    {
        return mTitleView;
    }

    public void onClick(View view)
    {
        if (view == mBackIcon || view == mHomeIcon)
        {
            mActivity.finish();
        }
    }

    public void onCreate()
    {
        mActionBarContainer = (RelativeLayout)LayoutInflater.from(mActivity).inflate(0x7f03003b, null);
        mActionBar = (RelativeLayout)mActionBarContainer.findViewById(0x7f0a00e7);
        ViewUtil.setActionBarHeight(mActivity, mActionBar);
        mDistanceMarker = mActionBarContainer.findViewById(0x7f0a00e6);
        ViewUtil.setActionBarHeight(mActivity, mDistanceMarker);
        mActionBarLeft = (RelativeLayout)mActionBarContainer.findViewById(0x7f0a00e8);
        mActionBarRight = (LinearLayout)mActionBarContainer.findViewById(0x7f0a00ec);
        mBackIcon = (ImageView)mActionBar.findViewById(0x7f0a00e9);
        mHomeIcon = (ImageView)mActionBar.findViewById(0x7f0a00ea);
        mTitleView = (TextView)mActionBar.findViewById(0x7f0a00eb);
    }

    public void onCreateOptionsMenu(Menu menu, boolean flag)
    {
        mMenu = menu;
        menu = mMenuItemPacks.iterator();
        do
        {
            if (!menu.hasNext())
            {
                break;
            }
            MenuItemPack menuitempack = (MenuItemPack)menu.next();
            if (menuitempack.view != null)
            {
                mActionBarRight.removeView(menuitempack.view);
            }
        } while (true);
        if (!flag)
        {
            return;
        }
        int j = mMenu.size();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < j; i++)
        {
            final MenuItem item = mMenu.getItem(i);
            if (!item.isVisible())
            {
                continue;
            }
            menu = null;
            android.graphics.drawable.Drawable drawable = item.getIcon();
            CharSequence charsequence = item.getTitle();
            if (drawable != null)
            {
                menu = new ImageView(mActivity);
                ((ImageView)menu).setImageDrawable(drawable);
            }
            if (charsequence != null)
            {
                menu = new TextView(mActivity);
                ((TextView)menu).setText(charsequence);
            }
            if (menu != null)
            {
                menu.setOnClickListener(new android.view.View.OnClickListener() {

                    final FakeActionBar this$0;
                    final MenuItem val$item;

                    public void onClick(View view)
                    {
                        mActivity.onOptionsItemSelected(item);
                    }

            
            {
                this$0 = FakeActionBar.this;
                item = menuitem;
                super();
            }
                });
                mActionBarRight.addView(menu);
            }
        }

        mMenuItemPacks.clear();
        mMenuItemPacks.addAll(arraylist);
    }

    public void onPostCreate(Bundle bundle)
    {
        if (mContentView == null || mActionBarContainer == null)
        {
            throw new IllegalStateException("custom setContentView is not called.");
        }
        if (mDisplayHomeAsUp || mHomeButtonEnabled)
        {
            if (mDisplayHomeAsUp)
            {
                bundle = mBackIcon;
                Object obj;
                TypedArray typedarray;
                android.content.res.Resources.Theme theme;
                TypedValue typedvalue;
                int i;
                if (mTheme == Theme.DARK)
                {
                    i = 0x7f020012;
                } else
                {
                    i = 0x7f020013;
                }
                bundle.setImageResource(i);
                mBackIcon.setClickable(true);
                mBackIcon.setVisibility(0);
                mBackIcon.setOnClickListener(this);
            } else
            {
                mBackIcon.setVisibility(8);
            }
            obj = null;
            theme = mActivity.getTheme();
            bundle = ((Bundle) (obj));
            if (theme != null)
            {
                typedarray = theme.obtainStyledAttributes(new int[] {
                    0x10102ce
                });
                typedvalue = new TypedValue();
                bundle = ((Bundle) (obj));
                if (typedarray.getValue(0, typedvalue))
                {
                    bundle = theme.obtainStyledAttributes(typedvalue.resourceId, new int[] {
                        0x1010002
                    });
                    i = bundle.getResourceId(0, -1);
                    typedarray.recycle();
                    bundle.recycle();
                    bundle = ((Bundle) (obj));
                    if (i > 0)
                    {
                        bundle = mActivity.getResources().getDrawable(i);
                    }
                }
            }
            obj = bundle;
            if (bundle == null)
            {
                obj = mActivity.getApplicationInfo().loadLogo(mActivity.getPackageManager());
            }
            if (mHomeButtonEnabled)
            {
                mHomeIcon.setClickable(true);
                mHomeIcon.setOnClickListener(this);
                mHomeIcon.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                mHomeIcon.setVisibility(0);
            } else
            {
                mHomeIcon.setVisibility(8);
            }
        } else
        {
            mHomeIcon.setVisibility(8);
        }
        if (mDisplayShowTitle.booleanValue() && mTitle != null)
        {
            mTitleView.setVisibility(0);
            mTitleView.setText(mTitle);
            return;
        } else
        {
            mTitleView.setVisibility(8);
            return;
        }
    }

    public void onPrepareOptionsMenu(Menu menu, boolean flag)
    {
    }

    public void setActionBarColor(int i)
    {
        mActionBar.setBackgroundColor(i);
    }

    public void setActionBarTransition(TransitionDrawable transitiondrawable)
    {
        mActionBar.setBackgroundDrawable(transitiondrawable);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        mContentView = view;
        layoutparams = new android.widget.RelativeLayout.LayoutParams(layoutparams);
        view.setLayoutParams(layoutparams);
        layoutparams.addRule(3, mDistanceMarker.getId());
        mActionBarContainer.addView(mContentView);
    }

    public void setDisplayHomeAsUpEnabled(Boolean boolean1)
    {
        mDisplayHomeAsUp = boolean1.booleanValue();
    }

    public void setDisplayShowTitleEnabled(Boolean boolean1)
    {
        mDisplayShowTitle = boolean1;
    }

    public void setHomeButtonEnabled(Boolean boolean1)
    {
        mHomeButtonEnabled = boolean1.booleanValue();
    }

    public void setTheme(Theme theme)
    {
        mTheme = theme;
    }

    public void setTitle(Integer integer)
    {
        mTitle = mActivity.getString(integer.intValue());
    }

    public void setTitle(String s)
    {
        mTitle = s;
    }

}
