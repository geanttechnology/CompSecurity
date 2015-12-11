// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            Business, Merchant

public class Tip
{

    public String businessChannelId;
    public Date createdAt;
    public int likes;
    public String maskedName;
    public Business parentBusiness;
    public Merchant parentMerchant;
    public Long primaryKey;
    public String remoteId;
    public String text;
    public Date updatedAt;

    public Tip()
    {
        businessChannelId = "";
        text = "";
        likes = 0;
        maskedName = "";
        createdAt = null;
        updatedAt = null;
    }
}
