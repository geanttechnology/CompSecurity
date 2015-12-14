// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public class type
{

    public data data;
    public String photo;
    public String text;
    public String title;
    public String type;

    public String getDataType()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.data;
        }
    }

    public String getMessage()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.data;
        }
    }

    public String getScreenPhotoUrl()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.data;
        }
    }

    public String getTitle()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.data;
        }
    }

    public ()
    {
        type = "welcome";
    }
}
