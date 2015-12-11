// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class BrandShareMessages
{
    public class ShareMessage
    {

        public String body;
        public String hint;
        public String message;
        public String subject;
        final BrandShareMessages this$0;

        public ShareMessage()
        {
            this$0 = BrandShareMessages.this;
            super();
        }
    }


    public ShareMessage email;
    public ShareMessage facebook;
    public ShareMessage pinterest;
    public ShareMessage sms;
    public ShareMessage tumblr;
    public ShareMessage twitter;

    public BrandShareMessages()
    {
    }
}
