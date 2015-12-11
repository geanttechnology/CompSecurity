// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import android.webkit.URLUtil;
import org.w3c.dom.Element;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            Util

abstract class AbstractPager
{

    public String id;
    public String url;

    AbstractPager()
    {
    }

    public boolean isValid()
    {
        return !Util.isNullOrEmptyString(url) && URLUtil.isValidUrl(url);
    }

    public void parse(Element element)
    {
        id = element.getAttribute("id");
        url = XMLHandler.getTextNodeValue(element);
    }

    public String toString()
    {
        return String.format("[id=%s url=%s]", new Object[] {
            id, url
        });
    }
}
