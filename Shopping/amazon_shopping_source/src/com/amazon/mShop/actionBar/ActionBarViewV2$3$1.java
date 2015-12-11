// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.view.View;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.gno.GNODrawerHelper;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

class this._cls1
    implements Runnable
{

    final rker this$1;

    public void run()
    {
        android.content.Intent intent = (new SearchIntentBuilder(ActionBarViewV2.access$100(_fld0))).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(ClickStreamTag.ORIGIN_SEARCH.getTag()).build();
        ActivityUtils.startSearchActivity(ActionBarViewV2.access$100(_fld0), intent);
        RefMarkerObserver.logRefMarker("gno_sr");
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/actionBar/ActionBarViewV2$3

/* anonymous class */
    class ActionBarViewV2._cls3
        implements android.view.View.OnClickListener
    {

        final ActionBarViewV2 this$0;

        public void onClick(View view)
        {
            GNODrawerHelper.closeDrawerAndExecute(ActionBarViewV2.access$100(ActionBarViewV2.this), true, new ActionBarViewV2._cls3._cls1());
        }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
    }

}
