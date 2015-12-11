// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.lement
{
    private final class AttributeId extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        String id;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("AttributeId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AttributeId this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        id = s;
                    }

            
            {
                this$2 = AttributeId.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AttributeId()
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
        }

        AttributeId(PdsGetAttributesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class AttributesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        AttributeId attributeId;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Id".equals(s1))
            {
                return attributeId;
            }
            if ("Value".equals(s1))
            {
                return new Value(attributeId.id);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AttributesElement()
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
            attributeId = new AttributeId(null);
        }

        AttributesElement(PdsGetAttributesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ComplexListValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new ValueNested(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        ComplexListValue(String s)
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class CustomValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("rawValue".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CustomValue this$2;

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
                this$2 = CustomValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        CustomValue(String s)
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("complexListValue".equals(s1))
            {
                return new ComplexListValue(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        Value(String s)
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }

    private final class ValueNested extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String attributeId;
        final PdsGetAttributesResponse.GetAttributesResponseElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("customValue".equals(s1))
            {
                return new CustomValue(attributeId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        ValueNested(String s)
        {
            this$1 = PdsGetAttributesResponse.GetAttributesResponseElement.this;
            super();
            attributeId = s;
        }
    }


    final PdsGetAttributesResponse this$0;

    public com.ebay.nautilus.kernel.util.lement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equalsIgnoreCase(s1))
        {
            return new AckElement(PdsGetAttributesResponse.this);
        }
        if ("attributes".equals(s1))
        {
            return new AttributesElement(null);
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
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ValueNested.attributeId()
    {
        this$0 = PdsGetAttributesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
