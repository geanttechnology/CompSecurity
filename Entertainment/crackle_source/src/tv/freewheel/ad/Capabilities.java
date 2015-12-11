// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import tv.freewheel.utils.XMLElement;

// Referenced classes of package tv.freewheel.ad:
//            XMLObject

public class Capabilities
    implements XMLObject
{

    public static final ArrayList CANDIDATE_ADS_CAPABILITIES;
    private static final HashSet DEFAULT_CAPABILITIES;
    public static final ArrayList TRI_VALUE_CAPABILITIES;
    public static final ArrayList TWO_VALUE_CAPABILITIES;
    private TreeMap capabilities;

    public Capabilities()
    {
        capabilities = new TreeMap();
        for (Iterator iterator = DEFAULT_CAPABILITIES.iterator(); iterator.hasNext(); capabilities.put(iterator.next(), Integer.valueOf(0))) { }
        for (Iterator iterator1 = TRI_VALUE_CAPABILITIES.iterator(); iterator1.hasNext(); capabilities.put(iterator1.next(), Integer.valueOf(2))) { }
    }

    public XMLElement buildXMLElement()
    {
        XMLElement xmlelement = new XMLElement("capabilities");
        Iterator iterator = capabilities.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            int i = getCapability(((String) (obj)));
            if (TRI_VALUE_CAPABILITIES.contains(obj))
            {
                obj = new XMLElement(((String) (obj)));
                if (i == 0)
                {
                    ((XMLElement) (obj)).setText("true");
                } else
                {
                    if (i != 1)
                    {
                        continue;
                    }
                    ((XMLElement) (obj)).setText("false");
                }
                xmlelement.appendChild(((XMLElement) (obj)));
                continue;
            }
            if (i == 0)
            {
                xmlelement.appendChild(new XMLElement(((String) (obj))));
            }
        } while (true);
        return xmlelement;
    }

    public int getCapability(String s)
    {
        if (capabilities.containsKey(s))
        {
            for (int i = ((Integer)capabilities.get(s)).intValue(); TRI_VALUE_CAPABILITIES.contains(s) || i != 2;)
            {
                return i;
            }

            return !DEFAULT_CAPABILITIES.contains(s) ? 1 : 0;
        } else
        {
            return 1;
        }
    }

    public void setCapabilities(Capabilities capabilities1)
    {
        capabilities.clear();
        capabilities.putAll(capabilities1.capabilities);
    }

    public void setCapability(String s, int i)
    {
        if (s == null || s.trim().length() == 0)
        {
            return;
        } else
        {
            capabilities.put(s, Integer.valueOf(i));
            return;
        }
    }

    static 
    {
        CANDIDATE_ADS_CAPABILITIES = new ArrayList();
        CANDIDATE_ADS_CAPABILITIES.add("checkCompanion");
        CANDIDATE_ADS_CAPABILITIES.add("checkTargeting");
        TWO_VALUE_CAPABILITIES = new ArrayList();
        TWO_VALUE_CAPABILITIES.add("supportsSlotTemplate");
        TWO_VALUE_CAPABILITIES.add("supportsAdUnitInMultipleSlots");
        TWO_VALUE_CAPABILITIES.add("supportsSlotCallback");
        TWO_VALUE_CAPABILITIES.add("bypassCommercialRatioRestriction");
        TWO_VALUE_CAPABILITIES.add("requiresVideoCallbackUrl");
        TWO_VALUE_CAPABILITIES.add("skipsAdSelection");
        TWO_VALUE_CAPABILITIES.add("synchronizeMultipleRequests");
        TWO_VALUE_CAPABILITIES.add("resetExclusivity");
        TWO_VALUE_CAPABILITIES.add("supportNullCreative");
        TWO_VALUE_CAPABILITIES.add("expectMultipleCreativeRenditions");
        TWO_VALUE_CAPABILITIES.add("supportsFallbackAds");
        TRI_VALUE_CAPABILITIES = new ArrayList();
        TRI_VALUE_CAPABILITIES.add("recordVideoView");
        DEFAULT_CAPABILITIES = new HashSet();
        DEFAULT_CAPABILITIES.add("supportsSlotTemplate");
        DEFAULT_CAPABILITIES.add("supportsAdUnitInMultipleSlots");
        DEFAULT_CAPABILITIES.add("supportsSlotCallback");
        DEFAULT_CAPABILITIES.add("requiresRendererManifest");
        DEFAULT_CAPABILITIES.add("supportNullCreative");
        DEFAULT_CAPABILITIES.add("expectMultipleCreativeRenditions");
        DEFAULT_CAPABILITIES.add("supportsFallbackAds");
    }
}
