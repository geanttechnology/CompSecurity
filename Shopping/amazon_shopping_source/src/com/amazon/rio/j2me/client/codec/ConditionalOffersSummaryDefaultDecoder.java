// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ConditionalOffersSummary;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, OffersSummaryDefaultDecoder, StreamedResponseListener

public class ConditionalOffersSummaryDefaultDecoder
    implements Decoder
{

    public ConditionalOffersSummaryDefaultDecoder()
    {
    }

    public ConditionalOffersSummary decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new ConditionalOffersSummary();
        streamedresponselistener.setCondition((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setConditionType((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setSummary((new OffersSummaryDefaultDecoder()).decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
