// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;


// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.iafToken
    implements Runnable
{

    final FollowedEntityDataManager this$0;
    final String val$iafToken;
    final String val$searchName;

    public void run()
    {
        FollowedEntityDataManager.access$1700(FollowedEntityDataManager.this, val$searchName, val$iafToken);
    }

    ()
    {
        this$0 = final_followedentitydatamanager;
        val$searchName = s;
        val$iafToken = String.this;
        super();
    }
}
