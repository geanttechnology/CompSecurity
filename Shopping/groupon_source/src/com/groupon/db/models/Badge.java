// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.io.Serializable;

public class Badge
    implements Serializable
{

    public String badgeType;
    public String displayLocation;
    public boolean mustDisplay;
    public String primaryColor;
    public String secondaryColor;
    public String text;

    public Badge()
    {
        badgeType = "";
        text = "";
        primaryColor = "";
        secondaryColor = "";
        mustDisplay = false;
        displayLocation = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (badgeType == null)
        {
            badgeType = "";
        }
        if (text == null)
        {
            text = "";
        }
        primaryColor = shiftAlphaCode(primaryColor);
        secondaryColor = shiftAlphaCode(secondaryColor);
        if (displayLocation == null)
        {
            displayLocation = "";
        }
    }

    public String shiftAlphaCode(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.length() == 9)
            {
                return (new StringBuilder()).append(s.charAt(0)).append(s.substring(7, 9)).append(s.substring(1, 7)).toString();
            }
        }
        return s1;
    }
}
