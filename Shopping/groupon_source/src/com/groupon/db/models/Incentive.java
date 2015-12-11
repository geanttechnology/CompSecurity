// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            Deal

public class Incentive
{

    public Date expiresAt;
    public String faqUrl;
    public String longMessage;
    public Deal parentDeal;
    public Long primaryKey;
    public String promotionCode;
    public String promotionType;
    public String shortMessage;

    public Incentive()
    {
        shortMessage = "";
        longMessage = "";
        expiresAt = null;
        promotionCode = "";
        promotionType = "";
        faqUrl = "";
    }
}
