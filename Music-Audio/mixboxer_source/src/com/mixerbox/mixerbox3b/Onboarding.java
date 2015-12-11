// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.utils.MixerBoxConstants;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

public class Onboarding extends FragmentActivity
{

    Bundle bundle;
    FragmentManager fm;
    public boolean hasInit;
    public ImageView ivS1;
    public ImageView ivS2;
    public ImageView ivS3;
    private MyFragmentPageAdapter mAdapter;
    MyHandler mHandler;
    private ViewPager mViewPager;

    public Onboarding()
    {
    }

    public void goToMainPage()
    {
        mHandler.removeMessages(1);
        MixerBoxConstants.shouldOnCreate = true;
        bundle.putBoolean("isLogIn", false);
        Intent intent = new Intent();
        intent.setClass(this, com/mixerbox/mixerbox3b/MainPage);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void initAnim()
    {
        hasInit = true;
        ivS1 = (ImageView)findViewById(0x7f070076);
        ivS2 = (ImageView)findViewById(0x7f070078);
        ivS3 = (ImageView)findViewById(0x7f07007a);
        mHandler.sendEmptyMessageDelayed(1, 300L);
    }

    protected void onCreate(final Bundle tvSkip)
    {
        super.onCreate(tvSkip);
        setContentView(0x7f030044);
        hasInit = false;
        final ImageView ivDot;
        if (getIntent().getExtras() != null)
        {
            bundle = getIntent().getExtras();
        } else
        {
            bundle = new Bundle();
        }
        mViewPager = (ViewPager)findViewById(0x7f0700f1);
        tvSkip = (TextView)findViewById(0x7f0700f2);
        ivDot = (ImageView)findViewById(0x7f0700f0);
        mHandler = new MyHandler();
        fm = getSupportFragmentManager();
        mAdapter = new MyFragmentPageAdapter(fm);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new _cls1());
        tvSkip.setOnClickListener(new _cls2());
    }

    public void onPause()
    {
        mHandler.removeMessages(1);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (hasInit && mViewPager.getCurrentItem() == 0)
        {
            mHandler.sendEmptyMessageDelayed(1, 300L);
        }
    }

