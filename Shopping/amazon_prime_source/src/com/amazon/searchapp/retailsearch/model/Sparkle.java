// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Widget, Image

public interface Sparkle
    extends Widget
{

    public abstract String getAltText();

    public abstract List getDescription();

    public abstract Image getImage();

    public abstract List getTitle();

    public abstract String getType();

    public abstract String getUrl();

    public abstract void setAltText(String s);

    public abstract void setDescription(List list);

    public abstract void setImage(Image image);

    public abstract void setTitle(List list);

    public abstract void setType(String s);

    public abstract void setUrl(String s);
}
