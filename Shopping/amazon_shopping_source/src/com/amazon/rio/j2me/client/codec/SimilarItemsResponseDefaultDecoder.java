// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.SimilarItemsResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener, SearchResultDefaultDecoder, 
//            KeyValuePairDefaultDecoder

public class SimilarItemsResponseDefaultDecoder
    implements Decoder
{
    final class _cls1ArrayResponseListener
        implements StreamedResponseListener
    {

        private final int path[];
        final SimilarItemsResponseDefaultDecoder this$0;
        final StreamedResponseListener val$callback;
        final int val$fieldPath[];

        public void aboutToReceiveArrayOfSize(int i, int ai[])
        {
            callback.aboutToReceiveArrayOfSize(i, fieldPath);
        }

        public void receivedObject(Object obj, int ai[])
        {
            if (ai.length > 0)
            {
                path[1] = ai[0];
                callback.receivedObject(obj, path);
            }
        }

        _cls1ArrayResponseListener()
        {
            this$0 = SimilarItemsResponseDefaultDecoder.this;
            fieldPath = ai;
            callback = streamedresponselistener;
            super();
            path = (new int[] {
                fieldPath[0], -1
            });
        }
    }


    public SimilarItemsResponseDefaultDecoder()
    {
    }

    public SimilarItemsResponse decode(DataInputStream datainputstream, final StreamedResponseListener callback)
        throws IOException
    {
        SimilarItemsResponse similaritemsresponse;
        Object obj;
        final int fieldPath[];
        Decoder decoder;
        if (callback == null)
        {
            similaritemsresponse = new SimilarItemsResponse();
        } else
        {
            similaritemsresponse = null;
        }
        fieldPath = new int[1];
        obj = (Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null);
        if (similaritemsresponse != null)
        {
            similaritemsresponse.setTotalCount(((Integer) (obj)).intValue());
        }
        if (callback != null)
        {
            callback.receivedObject(obj, fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        decoder = DefaultDecoder.getArrayInstance(new SearchResultDefaultDecoder());
        if (callback == null)
        {
            obj = null;
        } else
        {
            obj = new _cls1ArrayResponseListener();
        }
        obj = (List)decoder.decode(datainputstream, ((StreamedResponseListener) (obj)));
        if (similaritemsresponse != null)
        {
            similaritemsresponse.setItems(((List) (obj)));
        }
        if (callback != null)
        {
            callback.receivedObject(obj, fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        datainputstream = (new KeyValuePairDefaultDecoder()).decode(datainputstream, null);
        if (similaritemsresponse != null)
        {
            similaritemsresponse.setDatasetInfo(datainputstream);
        }
        if (callback != null)
        {
            callback.receivedObject(datainputstream, fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        if (callback != null)
        {
            callback.receivedObject(similaritemsresponse, new int[0]);
        }
        return similaritemsresponse;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
