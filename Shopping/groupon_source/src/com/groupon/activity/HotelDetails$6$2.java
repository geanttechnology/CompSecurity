// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class this._cls1
    implements Function0
{

    final is._cls0 this$1;

    public void execute()
    {
        HotelDetails.access$1200(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/HotelDetails$6

/* anonymous class */
    class HotelDetails._cls6
        implements android.view.View.OnClickListener
    {

        final HotelDetails this$0;

        public void onClick(View view)
        {
            logger.logClick("", "select_room_click", "market_rate", hotelId);
            if (hasRaO && raoUnlockingTimerContainer.getVisibility() == 0)
            {
                HotelDetails.access$1000(HotelDetails.this);
                logger.logClick("", "rao_skip_offer_click", "hotel_details", new HotelDetails._cls6._cls1());
            }
            if (HotelDetails.access$1100(HotelDetails.this) == null || HotelDetails.access$1100(HotelDetails.this).size() == 0)
            {
                HotelDetails.access$1300(HotelDetails.this, new HotelDetails._cls6._cls2());
                return;
            } else
            {
                HotelDetails.access$1200(HotelDetails.this);
                return;
            }
        }

            
            {
                this$0 = HotelDetails.this;
                super();
            }

        // Unreferenced inner class com/groupon/activity/HotelDetails$6$1

/* anonymous class */
        class HotelDetails._cls6._cls1 extends EncodedNSTField
        {

            final HotelDetails._cls6 this$1;

            public String toEncodedString()
            {
                return "Skip_RaO_offer";
            }

                    
                    {
                        this$1 = HotelDetails._cls6.this;
                        super();
                    }
        }

    }

}
