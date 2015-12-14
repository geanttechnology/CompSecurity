// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls1
    implements com.amazon.gallery.framework.gallery.actions.DetectCallback
{

    final is._cls0 this$1;

    public void onResult(boolean flag)
    {
        if (flag)
        {
            FacebookScreen.access$3500(_fld0);
            return;
        } else
        {
            FacebookScreen.access$2500(_fld0).launchFacebookSettingsPage(FacebookScreen.access$3600(_fld0));
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$6

/* anonymous class */
    class FacebookScreen._cls6
        implements android.content.DialogInterface.OnClickListener
    {

        final FacebookScreen this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.dismiss();
            if (!FacebookScreen.access$3300(FacebookScreen.this).promptIfOffline(FacebookScreen.access$3200(FacebookScreen.this)))
            {
                FacebookScreen.access$2500(FacebookScreen.this).isLinkedToFacebook(FacebookScreen.access$3400(FacebookScreen.this), new FacebookScreen._cls6._cls1());
            }
        }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
    }

}
