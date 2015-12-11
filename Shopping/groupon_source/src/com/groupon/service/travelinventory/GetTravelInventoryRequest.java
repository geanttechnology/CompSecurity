// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.travelinventory;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.travelinventory.ByOptions;
import com.groupon.models.travelinventory.Options;
import com.groupon.models.travelinventory.TravelInventory;
import com.groupon.models.travelinventory.TravelInventoryResponse;
import com.groupon.models.travelinventory.TravelInventoryWrapper;
import java.util.ArrayList;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.travelinventory:
//            GetTravelInventoryCallBack

public class GetTravelInventoryRequest extends Http
{

    private GetTravelInventoryCallBack callBack;
    private String optionId;

    public GetTravelInventoryRequest(Context context, String s, String s1, String s2, GetTravelInventoryCallBack gettravelinventorycallback)
    {
        super(context, com/groupon/models/travelinventory/TravelInventoryWrapper, (new StringBuilder()).append("/deals/").append(s).append("/travel_inventory").toString(), new Object[] {
            "end_date", s2
        });
        optionId = s1;
        callBack = gettravelinventorycallback;
    }

    protected void onSuccess(TravelInventoryWrapper travelinventorywrapper)
        throws Exception
    {
        TravelInventoryResponse travelinventoryresponse;
        ByOptions abyoptions[];
        int i;
        boolean flag;
        int j;
        flag = false;
        super.onSuccess(travelinventorywrapper);
        ArrayList arraylist = new ArrayList();
        travelinventoryresponse = new TravelInventoryResponse();
        travelinventoryresponse.bookableDateList = arraylist;
        abyoptions = travelinventorywrapper.travelInventory.byOptions;
        j = abyoptions.length;
        i = 0;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        ByOptions byoptions = abyoptions[i];
        if (!Strings.equals(byoptions.optionId, optionId)) goto _L4; else goto _L3
_L3:
        travelinventoryresponse.bookableDateList = byoptions.byDates;
_L2:
        travelinventorywrapper = travelinventorywrapper.travelInventory.options;
        j = travelinventorywrapper.length;
        i = ((flag) ? 1 : 0);
_L6:
        if (i < j)
        {
            Object obj = travelinventorywrapper[i];
            if (!Strings.equals(((Options) (obj)).id, optionId))
            {
                break MISSING_BLOCK_LABEL_166;
            }
            travelinventoryresponse.minNights = ((Options) (obj)).minimum;
            travelinventoryresponse.maxNights = ((Options) (obj)).maximum;
        }
        if (callBack != null)
        {
            callBack.onSuccess(travelinventoryresponse);
        }
        return;
_L4:
        i++;
          goto _L5
        i++;
          goto _L6
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((TravelInventoryWrapper)obj);
    }
}
