// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface TopNewRelease
{

    public abstract String getBadgeAssetId();

    public abstract String getBadgeLabel();

    public abstract String getCategory();

    public abstract String getListId();

    public abstract Link getListLink();

    public abstract int getRank();

    public abstract void setBadgeAssetId(String s);

    public abstract void setBadgeLabel(String s);

    public abstract void setCategory(String s);

    public abstract void setListId(String s);

    public abstract void setListLink(Link link);

    public abstract void setRank(int i);
}
