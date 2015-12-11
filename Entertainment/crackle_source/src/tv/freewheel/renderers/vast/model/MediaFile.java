// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.vast.util.StringUtils;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.XMLHandler;

// Referenced classes of package tv.freewheel.renderers.vast.model:
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

    public void adjustMatchedRendition(ICreativeRendition icreativerendition, String s, String s1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (icreativerendition.getContentType() == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (icreativerendition.getContentType().isEmpty()) goto _L2; else goto _L3
_L3:
        flag = flag1;
        if (s == null) goto _L2; else goto _L4
_L4:
        flag = flag1;
        if (s.isEmpty()) goto _L2; else goto _L5
_L5:
        String s2;
        String s3;
        s2 = icreativerendition.getContentType().toLowerCase();
        s3 = s.toLowerCase();
        if (!s2.equals(s3)) goto _L7; else goto _L6
_L6:
        flag = true;
_L2:
        boolean flag2 = false;
        flag1 = flag2;
        if (icreativerendition.getCreativeAPI() != null)
        {
            flag1 = flag2;
            if (!icreativerendition.getCreativeAPI().isEmpty())
            {
                flag1 = flag2;
                if (s1 != null)
                {
                    flag1 = flag2;
                    if (!s1.isEmpty())
                    {
                        s = icreativerendition.getCreativeAPI().toLowerCase();
                        s2 = s1.toLowerCase();
                        if (s.equals(s2))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = flag2;
                            if (s.startsWith("mraid"))
                            {
                                flag1 = flag2;
                                if (s2.startsWith("mraid"))
                                {
                                    flag1 = true;
                                    icreativerendition.setCreativeAPI(s1);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (flag && flag1)
        {
            icreativerendition.setPreference(10);
        } else
        if (flag1)
        {
            icreativerendition.setPreference(6);
        } else
        if (flag)
        {
            icreativerendition.setPreference(5);
        } else
        {
            icreativerendition.setPreference(0);
        }
        logger.debug((new StringBuilder()).append("adjustMatchedRendition ").append(icreativerendition.getId()).append(", contentType ").append(icreativerendition.getContentType()).append(", creativeAPI ").append(icreativerendition.getCreativeAPI()).append(", preference ").append(icreativerendition.getPreference()).toString());
        return;
_L7:
        if (s2.startsWith("video/mp4") && s3.startsWith("video/mp4")) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (!s2.equals("text/js_ref")) goto _L2; else goto _L10
_L10:
        flag = flag1;
        if (!s3.equals("application/javascript")) goto _L2; else goto _L9
_L9:
        flag = true;
        icreativerendition.setContentType(s);
          goto _L2
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

    ArrayList getClickTrackingURLs()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = linear.videoClicks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoClick videoclick = (VideoClick)iterator.next();
            if ("ClickTracking".equals(videoclick.type))
            {
                arraylist.add(videoclick.url);
            }
        } while (true);
        return arraylist;
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
            if (!Util.isNullOrEmptyString(s) && URLUtil.isValidUrl(s))
            {
                if (!super.isSetAssetContentSuccessfully(s))
                {
                    assetURL = s.trim();
                    if (type.equalsIgnoreCase("text/html"))
                    {
                        type = "text/html_doc_ref";
                    }
                }
                assetURL = s.trim();
            }
            if (type.toLowerCase().contains("javascript"))
            {
                type = "text/js_ref";
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
