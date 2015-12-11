// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import com.bestbuy.android.api.lib.models.home.ImageType;
import gu;
import java.io.Serializable;
import java.util.List;

public class CastMember
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List characterNames;
    private String displayName;
    private ImageType headshotImage;

    public CastMember()
    {
    }

    public List getCharacterNames()
    {
        return characterNames;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public ImageType getHeadshotImage()
    {
        return headshotImage;
    }

    public void setCharacterNames(List list)
    {
        characterNames = list;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setHeadshotImage(ImageType imagetype)
    {
        headshotImage = imagetype;
    }
}
