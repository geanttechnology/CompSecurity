// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.ftue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.ftue:
//            FixedViewPager, PagedFragmentViewAdapter

public abstract class PagedFragmentActivity extends BeanAwareActivity
    implements android.view.View.OnTouchListener
{

    private static final String TAG = com/amazon/gallery/framework/gallery/ftue/PagedFragmentActivity.getName();
    protected List fragments;
    protected FixedViewPager viewPager;

    public PagedFragmentActivity(BeanFactory beanfactory)
    {
        super(beanfactory);
    }

    public abstract void finishFlow();

    public int getPositionForFragment(Class class1)
    {
        for (int i = 0; i < fragments.size(); i++)
        {
            if (((Fragment)fragments.get(i)).getClass().equals(class1))
            {
                return i;
            }
        }

        throw new RuntimeException("Desired fragment class was not found in list of fragments!");
    }

    protected abstract int getStartPageIndex();

    protected void moveToNext()
    {
        int i = viewPager.getCurrentItem() + 1;
        if (i == fragments.size())
        {
            finishFlow();
            return;
        } else
        {
            viewPager.setCurrentItem(i, true);
            return;
        }
    }

    public void moveToSpecific(int i, boolean flag)
    {
        moveToSpecific(i, flag, false);
    }

    public void moveToSpecific(int i, boolean flag, boolean flag1)
    {
        Bundle bundle = ((Fragment)fragments.get(i)).getArguments();
        if (flag)
        {
            bundle.putInt("RETURN_WHEN_DONE", viewPager.getCurrentItem());
        }
        viewPager.setCurrentItem(i, flag1);
    }

    public void moveToSpecific(Class class1, boolean flag)
    {
        moveToSpecific(getPositionForFragment(class1), flag);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return !viewPager.isSwipeEnabled();
    }

    public void proceedToNext(Fragment fragment, boolean flag)
    {
        fragment = fragment.getArguments();
        if (fragment != null && fragment.containsKey("RETURN_WHEN_DONE"))
        {
            int i = fragment.getInt("RETURN_WHEN_DONE");
            fragment.remove("RETURN_WHEN_DONE");
            moveToSpecific(i, false);
            return;
        } else
        {
            moveToNext();
            return;
        }
    }

    public void setViewPager(FixedViewPager fixedviewpager)
    {
        viewPager = fixedviewpager;
        fixedviewpager.setAdapter(new PagedFragmentViewAdapter(super.getSupportFragmentManager(), fragments));
        fixedviewpager.setCurrentItem(getStartPageIndex(), false);
        fixedviewpager.setOffscreenPageLimit(1);
    }

}
