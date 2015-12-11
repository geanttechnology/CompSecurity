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

class this._cls0 extends g
{

    final WeeklyAdFragment this$0;

    public e a()
    {
        return e.b(new com.target.ui.f.e() {

            final WeeklyAdFragment._cls1 this$1;

            public void onTransitionEnd(Transition transition)
            {
                (new Handler(Looper.getMainLooper())).post(new Runnable() {

                    final _cls1 this$2;

                    public void run()
                    {
                        if (WeeklyAdFragment.b(this$0) != null)
                        {
                            WeeklyAdFragment.b(this$0).weeklyAdListLayout.setEnabled(true);
                            if (WeeklyAdFragment.c(this$0) != null)
                            {
                                WeeklyAdFragment.b(this$0).weeklyAdHeaderView.a(false);
                                WeeklyAdFragment.b(this$0).weeklyAdHeaderView.a();
                                return;
                            }
                        }
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            public void onTransitionStart(Transition transition)
            {
                (new Handler(Looper.getMainLooper())).post(new Runnable() {

                    final _cls1 this$2;

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
                this$2 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$1 = WeeklyAdFragment._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = WeeklyAdFragment.this;
        super();
    }
}
