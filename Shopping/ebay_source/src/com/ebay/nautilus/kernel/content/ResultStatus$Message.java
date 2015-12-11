// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            ResultStatus, EbayContext

public static interface 
{

    public abstract boolean displayToUser();

    public abstract String getCategory();

    public abstract String getDomain();

    public abstract int getId();

    public abstract String getLongMessage(EbayContext ebaycontext);

    public abstract String getRemediationUrl();

    public abstract  getSeverity();

    public abstract String getShortMessage(EbayContext ebaycontext);

    public abstract boolean isLongMessageHtml(EbayContext ebaycontext);
}
