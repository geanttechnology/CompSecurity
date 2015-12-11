// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRendition;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.renderers.vast.util.StringUtils;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractCreativeRendition, Linear, VideoClick, Util

public class MediaFile extends AbstractCreativeRendition
{

    public Integer bitrate;
    public String delivery;
    private Linear linear;
    public Boolean maintainAspectRatio;
    public Boolean scalable;

    public MediaFile(Linear linear1)
    {
        linear = linear1;
    }

    String getClickThroughURL()
    {
        Object obj1 = null;
        Iterator iterator = linear.videoClicks.iterator();
        Object obj;
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (VideoClick)iterator.next();
            if (!"ClickThrough".equals(((VideoClick) (obj)).type))
            {
                continue;
            }
            obj = ((VideoClick) (obj)).url;
            break;
        } while (true);
        return ((String) (obj));
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        if (islot.getType() == iconstants.SLOT_TYPE_TEMPORAL() && islot.getTimePositionClass() != iconstants.TIME_POSITION_CLASS_OVERLAY())
        {
            return super.isValid(islot, iconstants);
        } else
        {
            return false;
        }
    }

    public void parse(Element element)
    {
        super.parse(element);
        String s = element.getAttribute("type");
        if (!Util.isNullOrEmptyString(s))
        {
            type = s.trim();
            s = XMLHandler.getTextNodeValue(element).trim();
            if (!Util.isNullOrEmptyString(s) && URLUtil.isValidUrl(s) && !super.isSetAssetContentSuccessfully(s))
            {
                assetURL = s.trim();
                if (type.equalsIgnoreCase("text/html"))
                {
                    type = "text/html_doc_ref";
                }
            }
        }
        delivery = element.getAttribute("delivery");
        bitrate = StringUtils.parseInteger(element.getAttribute("bitrate"));
        scalable = StringUtils.parseBoolean(element.getAttribute("scalable"));
        maintainAspectRatio = StringUtils.parseBoolean(element.getAttribute("maintainAspectRatio"));
        adParameters = linear.adParameters;
    }

    public String toString()
    {
        return String.format("[MediaFile %s delivery=%s bitrate=%d scalable=%b maintainAspectRatio=%b]", new Object[] {
            super.toString(), delivery, bitrate, scalable, maintainAspectRatio
        });
    }

    public void translateToFWCreativeRendition(ICreativeRendition icreativerendition, IAdInstance iadinstance, IAdInstance iadinstance1, IConstants iconstants)
    {
        if (linear.duration == null) goto _L2; else goto _L1
_L1:
        icreativerendition.setDuration(linear.duration.doubleValue());
_L4:
        super.translateToFWCreativeRendition(icreativerendition, iadinstance, iadinstance1, iconstants);
        return;
_L2:
        if (iadinstance1.getActiveCreativeRendition() != null)
        {
            linear.duration = Double.valueOf(iadinstance1.getActiveCreativeRendition().getDuration());
            icreativerendition.setDuration(linear.duration.doubleValue());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void translateToFWCreativeRenditionAsset(ICreativeRenditionAsset icreativerenditionasset)
    {
        if (linear.duration != null && linear.duration.doubleValue() > 0.0D && bitrate != null && bitrate.intValue() > 0)
        {
            icreativerenditionasset.setBytes((int)((linear.duration.doubleValue() * (double)bitrate.intValue() * 1000D) / 8D));
        }
    }
}
