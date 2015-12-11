// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            WatchListChangeRequest

private static class it> extends it>
    implements com.ebay.nautilus.domain.net.ilder
{

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "RemoveAllItems", "true");
    }

    public ()
    {
        super(false);
    }
}
