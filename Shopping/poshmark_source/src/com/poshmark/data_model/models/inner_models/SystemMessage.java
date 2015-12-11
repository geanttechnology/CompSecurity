// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class SystemMessage
{

    String destination_url;
    String image_url;
    String message;
    String name;
    String right_image_url;

    public SystemMessage()
    {
    }

    public String getDestinationUrl()
    {
        return destination_url;
    }

    public String getImageUrl()
    {
        return image_url;
    }

    public String getMessageName()
    {
        return name;
    }

    public String getMessageText()
    {
        return message;
    }

    public String getRightImageUrl()
    {
        return right_image_url;
    }

    public void setDestinationUrl(String s)
    {
        destination_url = s;
    }

    public void setImageUrl(String s)
    {
        image_url = s;
    }

    public void setMessageName(String s)
    {
        name = s;
    }

    public void setMessageText(String s)
    {
        message = s;
    }
}
