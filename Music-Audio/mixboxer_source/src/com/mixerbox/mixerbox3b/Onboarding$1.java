// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            Onboarding

class shouldMove
    implements android.support.v4.view.ageChangeListener
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

                final Onboarding._cls1 this$1;
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
                this$1 = Onboarding._cls1.this;
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

                final Onboarding._cls1 this$1;
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
                this$1 = Onboarding._cls1.this;
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

                final Onboarding._cls1 this$1;
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
                this$1 = Onboarding._cls1.this;
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

                final Onboarding._cls1 this$1;
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
                this$1 = Onboarding._cls1.this;
                b4 = imageview;
                super();
            }
            }

            zoom4.setAnimationListener(new _cls4());
            b1.startAnimation(animation);
        }
        if (i == 2)
        {
            val$tvSkip.setVisibility(4);
        } else
        {
            val$tvSkip.setVisibility(0);
        }
        if (i == 0)
        {
            val$ivDot.setImageDrawable(getResources().getDrawable(0x7f0200d8));
        } else
        if (i == 1)
        {
            val$ivDot.setImageDrawable(getResources().getDrawable(0x7f0200d9));
            return;
        }
    }

    _cls4()
    {
        this$0 = final_onboarding;
        val$tvSkip = textview;
        val$ivDot = ImageView.this;
        super();
        shouldMove = false;
    }
}
