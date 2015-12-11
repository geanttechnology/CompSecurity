// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal

public class DealType
{

    public String description;
    public String name;
    public Deal parentDeal;
    public Long primaryKey;
    public String remoteId;

    public DealType()
    {
        remoteId = "";
        name = "";
        description = "";
    }
}
