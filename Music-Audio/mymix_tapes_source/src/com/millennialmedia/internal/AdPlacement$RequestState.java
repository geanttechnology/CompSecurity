// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            AdPlacement, AdPlacementReporter

public static class requestHash
{

    private AdPlacementReporter adPlacementReporter;
    private int itemHash;
    private int requestHash;

    public boolean compare(requestHash requesthash)
    {
        while (requestHash != requesthash.requestHash || itemHash != requesthash.itemHash) 
        {
            return false;
        }
        return true;
    }

    public boolean compareRequest(itemHash itemhash)
    {
        return requestHash == itemhash.requestHash;
    }

    public requestHash copy()
    {
        requestHash requesthash = new <init>();
        requesthash.requestHash = requestHash;
        requesthash.itemHash = itemHash;
        requesthash.adPlacementReporter = adPlacementReporter;
        return requesthash;
    }

    public AdPlacementReporter getAdPlacementReporter()
    {
        return adPlacementReporter;
    }

    public int getItemHash()
    {
        itemHash = (new Object()).hashCode();
        return itemHash;
    }

    public void setAdPlacementReporter(AdPlacementReporter adplacementreporter)
    {
        adPlacementReporter = adplacementreporter;
    }

    public ()
    {
        requestHash = (new Object()).hashCode();
    }
}
