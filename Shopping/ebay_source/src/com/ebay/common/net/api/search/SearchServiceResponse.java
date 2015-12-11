// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.SellerOffer;
import com.ebay.common.net.api.search.idealmodel.RewriteEndSrpListItem;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.common.net.api.search:
//            ISearchTracking, SearchConfiguration

public abstract class SearchServiceResponse extends EbayCosResponse
    implements ISearchTracking, IResponseHeaderHandler
{
    public static class SellerOfferDetail
    {

        public String legalTextMessage;
        public String subTitle;
        public String textMessage;

        public SellerOfferDetail()
        {
            subTitle = null;
            textMessage = null;
            legalTextMessage = null;
        }
    }


    protected static final Pattern LABELED_ANSWER_PATH_PATTERN = Pattern.compile("answers\\.labeledItem\\.answer\\[(\\d+)\\]");
    protected static final Pattern REGULAR_ITEM_PATH_PATTERN = Pattern.compile("items\\.items\\.item\\[(\\d+)\\]");
    protected static final Pattern RERWITE_ITEM_PATH_PATTERN = Pattern.compile("items\\.rewrites\\.rewrite\\[(\\d+)\\]\\.result\\[(\\d+)\\]\\.item\\[(\\d+)\\]");
    protected static final Pattern REWRITE_START_PATH_PATTERN = Pattern.compile("items\\.rewrites\\.rewrite\\[(\\d+)\\]\\.result\\[(\\d+)\\]");
    protected final SearchConfiguration config;
    protected RewriteEndSrpListItem rewriteEndSrpListItem;

    protected SearchServiceResponse(SearchConfiguration searchconfiguration)
    {
        super(false);
        config = searchconfiguration;
    }

    protected void addRewriteEndIfNeeded(List list)
    {
        if (rewriteEndSrpListItem != null)
        {
            list.add(rewriteEndSrpListItem);
            rewriteEndSrpListItem = null;
        }
    }

    public abstract void fill(ArrayList arraylist);

    public abstract ArrayList getExpansions();

    public abstract List getRewrites();

    public abstract SellerOffer getSellerOffer();

    public abstract int getTotalCountWithDupes();

}
