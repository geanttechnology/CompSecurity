// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.Handler;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        FacebookScreen.access$4400(_fld0).proceedToNext(_fld0, true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$10

/* anonymous class */
    class FacebookScreen._cls10
        implements Runnable
    {

        final FacebookScreen this$0;

        public void run()
        {
            FacebookScreen.access$2100(FacebookScreen.this);
            FacebookScreen.access$4300(FacebookScreen.this).setNotification(FacebookScreen.access$4200(FacebookScreen.this).getString(0x7f0e00be));
            FacebookScreen.access$4500(FacebookScreen.this).postDelayed(new FacebookScreen._cls10._cls1(), 3000L);
        }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
    }

}
