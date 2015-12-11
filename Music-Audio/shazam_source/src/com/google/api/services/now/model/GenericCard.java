// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.h;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Button, Address, TemplatedString, Image, 
//            Action

public final class GenericCard extends b
{

    private Address address;
    private List buttons;
    private TemplatedString content;
    private Image image;
    private Image logo;
    private Action tapAction;
    private TemplatedString title;

    public GenericCard()
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

    public final GenericCard clone()
    {
        return (GenericCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Address getAddress()
    {
        return address;
    }

    public final List getButtons()
    {
        return buttons;
    }

    public final TemplatedString getContent()
    {
        return content;
    }

    public final Image getImage()
    {
        return image;
    }

    public final Image getLogo()
    {
        return logo;
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

    public final GenericCard set(String s, Object obj)
    {
        return (GenericCard)super.set(s, obj);
    }

    public final GenericCard setAddress(Address address1)
    {
        address = address1;
        return this;
    }

    public final GenericCard setButtons(List list)
    {
        buttons = list;
        return this;
    }

    public final GenericCard setContent(TemplatedString templatedstring)
    {
        content = templatedstring;
        return this;
    }

    public final GenericCard setImage(Image image1)
    {
        image = image1;
        return this;
    }

    public final GenericCard setLogo(Image image1)
    {
        logo = image1;
        return this;
    }

    public final GenericCard setTapAction(Action action)
    {
        tapAction = action;
        return this;
    }

    public final GenericCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }

    static 
    {
        h.a(com/google/api/services/now/model/Button);
    }
}
