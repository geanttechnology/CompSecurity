// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContextScoped, AdContext

public class CreativeRenditionAsset extends AdContextScoped
    implements ICreativeRenditionAsset
{

    public int bytes;
    public String content;
    public String contentType;
    public int creativeRenditionAssetId;
    public String id;
    public String mimeType;
    public String name;
    public String url;

    public CreativeRenditionAsset(AdContext adcontext)
    {
        super(adcontext);
    }

    public int getBytes()
    {
        return bytes;
    }

    public String getContent()
    {
        return content;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public String getURL()
    {
        return url;
    }

    public void parse(Element element)
    {
        NodeList nodelist = element.getChildNodes();
        creativeRenditionAssetId = tryParseInt(element.getAttribute("id"), 0);
        setContentType(element.getAttribute("contentType"));
        setMimeType(element.getAttribute("mimeType"));
        name = element.getAttribute("name");
        setURL(element.getAttribute("url"));
        id = element.getAttribute("id");
        if (url != null && url.contains(" "))
        {
            url.replace(" ", "%20");
        }
        if (element.hasAttribute("bytes"))
        {
            setBytes(tryParseInt(element.getAttribute("bytes"), 0));
        }
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            element = nodelist.item(i);
            if (element.getNodeType() == 1)
            {
                String s = element.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("content"))
                {
                    content = getTextNodeValue(element);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public void setBytes(int i)
    {
        bytes = i;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setMimeType(String s)
    {
        mimeType = s;
    }

    public void setURL(String s)
    {
        url = s;
    }
}
