// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.content:
//            EbayCguid, EbayCguidPersister

public class EbayCguidGetter
{
    private static final class GetCguidRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String REQUEST_NAME = "getUserCGUIDRequest";
        private static final String SERVICE_NAME = "CommonMobileAppService";
        private static final String SERVICE_OPERATION = "getUserCGUID";
        private static final String SERVICE_VERSION = "1.1.5";
        private static final URL ServiceUrl;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
            xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
            xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getUserCGUIDRequest");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getUserCGUIDRequest");
            xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
            xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ServiceUrl;
        }

        public GetCguidResponse getResponse()
        {
            return new GetCguidResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
        }

        static 
        {
            Object obj1 = null;
            Object obj;
            if (NautilusKernel.isQaMode())
            {
                obj = "https://api4.qa.ebay.com/services/mobileor/v1/CommonMobileAppService";
            } else
            {
                obj = "https://svcs.ebay.com/services/mobileor/v1/CommonMobileAppService";
            }
            try
            {
                obj = new URL(((String) (obj)));
            }
            catch (MalformedURLException malformedurlexception)
            {
                malformedurlexception.printStackTrace();
                malformedurlexception = obj1;
            }
            ServiceUrl = ((URL) (obj));
            return;
        }

        public GetCguidRequest(EbaySite ebaysite, String s)
        {
            super("CommonMobileAppService", true, "getUserCGUID");
            soaServiceVersion = "1.1.5";
            soaAppIdHeaderName = "x-ebay-soa-security-appname";
            soaGlobalId = ebaysite.idString;
            dataFormat = "XML";
            responseDataFormat = "XML";
            if (s != null)
            {
                iafToken = s;
            }
        }
    }

    public static final class GetCguidResponse extends EbayResponse
    {

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
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }



/*
        static String access$002(GetCguidResponse getcguidresponse, String s)
        {
            getcguidresponse.cguid = s;
            return s;
        }

*/



/*
        static String access$102(GetCguidResponse getcguidresponse, String s)
        {
            getcguidresponse.expire = s;
            return s;
        }

*/


