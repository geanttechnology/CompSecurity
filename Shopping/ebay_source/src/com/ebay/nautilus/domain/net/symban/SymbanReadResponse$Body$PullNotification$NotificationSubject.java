// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;

import com.ebay.nautilus.domain.data.EbayCosDateTime;

// Referenced classes of package com.ebay.nautilus.domain.net.symban:
//            SymbanReadResponse

public static class Message
{
    public static class Listing
    {

        public String bestOfferId;
        public String listingId;
        public EbayCosDateTime scheduledEndDate;
        public String transactionId;

        public Listing()
        {
        }
    }

    public static class Message
    {

        public String messageId;

        public Message()
        {
        }
    }


    public Listing listing;
    public Message message;

    public Message()
    {
    }
}
