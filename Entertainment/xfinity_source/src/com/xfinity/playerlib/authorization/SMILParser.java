// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            SMILResource

public class SMILParser
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/authorization/SMILParser);

    public SMILParser()
    {
    }

    private boolean adStartsTooCloseToTotalDuration(int i, long l)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (l > 0L)
        {
            flag = flag1;
            if (l >= (long)i)
            {
                flag = flag1;
                if ((long)i > l - 30000L)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private int convertAdsTime(String s)
        throws Exception
    {
        String s1 = s;
        s = s.trim();
        s1 = s;
        if (!s.contains(":"))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s1 = s;
        String as[] = s.split(":");
        s1 = s;
        int i = Integer.parseInt(as[0]);
        s1 = s;
        try
        {
            return (Integer.parseInt(as[1]) * 60 + Integer.parseInt(as[2]) + i * 60 * 60) * 1000;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LOG.error((new StringBuilder()).append("Smil Ad time parsing error for ").append(s1).toString(), s);
        }
        break MISSING_BLOCK_LABEL_123;
        s1 = s;
        i = Integer.parseInt(s);
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        s1 = s;
        throw new RuntimeException("ad time <= 0");
        throw s;
        return i;
    }

    public SMILResource parse(String s)
        throws Exception
    {
        Object obj1;
        SMILResource smilresource;
        Object obj2;
        Object obj3;
        String as1[];
        int i;
        int j;
        long l1;
        long l2;
        try
        {
            Object obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(s.getBytes()));
            s = ((Document) (obj)).getElementsByTagName("meta").item(0).getAttributes().getNamedItem("base").getNodeValue();
            obj2 = ((Document) (obj)).getElementsByTagName("ref").item(0).getAttributes();
            obj = ((NamedNodeMap) (obj2)).getNamedItem("src").getNodeValue();
            smilresource = new SMILResource((new StringBuilder()).append(s).append(((String) (obj))).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LOG.error("Unable to parse SMIL from thePlatform.", s);
            throw s;
        }
        l2 = 0L;
        l1 = l2;
        String as[];
        Object obj4;
        int k;
        int l;
        try
        {
            if (((NamedNodeMap) (obj2)).getNamedItem("dur") != null)
            {
                l1 = Long.parseLong(((NamedNodeMap) (obj2)).getNamedItem("dur").getNodeValue().replaceAll("ms", ""));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            l1 = l2;
        }
        s = SMILResource.AdsType.NO_ADS;
        obj3 = ((NamedNodeMap) (obj2)).getNamedItem("tp:ChapterStartTimes");
        if (obj3 == null) goto _L2; else goto _L1
_L1:
        obj1 = SMILResource.AdsType.AUDITUDE_ADS;
        as1 = ((Node) (obj3)).getNodeValue().split(",");
        j = as1.length;
        i = 0;
_L3:
        s = ((String) (obj1));
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as1[i];
        smilresource.addAdsBreakStartTime(convertAdsTime(s));
_L4:
        i++;
        if (true) goto _L3; else goto _L2
        s;
        LOG.error("Ad time parsing error...ignore");
          goto _L4
_L2:
        as1 = ((NamedNodeMap) (obj2)).getNamedItem("tp:BlackoutStartTimes");
        obj2 = ((NamedNodeMap) (obj2)).getNamedItem("tp:BlackoutEndTimes");
        obj1 = s;
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        obj1 = s;
        if (as1 == null) goto _L6; else goto _L7
_L7:
        s = SMILResource.AdsType.C3_ADS;
        obj1 = as1.getNodeValue();
        as1 = ((Node) (obj2)).getNodeValue();
        as = ((String) (obj1)).split(",");
        as1 = as1.split(",");
        if (as.length < as1.length) goto _L9; else goto _L8
_L8:
        i = as1.length;
_L13:
        j = 0;
_L10:
        obj1 = s;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        k = convertAdsTime(as[j]);
        l = convertAdsTime(as1[j]);
        if (l - k <= 0)
        {
            break MISSING_BLOCK_LABEL_493;
        }
        if (!adStartsTooCloseToTotalDuration(k, l1))
        {
            obj1 = new ArrayList();
            obj4 = new VideoAd();
            ((VideoAd) (obj4)).setStartTime(k);
            ((VideoAd) (obj4)).setDuration(l - k);
            ((List) (obj1)).add(obj4);
            obj4 = new VideoAdBreak();
            ((VideoAdBreak) (obj4)).setVideoAdsList(((List) (obj1)));
            ((VideoAdBreak) (obj4)).setStartTime(k);
            ((VideoAdBreak) (obj4)).setDuration(k - l);
            smilresource.addC3Block(((VideoAdBreak) (obj4)));
        }
_L11:
        j++;
        if (true) goto _L10; else goto _L6
_L9:
        i = as.length;
        continue; /* Loop/switch isn't completed */
        obj1;
        LOG.error("C3 Ad time parsing error...ignore");
          goto _L11
_L6:
        smilresource.setAdsType(((SMILResource.AdsType) (obj1)));
        return smilresource;
        if (true) goto _L13; else goto _L12
_L12:
    }

}
