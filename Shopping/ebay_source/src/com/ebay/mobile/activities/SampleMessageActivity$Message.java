// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.activities:
//            SampleMessageActivity

private static class <init>
    implements com.ebay.nautilus.kernel.content.
{

    private final int id;
    private final String longMessage;
    private final String shortMessage;

    public boolean displayToUser()
    {
        return true;
    }

    public String getCategory()
    {
        return "network";
    }

    public String getDomain()
    {
        return "http";
    }

    public int getId()
    {
        return id;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return longMessage;
    }

    public String getRemediationUrl()
    {
        return null;
    }

    public com.ebay.nautilus.kernel.content.ssage getSeverity()
    {
        return com.ebay.nautilus.kernel.content.ssage;
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return shortMessage;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        ebaycontext = getLongMessage(ebaycontext);
        return ebaycontext != null && ebaycontext.contains("</");
    }

    public String toString()
    {
        return shortMessage;
    }

    public (int i, String s, String s1)
    {
        id = i;
        shortMessage = s;
        longMessage = s1;
    }

    public longMessage(String s, String s1)
    {
        this(0, s, s1);
    }
}
