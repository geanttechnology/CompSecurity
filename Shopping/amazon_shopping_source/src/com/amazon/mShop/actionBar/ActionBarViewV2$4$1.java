// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.view.View;
import com.amazon.mShop.gno.GNODrawerHelper;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

class this._cls1
    implements Runnable
{

    final rker this$1;

    public void run()
    {
        ActivityUtils.startCartActivity(ActionBarViewV2.access$100(_fld0));
        RefMarkerObserver.logRefMarker("gno_cart");
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/actionBar/ActionBarViewV2$4

/* anonymous class */
    class ActionBarViewV2._cls4
        implements android.view.View.OnClickListener
    {

        final ActionBarViewV2 this$0;

        public void onClick(View view)
        {
            GNODrawerHelper.closeDrawerAndExecute(ActionBarViewV2.access$100(ActionBarViewV2.this), true, new ActionBarViewV2._cls4._cls1());
        }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
    }

}
