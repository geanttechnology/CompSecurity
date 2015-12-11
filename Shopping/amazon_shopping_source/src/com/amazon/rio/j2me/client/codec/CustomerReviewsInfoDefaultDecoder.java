// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CustomerReviewsInfo;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, CustomerReviewDefaultDecoder, KeyValuePairDefaultDecoder, 
//            StreamedResponseListener

public class CustomerReviewsInfoDefaultDecoder
    implements Decoder
{

    public CustomerReviewsInfoDefaultDecoder()
    {
    }

    public CustomerReviewsInfo decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new CustomerReviewsInfo();
        streamedresponselistener.setOneStarCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        streamedresponselistener.setTwoStarCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        streamedresponselistener.setThreeStarCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        streamedresponselistener.setFourStarCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        streamedresponselistener.setFiveStarCount(((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null)).intValue());
        streamedresponselistener.setReviews((List)DefaultDecoder.getArrayInstance(new CustomerReviewDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setSortTypes((List)DefaultDecoder.getArrayInstance(new KeyValuePairDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSelectedStarFilter((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        streamedresponselistener.setSelectedSortType((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
