// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.RootTabFragment;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMButton, PMTabBar

public class PMTabButton extends PMButton
{

    private int badge;
    private String clickEventString;
    Context context;
    PMTabBar.PMTabListener defaultTabListener = new PMTabBar.PMTabListener() {

        final PMTabButton this$0;

        public void onTabSelected(PMTabButton pmtabbutton)
        {
        }

        public void onTabUnselected(PMTabButton pmtabbutton)
        {
        }

            
            {
                this$0 = PMTabButton.this;
                super();
            }
    };
    Class fragmentClass;
    Bundle fragmentData;
    private Drawable icon;
    private RootTabFragment mFragment;
    private PMTabBar parentContainerBar;
    private Drawable selectedIcon;
    PMTabBar.PMTabListener tabListener;

    public PMTabButton(Context context1)
    {
        super(context1, null);
        badge = -1;
        context = context1;
    }

    public PMTabButton(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        badge = -1;
        attributeset = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMTabButton);
        String s = attributeset.getString(1);
        if (s != null)
        {
            int i = context1.getResources().getIdentifier(s, "drawable", context1.getPackageName());
            icon = getResources().getDrawable(i);
        }
        s = attributeset.getString(2);
        if (s != null)
        {
            int j = context1.getResources().getIdentifier(s, "drawable", context1.getPackageName());
            selectedIcon = getResources().getDrawable(j);
        }
        clickEventString = attributeset.getString(3);
        setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
        tabListener = defaultTabListener;
    }

    public void clearBadge()
    {
        badge = -1;
        postInvalidate();
    }

    public void collapseFragmentStack()
    {
        if (mFragment != null)
        {
            mFragment.collapseAllSubfragments();
        }
    }

    public void detachFragmentFromTabButton()
    {
        mFragment = null;
    }

    public String getClickEventString()
    {
        return clickEventString;
    }

    public RootTabFragment getFragment()
    {
        return mFragment;
    }

    public PMTabBar.PMTabListener getTabListener()
    {
        return tabListener;
    }

    public void hideFragment(PMActivity pmactivity)
    {
        if (mFragment != null)
        {
            pmactivity = pmactivity.getSupportFragmentManager();
            FragmentTransaction fragmenttransaction = pmactivity.beginTransaction();
            fragmenttransaction.detach(mFragment);
            if (mFragment.isStateSavingCompleted())
            {
                fragmenttransaction.commitAllowingStateLoss();
            } else
            {
                fragmenttransaction.commit();
            }
            pmactivity.executePendingTransactions();
        }
    }

    public void launchFragment(PMActivity pmactivity)
    {
        FragmentManager fragmentmanager;
        FragmentTransaction fragmenttransaction;
        fragmentmanager = pmactivity.getSupportFragmentManager();
        fragmenttransaction = fragmentmanager.beginTransaction();
        if (mFragment != null) goto _L2; else goto _L1
_L1:
        Bundle bundle = new Bundle();
        bundle.putString("FRAGMENT_CLASS", fragmentClass.getName());
        bundle.putBundle("FRAGMENT_DATA", fragmentData);
        mFragment = (RootTabFragment)Fragment.instantiate(pmactivity, com/poshmark/ui/fragments/RootTabFragment.getName(), bundle);
        fragmenttransaction.add(0x7f0c0049, mFragment);
_L4:
        fragmenttransaction.commit();
        fragmentmanager.executePendingTransactions();
        mFragment.attachTabButton(this);
        return;
_L2:
        if (!mFragment.isAdded())
        {
            fragmenttransaction.attach(mFragment);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (badge > 0)
        {
            Paint paint = new Paint();
            String s = String.format("%d", new Object[] {
                Integer.valueOf(badge)
            });
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            paint.setTextSize((int)ViewUtils.dipToPixels(getContext(), 14F));
            if (badge > 99)
            {
                s = "99+";
                paint.setTextSize((int)ViewUtils.dipToPixels(getContext(), 12F));
                paint.setTypeface(Typeface.create("sans-serif", 1));
            }
            Rect rect = new Rect();
            paint.getTextBounds(s, 0, s.length(), rect);
            float f1 = ViewUtils.dipToPixels(getContext(), 22F);
            float f = f1;
            if ((float)rect.width() > f1)
            {
                f = rect.width() + 10;
            }
            paint.setAntiAlias(true);
            paint.setColor(0xffff0000);
            f1 = f / 2.0F + 5F;
            canvas.drawCircle((float)getWidth() - f, f1, f / 2.0F, paint);
            paint.setColor(-1);
            int i = getWidth();
            int j = (int)f;
            f = rect.height() / 2;
            canvas.drawText(s, i - j, f1 + f, paint);
        }
    }

    public void setBadge(int i)
    {
        badge = i;
        postInvalidate();
    }

    public void setFragmentToLaunch(Class class1, Bundle bundle)
    {
        fragmentClass = class1;
        fragmentData = bundle;
    }

    public void setParentTabBar(PMTabBar pmtabbar)
    {
        parentContainerBar = pmtabbar;
    }

    public void setSelected(boolean flag)
    {
        if (flag && selectedIcon != null)
        {
            setTextColor(getResources().getColor(0x7f090040));
            setCompoundDrawablesWithIntrinsicBounds(null, selectedIcon, null, null);
            return;
        } else
        {
            setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
            setTextColor(getResources().getColor(0x7f09003e));
            return;
        }
    }

    public void setTabListener(PMTabBar.PMTabListener pmtablistener)
    {
        tabListener = pmtablistener;
    }
}
