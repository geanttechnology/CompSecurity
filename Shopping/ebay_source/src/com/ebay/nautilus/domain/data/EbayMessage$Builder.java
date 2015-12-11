// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayMessage

public static class responseEnabled
{

    private String externalMessageId;
    private boolean flagged;
    private long folderId;
    private boolean highPriority;
    private Date itemEndDate;
    private long itemId;
    private String itemTitle;
    private String messageId;
    private boolean read;
    private Date receiveDate;
    private boolean replied;
    private boolean responseEnabled;
    private String sendToName;
    private String sender;
    private String subject;
    private String text;

    public EbayMessage build()
    {
        return new EbayMessage(messageId, externalMessageId, flagged, folderId, highPriority, itemEndDate, itemId, itemTitle, read, receiveDate, replied, sender, sendToName, subject, text, responseEnabled);
    }

    public responseEnabled externalMessageId(String s)
    {
        externalMessageId = s;
        return this;
    }

    public externalMessageId flagged(boolean flag)
    {
        flagged = flag;
        return this;
    }

    public flagged folderId(long l)
    {
        folderId = l;
        return this;
    }

    public folderId highPriority(boolean flag)
    {
        highPriority = flag;
        return this;
    }

    public highPriority itemEndDate(Date date)
    {
        itemEndDate = date;
        return this;
    }

    public itemEndDate itemId(long l)
    {
        itemId = l;
        return this;
    }

    public itemId itemTitle(String s)
    {
        itemTitle = s;
        return this;
    }

    public itemTitle messageId(String s)
    {
        messageId = s;
        return this;
    }

    public messageId read(boolean flag)
    {
        read = flag;
        return this;
    }

    public read receiveDate(Date date)
    {
        receiveDate = date;
        return this;
    }

    public receiveDate replied(boolean flag)
    {
        replied = flag;
        return this;
    }

    public replied responseEnabled(boolean flag)
    {
        responseEnabled = flag;
        return this;
    }

    public responseEnabled sendToName(String s)
    {
        sendToName = s;
        return this;
    }

    public sendToName sender(String s)
    {
        sender = s;
        return this;
    }

    public sender subject(String s)
    {
        subject = s;
        return this;
    }

    public subject text(String s)
    {
        text = s;
        return this;
    }

    public ()
    {
        folderId = -1L;
        itemId = -1L;
    }

    public itemId(String s)
    {
        messageId = s;
        folderId = -1L;
        itemId = -1L;
    }

    public itemId(String s, String s1, boolean flag, long l, boolean flag1, Date date, 
            long l1, String s2, boolean flag2, Date date1, boolean flag3, String s3, 
            String s4, String s5, String s6, boolean flag4)
    {
        messageId = s;
        externalMessageId = s1;
        flagged = flag;
        folderId = l;
        highPriority = flag1;
        itemEndDate = date;
        itemId = l1;
        itemTitle = s2;
        read = flag2;
        receiveDate = date1;
        replied = flag3;
        sender = s3;
        sendToName = s4;
        subject = s5;
        text = s6;
        responseEnabled = flag4;
    }
}
