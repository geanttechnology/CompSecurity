// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.apiv3.IntrospectiveArrayList;
import com.socialin.android.apiv3.model.card.CardData;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, LocationCategory

public class Tag extends Response
    implements CardData
{

    public int count;
    public boolean isTagFollow;
    public IntrospectiveArrayList items;
    public LocationCategory locationCategory;
    public String name;
    public int photosCount;
    public int usersCount;

    public Tag()
    {
    }
}
