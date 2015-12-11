// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class PdsGetAttributesResponse extends EbayResponse
{
    private final class GetAttributesResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PdsGetAttributesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equalsIgnoreCase(s1))
            {
                return new AckElement(PdsGetAttributesResponse.this);
            }
            if ("attributes".equals(s1))
            {
                return new AttributesElement();
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(PdsGetAttributesResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(PdsGetAttributesResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetAttributesResponseElement()
        {
            this$0 = PdsGetAttributesResponse.this;
            super();
        }

    }

    private final class GetAttributesResponseElement.AttributeId extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        String id;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("AttributeId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAttributesResponseElement.AttributeId this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        id = s;
                    }

            
            {
                this$2 = GetAttributesResponseElement.AttributeId.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetAttributesResponseElement.AttributeId()
        {
            this$1 = GetAttributesResponseElement.this;
            super();
        }

    }

    private final class GetAttributesResponseElement.AttributesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        GetAttributesResponseElement.AttributeId attributeId;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Id".equals(s1))
            {
                return attributeId;
            }
            if ("Value".equals(s1))
            {
                return new GetAttributesResponseElement.Value(attributeId.id);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetAttributesResponseElement.AttributesElement()
        {
            this$1 = GetAttributesResponseElement.this;
            super();
            attributeId = new GetAttributesResponseElement.AttributeId();
        }

    }

    private final class GetAttributesResponseElement.ComplexListValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new GetAttributesResponseElement.ValueNested(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        GetAttributesResponseElement.ComplexListValue(String s)
        {
            this$1 = GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class GetAttributesResponseElement.CustomValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("rawValue".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAttributesResponseElement.CustomValue this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        if (TextUtils.isEmpty(s))
                        {
                            break MISSING_BLOCK_LABEL_156;
                        }
                        s = s.split("\\?");
                        if (s.length != 3)
                        {
                            break MISSING_BLOCK_LABEL_139;
                        }
                        if ("10297".equals(attributeId))
                        {
                            recentlyViewedItems.add(new PdsViewItemAttribute(s[2]));
                            return;
                        }
                        boolean flag = "10203".equals(attributeId);
                        if (!flag)
                        {
                            break MISSING_BLOCK_LABEL_156;
                        }
                        s = PdsSearchItemAttribute.parseSearchItem(s[2]);
                        if (s == null)
                        {
                            break MISSING_BLOCK_LABEL_156;
                        }
                        recentSearches.add(s);
                        return;
                        s;
                        try
                        {
                            s.printStackTrace();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s) { }
                        if (PdsGetAttributesResponse.logTag.isLoggable)
                        {
                            PdsGetAttributesResponse.logTag.logAsError("Unknown format for attribute value");
                            return;
                        }
                        break MISSING_BLOCK_LABEL_156;
                        if (PdsGetAttributesResponse.logTag.isLoggable)
                        {
                            PdsGetAttributesResponse.logTag.logAsError("Unknown format for attribute value");
                        }
                    }

            
            {
                this$2 = GetAttributesResponseElement.CustomValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        GetAttributesResponseElement.CustomValue(String s)
        {
            this$1 = GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class GetAttributesResponseElement.Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("complexListValue".equals(s1))
            {
                return new GetAttributesResponseElement.ComplexListValue(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        GetAttributesResponseElement.Value(String s)
        {
            this$1 = GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class GetAttributesResponseElement.ValueNested extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("customValue".equals(s1))
            {
                return new GetAttributesResponseElement.CustomValue(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        GetAttributesResponseElement.ValueNested(String s)
        {
            this$1 = GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }


    private static final int PDS_ATTRIBUTE_COUNT = 3;
    private static final int PDS_ATTRIBUTE_VALUE_INDEX = 2;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PdsGetAttributes", 3, "Parse attributes from response");
    public final List recentSearches = new ArrayList();
    public final List recentlyViewedItems = new ArrayList();

    public PdsGetAttributesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new GetAttributesResponseElement());
    }

}
