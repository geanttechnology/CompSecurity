// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.Date;

public class type
{

    public Date created;
    public data data;
    public String id;
    public String type;

    public type getActionButton()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.tton;
        }
    }

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

    public String getLink()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.data;
        }
    }

    public String getLinkName()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.;
        }
    }

    public String getPhotoUrl()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.;
        }
    }

    public String getText()
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

    public String getUrl()
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
        type = "news";
    }
}
