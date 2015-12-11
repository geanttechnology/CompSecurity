// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;

public class role
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String characterName;
    private String displayName;
    private String imageUrl;
    private String role;

    public String getCharacterName()
    {
        return characterName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getRole()
    {
        return role;
    }

    public (String s, String s1, String s2, String s3)
    {
        displayName = s;
        characterName = s1;
        imageUrl = s2;
        role = s3;
    }
}