/*
        static Boolean access$402(GetCguidResponse getcguidresponse, Boolean boolean1)
        {
            getcguidresponse.isLinked = boolean1;
            return boolean1;
        }

*/

        public GetCguidResponse()
        {
            cguid = null;
            expire = null;
            isLinked = Boolean.valueOf(false);
        }
    }

    private final class GetCguidResponse.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCguidResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetCguidResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetCguidResponse.DetailElement()
        {
            this$0 = GetCguidResponse.this;
            super();
        }

    }

    private final class GetCguidResponse.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCguidResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new GetCguidResponse.DetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetCguidResponse.FaultElement()
        {
            this$0 = GetCguidResponse.this;
            super();
        }

    }

    private final class GetCguidResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCguidResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobileor/v1/commonservices".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetCguidResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetCguidResponse.this);
                }
                if ("Fault".equals(s1))
                {
                    return new GetCguidResponse.FaultElement();
                }
                if ("cguid".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final GetCguidResponse.RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            cguid = s;
                        }

            
            {
                this$1 = GetCguidResponse.RootElement.this;
                super();
            }
                    };
                }
                if ("expire".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final GetCguidResponse.RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            expire = s;
                        }

            
            {
                this$1 = GetCguidResponse.RootElement.this;
                super();
            }
                    };
                }
                if ("linked".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final GetCguidResponse.RootElement this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            isLinked = Boolean.valueOf(flag);
                        }

            
            {
                this$1 = GetCguidResponse.RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private GetCguidResponse.RootElement()
        {
            this$0 = GetCguidResponse.this;
            super();
        }

    }


    private static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static final Object lock = new Object();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private final String iafToken;
    private final EbayCguidPersister persister;
    private final EbaySite site;

    private EbayCguidGetter(EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s)
    {
        persister = ebaycguidpersister;
        site = ebaysite;
        iafToken = s;
    }

    private EbayCguid fetch(EbayContext ebaycontext)
    {
        boolean flag;
        flag = false;
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[0]);
        }
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (!TextUtils.isEmpty(iafToken))
        {
            flag = true;
        }
        EbayCguid ebaycguid1 = getCguidFromLocalStore(flag);
        EbayCguid ebaycguid;
        if (ebaycguid1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ebaycguid = ebaycguid1;
        if (!ebaycguid1.isExpired())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ebaycguid = retrieveCguidFromNetwork(ebaycontext);
        setCguidIntoLocalStore(flag, ebaycguid);
        obj;
        JVM INSTR monitorexit ;
        return ebaycguid;
        ebaycontext;
        obj;
        JVM INSTR monitorexit ;
        throw ebaycontext;
    }

    public static String get(EbayContext ebaycontext, EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s)
    {
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[] {
                ebaycguidpersister, ebaysite, s
            });
        }
        String s1 = "";
        ebaycguidpersister = (new EbayCguidGetter(ebaycguidpersister, ebaysite, s)).fetch(ebaycontext);
        ebaycontext = s1;
        if (ebaycguidpersister != null)
        {
            ebaycontext = ebaycguidpersister.toString();
        }
        return ebaycontext;
    }

    private EbayCguid getCguidFromLocalStore(boolean flag)
    {
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[0]);
        }
        EbayCguid ebaycguid = null;
        if (persister != null)
        {
            ebaycguid = persister.getCguid(flag);
        }
        if (verboseLogger.isLoggable)
        {
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = verboseLogger;
            String s;
            if (ebaycguid == null)
            {
                s = "null";
            } else
            {
                s = ebaycguid.toString();
            }
            FwLog.println(loginfo, String.format("Cguid from store: %s", new Object[] {
                s
            }));
        }
        return ebaycguid;
    }

    private EbayCguid retrieveCguidFromNetwork(EbayContext ebaycontext)
    {
        String s;
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[0]);
        }
        s = null;
        GetCguidResponse getcguidresponse = (GetCguidResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, new GetCguidRequest(site, iafToken));
        ebaycontext = s;
        if (getcguidresponse != null)
        {
            try
            {
                ebaycontext = new EbayCguid(getcguidresponse.cguid, getcguidresponse.expire);
            }
            // Misplaced declaration of an exception variable
            catch (EbayContext ebaycontext)
            {
                ebaycontext.printStackTrace();
                ebaycontext = s;
            }
            // Misplaced declaration of an exception variable
            catch (EbayContext ebaycontext)
            {
                ebaycontext.printStackTrace();
                ebaycontext = s;
            }
            // Misplaced declaration of an exception variable
            catch (EbayContext ebaycontext)
            {
                ebaycontext.printStackTrace();
                ebaycontext = s;
            }
            // Misplaced declaration of an exception variable
            catch (EbayContext ebaycontext)
            {
                ebaycontext.printStackTrace();
                ebaycontext = null;
            }
        }
        if (verboseLogger.isLoggable)
        {
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = verboseLogger;
            if (ebaycontext == null)
            {
                s = "null";
            } else
            {
                s = ebaycontext.toString();
            }
            FwLog.println(loginfo, String.format("Cguid from network: %s", new Object[] {
                s
            }));
        }
        return ebaycontext;
    }

    private void setCguidIntoLocalStore(boolean flag, EbayCguid ebaycguid)
    {
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[0]);
        }
        if (persister != null)
        {
            if (verboseLogger.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = verboseLogger;
                String s;
                if (ebaycguid == null)
                {
                    s = "null";
                } else
                {
                    s = ebaycguid.toString();
                }
                FwLog.println(loginfo, String.format("Storing cguid: %s", new Object[] {
                    s
                }));
            }
            persister.setCguid(flag, ebaycguid);
        }
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayCguid", 3, "Log eBay CGUID events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended eBay CGUID events");
    }
}
