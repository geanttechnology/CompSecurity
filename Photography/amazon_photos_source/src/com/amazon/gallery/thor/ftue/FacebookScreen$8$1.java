// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        FacebookScreen.access$3800(_fld0).hide();
        FacebookScreen.access$2500(_fld0).launchFacebookPermissionsPage(FacebookScreen.access$3900(_fld0));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$8

/* anonymous class */
    class FacebookScreen._cls8
        implements Runnable
    {

        final FacebookScreen this$0;

        public void run()
        {
            FacebookScreen.access$4000(FacebookScreen.this).runOnUiThread(new FacebookScreen._cls8._cls1());
        }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
    }

}
