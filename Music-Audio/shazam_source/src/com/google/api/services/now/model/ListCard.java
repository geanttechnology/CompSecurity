// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Button, Image, TemplatedString

public final class ListCard extends b
{

    private Button button;
    private List listItems;
    private Image logo;
    private TemplatedString title;

    public ListCard()
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

    public final ListCard clone()
    {
        return (ListCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Button getButton()
    {
        return button;
    }

    public final List getListItems()
    {
        return listItems;
    }

    public final Image getLogo()
    {
        return logo;
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

    public final ListCard set(String s, Object obj)
    {
        return (ListCard)super.set(s, obj);
    }

    public final ListCard setButton(Button button1)
    {
        button = button1;
        return this;
    }

    public final ListCard setListItems(List list)
    {
        listItems = list;
        return this;
    }

    public final ListCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final ListCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }
}
