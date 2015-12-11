// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import com.groupon.tracking.mobile.sdk.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GrouponSafeAsyncTask

public abstract class ZipCodeAutoComplete extends GrouponSafeAsyncTask
{

    private Context context;
    private Logger logger;
    private String zipCode;

    public ZipCodeAutoComplete(Context context1)
    {
        context = context1;
        zipCode = "";
        logger = (Logger)RoboGuice.getInjector(context1).getInstance(com/groupon/tracking/mobile/sdk/Logger);
    }

    public Bundle call()
        throws Exception
    {
        if (!Strings.isEmpty(zipCode)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Bundle bundle;
        Object obj = new Geocoder(context, Locale.US);
        Address address;
        try
        {
            obj = ((Geocoder) (obj)).getFromLocationName(zipCode, 1);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        if (((List) (obj)).isEmpty()) goto _L1; else goto _L4
_L4:
        address = (Address)((List) (obj)).get(0);
        if (!Strings.equalsIgnoreCase(address.getCountryCode(), "us")) goto _L1; else goto _L5
_L5:
        bundle = new Bundle();
        if (address.getLocality() == null) goto _L7; else goto _L6
_L6:
        obj = address.getLocality();
_L9:
        bundle.putString("city", ((String) (obj)));
        obj = address.getAddressLine(0).split(",");
        if (obj.length >= 2 && obj[1].trim().length() > 2)
        {
            bundle.putString("state", obj[1].trim().substring(0, 2));
        }
        break MISSING_BLOCK_LABEL_164;
_L7:
        try
        {
            obj = address.getSubLocality();
        }
        catch (IOException ioexception1)
        {
            return bundle;
        }
        if (true) goto _L9; else goto _L8
_L8:
        return bundle;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public void execute(String s)
    {
        zipCode = s;
        execute();
    }

    public void logGeoCoderUserChangesCity(String s, String s1)
    {
        if (s != null && !Strings.equals(s, s1))
        {
            logger.logGeneralEvent("cc_billing_address", "edit_city", (new StringBuilder()).append(s).append(", ").append(s1).toString(), 1, Logger.NULL_NST_FIELD);
        }
    }

    public void logGeoCoderUserChangesState(String s, String s1)
    {
        if (s != null && !Strings.equals(s, s1))
        {
            logger.logGeneralEvent("shipping_address", "edit_state", (new StringBuilder()).append(s).append(", ").append(s1).toString(), 1, Logger.NULL_NST_FIELD);
        }
    }
}
