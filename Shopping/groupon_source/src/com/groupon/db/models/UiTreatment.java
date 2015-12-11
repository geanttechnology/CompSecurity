// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal, Option

public class UiTreatment
{

    public String description;
    public String logoImage;
    public String name;
    public Deal parentDeal;
    public Option parentOption;
    public Long primaryKey;
    public String slug;
    public String uuid;

    public UiTreatment()
    {
        uuid = "";
        slug = "";
        name = "";
        description = "";
        logoImage = "";
    }
}
