// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Image, TemplatedString, Action

public final class ListItem extends b
{

    private List details;
    private Image image;
    private TemplatedString subtitle;
    private Action tapAction;
    private TemplatedString title;

    public ListItem()
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

    public final ListItem clone()
    {
        return (ListItem)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final List getDetails()
    {
        return details;
    }

    public final Image getImage()
    {
        return image;
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

    public final ListItem set(String s, Object obj)
    {
        return (ListItem)super.set(s, obj);
    }

    public final ListItem setDetails(List list)
    {
        details = list;
        return this;
    }

    public final ListItem setImage(Image image1)
    {
        image = image1;
        return this;
    }

    public final ListItem setSubtitle(TemplatedString templatedstring)
    {
        subtitle = templatedstring;
        return this;
    }

    public final ListItem setTapAction(Action action)
    {
        tapAction = action;
        return this;
    }

    public final ListItem setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }
}
