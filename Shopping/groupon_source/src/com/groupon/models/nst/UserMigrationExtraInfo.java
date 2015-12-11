// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class UserMigrationExtraInfo extends JsonEncodedNSTField
{

    protected String countryCode;

    public UserMigrationExtraInfo(String s)
    {
        countryCode = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (UserMigrationExtraInfo)obj;
        if (countryCode == null) goto _L4; else goto _L3
_L3:
        if (countryCode.equals(((UserMigrationExtraInfo) (obj)).countryCode)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((UserMigrationExtraInfo) (obj)).countryCode == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        if (countryCode != null)
        {
            return countryCode.hashCode();
        } else
        {
            return 0;
        }
    }
}
