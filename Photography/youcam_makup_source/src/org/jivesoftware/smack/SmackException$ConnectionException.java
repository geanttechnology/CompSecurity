// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.List;

// Referenced classes of package org.jivesoftware.smack:
//            SmackException

public class failedAddresses extends SmackException
{

    private static final long serialVersionUID = 0x17693ad0489b288cL;
    private final List failedAddresses;

    public List a()
    {
        return failedAddresses;
    }

    public (List list)
    {
        failedAddresses = list;
    }
}
