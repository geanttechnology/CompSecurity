// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.h;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Button, LabelContentPair, Address, Image, 
//            Action, TemplatedString

public final class TableCard extends b
{

    private Address address;
    private List buttons;
    private List labelContentPairs;
    private Image logo;
    private Action tapAction;
    private TemplatedString title;

    public TableCard()
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

    public final TableCard clone()
    {
        return (TableCard)super.clone();
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

    public final List getLabelContentPairs()
    {
        return labelContentPairs;
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

    public final TableCard set(String s, Object obj)
    {
        return (TableCard)super.set(s, obj);
    }

    public final TableCard setAddress(Address address1)
    {
        address = address1;
        return this;
    }

    public final TableCard setButtons(List list)
    {
        buttons = list;
        return this;
    }

    public final TableCard setLabelContentPairs(List list)
    {
        labelContentPairs = list;
        return this;
    }

    public final TableCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final TableCard setTapAction(Action action)
    {
        tapAction = action;
        return this;
    }

    public final TableCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }

    static 
    {
        h.a(com/google/api/services/now/model/Button);
        h.a(com/google/api/services/now/model/LabelContentPair);
    }
}
