// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CustomerReview;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, DateDefaultDecoder, StreamedResponseListener

public class CustomerReviewDefaultDecoder
    implements Decoder
{

    public CustomerReviewDefaultDecoder()
    {
    }

    public CustomerReview decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new CustomerReview();
        streamedresponselistener.setOverallRating(((Integer)DefaultDecoder.getIntegerInstance(2L, 10L).decode(datainputstream, null)).intValue());
        streamedresponselistener.setTitle((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setAuthorName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setSubmissionDate((new DateDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setText((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setIsVine((Boolean)DefaultDecoder.getBooleanInstance().decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
