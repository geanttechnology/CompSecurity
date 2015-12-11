// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.slot;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import tv.freewheel.hybrid.ad.AdContext;
import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.XMLElement;

// Referenced classes of package tv.freewheel.hybrid.ad.slot:
//            Slot

public class TemporalSlot extends Slot
{

    public int cuePointSequence;
    public double embeddedAdsDuration;
    public double endTimePosition;
    public double maxDuration;
    public double minDuration;
    public double timePosition;

    public TemporalSlot(AdContext adcontext, int i)
    {
        super(adcontext, i);
    }

    public XMLElement buildXMLElement()
    {
        XMLElement xmlelement = new XMLElement("temporalAdSlot");
        super.buildXMLElement(xmlelement);
        xmlelement.setAttribute("timePosition", timePosition);
        xmlelement.setAttribute("maxSlotDuration", maxDuration, true);
        xmlelement.setAttribute("minSlotDuration", minDuration, true);
        xmlelement.setAttribute("cuePointSequence", cuePointSequence, true);
        return xmlelement;
    }

    public volatile Slot copy()
    {
        return copy();
    }

    public TemporalSlot copy()
    {
        TemporalSlot temporalslot = (TemporalSlot)super.copy();
        temporalslot.timePosition = timePosition;
        temporalslot.cuePointSequence = cuePointSequence;
        temporalslot.maxDuration = maxDuration;
        return temporalslot;
    }

    public ArrayList getAdInstances()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = getAdInstancesInPlayPlan().iterator(); iterator.hasNext(); arraylist.add((AdInstance)iterator.next())) { }
        return arraylist;
    }

    public ViewGroup getBase()
    {
        return context.getTemporalSlotBase();
    }

    public int getHeight()
    {
        byte byte0 = -1;
        FrameLayout framelayout = context.getTemporalSlotBase();
        int i = byte0;
        if (framelayout != null)
        {
            i = byte0;
            if (framelayout.getHeight() > 0)
            {
                i = framelayout.getHeight();
            }
        }
        return i;
    }

    public double getTimePosition()
    {
        return timePosition;
    }

    public int getWidth()
    {
        byte byte0 = -1;
        FrameLayout framelayout = context.getTemporalSlotBase();
        int i = byte0;
        if (framelayout != null)
        {
            i = byte0;
            if (framelayout.getWidth() > 0)
            {
                i = framelayout.getWidth();
            }
        }
        return i;
    }

    public void onComplete()
    {
        logger.info("onComplete");
        if (timePositionClass != 6) goto _L2; else goto _L1
_L1:
        requestContentPause = false;
_L4:
        super.onComplete();
        return;
_L2:
        if (timePositionClass != 4)
        {
            requestContentPause = false;
            context.requestContentResume(this);
        } else
        if (requestContentPause)
        {
            requestContentPause = false;
            context.requestContentResume(this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onStartPlay()
    {
        if (timePositionClass != 4)
        {
            context.requestContentPause(this);
            requestContentPause = true;
        }
        if (timePositionClass == 6)
        {
            requestContentPause = true;
        }
        super.onStartPlay();
    }

    public void parse(Element element)
        throws tv.freewheel.hybrid.ad.AdResponse.IllegalAdResponseException
    {
        timePosition = tryParseDouble(element.getAttribute("timePosition"));
        double d = tryParseDouble(element.getAttribute("embeddedAdsDuration"), -1D);
        if (d < 0.0D)
        {
            d = -1D;
        }
        embeddedAdsDuration = d;
        d = tryParseDouble(element.getAttribute("endTimePosition"), -1D);
        if (d < timePosition)
        {
            d = -1D;
        }
        endTimePosition = d;
        cuePointSequence = tryParseInt(element.getAttribute("cuePointSequence"));
        setTimePositionClass(element.getAttribute("timePositionClass").toUpperCase());
        super.parse(element);
    }

    protected void setTimePositionClass(String s)
    {
        if (s.equalsIgnoreCase("PREROLL"))
        {
            timePositionClass = 1;
            return;
        }
        if (s.equalsIgnoreCase("MIDROLL"))
        {
            timePositionClass = 2;
            return;
        }
        if (s.equalsIgnoreCase("POSTROLL"))
        {
            timePositionClass = 3;
            return;
        }
        if (s.equalsIgnoreCase("OVERLAY"))
        {
            timePositionClass = 4;
            return;
        }
        if (s.equalsIgnoreCase("PAUSE_MIDROLL"))
        {
            timePositionClass = 6;
            return;
        } else
        {
            timePositionClass = 0;
            return;
        }
    }
}
