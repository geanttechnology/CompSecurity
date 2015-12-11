// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            IVastValidation, Creative, Impression

public abstract class AbstractAd
    implements IVastValidation
{

    public ArrayList creatives;
    String error;
    public ArrayList impressions;
    private Logger logger;

    public AbstractAd()
    {
        logger = Logger.getLogger(this);
        impressions = new ArrayList();
        creatives = new ArrayList();
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        if (creatives != null && !creatives.isEmpty())
        {
            Iterator iterator = creatives.iterator();
            while (iterator.hasNext()) 
            {
                if (((Creative)iterator.next()).isValid(islot, iconstants))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void parse(Element element)
    {
        int i;
        int k;
        element = element.getChildNodes();
        k = element.getLength();
        i = 0;
_L1:
        Object obj;
        Object obj1;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        obj = element.item(i);
        if (((Node) (obj)).getNodeType() == 1)
        {
            obj1 = ((Node) (obj)).getNodeName();
            if (((String) (obj1)).equals("Error"))
            {
                error = XMLHandler.getTextNodeValue(((Node) (obj)));
            } else
            {
                if (!((String) (obj1)).equals("Impression"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj1 = new Impression();
                ((Impression) (obj1)).parse((Element)obj);
                impressions.add(obj1);
            }
        }
_L3:
        i++;
          goto _L1
        if (!((String) (obj1)).equals("Creatives")) goto _L3; else goto _L2
_L2:
        obj = ((Element)obj).getElementsByTagName("Creative");
        int j = 0;
        while (j < ((NodeList) (obj)).getLength()) 
        {
            Creative creative = new Creative();
            creative.parse((Element)((NodeList) (obj)).item(j));
            creatives.add(creative);
            j++;
        }
          goto _L3
    }

    public ArrayList searchInCompanionSlot(ISlot islot, IConstants iconstants)
    {
        ArrayList arraylist = new ArrayList();
        if (islot.getType() != iconstants.SLOT_TYPE_TEMPORAL())
        {
            for (Iterator iterator = creatives.iterator(); iterator.hasNext(); arraylist.addAll(((Creative)iterator.next()).searchInCompanionSlot(islot, iconstants))) { }
        } else
        {
            logger.debug("Temporal slot should NOT be companion slot. ");
        }
        return arraylist;
    }

    public ArrayList searchInDrivingSlot(ISlot islot, IConstants iconstants)
    {
        ArrayList arraylist = new ArrayList();
        if (islot.getType() == iconstants.SLOT_TYPE_TEMPORAL())
        {
            for (Iterator iterator = creatives.iterator(); iterator.hasNext(); arraylist.addAll(((Creative)iterator.next()).searchInDrivingSlot(islot, iconstants))) { }
        } else
        {
            logger.debug("Non-Temporal slot should NOT be driving slot. ");
        }
        return arraylist;
    }

    public String toString()
    {
        return String.format("[VastAd\n\t\tError=%s\n\t\tImpressions=%s\n\t\tCreatives=%s\n\t]", new Object[] {
            error, impressions, creatives
        });
    }
}
