// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CollectionDetail, EbayCosDateTime

public static class lectionRelationship
{

    public String collectionId;
    public EbayCosDateTime creationDate;
    public lectionRelationship creator;
    public String description;
    public List entries;
    public int entryCount;
    public int followersCount;
    public String headline;
    public String href;
    public EbayCosDateTime lastActivityDate;
    public int maxAllowedItems;
    public utes mediaAttributes;
    public String name;
    public String subtitle;
    public int topLeafCategoryId;
    public lectionRelationship viewerToCollectionRelationship;
    public lectionRelationship visibility;

    public lectionRelationship()
    {
    }
}
