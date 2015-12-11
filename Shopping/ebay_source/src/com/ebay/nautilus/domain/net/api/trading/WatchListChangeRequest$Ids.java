// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            WatchListChangeRequest

private static class data extends ge
    implements com.ebay.nautilus.domain.net.uestBuilder
{

    private final long data[];

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        long al[] = data;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(al[i]));
        }

    }

    public ge(boolean flag, long al[])
    {
        super(flag);
        data = al;
    }
}
