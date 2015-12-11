// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;


// Referenced classes of package com.ebay.nautilus.domain.net.symban:
//            SymbanReadRequest

public static class offset
{

    boolean badgeCountOnly;
    int limit;
    int offset;

    public boolean isBadgeCountOnly()
    {
        return badgeCountOnly;
    }

    public badgeCountOnly setBadgeCountOnly(boolean flag)
    {
        badgeCountOnly = flag;
        return this;
    }

    public badgeCountOnly setLimit(int i)
    {
        limit = i;
        return this;
    }

    public limit setOffset(int i)
    {
        offset = i;
        return this;
    }

    public ()
    {
        badgeCountOnly = false;
        limit = 40;
        offset = 0;
    }
}
