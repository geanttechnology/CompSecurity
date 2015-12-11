// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import com.medialets.thrift.MMAdDownload;
import com.medialets.thrift.MMSlotZeroResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;

// Referenced classes of package com.medialets.advertising:
//            a, ae, ac

final class ad extends DataSource.AdvertListHandler
{

    ad(ac ac)
    {
        this(ac, (byte)0);
    }

    private ad(ac ac, byte byte0)
    {
        super(ac);
    }

    protected final void createAdvertisements(HttpEntity httpentity, List list)
        throws HttpResponseException, IOException
    {
        TDeserializer tdeserializer = new TDeserializer(new org.apache.thrift.protocol.TBinaryProtocol.Factory());
        MMSlotZeroResponse mmslotzeroresponse = new MMSlotZeroResponse();
        try
        {
            tdeserializer.deserialize(mmslotzeroresponse, EntityUtils.toByteArray(httpentity));
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            throw new IOException(httpentity.getMessage());
        }
        a.a((new StringBuilder()).append("Advertisements in response: ").append(mmslotzeroresponse.getAdDownloadsSize()).toString());
        for (httpentity = mmslotzeroresponse.getAdDownloads().iterator(); httpentity.hasNext(); list.add(ae.a((MMAdDownload)httpentity.next()))) { }
    }
}
