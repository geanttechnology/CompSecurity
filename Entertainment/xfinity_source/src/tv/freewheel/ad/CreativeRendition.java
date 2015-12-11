// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad:
//            ParametersHolder, Creative, CreativeRenditionAsset

public class CreativeRendition extends ParametersHolder
    implements Comparable, ICreativeRendition
{

    private String baseUnit;
    private String contentType;
    private String creativeAPI;
    public int creativeRenditionId;
    private double duration;
    private int height;
    private ArrayList otherCreativeRenditionAssets;
    private int preference;
    private CreativeRenditionAsset primaryCreativeRenditionAsset;
    public int replicaId;
    private int width;
    private String wrapperType;
    private String wrapperUrl;

    public CreativeRendition(Creative creative)
    {
        super(creative.getAdContext());
        baseUnit = creative.baseUnit;
        otherCreativeRenditionAssets = new ArrayList();
        setCreativeAPI("None");
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CreativeRendition)obj);
    }

    public int compareTo(CreativeRendition creativerendition)
    {
        if (preference > creativerendition.preference)
        {
            return -1;
        }
        return preference >= creativerendition.preference ? 0 : 1;
    }

    public ICreativeRenditionAsset createCreativeRenditionAssetForTranslation(String s, boolean flag)
    {
        CreativeRenditionAsset creativerenditionasset = new CreativeRenditionAsset(context);
        creativerenditionasset.name = s;
        if (flag)
        {
            primaryCreativeRenditionAsset = creativerenditionasset;
            return creativerenditionasset;
        } else
        {
            otherCreativeRenditionAssets.add(creativerenditionasset);
            return creativerenditionasset;
        }
    }

    public String getBaseUnit()
    {
        return baseUnit;
    }

    public String getContentType()
    {
        if (contentType != null && contentType.length() > 0)
        {
            return contentType;
        }
        if (primaryCreativeRenditionAsset != null)
        {
            return primaryCreativeRenditionAsset.contentType;
        } else
        {
            return null;
        }
    }

    public String getCreativeAPI()
    {
        return creativeAPI;
    }

    public double getDuration()
    {
        return duration;
    }

    public int getHeight()
    {
        return height;
    }

    public int getId()
    {
        return creativeRenditionId;
    }

    public int getPreference()
    {
        return preference;
    }

    public ICreativeRenditionAsset getPrimaryCreativRenditionAsset()
    {
        return primaryCreativeRenditionAsset;
    }

    public int getWidth()
    {
        return width;
    }

    public String getWrapperType()
    {
        return wrapperType;
    }

    public String getWrapperURL()
    {
        return wrapperUrl;
    }

    public void parse(Element element)
    {
        NodeList nodelist = element.getChildNodes();
        creativeRenditionId = tryParseInt(element.getAttribute("creativeRenditionId"), 0);
        replicaId = tryParseInt(element.getAttribute("adReplicaId"), -1);
        setContentType(element.getAttribute("contentType"));
        setWrapperType(element.getAttribute("wrapperType"));
        setWrapperURL(element.getAttribute("wrapperUrl"));
        setPreference(tryParseInt(element.getAttribute("preference"), 0));
        setHeight(tryParseInt(element.getAttribute("height"), 0));
        setWidth(tryParseInt(element.getAttribute("width"), 0));
        setCreativeAPI(element.getAttribute("creativeApi"));
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            element = nodelist.item(i);
            if (element.getNodeType() == 1)
            {
                String s = element.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("parameters"))
                {
                    parameters = parseParameters((Element)element);
                } else
                if (s.equals("asset"))
                {
                    primaryCreativeRenditionAsset = new CreativeRenditionAsset(context);
                    primaryCreativeRenditionAsset.parse((Element)element);
                } else
                if (s.equals("otherAssets"))
                {
                    parseOtherAssets((Element)element);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    protected void parseOtherAssets(Element element)
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                Object obj = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parseOtherAssets(), name: ").append(((String) (obj))).toString());
                if (((String) (obj)).equals("asset"))
                {
                    obj = new CreativeRenditionAsset(context);
                    ((CreativeRenditionAsset) (obj)).parse((Element)node);
                    otherCreativeRenditionAssets.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setCreativeAPI(String s)
    {
        creativeAPI = s;
    }

    public void setDuration(double d)
    {
        duration = d;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setParameter(String s, Object obj)
    {
        if (s == null)
        {
            return;
        }
        if (obj != null)
        {
            parameters.put(s, obj);
            return;
        } else
        {
            parameters.remove(s);
            return;
        }
    }

    public void setPreference(int i)
    {
        preference = i;
    }

    public void setWidth(int i)
    {
        width = i;
    }

    public void setWrapperType(String s)
    {
        wrapperType = s;
    }

    public void setWrapperURL(String s)
    {
        wrapperUrl = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(creativeRenditionId).toString();
    }
}
