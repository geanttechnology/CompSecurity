// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal, Option

public class LegalDisclosure
{

    public String line1;
    public String line2;
    public Deal parentDeal;
    public Option parentOption;
    public Long primaryKey;

    public LegalDisclosure()
    {
        line1 = "";
        line2 = "";
    }
}
