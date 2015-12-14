// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.mopub.mobileads:
//            VastAdXmlManager, VastTracker

class VastXmlManager
{

    private static final String AD = "Ad";
    private static final String CUSTOM_CLOSE_ICON = "MoPubCloseIcon";
    private static final String CUSTOM_CTA_TEXT = "MoPubCtaText";
    private static final String CUSTOM_FORCE_ORIENTATION = "MoPubForceOrientation";
    private static final String CUSTOM_SKIP_TEXT = "MoPubSkipText";
    private static final String ERROR = "Error";
    private static final int MAX_CTA_TEXT_LENGTH = 15;
    private static final int MAX_SKIP_TEXT_LENGTH = 8;
    private static final String MP_IMPRESSION_TRACKER = "MP_TRACKING_URL";
    private static final String ROOT_TAG = "MPMoVideoXMLDocRoot";
    private static final String ROOT_TAG_CLOSE = "</MPMoVideoXMLDocRoot>";
    private static final String ROOT_TAG_OPEN = "<MPMoVideoXMLDocRoot>";
    private Document mVastDoc;

    VastXmlManager()
    {
    }

    List getAdXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        if (mVastDoc != null)
        {
            NodeList nodelist = mVastDoc.getElementsByTagName("Ad");
            int i = 0;
            while (i < nodelist.getLength()) 
            {
                arraylist.add(new VastAdXmlManager(nodelist.item(i)));
                i++;
            }
        }
        return arraylist;
    }

    String getCustomCloseIconUrl()
    {
        return XmlUtils.getFirstMatchingStringData(mVastDoc, "MoPubCloseIcon");
    }

    String getCustomCtaText()
    {
        String s = XmlUtils.getFirstMatchingStringData(mVastDoc, "MoPubCtaText");
        if (s != null && s.length() <= 15)
        {
            return s;
        } else
        {
            return null;
        }
    }

    com.mopub.common.util.DeviceUtils.ForceOrientation getCustomForceOrientation()
    {
        return com.mopub.common.util.DeviceUtils.ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(mVastDoc, "MoPubForceOrientation"));
    }

    String getCustomSkipText()
    {
        String s = XmlUtils.getFirstMatchingStringData(mVastDoc, "MoPubSkipText");
        if (s != null && s.length() <= 8)
        {
            return s;
        } else
        {
            return null;
        }
    }

    VastTracker getErrorTracker()
    {
        String s;
        if (mVastDoc != null)
        {
            if (!TextUtils.isEmpty(s = XmlUtils.getFirstMatchingStringData(mVastDoc, "Error")))
            {
                return new VastTracker(s);
            }
        }
        return null;
    }

    List getMoPubImpressionTrackers()
    {
        Object obj = XmlUtils.getStringDataAsList(mVastDoc, "MP_TRACKING_URL");
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new VastTracker((String)((Iterator) (obj)).next()))) { }
        return arraylist;
    }

    void parseVastXml(String s)
        throws ParserConfigurationException, IOException, SAXException
    {
        Preconditions.checkNotNull(s, "xmlString cannot be null");
        s = s.replaceFirst("<\\?.*\\?>", "");
        s = (new StringBuilder()).append("<MPMoVideoXMLDocRoot>").append(s).append("</MPMoVideoXMLDocRoot>").toString();
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        documentbuilderfactory.setCoalescing(true);
        mVastDoc = documentbuilderfactory.newDocumentBuilder().parse(new InputSource(new StringReader(s)));
    }
}
