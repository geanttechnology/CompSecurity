// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.model.search.SavedSearch;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RetrieveFavoriteSearch

private final class this._cls0 extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("retrieveFavoriteSearchResponse".equals(s1))
            {
                return new ResponseElement(null);
            }
            if ("Fault".equals(s1))
            {
                return new FaultElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
        }

        BodyElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
        }

        DetailElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new DetailElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FaultElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
        }

        FaultElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private boolean idParsed;
        private boolean nameParsed;
        private final SavedSearch savedSearch;
        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchId".equals(s1))
            {
                idParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        savedSearch.id = s;
                    }

            
            {
                this$2 = MainElement.this;
                super();
            }
                };
            }
            if ("searchName".equals(s1))
            {
                nameParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        savedSearch.name = s;
                    }

            
            {
                this$2 = MainElement.this;
                super();
            }
                };
            }
            if (idParsed && nameParsed)
            {
                searchMap.put((new StringBuilder()).append(savedSearch.name.toLowerCase(Locale.getDefault())).append(savedSearch.id).toString(), savedSearch);
                nameParsed = false;
                idParsed = false;
            }
            return super.get(s, s1, s2, attributes);
        }


        private MainElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
            savedSearch = new SavedSearch(RetrieveFavoriteSearch.access$600(this$0), 25);
            idParsed = false;
            nameParsed = false;
        }

        MainElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("favoriteSearchRecordResponse".equals(s1))
            {
                return new MainElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
        }

        ResponseElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$1 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.this;
            super();
        }

        RootElement(RetrieveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }


    private final TreeMap searchMap = new TreeMap();
    final RetrieveFavoriteSearch this$0;

    List getSearchList()
    {
        return new ArrayList(searchMap.values());
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.searchMap
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }


    protected RootElement()
    {
        this$0 = RetrieveFavoriteSearch.this;
        super();
    }
}
