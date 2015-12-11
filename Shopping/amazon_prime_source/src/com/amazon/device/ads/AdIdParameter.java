// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            UserIdParameter, AdvertisingIdentifier, Settings, DebugProperties, 
//            WebRequest

class AdIdParameter
    implements UserIdParameter
{

    private final AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIndentifierInfo;
    private final DebugProperties debugProperties;
    private final Settings settings;

    public AdIdParameter()
    {
        this(new AdvertisingIdentifier(), Settings.getInstance(), DebugProperties.getInstance());
    }

    AdIdParameter(AdvertisingIdentifier advertisingidentifier, Settings settings1, DebugProperties debugproperties)
    {
        advertisingIdentifier = advertisingidentifier;
        settings = settings1;
        debugProperties = debugproperties;
    }

    private boolean canIdentify()
    {
        boolean flag = false;
        if (advertisingIndentifierInfo == null)
        {
            AdvertisingIdentifier advertisingidentifier = advertisingIdentifier;
            if (settings.getInt("configVersion", 0) != 0)
            {
                flag = true;
            }
            advertisingidentifier.setShouldSetCurrentAdvertisingIdentifier(flag);
            advertisingIndentifierInfo = advertisingIdentifier.getAdvertisingIdentifierInfo();
        }
        return advertisingIndentifierInfo.canDo();
    }

    public boolean evaluate(WebRequest webrequest)
    {
        if (!canIdentify())
        {
            return false;
        } else
        {
            webrequest.putUnencodedQueryParameter("adId", debugProperties.getDebugPropertyAsString("debug.adid", advertisingIndentifierInfo.getSISDeviceIdentifier()));
            return true;
        }
    }
}
