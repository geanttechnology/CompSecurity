// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.gno.GNODrawerHelper;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

class this._cls0
    implements android.view.er
{

    final ActionBarViewV2 this$0;

    public void onClick(View view)
    {
        if (!ActionBarViewV2.access$100(ActionBarViewV2.this).canLaunchHomeFromActionBar())
        {
            return;
        } else
        {
            GNODrawerHelper.closeDrawerAndExecute(ActionBarViewV2.access$100(ActionBarViewV2.this), true, new Runnable() {

                final ActionBarViewV2._cls2 this$1;

                public void run()
                {
                    ActivityUtils.startHomeActivity(ActionBarViewV2.access$100(this$0));
                    RefMarkerObserver.logRefMarker("gno_logo");
                }

            
            {
                this$1 = ActionBarViewV2._cls2.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ActionBarViewV2.this;
        super();
    }
}
