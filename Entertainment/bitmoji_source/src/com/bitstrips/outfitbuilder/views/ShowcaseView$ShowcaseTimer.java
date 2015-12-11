// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            ShowcaseView

class this._cls0 extends TimerTask
{

    final ShowcaseView this$0;

    public void run()
    {
        Activity activity = (Activity)weakActivity.get();
        if (activity == null)
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable() {

                final ShowcaseView.ShowcaseTimer this$1;

                public void run()
                {
                    if (adapter.getCount() == 0)
                    {
                        return;
                    } else
                    {
                        ViewPager viewpager = viewPager;
                        ShowcaseView showcaseview = this$0;
                        int i = showcaseview.pageCounter;
                        showcaseview.pageCounter = i + 1;
                        viewpager.setCurrentItem(i % adapter.getCount());
                        return;
                    }
                }

            
            {
                this$1 = ShowcaseView.ShowcaseTimer.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ShowcaseView.this;
        super();
    }
}
