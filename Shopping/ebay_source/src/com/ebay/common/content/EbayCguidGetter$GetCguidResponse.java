// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.content:
//            EbayCguidGetter

public static final class isLinked extends EbayResponse
{
    private final class DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayCguidGetter.GetCguidResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(EbayCguidGetter.GetCguidResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailElement()
        {
            this$0 = EbayCguidGetter.GetCguidResponse.this;
            super();
        }

        DetailElement(EbayCguidGetter._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayCguidGetter.GetCguidResponse this$0;

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
            this$0 = EbayCguidGetter.GetCguidResponse.this;
            super();
        }

        FaultElement(EbayCguidGetter._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayCguidGetter.GetCguidResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobileor/v1/commonservices".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(EbayCguidGetter.GetCguidResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(EbayCguidGetter.GetCguidResponse.this);
                }
                if ("Fault".equals(s1))
                {
                    return new FaultElement(null);
                }
                if ("cguid".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            cguid = s;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("expire".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            expire = s;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("linked".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            isLinked = Boolean.valueOf(flag);
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = EbayCguidGetter.GetCguidResponse.this;
            super();
        }

        RootElement(EbayCguidGetter._cls1 _pcls1)
        {
            this();
        }
    }


    private String cguid;
    private String expire;
    private Boolean isLinked;

    public final String getCguid()
    {
        return cguid;
    }

    public final String getExpire()
    {
        return expire;
    }

    public final Boolean isLinked()
    {
        return isLinked;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ion
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }



/*
    static String access$002(xception xception, String s)
    {
        xception.cguid = s;
        return s;
    }

*/



/*
    static String access$102(cguid cguid1, String s)
    {
        cguid1.expire = s;
        return s;
    }

*/


/*
    static Boolean access$402(expire expire1, Boolean boolean1)
    {
        expire1.isLinked = boolean1;
        return boolean1;
    }

*/

    public RootElement()
    {
        cguid = null;
        expire = null;
        isLinked = Boolean.valueOf(false);
    }
}
