// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.Handler;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls0
    implements Runnable
{

    final FacebookScreen this$0;

    public void run()
    {
        FacebookScreen.access$2100(FacebookScreen.this);
        FacebookScreen.access$4300(FacebookScreen.this).setNotification(FacebookScreen.access$4200(FacebookScreen.this).getString(0x7f0e00be));
        FacebookScreen.access$4500(FacebookScreen.this).postDelayed(new Runnable() {

            final FacebookScreen._cls10 this$1;

            public void run()
            {
                FacebookScreen.access$4400(this$0).proceedToNext(this$0, true);
            }

            
            {
                this$1 = FacebookScreen._cls10.this;
                super();
            }
        }, 3000L);
    }

    _cls1.this._cls1()
    {
        this$0 = FacebookScreen.this;
        super();
    }
}
