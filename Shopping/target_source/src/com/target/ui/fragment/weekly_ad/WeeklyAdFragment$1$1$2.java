// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.os.Handler;
import android.os.Looper;
import android.transition.Transition;
import com.google.a.a.e;
import com.target.ui.f.g;
import com.target.ui.view.weekly_ad.WeeklyAdHeaderView;
import com.target.ui.view.weekly_ad.WeeklyAdListLayout;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdFragment

class this._cls2
    implements Runnable
{

    final weeklyAdHeaderView this$2;

    public void run()
    {
        if (WeeklyAdFragment.b(_fld0) != null)
        {
            WeeklyAdFragment.b(_fld0).weeklyAdListLayout.setEnabled(true);
            if (WeeklyAdFragment.c(_fld0) != null)
            {
                WeeklyAdFragment.b(_fld0).weeklyAdHeaderView.a(false);
                WeeklyAdFragment.b(_fld0).weeklyAdHeaderView.a();
                return;
            }
        }
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/target/ui/fragment/weekly_ad/WeeklyAdFragment$1

/* anonymous class */
    class WeeklyAdFragment._cls1 extends g
    {

        final WeeklyAdFragment this$0;

        public e a()
        {
            return e.b(new WeeklyAdFragment._cls1._cls1());
        }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
    }


    // Unreferenced inner class com/target/ui/fragment/weekly_ad/WeeklyAdFragment$1$1

/* anonymous class */
    class WeeklyAdFragment._cls1._cls1 extends com.target.ui.f.e
    {

        final WeeklyAdFragment._cls1 this$1;

        public void onTransitionEnd(Transition transition)
        {
            (new Handler(Looper.getMainLooper())).post(new WeeklyAdFragment._cls1._cls1._cls2());
        }

        public void onTransitionStart(Transition transition)
        {
            (new Handler(Looper.getMainLooper())).post(new WeeklyAdFragment._cls1._cls1._cls1());
        }

            
            {
                this$1 = WeeklyAdFragment._cls1.this;
                super();
            }

        // Unreferenced inner class com/target/ui/fragment/weekly_ad/WeeklyAdFragment$1$1$1

/* anonymous class */
        class WeeklyAdFragment._cls1._cls1._cls1
            implements Runnable
        {

            final WeeklyAdFragment._cls1._cls1 this$2;

            public void run()
            {
                if (WeeklyAdFragment.b(this$0) == null)
                {
                    return;
                } else
                {
                    WeeklyAdFragment.b(this$0).weeklyAdListLayout.setEnabled(false);
                    WeeklyAdFragment.b(this$0).weeklyAdHeaderView.c();
                    return;
                }
            }

                    
                    {
                        this$2 = WeeklyAdFragment._cls1._cls1.this;
                        super();
                    }
        }

    }

}
