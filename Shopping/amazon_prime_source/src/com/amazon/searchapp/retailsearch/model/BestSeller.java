// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface BestSeller
{

    public abstract String getBadgeAssetId();

    public abstract String getLabel();

    public abstract Link getLink();

    public abstract String getNode();

    public abstract int getRank();

    public abstract void setBadgeAssetId(String s);

    public abstract void setLabel(String s);

    public abstract void setLink(Link link);

    public abstract void setNode(String s);

    public abstract void setRank(int i);
}
