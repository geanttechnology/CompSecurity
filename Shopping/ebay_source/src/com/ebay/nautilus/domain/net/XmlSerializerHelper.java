// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.KXmlSerializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

public final class XmlSerializerHelper
{
    public static interface IXmlRequestBuilder
    {

        public abstract void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException;
    }

    public static interface Soap
    {

        public static final String BODY = "Body";
        public static final String ENVELOPE = "Envelope";
        public static final String SOAP_11 = "SOAP11";
        public static final String SOAP_11_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
        public static final String SOAP_12 = "SOAP12";
        public static final String SOAP_12_DOMAIN = "http://www.w3.org/2003/05/soap-envelope";
    }


    private static final HashMap errorCountries;
    private static final HashMap errorLanguages;
    private static final HashSet errorLocales;

    private XmlSerializerHelper()
    {
    }

    public static byte[] buildXmlRequest(IXmlRequestBuilder ixmlrequestbuilder)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        ByteArrayOutputStream bytearrayoutputstream;
        XmlSerializer xmlserializer;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (IXmlRequestBuilder ixmlrequestbuilder)
        {
            throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(ixmlrequestbuilder);
        }
        xmlserializer = createSerializer();
        xmlserializer.setOutput(bytearrayoutputstream, "UTF8");
        xmlserializer.startDocument("utf-8", null);
        ixmlrequestbuilder.buildXmlRequest(xmlserializer);
        xmlserializer.endDocument();
        ixmlrequestbuilder = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        return ixmlrequestbuilder;
        ixmlrequestbuilder;
        bytearrayoutputstream.close();
        throw ixmlrequestbuilder;
    }

    public static XmlSerializer createSerializer()
    {
        return new KXmlSerializer();
    }

    public static final String getDefaultErrorLocale()
    {
        Object obj = Locale.getDefault();
        String s2 = ((Locale) (obj)).getLanguage();
        String s3 = ((Locale) (obj)).getCountry();
        if (s2 == null || s3 == null || s2.length() != 2 || s3.length() != 2)
        {
            obj = null;
        } else
        {
            String s = (new StringBuilder()).append(s2).append('_').append(s3).toString();
            obj = s;
            if (!errorLocales.contains(s))
            {
                String s1 = (String)errorLanguages.get(s2);
                obj = s1;
                if (s1 == null)
                {
                    return (String)errorCountries.get(s3);
                }
            }
        }
        return ((String) (obj));
    }

    public static final void writeErrorLocale(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        String s1 = getDefaultErrorLocale();
        if (s1 != null)
        {
            writeSimple(xmlserializer, s, "ErrorLanguage", s1);
        }
    }

    public static final void writeItemFilter(XmlSerializer xmlserializer, String s, String s1, String s2, String s3, String s4)
        throws IOException
    {
        xmlserializer.startTag(s, "itemFilter");
        writeSimple(xmlserializer, s, "name", s1);
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            writeSimple(xmlserializer, s, "paramName", s2);
            writeSimple(xmlserializer, s, "paramValue", s3);
        }
        writeSimple(xmlserializer, s, "value", s4);
        xmlserializer.endTag(s, "itemFilter");
    }

    public static final void writeItemFilter(XmlSerializer xmlserializer, String s, String s1, String s2, String s3, String as[])
        throws IOException
    {
        xmlserializer.startTag(s, "itemFilter");
        writeSimple(xmlserializer, s, "name", s1);
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            writeSimple(xmlserializer, s, "paramName", s2);
            writeSimple(xmlserializer, s, "paramValue", s3);
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            writeSimple(xmlserializer, s, "value", as[i]);
        }

        xmlserializer.endTag(s, "itemFilter");
    }

    public static final void writePagination(XmlSerializer xmlserializer, String s, int i, int j)
        throws IOException
    {
        xmlserializer.startTag(s, "Pagination");
        writeSimple(xmlserializer, s, "EntriesPerPage", String.valueOf(j));
        writeSimple(xmlserializer, s, "PageNumber", String.valueOf(i));
        xmlserializer.endTag(s, "Pagination");
    }

    public static final void writePaginationInput(XmlSerializer xmlserializer, String s, int i, int j)
        throws IOException
    {
        xmlserializer.startTag(s, "paginationInput");
        writeSimple(xmlserializer, s, "entriesPerPage", String.valueOf(j));
        writeSimple(xmlserializer, s, "pageNumber", String.valueOf(i));
        xmlserializer.endTag(s, "paginationInput");
    }

    public static final void writeSimple(XmlSerializer xmlserializer, String s, String s1, String s2)
        throws IOException
    {
        xmlserializer.startTag(s, s1);
        if (s2 != null)
        {
            xmlserializer.text(s2);
        }
        xmlserializer.endTag(s, s1);
    }

    public static final void writeTagWithAttribute(XmlSerializer xmlserializer, String s, String s1, String s2, String s3, String s4)
        throws IOException
    {
        xmlserializer.startTag(s, s1);
        xmlserializer.attribute(s, s3, s4);
        xmlserializer.text(s2);
        xmlserializer.endTag(s, s1);
    }

    static 
    {
        Object obj = new HashSet();
        ((HashSet) (obj)).add("de_AT");
        ((HashSet) (obj)).add("de_CH");
        ((HashSet) (obj)).add("de_DE");
        ((HashSet) (obj)).add("en_AU");
        ((HashSet) (obj)).add("en_CA");
        ((HashSet) (obj)).add("en_GB");
        ((HashSet) (obj)).add("en_SG");
        ((HashSet) (obj)).add("en_US");
        ((HashSet) (obj)).add("es_ES");
        ((HashSet) (obj)).add("fr_BE");
        ((HashSet) (obj)).add("fr_CA");
        ((HashSet) (obj)).add("fr_FR");
        ((HashSet) (obj)).add("it_IT");
        ((HashSet) (obj)).add("nl_BE");
        ((HashSet) (obj)).add("nl_NL");
        ((HashSet) (obj)).add("zh_CN");
        ((HashSet) (obj)).add("en_IN");
        ((HashSet) (obj)).add("en_IE");
        ((HashSet) (obj)).add("zh_HK");
        errorLocales = ((HashSet) (obj));
        obj = new HashMap();
        ((HashMap) (obj)).put("AT", "de_AT");
        ((HashMap) (obj)).put("CH", "de_CH");
        ((HashMap) (obj)).put("DE", "de_DE");
        ((HashMap) (obj)).put("AU", "en_AU");
        ((HashMap) (obj)).put("CA", "en_CA");
        ((HashMap) (obj)).put("GB", "en_GB");
        ((HashMap) (obj)).put("SG", "en_SG");
        ((HashMap) (obj)).put("US", "en_US");
        ((HashMap) (obj)).put("ES", "es_ES");
        ((HashMap) (obj)).put("BE", "fr_BE");
        ((HashMap) (obj)).put("FR", "fr_FR");
        ((HashMap) (obj)).put("IT", "it_IT");
        ((HashMap) (obj)).put("NL", "nl_NL");
        ((HashMap) (obj)).put("CN", "zh_CN");
        ((HashMap) (obj)).put("IN", "en_IN");
        ((HashMap) (obj)).put("IE", "en_IE");
        ((HashMap) (obj)).put("HK", "zh_HK");
        errorCountries = ((HashMap) (obj));
        obj = new HashMap();
        ((HashMap) (obj)).put("de", "de_DE");
        ((HashMap) (obj)).put("en", "en_US");
        ((HashMap) (obj)).put("es", "es_ES");
        ((HashMap) (obj)).put("fr", "fr_FR");
        ((HashMap) (obj)).put("it", "it_IT");
        ((HashMap) (obj)).put("nl", "nl_NL");
        ((HashMap) (obj)).put("zh", "zh_CN");
        errorLanguages = ((HashMap) (obj));
    }
}
