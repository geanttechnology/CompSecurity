// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Widget, AppIntent, Image

public interface ImageSparkle
    extends Widget
{

    public abstract AppIntent getAction();

    public abstract String getAltText();

    public abstract Image getImage();

    public abstract String getUrl();

    public abstract void setAction(AppIntent appintent);

    public abstract void setAltText(String s);

    public abstract void setImage(Image image);

    public abstract void setUrl(String s);
}
