// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class FindPopularSearchesResponse extends EbayResponse
{
    private class PopularResultSearchElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindPopularSearchesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("RelatedSearches".equals(s1))
            {
                return new SearchesElement(relatedSearches);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PopularResultSearchElement()
        {
            this$0 = FindPopularSearchesResponse.this;
            super();
        }

    }

    private class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindPopularSearchesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(FindPopularSearchesResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(FindPopularSearchesResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(FindPopularSearchesResponse.this);
                }
                if ("PopularSearchResult".equals(s1))
                {
                    return new PopularResultSearchElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = FindPopularSearchesResponse.this;
            super();
        }

    }

    private class SearchesElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final ArrayList searches;
        final FindPopularSearchesResponse this$0;

        public void text(String s)
            throws SAXException
        {
            if (!TextUtils.isEmpty(s))
            {
                s = s.split(";");
                int j = s.length;
                for (int i = 0; i < j; i++)
                {
                    Object obj = s[i];
                    searches.add(obj);
                }

            }
        }

        public SearchesElement(ArrayList arraylist)
        {
            this$0 = FindPopularSearchesResponse.this;
            super();
            searches = arraylist;
        }
    }


    private final ArrayList relatedSearches = new ArrayList();

    public FindPopularSearchesResponse()
    {
    }

    public ArrayList getRelatedSearches()
    {
        return relatedSearches;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

}
