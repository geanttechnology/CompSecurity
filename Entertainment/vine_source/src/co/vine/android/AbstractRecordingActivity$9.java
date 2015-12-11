// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import android.support.v4.view.DraftViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.widget.ImageView;
import co.vine.android.animation.SimpleAnimationListener;
import co.vine.android.recorder.ViewGoneAnimationListener;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, RecordingFragment

class tener extends SimpleAnimationListener
{

    final AbstractRecordingActivity this$0;
    final boolean val$goToCamera;

    public void onAnimationEnd(Animation animation)
    {
        if (mCurrentPage != AbstractRecordingActivity.access$000(AbstractRecordingActivity.this).size())
        {
            AbstractRecordingActivity.access$400(AbstractRecordingActivity.this).setAlpha(0.0F);
            AbstractRecordingActivity.access$400(AbstractRecordingActivity.this).setVisibility(0);
            if (!AbstractRecordingActivity.access$1300(AbstractRecordingActivity.this))
            {
                AbstractRecordingActivity.access$400(AbstractRecordingActivity.this).animate().alpha(1.0F).start();
            }
        }
        AbstractRecordingActivity.access$1500(AbstractRecordingActivity.this).setAnimationListener(new SimpleAnimationListener() {

            final AbstractRecordingActivity._cls9 this$1;

            public void onAnimationEnd(Animation animation1)
            {
                AbstractRecordingActivity.access$1702(this$0, false);
                AbstractRecordingActivity.access$1200(this$0).postDelayed(new Runnable() {

                    final _cls1 this$2;

                    public void run()
                    {
                        if (!goToCamera)
                        {
                            AbstractRecordingActivity.access$900(this$0).setVisibility(8);
                            AbstractRecordingActivity.access$1000(this$0).setVisibility(8);
                        }
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                }, 300L);
            }

            public void onAnimationStart(Animation animation1)
            {
                if (goToCamera)
                {
                    AbstractRecordingActivity.access$1400(this$0).setVisibility(0);
                    AbstractRecordingActivity.access$1400(this$0).setAlpha(0.0F);
                    AbstractRecordingActivity.access$1400(this$0).animate().alpha(1.0F).setDuration(AbstractRecordingActivity.access$1500(this$0).getDuration()).setListener(new ViewGoneAnimationListener(AbstractRecordingActivity.access$1400(this$0))).start();
                    AbstractRecordingActivity.access$1200(this$0).postDelayed(new Runnable() {

                        final _cls1 this$2;

                        public void run()
                        {
                            AbstractRecordingActivity.access$800(this$0).setVisibility(8);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    }, AbstractRecordingActivity.access$1600(this$0).getDuration());
                }
            }

            
            {
                this$1 = AbstractRecordingActivity._cls9.this;
                super();
            }
        });
        AbstractRecordingActivity.access$1200(AbstractRecordingActivity.this).postDelayed(new Runnable() {

            final AbstractRecordingActivity._cls9 this$1;

            public void run()
            {
                AbstractRecordingActivity.access$1800(this$0).setVisibility(8);
            }

            
            {
                this$1 = AbstractRecordingActivity._cls9.this;
                super();
            }
        }, 150L);
        AbstractRecordingActivity.access$1900(AbstractRecordingActivity.this).setVisibility(0);
        AbstractRecordingActivity.access$1900(AbstractRecordingActivity.this).startAnimation(AbstractRecordingActivity.access$1500(AbstractRecordingActivity.this));
        AbstractRecordingActivity.access$2002(AbstractRecordingActivity.this, 0);
        AbstractRecordingActivity.access$600(AbstractRecordingActivity.this).setVisibility(0);
        if (mCurrentFragment instanceof RecordingFragment)
        {
            ((RecordingFragment)mCurrentFragment).onShowDrafts();
        }
        AbstractRecordingActivity.access$500(AbstractRecordingActivity.this).setVisibility(8);
        AbstractRecordingActivity.access$2100(AbstractRecordingActivity.this).setVisibility(8);
        AbstractRecordingActivity.access$2200(AbstractRecordingActivity.this).setVisibility(8);
        AbstractRecordingActivity.access$2300(AbstractRecordingActivity.this).setVisibility(8);
    }

    public void onAnimationStart(Animation animation)
    {
        AbstractRecordingActivity.access$1200(AbstractRecordingActivity.this).removeCallbacks(AbstractRecordingActivity.access$1100(AbstractRecordingActivity.this));
        AbstractRecordingActivity.access$1200(AbstractRecordingActivity.this).postDelayed(AbstractRecordingActivity.access$1100(AbstractRecordingActivity.this), 300L);
    }

    _cls2.this._cls1()
    {
        this$0 = final_abstractrecordingactivity;
        val$goToCamera = Z.this;
        super();
    }
}
