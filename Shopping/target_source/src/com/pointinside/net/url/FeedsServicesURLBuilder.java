// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.internal.ParameterCheck;

// Referenced classes of package com.pointinside.net.url:
//            FeedsURLBuilder

public class FeedsServicesURLBuilder extends FeedsURLBuilder
{

    public FeedsServicesURLBuilder(String s)
    {
        super(s);
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        ParameterCheck.throwIfNullOrEmpty("venueUUID", venueUUID);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(venueUUID);
        stringbuilder.append("/services");
        setQualifiers(stringbuilder.toString());
    }
}
