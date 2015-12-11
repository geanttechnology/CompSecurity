// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import com.bestbuy.android.api.lib.models.home.ImageType;
import gu;
import java.io.Serializable;

public class BonusContent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String availabilityMessage;
    private String description;
    private String displayName;
    private ImageType primaryImage;

    public BonusContent()
    {
    }

    public String getAvailabilityMessage()
    {
        return availabilityMessage;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public ImageType getPrimaryImage()
    {
        return primaryImage;
    }

    public void setAvailabilityMessage(String s)
    {
        availabilityMessage = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setPrimaryImage(ImageType imagetype)
    {
        primaryImage = imagetype;
    }
}
