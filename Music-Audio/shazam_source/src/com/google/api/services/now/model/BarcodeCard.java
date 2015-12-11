// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Image, TemplatedString, Action

public final class BarcodeCard extends b
{

    private Image barcodeImage;
    private String barcodeText;
    private List buttons;
    private String domainUrl;
    private List labelContentPairs;
    private Image logo;
    private String secondaryTitle;
    private TemplatedString subtitle;
    private Action tapAction;
    private TemplatedString title;

    public BarcodeCard()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final BarcodeCard clone()
    {
        return (BarcodeCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Image getBarcodeImage()
    {
        return barcodeImage;
    }

    public final String getBarcodeText()
    {
        return barcodeText;
    }

    public final List getButtons()
    {
        return buttons;
    }

    public final String getDomainUrl()
    {
        return domainUrl;
    }

    public final List getLabelContentPairs()
    {
        return labelContentPairs;
    }

    public final Image getLogo()
    {
        return logo;
    }

    public final String getSecondaryTitle()
    {
        return secondaryTitle;
    }

    public final TemplatedString getSubtitle()
    {
        return subtitle;
    }

    public final Action getTapAction()
    {
        return tapAction;
    }

    public final TemplatedString getTitle()
    {
        return title;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final BarcodeCard set(String s, Object obj)
    {
        return (BarcodeCard)super.set(s, obj);
    }

    public final BarcodeCard setBarcodeImage(Image image)
    {
        barcodeImage = image;
        return this;
    }

    public final BarcodeCard setBarcodeText(String s)
    {
        barcodeText = s;
        return this;
    }

    public final BarcodeCard setButtons(List list)
    {
        buttons = list;
        return this;
    }

    public final BarcodeCard setDomainUrl(String s)
    {
        domainUrl = s;
        return this;
    }

    public final BarcodeCard setLabelContentPairs(List list)
    {
        labelContentPairs = list;
        return this;
    }

    public final BarcodeCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final BarcodeCard setSecondaryTitle(String s)
    {
        secondaryTitle = s;
        return this;
    }

    public final BarcodeCard setSubtitle(TemplatedString templatedstring)
    {
        subtitle = templatedstring;
        return this;
    }

    public final BarcodeCard setTapAction(Action action)
    {
        tapAction = action;
        return this;
    }

    public final BarcodeCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }
}