    protected void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        FlurryAgent.onStartSession(this, "Z8QPYZT3PBG8R6ZNSDXQ");
    }

    protected void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        FlurryAgent.onEndSession(this);
        super.onStop();
    }

    private class MyHandler extends Handler
    {

        WeakReference mActivity;

        public void handleMessage(Message message)
        {
            Onboarding onboarding = (Onboarding)mActivity.get();
            super.handleMessage(message);
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                message = new Random();
                break;
            }
            if (message.nextInt(2) % 2 == 0)
            {
                onboarding.ivS1.setVisibility(0);
            } else
            {
                onboarding.ivS1.setVisibility(4);
            }
            if (message.nextInt(2) % 2 == 0)
            {
                onboarding.ivS2.setVisibility(0);
            } else
            {
                onboarding.ivS2.setVisibility(4);
            }
            if (message.nextInt(2) % 2 == 0)
            {
                onboarding.ivS3.setVisibility(0);
            } else
            {
                onboarding.ivS3.setVisibility(4);
            }
            removeMessages(1);
            sendEmptyMessageDelayed(1, 500L);
        }

        MyHandler()
        {
            mActivity = new WeakReference(Onboarding.this);
        }
    }


    private class MyFragmentPageAdapter extends FragmentPagerAdapter
    {

        final Onboarding this$0;

        public int getCount()
        {
            return 3;
        }

        public Fragment getItem(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                return MyFragment.newInstance(i);

            case 1: // '\001'
                return MyFragment.newInstance(i);

            case 2: // '\002'
                return MyFragment.newInstance(i);
            }
        }

        public MyFragmentPageAdapter(FragmentManager fragmentmanager)
        {
            this$0 = Onboarding.this;
            super(fragmentmanager);
        }
    }


    private class _cls1
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        boolean shouldMove;
        final Onboarding this$0;
        final ImageView val$ivDot;
        final TextView val$tvSkip;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            (new StringBuilder()).append("arg0 = ").append(i).append(", arg1 = ").append(f).append(", arg2 = ").append(j).toString();
            if (shouldMove)
            {
                Object obj = ((Fragment)fm.getFragments().get(1)).getView();
                ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f07008a);
                ImageView imageview1 = (ImageView)((View) (obj)).findViewById(0x7f07008b);
                ImageView imageview2 = (ImageView)((View) (obj)).findViewById(0x7f070089);
                ImageView imageview3 = (ImageView)((View) (obj)).findViewById(0x7f07008c);
                if (i == 0 && (double)f > 0.5D || i == 1 && (double)f < 0.5D)
                {
                    obj = (RelativeLayout)((View) (obj)).findViewById(0x7f070088);
                    float f1 = imageview.getX() + (float)imageview.getWidth();
                    if (i == 1)
                    {
                        imageview1.setX(f1 - (float)(imageview1.getWidth() / 2) - (float)j);
                        if ((double)f < 0.5D && (double)((int)((double)imageview.getX() - (double)imageview2.getWidth() * 1.2D) + j + j / 4) < (double)((float)imageview.getWidth() + imageview.getX()) + (double)imageview2.getWidth() * 1.3D)
                        {
                            imageview2.setX((int)((double)imageview.getX() - (double)imageview2.getWidth() * 1.2D) + j + j / 4);
                        }
                        imageview3.setX(f1 - (float)imageview3.getWidth() - (float)(j / 3));
                    }
                    if (i == 0)
                    {
                        imageview1.setX((f1 - (float)(imageview1.getWidth() / 2)) + (float)(((RelativeLayout) (obj)).getWidth() - j));
                        imageview2.setX((int)((double)imageview.getX() - (double)imageview2.getWidth() * 1.2D) + (((RelativeLayout) (obj)).getWidth() - j) / 2);
                        imageview3.setX((f1 - (float)imageview3.getWidth()) + (float)((((RelativeLayout) (obj)).getWidth() - j) / 3));
                    }
                }
            }
        }

        public void onPageSelected(int i)
        {
            if (i == 1)
            {
                shouldMove = true;
            } else
            {
                shouldMove = false;
            }
            if (i != 0)
            {
                mHandler.removeMessages(1);
            } else
            {
                mHandler.sendEmptyMessageDelayed(1, 300L);
            }
            if (i == 1)
            {
                Object obj = ((Fragment)fm.getFragments().get(1)).getView();
                ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f07008a);
                ImageView imageview1 = (ImageView)((View) (obj)).findViewById(0x7f07008b);
                ImageView imageview2 = (ImageView)((View) (obj)).findViewById(0x7f070089);
                obj = (ImageView)((View) (obj)).findViewById(0x7f07008c);
                float f = imageview.getX() + (float)imageview.getWidth();
                imageview2.setX((int)((double)imageview.getX() - (double)imageview2.getWidth() * 1.2D));
                imageview1.setY(imageview.getY() - (float)(imageview1.getHeight() / 2));
                imageview1.setX(f - (float)(imageview1.getWidth() / 2));
                ((ImageView) (obj)).setX(f - (float)((ImageView) (obj)).getWidth());
                f = imageview.getY();
                ((ImageView) (obj)).setY(((float)imageview.getHeight() + f) - (float)(((ImageView) (obj)).getHeight() / 2));
                imageview1.setVisibility(0);
                imageview2.setVisibility(0);
                ((ImageView) (obj)).setVisibility(0);
            }
            if (i == 2)
            {
                final ImageView b4 = ((Fragment)fm.getFragments().get(i)).getView();
                final ImageView b1 = (ImageView)b4.findViewById(0x7f07007d);
                final ImageView b2 = (ImageView)b4.findViewById(0x7f070080);
                final ImageView b3 = (ImageView)b4.findViewById(0x7f070083);
                b4 = (ImageView)b4.findViewById(0x7f070086);
                Animation animation = AnimationUtils.loadAnimation(Onboarding.this, 0x7f040005);
                final Animation zoom2 = AnimationUtils.loadAnimation(Onboarding.this, 0x7f040005);
                final Animation zoom3 = AnimationUtils.loadAnimation(Onboarding.this, 0x7f040005);
                final Animation zoom4 = AnimationUtils.loadAnimation(Onboarding.this, 0x7f040005);
                b1.setVisibility(4);
                b2.setVisibility(4);
                b3.setVisibility(4);
                b4.setVisibility(4);
                animation.setRepeatCount(1);
                class _cls1
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls1 this$1;
                    final ImageView val$b1;
                    final ImageView val$b2;
                    final Animation val$zoom2;

                    public void onAnimationEnd(Animation animation1)
                    {
                        b2.startAnimation(zoom2);
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                        b1.setVisibility(0);
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    b1 = imageview;
                    b2 = imageview1;
                    zoom2 = animation;
                    super();
                }
                }

                animation.setAnimationListener(new _cls1());
                zoom2.setRepeatCount(1);
                class _cls2
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls1 this$1;
                    final ImageView val$b2;
                    final ImageView val$b3;
                    final Animation val$zoom3;

                    public void onAnimationEnd(Animation animation1)
                    {
                        b3.startAnimation(zoom3);
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                        b2.setVisibility(0);
                    }

                _cls2()
                {
                    this$1 = _cls1.this;
                    b2 = imageview;
                    b3 = imageview1;
                    zoom3 = animation;
                    super();
                }
                }

                zoom2.setAnimationListener(new _cls2());
                zoom3.setRepeatCount(1);
                class _cls3
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls1 this$1;
                    final ImageView val$b3;
                    final ImageView val$b4;
                    final Animation val$zoom4;

                    public void onAnimationEnd(Animation animation1)
                    {
                        b4.startAnimation(zoom4);
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                        b3.setVisibility(0);
                    }

                _cls3()
                {
                    this$1 = _cls1.this;
                    b3 = imageview;
                    b4 = imageview1;
                    zoom4 = animation;
                    super();
                }
                }

                zoom3.setAnimationListener(new _cls3());
                zoom4.setRepeatCount(1);
                class _cls4
                    implements android.view.animation.Animation.AnimationListener
                {

                    final _cls1 this$1;
                    final ImageView val$b4;

                    public void onAnimationEnd(Animation animation1)
                    {
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                        b4.setVisibility(0);
                    }

                _cls4()
                {
                    this$1 = _cls1.this;
                    b4 = imageview;
                    super();
                }
                }

                zoom4.setAnimationListener(new _cls4());
                b1.startAnimation(animation);
            }
            if (i == 2)
            {
                tvSkip.setVisibility(4);
            } else
            {
                tvSkip.setVisibility(0);
            }
            if (i == 0)
            {
                ivDot.setImageDrawable(getResources().getDrawable(0x7f0200d8));
            } else
            if (i == 1)
            {
                ivDot.setImageDrawable(getResources().getDrawable(0x7f0200d9));
                return;
            }
        }

        _cls1()
        {
            this$0 = Onboarding.this;
            tvSkip = textview;
            ivDot = imageview;
            super();
            shouldMove = false;
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final Onboarding this$0;

        public void onClick(View view)
        {
            FlurryAgent.logEvent("action_onboarding_skip");
            goToMainPage();
        }

        _cls2()
        {
            this$0 = Onboarding.this;
            super();
        }
    }

}
