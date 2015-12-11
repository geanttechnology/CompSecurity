// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfiguration, DcsState, DcsProperty

final class DeviceConfigurationTestImpl extends DeviceConfiguration
{

    DeviceConfigurationTestImpl()
    {
        super((new DcsState(EbayCountry.getInstance(EbaySite.US), null, 100)).setLocale(Locale.US));
        devOverrides = new HashMap();
    }

    protected Object getValue(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = devOverrides.get(dcsproperty.key());
        if (obj != null) goto _L2; else goto _L1
_L1:
        dcsproperty = ((DcsProperty) (getDefaultValue(dcsproperty)));
_L4:
        this;
        JVM INSTR monitorexit ;
        return dcsproperty;
_L2:
        Object obj1 = DEV_OVERRIDE_NULL;
        dcsproperty = ((DcsProperty) (obj));
        if (obj == obj1)
        {
            dcsproperty = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        dcsproperty;
        throw dcsproperty;
    }
}
