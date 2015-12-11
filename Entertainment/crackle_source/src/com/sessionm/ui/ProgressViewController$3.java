// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ScrollView;

// Referenced classes of package com.sessionm.ui:
//            ProgressViewController

class this._cls0
    implements android.view.animation.er
{

    final ProgressViewController this$0;

    public void onAnimationEnd(Animation animation)
    {
        if (ProgressViewController.access$300(ProgressViewController.this) == null)
        {
            return;
        } else
        {
            ProgressViewController.access$200(ProgressViewController.this).runOnUiThread(new Runnable() {

                final ProgressViewController._cls3 this$1;

                public void run()
                {
                    ViewGroup viewgroup = (ViewGroup)ProgressViewController.access$300(this$0).getParent();
                    if (viewgroup != null)
                    {
                        viewgroup.removeView(ProgressViewController.access$300(this$0));
                    }
                    ProgressViewController.access$300(this$0).removeAllViews();
                }

            
            {
                this$1 = ProgressViewController._cls3.this;
                super();
            }
            });
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = ProgressViewController.this;
        super();
    }
}
