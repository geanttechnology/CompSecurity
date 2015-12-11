// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.h;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Button, LabelContentPair, Image, Map, 
//            TemplatedString

public final class MapCard extends b
{

    private List buttons;
    private List labelContentPairs;
    private Image logo;
    private Map map;
    private TemplatedString title;

    public MapCard()
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

    public final MapCard clone()
    {
        return (MapCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
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

    public final Map getMap()
    {
        return map;
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

    public final MapCard set(String s, Object obj)
    {
        return (MapCard)super.set(s, obj);
    }

    public final MapCard setButtons(List list)
    {
        buttons = list;
        return this;
    }

    public final MapCard setLabelContentPairs(List list)
    {
        labelContentPairs = list;
        return this;
    }

    public final MapCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final MapCard setMap(Map map1)
    {
        map = map1;
        return this;
    }

    public final MapCard setTitle(TemplatedString templatedstring)
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
