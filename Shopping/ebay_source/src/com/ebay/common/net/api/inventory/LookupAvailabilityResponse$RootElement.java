// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.nautilus.domain.net.ErrorElement;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ent
{

    final LookupAvailabilityResponse this$0;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Location".equals(s1))
        {
            if (availabilities == null)
            {
                availabilities = new ArrayList();
            }
            s = new StoreAvailability();
            s.address = new LocationAddress();
            availabilities.add(s);
            ackCode = 1;
            return new ent(LookupAvailabilityResponse.this, s);
        }
        if ("Errors".equals(s1))
        {
            return new ErrorElement(LookupAvailabilityResponse.this, "");
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ent()
    {
        this$0 = LookupAvailabilityResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
