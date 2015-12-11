// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AdRequest, AAXParameter, AdTargetingOptions, AdData

static class eterData
{

    static final AAXParameter PARAMETERS[];
    private final AdData adData;
    private final ctBuilder jsonObjectBuilder;
    private final AdTargetingOptions opt;

    AdData getAdData()
    {
        return adData;
    }

    AdTargetingOptions getAdTargetingOptions()
    {
        return opt;
    }

    JSONObject getJSON()
    {
        jsonObjectBuilder.build();
        return jsonObjectBuilder.getJSON();
    }

    static 
    {
        PARAMETERS = (new AAXParameter[] {
            AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE
        });
    }

    eterData(AdData addata, AdTargetingOptions adtargetingoptions, AdRequest adrequest)
    {
        adData = addata;
        opt = adtargetingoptions;
        addata = opt.getCopyOfAdvancedOptions();
        adtargetingoptions = (new eterData()).setAdvancedOptions(addata).setLOISlot(this).setAdRequest(adrequest);
        jsonObjectBuilder = (new ctBuilder()).setAAXParameters(PARAMETERS).setAdvancedOptions(addata).setParameterData(adtargetingoptions);
    }
}
