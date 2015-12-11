// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            AttrsContainer

public class AbstractBusiness extends AttrsContainer
{

    public double distance;
    public String heroImageUrl;
    public String name;

    public AbstractBusiness()
    {
        name = "";
        distance = 0.0D;
        heroImageUrl = "";
    }

    public AbstractBusiness(AbstractBusiness abstractbusiness)
    {
        name = "";
        distance = 0.0D;
        heroImageUrl = "";
        name = abstractbusiness.name;
        distance = abstractbusiness.distance;
        heroImageUrl = abstractbusiness.heroImageUrl;
    }
}
