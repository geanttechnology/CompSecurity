// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            SaveFavoriteSearch

private static class RootElement extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("saveFavoriteSearchResponse".equals(s1))
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
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
        }

        BodyElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(SaveFavoriteSearch.SaveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailElement()
        {
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
        }

        DetailElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

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
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
        }

        FaultElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String id;
        boolean idParsed;
        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchId".equals(s1))
            {
                idParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        id = s;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if (idParsed)
            {
                searchId = id;
                idParsed = false;
            }
            return super.get(s, s1, s2, attributes);
        }

        private MainElement()
        {
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
            idParsed = false;
        }

        MainElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(SaveFavoriteSearch.SaveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(SaveFavoriteSearch.SaveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(SaveFavoriteSearch.SaveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
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
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
        }

        ResponseElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearch.SaveFavoriteSearchResponse this$0;

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
            this$0 = SaveFavoriteSearch.SaveFavoriteSearchResponse.this;
            super();
        }

        RootElement(SaveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }


    private String searchId;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.BodyElement
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }



/*
    static String access$002(RootElement rootelement, String s)
    {
        rootelement.searchId = s;
        return s;
    }

*/

    protected RootElement()
    {
    }
}
