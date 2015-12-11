// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.gotv.crackle.Application;
import java.lang.reflect.Field;

// Referenced classes of package com.gotv.crackle.views:
//            PagerIndicator

public class HeroViewPager extends ViewPager
{
    public class FixedSpeedScroller extends Scroller
    {

        final HeroViewPager this$0;

        public void startScroll(int i, int j, int k, int l)
        {
            super.startScroll(i, j, k, l, 2000);
        }

        public void startScroll(int i, int j, int k, int l, int i1)
        {
            super.startScroll(i, j, k, l, 2000);
        }

        public FixedSpeedScroller(Context context)
        {
            this$0 = HeroViewPager.this;
            super(context);
        }
    }


    private static final int SLIDE_DELAY_TIME = 10000;
    private static final int SLIDE_DURATION = 2000;
    private static final int SLIDE_SHOW_NEXT = 0;
    private static Handler _handler = new Handler() {

        public void handleMessage(Message message)
        {
            HeroViewPager heroviewpager = (HeroViewPager)message.obj;
            message.what;
            JVM INSTR tableswitch 0 0: default 32
        //                       0 38;
               goto _L1 _L2
_L1:
            super.handleMessage(message);
            return;
_L2:
            heroviewpager.setFixedScroller();
            heroviewpager.setCurrentItem(heroviewpager.getCurrentItem() + 1, true);
            Message message1 = Message.obtain();
            message1.obj = heroviewpager;
            message1.what = 0;
            HeroViewPager._handler.sendMessageDelayed(message1, 10000L);
            if (true) goto _L1; else goto _L3
_L3:
        }

    };
    private static final Interpolator sInterpolator = new Interpolator() {

        public float getInterpolation(float f)
        {
            f--;
            return f * f * f + 1.0F;
        }

    };
    private Scroller mDefaultScroller;
    private Scroller mFixedScroller;
    private PagerIndicator mIndicator;

    public HeroViewPager(Context context)
    {
        super(context);
        init();
    }

    public HeroViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        mFixedScroller = new FixedSpeedScroller(getContext());
        mDefaultScroller = new Scroller(getContext(), sInterpolator);
        if (Application.isLeanBack())
        {
            setFixedScroller();
        }
        setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final HeroViewPager this$0;

            public void onPageScrollStateChanged(int i)
            {
                PagerIndicator pagerindicator = getIndicator();
                if (pagerindicator != null)
                {
                    pagerindicator.setCurrentPage(getCurrentItem() % pagerindicator.getNumberOfPages());
                }
            }

            public void onPageScrolled(int i, float f, int j)
            {
                HeroViewPager._handler.removeMessages(0);
                startHandler();
            }

            public void onPageSelected(int i)
            {
            }

            
            {
                this$0 = HeroViewPager.this;
                super();
            }
        });
        startHandler();
    }

    private void setDefaultScroller()
    {
        setScroller(mDefaultScroller);
    }

    private void setFixedScroller()
    {
        setScroller(mFixedScroller);
    }

    private void setScroller(Scroller scroller)
    {
        try
        {
            Field field = android/support/v4/view/ViewPager.getDeclaredField("mScroller");
            field.setAccessible(true);
            field.set(this, scroller);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Scroller scroller)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Scroller scroller)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Scroller scroller)
        {
            return;
        }
    }

    private void startHandler()
    {
        Message message = Message.obtain();
        message.obj = this;
        message.what = 0;
        _handler.sendMessageDelayed(message, 10000L);
    }

    public PagerIndicator getIndicator()
    {
        return mIndicator;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            setDefaultScroller();
        }
        return super.onTouchEvent(motionevent);
    }

    public void setIndicator(PagerIndicator pagerindicator)
    {
        mIndicator = pagerindicator;
    }




}
