// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import com.groupon.db.models.Division;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            MyGrouponItem

protected static class ltDivision
{

    public Division division;
    public String id;
    public boolean isBookableTravelDeal;
    public boolean isInventoryDeal;
    public boolean isRewardDeal;
    public String largeImageUrl;
    public String sidebarImageUrl;
    public String title;

    protected _cls9()
    {
        largeImageUrl = "";
        sidebarImageUrl = "";
        title = "";
        id = "";
        isRewardDeal = false;
        isInventoryDeal = false;
        isBookableTravelDeal = false;
        division = MyGrouponItem.DefaultDivision;
    }
}
