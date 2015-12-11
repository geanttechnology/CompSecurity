// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class UserMigrationClickMetadata extends JsonEncodedNSTField
{

    protected String clickDetails;
    protected String countryCode;

    public UserMigrationClickMetadata(String s, String s1)
    {
        clickDetails = s;
        countryCode = s1;
    }
}
