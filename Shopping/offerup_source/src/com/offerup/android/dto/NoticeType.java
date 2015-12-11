// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class NoticeType
{

    public static final int BID_ACCEPTED_NOTICE_TYPE = 5;
    public static final int ITEM_RESERVED_NOTICE_TYPE = 6;
    public static final int NEW_BID_OFFER_NOTICE_TYPE = 2;
    public static final int NEW_OFFER_MESSAGE_NOTICE_TYPE = 1;
    public static final int PAYMENT_RECEIVED_NOTICE_TYPE = 4;
    public static final int PAYMENT_SENT_NOTICE_TYPE = 3;
    public static final int RATING_INVITATION_NOTICE_TYPE = 7;
    int id;
    String label;

    public NoticeType()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public String toString()
    {
        return (new StringBuilder("NoticeType [id=")).append(id).append(", label=").append(label).append("]").toString();
    }
}
