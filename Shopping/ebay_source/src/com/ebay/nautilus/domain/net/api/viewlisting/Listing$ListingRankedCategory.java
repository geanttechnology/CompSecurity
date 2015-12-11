// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class 
    implements Comparable
{

    public compareTo category;
    public List categoryAspects;
    public compareTo categoryPathFromRoot;
    public compareTo categorySpecificCondition;
    public int rank;

    public int compareTo( )
    {
        return rank - .rank;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public ()
    {
    }
}
