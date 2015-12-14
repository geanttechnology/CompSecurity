// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            DMSSubAuthenticator

private static class deviceTypeInvariantForm
{

    public final String deviceTypeInvariantForm;
    public final String legacyToken;

    public String toString()
    {
        String s;
        String s1;
        if (legacyToken != null)
        {
            s = legacyToken;
        } else
        {
            s = "none";
        }
        if (deviceTypeInvariantForm != null)
        {
            s1 = deviceTypeInvariantForm;
        } else
        {
            s1 = "none";
        }
        return String.format("[%s,%s]", new Object[] {
            s, s1
        });
    }

    public (String s, String s1)
    {
        legacyToken = s;
        deviceTypeInvariantForm = s1;
    }
}
