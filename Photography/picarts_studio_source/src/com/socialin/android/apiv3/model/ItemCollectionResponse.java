// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response

public class ItemCollectionResponse extends Response
{

    public boolean isFollowing;
    public List items;
    public int total;

    public ItemCollectionResponse()
    {
        total = 0;
    }
}
