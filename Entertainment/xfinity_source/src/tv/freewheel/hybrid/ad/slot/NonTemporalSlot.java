// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.slot;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import tv.freewheel.hybrid.ad.AdChain;
import tv.freewheel.hybrid.ad.AdContext;
import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.CreativeRendition;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.XMLElement;

// Referenced classes of package tv.freewheel.hybrid.ad.slot:
//            Slot

public class NonTemporalSlot extends Slot
{

    public boolean acceptCompanion;
    public String compatibleDimensions;
    private boolean hasPendingCompanion;
    private boolean holdsCompanionAd;
    public int initialAdOption;

    public NonTemporalSlot(AdContext adcontext, int i)
    {
        super(adcontext, i);
        holdsCompanionAd = false;
        hasPendingCompanion = false;
    }

    public XMLElement buildXMLElement()
    {
        XMLElement xmlelement = new XMLElement("nonTemporalAdSlot");
        super.buildXMLElement(xmlelement);
        xmlelement.setAttribute("width", width, true);
        xmlelement.setAttribute("height", height, true);
        xmlelement.setAttribute("compatibleDimensions", compatibleDimensions);
        xmlelement.setAttribute("acceptCompanion", acceptCompanion);
        if (initialAdOption == 1 || initialAdOption == 2)
        {
            xmlelement.setAttribute("noInitial", true);
        }
        if (initialAdOption == 2 || initialAdOption == 3 || initialAdOption == 4 || initialAdOption == 5 || initialAdOption == 8)
        {
            xmlelement.setAttribute("firstCompanionAsInitial", true);
        }
        if (initialAdOption == 4)
        {
            xmlelement.setAttribute("noInitialIfCompanion", true);
        }
        if (initialAdOption == 6 || initialAdOption == 5)
        {
            xmlelement.setAttribute("noStandalone", true);
        }
        if (initialAdOption == 7 || initialAdOption == 8)
        {
            xmlelement.setAttribute("noStandaloneIfTemporal", true);
        }
        return xmlelement;
    }

    public NonTemporalSlot copy()
    {
        NonTemporalSlot nontemporalslot = (NonTemporalSlot)super.copy();
        nontemporalslot.acceptCompanion = acceptCompanion;
        nontemporalslot.initialAdOption = initialAdOption;
        nontemporalslot.compatibleDimensions = compatibleDimensions;
        return nontemporalslot;
    }

    public volatile Slot copy()
    {
        return copy();
    }

    protected void dispatchSlotEvent(String s)
    {
        if (!holdsCompanionAd)
        {
            super.dispatchSlotEvent(s);
        }
    }

    public ArrayList getAdInstances()
    {
        ArrayList arraylist = new ArrayList();
        if (currentPlayingAdInstance != null)
        {
            arraylist.add(currentPlayingAdInstance);
        } else
        {
            Iterator iterator = getAdInstancesInPlayPlan(true).iterator();
            while (iterator.hasNext()) 
            {
                arraylist.add((AdInstance)iterator.next());
            }
        }
        return arraylist;
    }

    public ViewGroup getBase()
    {
        if (displayBase == null)
        {
            if (context.getActivity() == null)
            {
                logger.error("host activity is null, can not create slot base");
            } else
            {
                displayBase = new RelativeLayout(context.getActivity());
                displayBase.setId((int)(Math.random() * 100000000D));
            }
        }
        return displayBase;
    }

    public int getHeight()
    {
        boolean flag = false;
        int i;
        if (height > 0)
        {
            i = height;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (currentPlayingAdInstance != null)
            {
                CreativeRendition creativerendition = currentPlayingAdInstance.getActiveCreativeRendition();
                i = ((flag) ? 1 : 0);
                if (creativerendition != null)
                {
                    return creativerendition.getHeight();
                }
            }
        }
        return i;
    }

    public int getWidth()
    {
        boolean flag = false;
        int i;
        if (width > 0)
        {
            i = width;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (currentPlayingAdInstance != null)
            {
                CreativeRendition creativerendition = currentPlayingAdInstance.getActiveCreativeRendition();
                i = ((flag) ? 1 : 0);
                if (creativerendition != null)
                {
                    return creativerendition.getWidth();
                }
            }
        }
        return i;
    }

    public void init(String s, int i, int j, String s1, String s2, boolean flag, String s3, 
            String s4, int k, String s5)
    {
        super.init(s, s2, s1, s4, s3);
        width = i;
        height = j;
        acceptCompanion = flag;
        initialAdOption = k;
        compatibleDimensions = s5;
    }

    public void onComplete()
    {
        logger.info("onComplete");
        super.onComplete();
        if (hasPendingCompanion)
        {
            holdsCompanionAd = true;
            hasPendingCompanion = false;
            play();
        }
        if (requestContentPause)
        {
            requestContentPause = false;
            context.requestContentResume(this);
        }
    }

    public void parse(Element element)
        throws tv.freewheel.hybrid.ad.AdResponse.IllegalAdResponseException
    {
        if (width <= 0 && height <= 0)
        {
            width = tryParseInt(element.getAttribute("width"), 0);
            height = tryParseInt(element.getAttribute("height"), 0);
        }
        super.parse(element);
    }

    public void play()
    {
        for (; adChains.size() > 1; adChains.remove(adChains.size() - 1)) { }
        super.play();
    }

    public void playCompanionAdInstance(AdInstance adinstance)
    {
        logger.verbose((new StringBuilder()).append(this).append(" playCompanionAdInstance(").append(adinstance).append(")").toString());
        if (adinstance.adChain == null)
        {
            new AdChain(adinstance);
        }
        adChains.add(0, adinstance.adChain);
        if (currentPlayingAdInstance != null)
        {
            hasPendingCompanion = true;
            stop();
            return;
        } else
        {
            holdsCompanionAd = true;
            play();
            return;
        }
    }

    protected void setTimePositionClass(String s)
    {
        timePositionClass = 5;
    }
}
