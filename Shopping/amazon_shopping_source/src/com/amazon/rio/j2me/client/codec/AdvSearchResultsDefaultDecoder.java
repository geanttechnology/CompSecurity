// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.AdvSearchResults;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, SearchResultDefaultDecoder, MinimalItemDefaultDecoder, 
//            RefinementBinDefaultDecoder, BreadcrumbDefaultDecoder, SortOptionDefaultDecoder, HyperTextDefaultDecoder, 
//            StreamedResponseListener

public class AdvSearchResultsDefaultDecoder
    implements Decoder
{

    public AdvSearchResultsDefaultDecoder()
    {
    }

    public AdvSearchResults decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new AdvSearchResults();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setTotalCount((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAvailableCount((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setResults((List)DefaultDecoder.getArrayInstance(new SearchResultDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setStubs((List)DefaultDecoder.getArrayInstance(new MinimalItemDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setQuery((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setRefinements((List)DefaultDecoder.getArrayInstance(new RefinementBinDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setFilters((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBreadcrumbs((List)DefaultDecoder.getArrayInstance(new BreadcrumbDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setSortOptions((List)DefaultDecoder.getArrayInstance(new SortOptionDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setResultsDesc((List)DefaultDecoder.getArrayInstance(new HyperTextDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
