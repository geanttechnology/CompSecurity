// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import android.util.Log;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

class val.scanDetail extends com.ebay.nautilus.kernel.util.._cls3
{

    final val.scanDetail this$1;
    final ShipmentTrackingScanDetail val$scanDetail;

    public void text(String s)
        throws SAXException
    {
        Object obj;
        obj = s;
        if (!useEventTimeHack)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        String s1;
        obj = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
        obj = (new SimpleDateFormat("Z", Locale.getDefault())).format(((Calendar) (obj)).getTime());
        s1 = (new StringBuilder()).append(((String) (obj)).substring(0, 3)).append(":").append(((String) (obj)).substring(3, 5)).toString();
        obj = s;
        try
        {
            if (!"-7:00".equals(s1))
            {
                obj = s.replace("-07:00", s1);
            }
        }
        catch (Exception exception)
        {
            Log.w("ShipmentTrackingResp", "failed to change eventTime, using API supplied value", exception);
            exception = s;
        }
        val$scanDetail.eventTime = EbayDateUtils.parseXml(((String) (obj)));
        return;
    }

    ()
    {
        this$1 = final_;
        val$scanDetail = ShipmentTrackingScanDetail.this;
        super();
    }
}
