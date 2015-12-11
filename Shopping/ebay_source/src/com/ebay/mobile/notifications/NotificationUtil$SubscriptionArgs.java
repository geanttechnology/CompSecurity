// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationUtil

private static class site
{

    public String clientId;
    public String iafToken;
    public String language;
    public String metaCategories;
    public icationType notificationType;
    public String regId;
    public EbaySite site;
    public String userId;

    icationType(String s, String s1, String s2, String s3, String s4, String s5, icationType icationtype, 
            EbaySite ebaysite)
    {
        iafToken = s;
        userId = s1;
        regId = s2;
        language = s3;
        clientId = s4;
        metaCategories = s5;
        notificationType = icationtype;
        site = ebaysite;
    }
}
