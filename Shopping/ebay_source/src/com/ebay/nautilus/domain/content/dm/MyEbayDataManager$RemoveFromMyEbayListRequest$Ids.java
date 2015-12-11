// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager

private static final class ids
    implements com.ebay.nautilus.domain.net.st.Ids
{

    private final long ids[];

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        long al[] = ids;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "itemID", String.valueOf(al[i]));
        }

    }

    public (MyEbayListItem amyebaylistitem[])
    {
        int j = amyebaylistitem.length;
        ids = new long[j];
        for (int i = 0; i < j; i++)
        {
            ids[i] = amyebaylistitem[i].id;
        }

    }
}
